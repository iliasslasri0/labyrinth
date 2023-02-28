package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.* ;
import iu.DrawingApp;
import iu.DrawingAppModel;

public class QuitMenuItem extends JMenuItem implements ActionListener{
	
	private final DrawingApp drawingApp ;

	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit") ;

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
				   JFileChooser fileChooser = new JFileChooser();
					File file = null;
					fileChooser.setCurrentDirectory(new File(".")); //sets current directory
					int response1 = fileChooser.showSaveDialog(null); //select file to save( giving a name to the file that we are saving)
					if(response1 == JFileChooser.APPROVE_OPTION) {
						file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					}
					if(file !=null) {
					try {
						drawingApp.getController().saveToTextFile(file+".txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					}
				   break ;
			   case JOptionPane.NO_OPTION:
				   break ;
			   }
		   }
		   System.exit(0) ;
	   }
	
}