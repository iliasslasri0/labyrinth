package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JButton;

import graph.Dijkstra;
import graph.ShortestPathsImpl;
import graph.Vertex;
import iu.DrawingApp;
import iu.DrawingAppModel;
import maze.Maze;
import maze.MazeHex;

public class SolveButton extends JButton implements ActionListener{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;
		
	   public SolveButton(DrawingApp drawingApp)	{
	      super("Solve the maze") ; // Button's text
			
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel(); 
		try {
			drawingAppModel.saveToTextFile();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Dijkstra dij = new Dijkstra();
		//Maze(nombre de colonnes , Nmbr de lines)
		Maze maze = new Maze(drawingAppModel.getWidth(),drawingAppModel.getHeight());
		
		//System.out.println(maze.maze.length);
		//System.out.println(maze.maze[0].length);
		maze.initFromTextFile(drawingAppModel.getFile());
		
		// [colonne][line]
		//MazeHex d = maze.maze[3][14];
	//	MazeHex a = maze.maze[2][2];
		
		ShortestPathsImpl path;
		
		path = dij.dijkstra(maze, d, a);
	
		
		List<Vertex> chemin = path.getShortestPath(a);

		
		
		for (int i=0;i<maze.getsizeMazeLine() ;i++) {
			for (int j=0;j<maze.getsizeMazeColum();j++) {
				if (chemin.contains(maze.maze[j][i])) {
					
					System.out.print('.');
				}else if((maze.maze[j][i]).isWall()) {
					System.out.print("W");
					
				}else {
					System.out.print("E");
				}
			}
			System.out.print("\n");
		}
		
		try (PrintWriter pw = new PrintWriter(drawingAppModel.getFile())) {
			for (int i=0;i<maze.getsizeMazeLine() ;i++) {
				for (int j=0;j<maze.getsizeMazeColum();j++) {
					if (chemin.contains(maze.maze[j][i])) {
						
						pw.print('.');
					}else if((maze.maze[j][i]).isWall()) {
						pw.print("W");
						
					}else {
						pw.print("E");
					}
				}
				
				pw.println();
			}
		}catch(Exception ex) {	
		}
		
	}
}