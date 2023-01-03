package Hex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import iu.DrawingApp;
import model.DrawingAppModel;

public class HexesJPanel extends JPanel {
	private DrawingApp drawingApp; 
	private HexJPanel[][] hexesJPanel ;
	HexJPanelMouseListener	hexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
	
	
	public HexesJPanel(DrawingApp drawingApp){
		this.drawingApp = drawingApp ;
		
		setBackground(Color.WHITE) ;

	      // for pack() instruction
	     setPreferredSize(new Dimension(300,300)) ;  
	      
		addMouseListener(hexJPanelMouseListener);
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		int width = drawingAppModel.getWidth();
		int height = drawingAppModel.getHeight();

		hexesJPanel = new HexJPanel[height][width];
		
		for(int i =0;i< height;i++) {
			for(int j =0;j< width;j++) {
				Hex hex = new Hex(j, j,"E");
				HexJPanel hexPanel = new HexJPanel(drawingApp,hex);
				hexesJPanel[i][j] = hexPanel;
				add(hexPanel);
			}
		}
		setBackground(Color.WHITE);
		
	}
	
	   @Override
	   protected void paintComponent(Graphics graphics) {
	      // Paint the background
	      super.paintComponent(graphics) ;
			
	  
	      drawingApp.getDrawingAppModel().paint(graphics) ;
	   }
	   
	   public void notifyForUpdate() {
		   repaint() ;		
		}


}
