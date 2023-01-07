package Hex;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import iu.DrawingApp;
import model.DrawingAppModel;

public class HexesJPanel extends JPanel {
	private final DrawingApp drawingApp; 
	private  ArrayList<ArrayList<HexJPanel>> hexesJPanel = new ArrayList<ArrayList<HexJPanel>>();
	private HexJPanel hexJPanel;
	
	public HexesJPanel(DrawingApp drawingApp){
		
		this.drawingApp = drawingApp ;
		
		setBackground(Color.WHITE) ;

	      // for pack() instruction
	     setPreferredSize(new Dimension(300,300)) ;  
	      
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		int width = drawingAppModel.getWidth();
		int height = drawingAppModel.getHeight();
		ArrayList<ArrayList<HexJPanel>> hexes = drawingAppModel.getHexes();
		/*
		for(int i =0;i< height;i++) {
			ArrayList<HexJPanel> list = new ArrayList<HexJPanel>();
			for(int j =0;j< width;j++) {
				
				HexJPanel hex = new HexJPanel(i, j);
				list.add(j,hex);
				drawingApp.add(hex);
			}
			hexesJPanel.add(i,list);
		}*/

		
		
		setBackground(Color.WHITE);
	}
	
	   @Override
	   protected void paintComponent(Graphics graphics) {
	      // Paint the background
	      super.paintComponent(graphics) ;
			
	  
	      for(int x=0;x<10;x++) {
	    	  for (int y=0;y<10;y++) {
	    		  add( hexJPanel = new HexJPanel(drawingApp, x,y));
	    		  
	    		  
	    	  }
	   
	    	  
	      }
	      setBackground(Color.WHITE) ;
			
	      setPreferredSize(new Dimension(300,300)) ;
	   }

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		
	}
	


}
