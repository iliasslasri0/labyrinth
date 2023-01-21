package iu;

import javax.imageio.ImageIO;
import javax.swing.* ;

import Buttons.ButtonsPanel;

import Hex.HexesJPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WindowPanel extends JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private ButtonsPanel buttonsPanel ;
   private HexesJPanel panel ;
    
   public WindowPanel(DrawingApp drawingApp) throws IOException {
      setLayout(new BorderLayout()) ;
      /*BufferedImage myPicture = ImageIO.read(new File(".\\data\\telecom.png"));
      //Image imgScaled = myPicture.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
      JLabel picLabel = new JLabel(new ImageIcon(imgScaled));
      picLabel.setBounds(550, 400,500,500);
      this.add(picLabel,BorderLayout.LINE_END);*/
      this.add(panel = new HexesJPanel(40,drawingApp),BorderLayout.CENTER);
      this.add(buttonsPanel = new ButtonsPanel (drawingApp), BorderLayout.SOUTH) ;
      
   }
   public void notifyForUpdate() {
	  // panel.notifyForUpdate() ;
	   
	}
}
