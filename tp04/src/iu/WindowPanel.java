package iu;

import javax.swing.* ;

import Buttons.ButtonsPanel;
import Hex.HexesJPanel;
import java.awt.*;
import java.io.IOException;

public class WindowPanel extends JPanel {

   private ButtonsPanel buttonsPanel ;
   private HexesJPanel panel ;
   
   public WindowPanel(DrawingApp drawingApp) throws IOException {
      setLayout(new BorderLayout()) ;
      this.add(panel = new HexesJPanel((int)(40 * 15/drawingApp.getDrawingAppModel().getNmbrOfrows()),drawingApp),BorderLayout.CENTER);
      this.add(buttonsPanel = new ButtonsPanel (drawingApp), BorderLayout.SOUTH) ;
   }
   
   public void notifyForUpdate() {
	   panel.stateChanged(null);
	}
}
