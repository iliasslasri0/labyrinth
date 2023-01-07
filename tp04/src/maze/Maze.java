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
		this.maze =new MazeHex[colums][lines] ;
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
				System.out.println(hex.getY());
				if (!(hex.getLabel() == "W" )) {
					
					allPossibleMazeHex.add((Vertex)hex);
				}
			}
		}
		return allPossibleMazeHex;
	}
	
	
	/**
	 * @return A list of the neighbors of a hex(Hexagon)
	 */

	

	public ArrayList<Vertex> getSuccessors(Vertex vertex) {
		ArrayList<Vertex> successors = new ArrayList<Vertex>();
		MazeHex hex = (MazeHex) vertex;
		int y = hex.getY();
		int x = hex.getX();
		if (hex.isWall() == true) {
			return null;
		}
		if (!hexIsInBounds(x + 1, y) && maze[x + 1][y].isWall() == false) {
			successors.add(maze[x + 1][y]);
		}
		if (!hexIsInBounds(x - 1, y) && maze[x - 1][y].isWall() == false) {
			successors.add(maze[x - 1][y]);
		}
		if (y % 2 == 0) {
			if (!hexIsInBounds(x - 1, y - 1) && maze[x - 1][y - 1].isWall() == false) {
				successors.add(maze[x - 1][y - 1]);
			}
			if (!hexIsInBounds(x, y - 1) && maze[x][y - 1].isWall() == false) {
				successors.add(maze[x][y - 1]);
			}

			if (!hexIsInBounds(x, y + 1) && maze[x][y + 1].isWall() == false) {
				successors.add(maze[x][y + 1]);
			}
			if (!hexIsInBounds(x - 1, y + 1) && maze[x - 1][y + 1].isWall() == false) {
				successors.add(maze[x - 1][y + 1]);
			}

		} else {
			if (!hexIsInBounds(x, y - 1) && maze[x][y - 1].isWall() == false) {
				successors.add(maze[x][y - 1]);
			}
			if (!hexIsInBounds(x + 1, y - 1) && maze[x + 1][y - 1].isWall() == false) {
				successors.add(maze[x + 1][y - 1]);
			}

			if (!hexIsInBounds(x + 1, y + 1) && maze[x + 1][y + 1].isWall() == false) {
				successors.add(maze[x + 1][y + 1]);
			}
			if (!hexIsInBounds(x, y + 1) && maze[x][y + 1].isWall() == false) {
				successors.add(maze[x][y + 1]);
			}

		}

		return successors;
		
		
	}
	/**
	 * 
	 * @param x 
	 * @param y : les coordonnées d'un hex
	 * @return true si le hex est situé dans les bornes de notre maze,false sinon
	 */
	public boolean hexIsInBounds(int x, int y) {
		if (x < 0 || x > (sizeMazeColum - 1) || y < 0 || y > (sizeMazeLine - 1)) {
			return true;
		}
		return false;
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
						// case D case A
						case 'E':
								this.maze[colonNum][lineNum] =new EmptyHex(this,colonNum,lineNum);break;
						case 'W':
								this.maze[colonNum][lineNum] =new WallHex(this,colonNum,lineNum);break;
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
