package Hex;

import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;

import iu.Controller;
import iu.DrawingApp;
import iu.DrawingAppModel;


public class HexesJPanel extends JPanel  implements ChangeListener{
	  
		private static final long serialVersionUID = 1L;
		
		private final Polygon hexagon = new Polygon();
	    private final BasicStroke bs1 = new BasicStroke(1);
	    private final BasicStroke bs3 = new BasicStroke(3);
	    private final Point focusedHexagonLocation = new Point();
	    private final Dimension dimension;
	    private int rows;

		private int columns;

		private final int side;
		private DrawingApp drawingApp;

		private DrawingAppModel drawingAppModel;
		private Controller controller;
	    
	    public HexesJPanel(final int side, final DrawingApp drawingApp) {
	        this.drawingApp = drawingApp;
	    	this.rows = drawingApp.getDrawingAppModel().getNmbrOfrows();
	        this.columns =drawingApp.getDrawingAppModel().getNmbrOfcolumns();
	        this.controller = drawingApp.getController();
	        this.side = side;
	        drawingApp.getDrawingAppModel().addObserver(this);
	        
	        dimension = getHexagon(0, 0).getBounds().getSize();
	        setPreferredSize(dimension);
	        
	      MouseInputAdapter mouseHandler = new MouseInputAdapter() {
	            @Override
	            public void mouseMoved(final MouseEvent e) {
	                controller.mouseMoved(e);
	                repaint();
	            }
	            @Override
	            public void mousePressed(final MouseEvent e) {
	                controller.mousePressed(e);
	                repaint();
	            }
	            
	            @Override
	            public void mouseDragged(final MouseEvent e) {
	            	controller.mouseDragged(e);
	                repaint();
	            }
	            
	        };
	        addMouseMotionListener(mouseHandler);
	        addMouseListener(mouseHandler);
	        
	    }

	    @Override
	    public void paintComponent(final Graphics g) {
	    	this.rows = drawingApp.getDrawingAppModel().getNmbrOfrows();
	        this.columns =drawingApp.getDrawingAppModel().getNmbrOfcolumns();
	        
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
	       
	        drawingAppModel = drawingApp.getDrawingAppModel();
	        drawingAppModel.setcurrent_x(-1);
	        drawingAppModel.setcurrent_y(-1);
	        g2d.setStroke(bs1);
	        for (int row = 0; row < rows; row += 2) {
	            for (int column = 0; column < columns; column++) {
	                getHexagon(column * dimension.width,
	                        (int) (row * side * 1.5));
	                if (drawingAppModel.getMousePosition() !=null && hexagon.contains(drawingAppModel.getMousePosition())){
	                    focusedHexagonLocation.x = column * dimension.width;
	                    focusedHexagonLocation.y = (int) (row * side * 1.5);
	                    drawingAppModel.setcurrent_x(row);
	                    drawingAppModel.setcurrent_y(column);
	                }
	                
	                
	                g2d.setColor(Color.black);
	                
	                g2d.draw(hexagon);
	                g2d.setColor(Color.ORANGE);
					if(drawingAppModel.getHexes()[column][row].isWall()) {g2d.setColor(Color.BLACK);}else if (drawingAppModel.getHexes()[column][row].equals(drawingAppModel.getDepartHex())) {
						g2d.setColor(Color.green);
					}else if (drawingAppModel.getHexes()[column][row].equals(drawingAppModel.getArrivalHex())) {
						g2d.setColor(Color.red);
					}
					if (drawingAppModel.getHexes()[column][row].isInPath()) {
						g2d.setColor(Color.white);
					}
	                g2d.fillPolygon(hexagon);
	              
	            }
	        }
	        for (int row = 1; row < rows; row += 2) {
	            for (int column = 0; column < columns; column++) {
	                getHexagon(column * dimension.width + dimension.width / 2,
	                        (int) (row * side * 1.5 + 0.5));
	                if (drawingAppModel.getMousePosition()!= null && hexagon.contains(drawingAppModel.getMousePosition())){
	                    focusedHexagonLocation.x = column * dimension.width + dimension.width / 2;
	                    focusedHexagonLocation.y =(int) (row * side * 1.5 + 0.5);
	                    drawingAppModel.setcurrent_x(row);
	                    drawingAppModel.setcurrent_y(column);
	                }
	                g2d.setColor(Color.black);
	                g2d.draw(hexagon);
	                g2d.setColor(Color.ORANGE);
	                if(drawingAppModel.getHexes()[column][row].isWall()) {g2d.setColor(Color.BLACK);}else if (drawingAppModel.getHexes()[column][row].equals(drawingAppModel.getDepartHex())) {
						g2d.setColor(Color.green);
					}else if (drawingAppModel.getHexes()[column][row].equals(drawingAppModel.getArrivalHex())) {
						g2d.setColor(Color.red);
					}
	                if (drawingAppModel.getHexes()[column][row].isInPath()) {
						g2d.setColor(Color.white);
					}
					
	                
	                g2d.fillPolygon(hexagon);
	                
	                
	            }
	        }
	        if (drawingAppModel.getcurrent_x() != -1 && drawingAppModel.getcurrent_y() != -1) {
	            g2d.setColor(Color.red);
	            g2d.setStroke(bs3);
	            Polygon focusedHexagon = getHexagon(focusedHexagonLocation.x,
	                    focusedHexagonLocation.y);
	            g2d.draw(focusedHexagon);
	            if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].isWall()) {
		            g2d.setColor(Color.black);
		            g2d.fillPolygon(focusedHexagon);
	            }else if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].equals(drawingAppModel.getDepartHex())) {
					g2d.setColor(Color.green);
					g2d.fillPolygon(focusedHexagon);
				}else if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].equals(drawingAppModel.getArrivalHex())) {
					g2d.setColor(Color.red);
					g2d.fillPolygon(focusedHexagon);
				}else if (drawingAppModel.getHexes()[drawingAppModel.getcurrent_y()][drawingAppModel.getcurrent_x()].isInPath()) {
		            g2d.setColor(Color.white);
		            g2d.fillPolygon(focusedHexagon);
	            }
	        }
	    }
	    
	    public Polygon getHexagon(final int x, final int y) {
	        hexagon.reset();
	        int h = side / 2;
	        int w = (int) (side * (Math.sqrt(3) / 2));
	        hexagon.addPoint(x, y + h);
	        hexagon.addPoint(x + w, y);
	        hexagon.addPoint(x + 2 * w, y + h);
	        hexagon.addPoint(x + 2 * w, y + (int) (1.5 * side));
	        hexagon.addPoint(x + w, y + 2 * side);
	        hexagon.addPoint(x, y + (int) (1.5 * side));
	        return hexagon;
	    }

		@Override
		public void stateChanged(ChangeEvent e) {
			repaint();
		}
}
