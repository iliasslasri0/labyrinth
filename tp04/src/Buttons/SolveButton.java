package Buttons;
import javax.sound.sampled.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import graph.Dijkstra;
import graph.ShortestPathsImpl;
import graph.Vertex;
import iu.DrawingApp;
import iu.DrawingAppModel;
import maze.Maze;
import maze.MazeHex;

public class SolveButton extends JButton implements ActionListener{
	private final DrawingApp drawingApp ;
		
	   public SolveButton(final DrawingApp drawingApp)	{
	      super("Solve the maze") ;
	      this.setBackground(Color.YELLOW);
	      this.setFont(new Font("Arial", Font.BOLD, 16));
	      this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }
	   /**

	   * This method is called when the Solve button is clicked. It solves the maze using Dijkstra's 
	   * algorithm implemented and highlights the shortest path from the departure point to the arrival point.
	   * If there is no path between the departure and arrival points or
	   * if the departure and arrival points are not selected, it displays an error message. 
	   
	   @param e the ActionEvent object
	   */
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		if (drawingAppModel.isDeparturechoosed() && drawingAppModel.isArrivalchoosed()){
			try {
				drawingApp.getController().saveToTextFile(".\\data\\labyrinthe.maze");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			Dijkstra dij = new Dijkstra();
			
			//Maze(nombre de colonnes ,Nmbr de lines)
			Maze maze = new Maze(drawingAppModel.getNmbrOfcolumns(),drawingAppModel.getNmbrOfrows());
			try {
				maze.initFromTextFile(drawingAppModel.getFile());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// [colonne][line]
			MazeHex d = maze.maze[drawingAppModel.getD_y()][drawingAppModel.getD_x()];
			MazeHex a = maze.maze[drawingAppModel.getA_y()][drawingAppModel.getA_x()];
			
			ShortestPathsImpl path;
			
			path = dij.dijkstra(maze, d, a);
		
			
			List<Vertex> chemin = path.getShortestPath(a);
			
			PrintWriter out=null;
			try {
				out = new PrintWriter(drawingAppModel.getFile());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			if(chemin.contains(d)) {
				for (int j=0;j<maze.getsizeMazeColum();j++) {
					for (int i=0;i<maze.getsizeMazeLine() ;i++) {	
							if (chemin.contains(maze.maze[j][i]) && !maze.maze[j][i].equals(d) && !maze.maze[j][i].equals(a) ) {
								drawingAppModel.getHexes()[j][i].setIsInPath(true);
								out.print('.');
								drawingAppModel.stateChanged();
							}else if((maze.maze[j][i]).isWall()) {
								out.print("W");
							}else if (maze.maze[j][i].equals(d)){
								drawingAppModel.getHexes()[j][i].setIsInPath(false);
								out.print("D");
							}else if (maze.maze[j][i].equals(a)){
								drawingAppModel.getHexes()[j][i].setIsInPath(false);
								out.print("A");
							}else {
								drawingAppModel.getHexes()[j][i].setIsInPath(false);
								if (drawingAppModel.getHexes()[j][i].isWall()) {
									drawingAppModel.getHexes()[j][i].setIsWall(false);
								}
								out.print("E");
							}
						}
						out.println();
					}
					out.close();
					drawingAppModel.stateChanged();
					try {
			            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./data/victory.wav"));
			            Clip clip = AudioSystem.getClip();
			            clip.open(audioInputStream);
			            clip.start();
			        } catch (Exception e3) {
			            e3.printStackTrace();
			        }			
			}else {
				try {
		            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./data/GearWarning.wav"));
		            Clip clip = AudioSystem.getClip();
		            clip.open(audioInputStream);
		            clip.start();
		        } catch (Exception e3) {
		            e3.printStackTrace();
		        }
				JOptionPane.showMessageDialog(drawingApp,"this is no path between the departure and the arrival !",
					    "Failed!",
					    JOptionPane.ERROR_MESSAGE);
			}	
		}else {
			JOptionPane.showMessageDialog(drawingApp,"Please! choose a departure and an arrival.",
				    "detecting the arrival and the departure failed",
				    JOptionPane.ERROR_MESSAGE);
		}
		
	}
}