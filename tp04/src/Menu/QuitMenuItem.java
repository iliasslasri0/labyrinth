package Menu;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.* ;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class QuitMenuItem extends JMenuItem implements ActionListener{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;

	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit") ; // Text of menu item

		this.drawingApp = drawingApp ;
		addActionListener(this) ;
   }

	@Override
	public void actionPerformed(ActionEvent evt) {
	      DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel() ;
		   
	      if (drawingAppModel.isModified()) {
	         int response = JOptionPane.showInternalOptionDialog(this,
	                                                             "Drawing not saved. Save it ?",
	                                                             "Quit application",
	                                                             JOptionPane.YES_NO_CANCEL_OPTION,
	                                                             JOptionPane.WARNING_MESSAGE,
	                                                             null,null,null) ;
			   switch (response) {
			   case JOptionPane.CANCEL_OPTION:
				   return ;
			   case JOptionPane.OK_OPTION:
				   String fileName = JOptionPane.showInputDialog(drawingApp, "Name of the File");
					int n = fileName.length();
					for (int i = 0; i < n; i++) {
						String c = String.valueOf(fileName.charAt(i));
					}
				try {
					drawingApp.getDrawingAppModel().saveToTextFile("./data/"+fileName+".txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break ;
			   case JOptionPane.NO_OPTION:
				   break ;
			   }
		   }
		   System.exit(0) ;
	   }
	
}