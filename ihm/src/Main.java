import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
        new Main();
    }

    public Main() {
        super("Labyrinthe");
        
        MainPanel panel = new MainPanel();

        setContentPane(panel);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu menu = new JMenu("File");
        mb.add(menu);
        JMenuItem menuItem = new JMenuItem("Quit");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,1000));
        pack();
        setVisible(true);
    }
}