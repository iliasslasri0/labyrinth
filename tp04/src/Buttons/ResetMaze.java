package Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import iu.DrawingApp;

public class ResetMaze extends JButton implements ActionListener{

	   private final DrawingApp drawingApp ;
		
	   public ResetMaze(final DrawingApp drawingApp)	{
	      super("Reset the maze") ;
	      this.setBackground(Color.YELLOW);
	      this.setFont(new Font("Arial", Font.BOLD, 16));
	      this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		drawingApp.getController().resetAll();
	}
	}

