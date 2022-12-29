import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;

	public MainPanel() {
        super();
       setBackground(Color.darkGray);
        GridLayout gl = new GridLayout(2,10);
        this.setLayout(gl);
        for (int i=0;i<10;i++) {
        	JCPanel jcp = new JCPanel();
            add(jcp);
        }
        //ButtonPanel p2 = new ButtonPanel();
        //add(p2);
    
        
}
}