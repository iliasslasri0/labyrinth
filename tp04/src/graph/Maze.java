package graph;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze implements Graph {
	final int sizeMaze = 10;
	MazeHex[][] maze = new MazeHex[sizeMaze][sizeMaze];
	
	/**
	 * @return A list of all the boxes possible to pass through
	 * 
	 */
	public List<Vertex> getAllVertexes(){
		
		ArrayList<MazeHex> allPossibleMazeHex = new ArrayList<MazeHex>();
		
		for (MazeHex h : maze ) {
			if (h.getLabel() == "E") {
				allPossibleMazeHex.add(h);
			}
		}	
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
			for (int lineNum=0; lineNum < sizeMaze ; lineNum++) {
				while ((line = readMazeParam.readLine()) != null) {
					for (int colonNum = 0; colonNum < sizeMaze ;colonNum++) {
						
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
				        
				      
						
						}
					}
				}
			}
			
				

			
		} catch (IOException e) {
			System.out.println("Please, Enter a valid directory.");
		}finally {
			try {  readMazeParam.close();   }catch(Exception ex){}
		}
		
		//pour écrire cette fonction on utilisera un REader de character 
		// et un switch selon les cas du charactere on construit le maze
		// ici on build the maze , on l'initie
		
	}
}
