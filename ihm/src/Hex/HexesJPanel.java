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


import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;


public class HexesJPanel extends JPanel {
	  
		private static final long serialVersionUID = 1L;
		
		private final Polygon hexagon = new Polygon();
	    private final BasicStroke bs1 = new BasicStroke(1);
	    private final BasicStroke bs3 = new BasicStroke(3);
	    private final Point focusedHexagonLocation = new Point();
	    private final Dimension dimension;
	    private final int rows, columns, side;
	    private Point mousePosition;
	    private int current_x = -1;
	    private int current_y =-1;
	    private Hex[][] hexes;
	    private boolean mousePressed;
	    
	    
	    public HexesJPanel(final int rows, final int columns, final int side) {
	    	hexes = new Hex[columns][rows];
	        this.rows = rows;
	        this.columns = columns;
	        this.side = side;
	        mousePressed = false;
	        dimension = getHexagon(0, 0).getBounds().getSize();
	        for(int i=0;i<columns;i++) {
	        	for(int j=0;j<rows;j++) {
	        		hexes[i][j] = new Hex(i,j);
	        	}
	        }
	        MouseInputAdapter mouseHandler = new MouseInputAdapter() {
	            @Override
	            public void mouseMoved(final MouseEvent e) {
	                mousePosition = e.getPoint();
	                repaint();
	            }
	            @Override
	            public void mousePressed(final MouseEvent e) {
	                if (current_x != -1 && current_y != -1) {
	                	System.out.println(current_x);
	                	System.out.println(current_y);
	                	hexes[current_y][current_x].setLabel("W");
	                	System.out.println(hexes[current_y][current_x].getLabel());
	                	repaint();
	                }
	                repaint();
	                mousePressed = true;
	            }
	        };
	        addMouseMotionListener(mouseHandler);
	        addMouseListener(mouseHandler);
	    }

	    @Override
	    public void paintComponent(final Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
	        current_x = -1;
	        current_y = -1;
	        g2d.setStroke(bs1);
	        for (int row = 0; row < rows; row += 2) {
	            for (int column = 0; column < columns; column++) {
	                getHexagon(column * dimension.width,
	                        (int) (row * side * 1.5));
	                
	                if (mousePosition !=null && hexagon.contains(mousePosition)){
	                    focusedHexagonLocation.x = column * dimension.width;
	                    focusedHexagonLocation.y = (int) (row * side * 1.5);
	                    current_x=column;
	                    current_y=row;
	                    
	                }
	                
	                
	                g2d.setColor(Color.black);
	                
	                g2d.draw(hexagon);
	                g2d.setColor(Color.ORANGE);
					if(hexes[row][column].getLabel() == "W") {g2d.setColor(Color.BLACK);}
	                g2d.fillPolygon(hexagon);
	              
	            }
	        }
	        for (int row = 1; row < rows; row += 2) {
	            for (int column = 0; column < columns; column++) {
	                getHexagon(column * dimension.width + dimension.width / 2,
	                        (int) (row * side * 1.5 + 0.5));
	                if (mousePosition!= null && hexagon.contains(mousePosition)){
	                    focusedHexagonLocation.x = column * dimension.width
	                            + dimension.width / 2;
	                    focusedHexagonLocation.y =(int) (row * side * 1.5 + 0.5);
	                    current_x=column;
	                    current_y=row;
	                }
	                
	                g2d.setColor(Color.black);
	                g2d.draw(hexagon);
	                g2d.setColor(Color.ORANGE);
	                if(hexes[row][column].getLabel() == "W") {g2d.setColor(Color.BLACK);}
	                g2d.fillPolygon(hexagon);
	                
	                
	            }
	        }
	        if (current_x != -1 && current_y != -1) {
	            g2d.setColor(Color.red);
	            g2d.setStroke(bs3);
	            Polygon focusedHexagon = getHexagon(focusedHexagonLocation.x,
	                    focusedHexagonLocation.y);
	            g2d.draw(focusedHexagon);
	            System.out.println((hexes[current_y][current_x].getLabel()));
	            if (hexes[current_y][current_x].getLabel()=="W") {
		            g2d.setColor(Color.black);
		            g2d.fillPolygon(focusedHexagon);
	            }
	            //System.out.println( "x"+current_x + "this is y"+current_y);

	            
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
	    
	    

}
