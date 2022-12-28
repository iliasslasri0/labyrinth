import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

	public ButtonPanel() {
        super();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200,100));
        setBackground(Color.yellow);
        JButton jb1 = new JButton("action");
        add(jb1, BorderLayout.WEST);
        jb1.setPreferredSize(new Dimension(300,100));
        JButton jb2 = new JButton("action 2");
        jb2.setPreferredSize(new Dimension(300,100));
        add(jb2, BorderLayout.CENTER);
        JButton jb3 = new JButton("action 3");
        add(jb3, BorderLayout.EAST);
        jb3.setPreferredSize(new Dimension(300,100));
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
}