package graph;
import java.util.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze implements Graph {
	final int sizeMazeLine;
	final int sizeMazeColum ;
	private MazeHex[][] maze;
	public Maze(int colums,int lines) {
		sizeMazeColum = colums;
		sizeMazeLine = lines ;
	}
	/**
	 * @return A list of all the boxes possible to pass through
	 * 
	 */

	public List<Vertex> getAllVertexes(){
		
		ArrayList<Vertex> allPossibleMazeHex = new ArrayList<Vertex>();
		
		for (MazeHex[] h : maze ) {
			for (MazeHex hex : h){
			if (hex.getLabel() == "E") {
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
		
		List<Vertex> neighbors = new ArrayList<Vertex>();
		MazeHex Hex = (MazeHex) vertex ;
		
		int x = Hex.getX();
		int y = Hex.getY();
		if (x == 0) {
			if (y == 0) {
				neighbors.add(maze[0][1]);
				neighbors.add(maze[1][0]);
			}
			else {
				neighbors.add(maze[x][y-1]);
				neighbors.add(maze[x][y+1]);
				neighbors.add(maze[x+1][y]);
				
			}
			
		}else if(x==9){
			if (y==9) {
				neighbors.add(maze[9][8]);
				neighbors.add(maze[8][9]);
			}else {
				neighbors.add(maze[x][y-1]);
				neighbors.add(maze[x][y+1]);
				neighbors.add(maze[x-1][y]);
				
			}
			
		}
		if (y== 0) {
			neighbors.add(maze[x-1][1]);
			neighbors.add(maze[x][1]);
		}else if (y==9){
			neighbors.add(maze[x+1][8]);
			neighbors.add(maze[x][18]);
		}
		else {
			neighbors.add(maze[x-1][y-1]);
			neighbors.add(maze[x-1][y+1]);
			neighbors.add(maze[x-1][y]);
			neighbors.add(maze[x][y-1]);
			neighbors.add(maze[x][y+1]);
			neighbors.add(maze[x+1][y]);
		}
		return (ArrayList<Vertex>)neighbors; 
	}
	/**
	 * @return the weight of the arc src to dst 
	 */
	public int getWeight(Vertex src, Vertex dst) {
		return 1;	
	}
	
	/**
	 * Read the text file that describes thes maze
	 * @param fileName
	 */
	public final void initFromTextFile(String fileName) {
		
		try {
			BufferedReader readMazeParam = new BufferedReader(new FileReader(fileName));
			String line;
			for (int lineNum=0; lineNum < sizeMazeLine ; lineNum++) {
					if (line == null) {throw new MazeReadingException(fileName, lineNum, "Increasing the number of lines is required");}
					if ( line.length() > this.sizeMazeColum) { throw new MazeReadingException(fileName,lineNum,"Reducing the number of columns is required");}
					if ( line.length() < this.sizeMazeColum) { throw new MazeReadingException(fileName,lineNum,"Increasing the number of columns is required");}
					
					for (int colonNum = 0; colonNum < sizeMazeColum ;colonNum++) {
						System.out.println(line.charAt(colonNum));
						switch (line.charAt(colonNum))
						{
						case 'A':
								maze[lineNum][colonNum] =new ArrivalHex(this,colonNum,lineNum);break;
						case 'D':
						        maze[lineNum][colonNum] =new DepartureHex(this,colonNum,lineNum);break;
						case 'E':
								maze[lineNum][colonNum] =new EmptyHex(this,colonNum,lineNum);break;
						case 'W':
								maze[lineNum][colonNum] =new WallHex(this,colonNum,lineNum);break;
				        default :
				        	throw new MazeReadingException(fileName , lineNum , "Inkown character");
						
						}
					 }
			
				

			}	
		} catch (IOException e) {
			System.out.println("Please, Enter a valid directory.");
		}
	}
	
	/*
	 * This method saves the state of the maze in a text file
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
