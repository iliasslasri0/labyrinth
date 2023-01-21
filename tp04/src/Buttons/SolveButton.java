package Buttons;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

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

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;
		
	   public SolveButton(DrawingApp drawingApp)	{
	      super("Solve the maze") ;
			
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		if (drawingAppModel.isDeparturechoosed() && drawingAppModel.isArrivalchoosed()){
			try {
				drawingAppModel.saveToTextFile();
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
								drawingAppModel.getHexes()[j][i].setLabel("C");
								out.print('C');
								drawingAppModel.stateChanged();
							}else if((maze.maze[j][i]).isWall()) {
								out.print("W");
								
							}else {
								if (drawingAppModel.getHexes()[j][i].getLabel()=="C") {
									drawingAppModel.getHexes()[j][i].setLabel("E");
								}
								out.print("E");
							}
						}
						out.println();
					}
					out.close();
					try {
			            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./data/victory.wav"));
			            Clip clip = AudioSystem.getClip();
			            clip.open(audioInputStream);
			            clip.start();
			        } catch (Exception e3) {
			            e3.printStackTrace();
			        }
					JOptionPane.showMessageDialog(drawingApp,"Congrats!");
					drawingAppModel.stateChanged();
					
			}else {
				try {
		            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./data/GearWarning.wav"));
		            Clip clip = AudioSystem.getClip();
		            clip.open(audioInputStream);
		            clip.start();
		        } catch (Exception e3) {
		            e3.printStackTrace();
		        }
				JOptionPane.showMessageDialog(drawingApp,"this is no path between the departure and the arrival",
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