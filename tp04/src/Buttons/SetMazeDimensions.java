package Buttons;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import iu.DrawingApp;
import iu.DrawingAppModel;

public class SetMazeDimensions extends JButton implements ActionListener{

	   private final DrawingApp drawingApp ;
		
	   public SetMazeDimensions(final DrawingApp drawingApp)	{
	      super("Set maze dimensions") ; // Button's text
	      this.setBackground(Color.YELLOW);
	      this.setFont(new Font("Arial", Font.BOLD, 16));
	      this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	      this.drawingApp = drawingApp ;
	      addActionListener(this) ;
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = new String[]{"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23", "24"};
	    JComboBox<String> comboBox = new JComboBox<>(options);

	    int result = JOptionPane.showConfirmDialog(null, comboBox, "Select the number of columns", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	        String selectedOption = (String) comboBox.getSelectedItem();
	        drawingApp.getDrawingAppModel().setNmbrOfcolumns(Integer.parseInt(selectedOption));
	        drawingApp.getDrawingAppModel().stateChanged();
	        drawingApp.getController().resetAll();
	    }
		
		
		
	    String[] options2 = new String[]{"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
	    JComboBox<String> comboBox2 = new JComboBox<>(options2);

	    int result2 = JOptionPane.showConfirmDialog(null, comboBox2, "Select the number of rows", JOptionPane.OK_CANCEL_OPTION);
	    if (result2 == JOptionPane.OK_OPTION) {
	        String selectedOption2 = (String) comboBox2.getSelectedItem();
	        drawingApp.getDrawingAppModel().setNmbrOfrows(Integer.parseInt(selectedOption2));
	        drawingApp.getDrawingAppModel().stateChanged();
	        drawingApp.getController().resetAll();
	    }
	}
	}