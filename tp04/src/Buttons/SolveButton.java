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
		try {
			maze.initFromTextFile(drawingAppModel.getFile());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// [colonne][line]
		MazeHex d = maze.maze[drawingAppModel.getD_y()][drawingAppModel.getD_x()];
		MazeHex a = maze.maze[drawingAppModel.getA_y()][drawingAppModel.getA_x()];
		
		ShortestPathsImpl path;
		
		path = dij.dijkstra(maze, d, a);
	
		
		List<Vertex> chemin = path.getShortestPath(a);

		
		/*try (PrintWriter pw = new PrintWriter(drawingAppModel.getFile())) {
			for (int j=0;j<maze.getsizeMazeColum();j++) {
			for (int i=0;i<maze.getsizeMazeLine() ;i++) {
				
					if (chemin.contains(maze.maze[i][j]) ) {
						drawingAppModel.getHexes()[i][j].setLabel("C");
						pw.print('C');
					}else if((maze.maze[i][j]).isWall()) {
						pw.print("W");
						
					}else {
						pw.print("E");
					}
				}
				
				pw.println();
			}
			pw.close();
		}catch(Exception ex) {	
		}*/
		
		
		PrintWriter out=null;
		try {
			out = new PrintWriter(drawingAppModel.getFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int j=0;j<maze.getsizeMazeColum();j++) {
		for (int i=0;i<maze.getsizeMazeLine() ;i++) {
			
				if (chemin.contains(maze.maze[i][j]) && !maze.maze[i][j].equals(d) && !maze.maze[i][j].equals(a) ) {
					drawingAppModel.getHexes()[i][j].setLabel("C");
					out.print('C');
				}else if((maze.maze[i][j]).isWall()) {
					out.print("W");
					
				}else {
					out.print("E");
				}
			}
			out.println();
		}
		out.close();
		
	}
}