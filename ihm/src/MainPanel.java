import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;

	public MainPanel() {
        super();
        setBackground(Color.darkGray);
        setLayout(new BorderLayout());
        JCPanel jcp = new JCPanel(0,0);
        add(jcp, BorderLayout.CENTER);
        JCPanel jcp1 = new JCPanel(1,1);
        add(jcp1, BorderLayout.CENTER);
        ButtonPanel p2 = new ButtonPanel();
        add(p2, BorderLayout.SOUTH);
    }
}
