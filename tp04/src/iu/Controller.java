package iu;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import Hex.Hex;
import maze.EmptyHex;
import maze.MazeReadingException;
import maze.WallHex;

//Controler
public class Controller{
	private DrawingApp drawingApp;
	private DrawingAppModel drawingAppModel;
	
	public Controller(DrawingApp drawingApp,DrawingAppModel drawingAppModel) {
		
		this.drawingApp = drawingApp;
		this.drawingAppModel = drawingAppModel;
	}
	

	public void mouseMoved(final MouseEvent e) {
        drawingAppModel.setMousePosition(e.getPoint());
        drawingAppModel.stateChanged();
    }
	/**

	* Updates the state of the hexagon grid
	* based on the mouse click. If the hexagon clicked is a wall, it will be set to non-wall and non-in-path.
	* If the hexagon clicked is not a wall or in-path, it will be set to a wall. If the hexagon clicked is
	* the departure or arrival hexagon, it will be set to non-wall and non-in-path and the corresponding
	* departure or arrival hexagon will be set to null. If a departure or arrival hexagon is currently being
	* chosen, it will set the chosen hexagon and update the state accordingly. It also updates the modified
	* flag of the drawingAppModel and notifies any observers of a state change.
	@param e the MouseEvent containing the mouse click information
	*/

	public void mousePressed(final MouseEvent e) {
		drawingAppModel.setMousePosition(e.getPoint());
		int current_x = drawingAppModel.getCurrent_x();
		int current_y = drawingAppModel.getCurrent_y();
		Hex[][] hexes= drawingAppModel.getHexes();
        if (current_x != -1 && current_y != -1) {
        	if(hexes[current_y][current_x].isWall()) {
        		hexes[current_y][current_x].setIsWall(false);
        		hexes[current_y][current_x].setIsInPath(false);
        	}else if( !(hexes[current_y][current_x].isWall() )| hexes[current_y][current_x].isInPath() ){
				if (hexes[current_y][current_x].equals(drawingAppModel.getDepartHex())) {
					hexes[current_y][current_x].setIsInPath(false);
	        		hexes[current_y][current_x].setIsWall(false);
					drawingAppModel.setDeparturechoosed(false);
					drawingAppModel.setdepartHex(null);
        		}else if (hexes[current_y][current_x].equals(drawingAppModel.getArrivalHex())) {
        			hexes[current_y][current_x].setIsInPath(false);
            		hexes[current_y][current_x].setIsWall(false);
        			drawingAppModel.setArrivalchoosed(false);
    				drawingAppModel.setArrivalHex(null);
        		}else {
        			hexes[current_y][current_x].setIsInPath(false);
            		hexes[current_y][current_x].setIsWall(true);
        		}
        		hexes[current_y][current_x].setIsWall(true);
        	}
        	if (drawingAppModel.getIfdepartEncours() ) {
        		hexes[current_y][current_x].setIsInPath(false);
        		hexes[current_y][current_x].setIsWall(false);
        		drawingAppModel.setdepartHex(hexes[current_y][current_x]);
        		drawingAppModel.setD_x(current_x);
        		drawingAppModel.setD_y (current_y);
        		drawingAppModel.setDepartureEncours (false);
        		drawingAppModel.setDeparturechoosed(true);
        	}
        	if (drawingAppModel.getIfarrivalEncours() ) {
        		hexes[current_y][current_x].setIsInPath(false);
        		hexes[current_y][current_x].setIsWall(false);
        		drawingAppModel.setArrivalHex(hexes[current_y][current_x]);
        		drawingAppModel.setA_x(current_x);
        		drawingAppModel.setA_y (current_y);
        		drawingAppModel.setArrivalEncours (false);
        		drawingAppModel.setArrivalchoosed(true);
        	}
        	drawingAppModel.stateChanged();
        }
        drawingAppModel.stateChanged();
        drawingAppModel.setModified(true);
    }

	/**
	 * Called during a mouse drag operation to update the state of the maze based on the new mouse position.
	 * This method sets the mouse position in the drawingAppModel and updates the state of the maze based on
	 * the current mouse position. If the mouse position is on a wall or in a path, the corresponding box is
	 * set to a wall state. If the mouse position is on the departure or arrival box, the corresponding box is
	 * reset to a non-departure/arrival state. The method then updates the state of the maze in the drawingAppModel
	 * and sets the modified flag to true.
	 *
	 * @param e the MouseEvent containing the current mouse position
	 */
	public void mouseDragged(final MouseEvent e) {
		drawingAppModel.setMousePosition(e.getPoint());
        if (drawingAppModel.getcurrent_x() != -1 && drawingAppModel.getcurrent_y() != -1) {
        	if(!drawingAppModel.gethexprev().equals(drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()])) {
        		if(drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].isWall()) {
        			drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].setIsWall(false);
        		}else if(!drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].isWall() | drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].isInPath()){
        			if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].equals(drawingAppModel.getDepartHex())) {
        							drawingAppModel.setDeparturechoosed(false);
        							drawingAppModel.setdepartHex(null);
        			        		}else if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].equals(drawingAppModel.getArrivalHex())) {
        			        			drawingAppModel.setArrivalchoosed(false);
        			        			drawingAppModel.setArrivalHex(  null);
        			        		}
        			drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].setIsWall(true);
                	}
                	drawingAppModel.stateChanged();
                	 	
        	}
        	drawingAppModel.sethexprev(drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()]);
        	drawingAppModel.setModified(true);
        }
        drawingAppModel.stateChanged();
		
	}
	
	/**
	 * Saves the current state of the maze to a text file with the specified file name.
	 * This method uses a PrintWriter to write the maze state to a text file in a format that can be loaded
	 * later. Each wall box is represented by a 'W' character, each path box is represented by a '.' character,
	 * the departure box is represented by a 'D' character, the arrival box is represented by an 'A' character.
	 *
	 * @param fileName the name of the text file to save the maze state to
	 * @throws FileNotFoundException if the specified file cannot be created or opened for writing
	 */
	public final void saveToTextFile(final String fileName)throws FileNotFoundException{
		try (PrintWriter pw = new PrintWriter(fileName)) {
			for (int lineNum = 0; lineNum < drawingAppModel.getNmbrOfrows(); lineNum++) {
				for (int columNum=0; columNum < drawingAppModel.getNmbrOfcolumns(); columNum++ ) {
					if(drawingAppModel.getHexes()[columNum][lineNum].isWall()) {
						pw.print("W");
					}else if (drawingAppModel.getHexes()[columNum][lineNum].isInPath()){
						pw.print(".");
					}else if(drawingAppModel.getHexes()[columNum][lineNum].equals(drawingAppModel.getDepartHex())) {
						pw.print("D");
					}else if (drawingAppModel.getHexes()[columNum][lineNum].equals(drawingAppModel.getArrivalHex())) {
						pw.print("A");
					}else {
						pw.print("E");
					}
				}
				pw.println();
			}
		}catch(Exception ex) {	
		}
		drawingAppModel.stateChanged();
	}
	
	/**
	* Initializes the model by reading a maze configuration from a text file.
	@param file the file containing the maze configuration.
	@throws MazeReadingException if there is an error reading the maze configuration from the file.
	*/
	public final void initFromTextFile(File file) throws Exception {
		try (BufferedReader readMazeParam = new BufferedReader(new FileReader(file))) {
			String line=readMazeParam.readLine();
			if (line == null) {throw new MazeReadingException(file, 0, "Increasing the number of lines is required");}
			drawingAppModel.setNmbrOfcolumns( line.length() );
			int lineNum=0;
			while(line!=null) {
					lineNum+=1;
					line = readMazeParam.readLine();
			}
			drawingAppModel.setNmbrOfrows(lineNum);
			resetAll();
			try (BufferedReader readMazeParam0 = new BufferedReader(new FileReader(file))) {
				String line0;
				for (lineNum=0; lineNum < drawingAppModel.getNmbrOfrows() ; lineNum++) {
						line0 = readMazeParam0.readLine();
						if (line0 == null) {throw new MazeReadingException(file, lineNum, "Increasing the number of lines is required");}
						if ( line0.length() > drawingAppModel.getNmbrOfcolumns()) { throw new MazeReadingException(file,lineNum,"Reducing the number of columns is required");}
						if ( line0.length() < drawingAppModel.getNmbrOfcolumns()) { throw new MazeReadingException(file,lineNum,"Increasing the number of columns is required");}
						
						for (int colonNum = 0; colonNum < drawingAppModel.getNmbrOfcolumns() ;colonNum++) {
						
						switch (line0.charAt(colonNum))
						{
						case '.':
							drawingAppModel.getHexes()[colonNum][lineNum] =new Hex(colonNum,lineNum,false,true);break;
						case 'W':
							drawingAppModel.getHexes()[colonNum][lineNum] =new Hex(colonNum,lineNum,true,false);break;
						case 'A':
							drawingAppModel.getHexes()[colonNum][lineNum] =new Hex(colonNum,lineNum,false,false);
							drawingAppModel.setArrivalHex( drawingAppModel.getHexes()[colonNum][lineNum] );
							drawingAppModel.setA_x(lineNum);
							drawingAppModel.setA_y(colonNum);
							drawingAppModel.setArrivalchoosed(true);
							break;
						case 'D':
							drawingAppModel.getHexes()[colonNum][lineNum] =new Hex(colonNum,lineNum,false,false);
							drawingAppModel.setdepartHex( drawingAppModel.getHexes()[colonNum][lineNum] );
							drawingAppModel.setD_x(lineNum);
							drawingAppModel.setD_y(colonNum);
							drawingAppModel.setDeparturechoosed(true);
							break;
						default:
							drawingAppModel.getHexes()[colonNum][lineNum] =new Hex(colonNum,lineNum,false,false);break;
						}
					 }
					
}
				readMazeParam.close();
				readMazeParam0.close();
			}
			} catch (IOException e) {
		}
	}
	public void resetAll() {
		for(int i=0;i<drawingAppModel.getNmbrOfcolumns();i++) {
        	for(int j=0;j<drawingAppModel.getNmbrOfrows();j++) {
        		drawingAppModel.getHexes()[i][j] = new Hex(j,i,false,false);
        	}
        }
		drawingAppModel.setArrivalHex(null);
		drawingAppModel.setdepartHex(null);
		drawingAppModel.setDeparturechoosed(false);
		drawingAppModel.setArrivalchoosed(false);
		drawingAppModel.stateChanged();
	}
}
