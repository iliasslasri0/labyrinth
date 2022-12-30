package Hex;

import java.awt.Color;



import javax.swing.JPanel;

import iu.DrawingApp;
import model.DrawingAppModel;

public class HexesJPanel extends JPanel {
	private DrawingApp drawingApp; 
	private HexJPanel[][] hexesJPanel ;
	HexJPanelMouseListener	hexJPanelMouseListener = new HexJPanelMouseListener(drawingApp);
	
	
	public HexesJPanel(DrawingApp drawingApp){
		this.drawingApp = drawingApp ;
		addMouseListener(hexJPanelMouseListener);
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();
		int width = drawingAppModel.getWidth();
		int height = drawingAppModel.getHeight();

		hexesJPanel = new HexJPanel[height][width];
		Hex[][] boxesModel = drawingAppModel.getHexes();
		for(Hex[] rows : boxesModel) {
			for(Hex hex : rows) {
				int i = hex.getX();
				int j = hex.getY();
				HexJPanel hexPanel = new HexJPanel(drawingApp,hex);
				hexesJPanel[i][j] = hexPanel;
				add(hexPanel);
			}
		}
		setBackground(Color.WHITE);
		
	}


}
