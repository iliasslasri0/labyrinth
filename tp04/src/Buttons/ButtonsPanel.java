package Buttons;

import java.awt.*;
import javax.swing.* ;

import iu.DrawingApp;

public class ButtonsPanel extends JPanel {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   private final ResetMaze resetMaze ;
   private final SolveButton solveButton;
   private final DepartButton departButton;
   private final ArrivalButton arrivalButton;
   private final SetMazeDimensions setMazeDimensions;
   
   
   public ButtonsPanel(final DrawingApp drawingApp) {
	   drawingApp.setLayout(new GridLayout(3,1)) ; // 3 row, 1 columns
		
	  add(setMazeDimensions = new SetMazeDimensions(drawingApp));
	   add(resetMaze   = new ResetMaze(drawingApp)) ;
	   add(solveButton   = new SolveButton(drawingApp)) ;
	   add(departButton = new DepartButton(drawingApp));
	   add(arrivalButton = new ArrivalButton(drawingApp));
   }
}

