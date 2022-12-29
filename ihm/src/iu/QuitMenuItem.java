package iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.* ;

public class QuitMenuItem extends JMenuItem {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;

	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit") ; // Text of menu item

		this.drawingApp = drawingApp ;
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
   }
}