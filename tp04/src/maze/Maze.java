package maze;
import java.util.ArrayList;
import java.util.List;

import graph.Graph;
import graph.ProcessedVertexesImpl;
import graph.Vertex;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze implements Graph {
	private final int sizeMazeLine;
	private final int sizeMazeColum ;
	public MazeHex[][] maze;
	
	public Maze(int colums,int lines) {
		this.sizeMazeColum = colums;
		this.sizeMazeLine = lines ;
		this.maze =new MazeHex[lines][colums] ;
	}
	
	public int getsizeMazeLine() {
		return this.sizeMazeLine;
	}
	
	public int getsizeMazeColum() {
		return this.sizeMazeColum;
	}
	/**
	 * @return A list of all the boxes possible to pass through & the departure Hex & the arrival Hex
	 * 
	 */
	public List<Vertex> getAllVertexes(){
		
		ArrayList<Vertex> allPossibleMazeHex = new ArrayList<Vertex>();
		
		for (MazeHex[] h : this.maze ) {
			for (MazeHex hex : h){
				if (!(hex.getLabel() == "W")) {
					allPossibleMazeHex.add((Vertex)hex);
				}
			}
		}
		return allPossibleMazeHex;
	}
	
	
	/**
	 * @return A list of the neighbors of a box(Hexagon)
	 */
	public List<Vertex> getSuccessors(Vertex vertex){
		
		List<MazeHex> neighbors = new ArrayList<MazeHex>();
		MazeHex Hex = (MazeHex) vertex ;
		
		int x = Hex.getX();
		int y = Hex.getY();
		if (x == 0) {
			if (y == 0) {
				neighbors.add(this.maze[0][1]);
				neighbors.add(this.maze[1][0]);
			}
			else if (y!=sizeMazeColum){
				neighbors.add(this.maze[x][y-1]);
				neighbors.add(this.maze[x][y+1]);
				neighbors.add(this.maze[x+1][y]);
				
			} else { if (sizeMazeColum % 2 == 0) {
				neighbors.add(this.maze[sizeMazeColum][y+1]);
				neighbors.add(this.maze[sizeMazeColum-1][y]);
				}else {
					neighbors.add(this.maze[sizeMazeColum][y+1]);
					neighbors.add(this.maze[sizeMazeColum-1][y]);
					neighbors.add(this.maze[sizeMazeColum-1][y+1]);
				}
				
			}
			
		}else if(x==sizeMazeLine){
			if (y==sizeMazeColum) {
				neighbors.add(this.maze[sizeMazeColum][sizeMazeLine-1]);
				neighbors.add(this.maze[sizeMazeColum-1][sizeMazeLine]);
			}else if (y!=0) {
				neighbors.add(this.maze[x][y-1]);
				neighbors.add(this.maze[x][y+1]);
				neighbors.add(this.maze[x-1][y]);
			}else if(y==0) {
				
			}
		}
		if ( y==0 && x!=0) {
			
			neighbors.add(this.maze[x-1][1]);
			neighbors.add(this.maze[x][1]);
		}else if (y==9){
			neighbors.add(this.maze[x+1][8]);
			neighbors.add(this.maze[x][8]);
		}
		else if (y!=0 && x!=0 && x !=9 && y!=9){
			neighbors.add(this.maze[x-1][y-1]);
			neighbors.add(this.maze[x-1][y+1]);
			neighbors.add(this.maze[x-1][y]);
			neighbors.add(this.maze[x][y-1]);
			neighbors.add(this.maze[x][y+1]);
			neighbors.add(this.maze[x+1][y]);
		}
		List<Vertex> neighborsVertex = new ArrayList<Vertex>();
		for (MazeHex mhex : neighbors) {
			if (isntAWall(mhex)) {
				neighborsVertex.add((Vertex) mhex);
			}
		}
		return neighborsVertex;
	}
	
	/**
	 * 
	 * @param un MazeHex V
	 * @return false si le MazeHex est de type Wall, true sinon
	 */
	private boolean isntAWall(MazeHex v) {
		if (v.getLabel() == "W"){
				return false;
		}else {
			return true;
		}
		
	}
	
	/**
	 * Read the text file that describes the maze
	 * @param fileName
	 * @throws Exception 
	 */
	public final void initFromTextFile(String fileName) throws Exception {
		
		try (BufferedReader readMazeParam = new BufferedReader(new FileReader(fileName))) {
			String line;
			for (int lineNum=0; lineNum < this.sizeMazeLine ; lineNum++) {
					line = readMazeParam.readLine();
					if (line == null) {throw new MazeReadingException(fileName, lineNum, "Increasing the number of lines is required");}
					if ( line.length() > this.sizeMazeColum) { throw new MazeReadingException(fileName,lineNum,"Reducing the number of columns is required");}
					if ( line.length() < this.sizeMazeColum) { throw new MazeReadingException(fileName,lineNum,"Increasing the number of columns is required");}
					
					for (int colonNum = 0; colonNum < this.sizeMazeColum ;colonNum++) {
						switch (line.charAt(colonNum))
						{
						case 'A':
								this.maze[lineNum][colonNum] =new ArrivalHex(this,lineNum,colonNum);break;
						case 'D':
						        this.maze[lineNum][colonNum] =new DepartureHex(this,lineNum,colonNum);break;
						case 'E':
								this.maze[lineNum][colonNum] =new EmptyHex(this,lineNum,colonNum);break;
						case 'W':
								this.maze[lineNum][colonNum] =new WallHex(this,lineNum,colonNum);break;
				        default :
				        	throw new MazeReadingException(fileName , lineNum , "Inkown character");
						
						}
					 }
			}
			readMazeParam.close();	
		} catch (IOException e) {
			System.out.println("Please, Enter a valid directory.");
		}
	}
	
	
	/**
	 * This method saves the state of the maze into a text file
	 */
	public final void saveToTextFile(String fileName)throws FileNotFoundException{
		try (PrintWriter pw = new PrintWriter(fileName)) {
			for (int lineNum = 0; lineNum < this.sizeMazeLine; lineNum++) {
				for (int columNum=0; columNum < this.sizeMazeColum; columNum++ ) {
					pw.print(this.maze[lineNum][columNum].getLabel());
					
				}
				pw.println();
			}
		}catch(Exception ex) {	
		}
	}
}
