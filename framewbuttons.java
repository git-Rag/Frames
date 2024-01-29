import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class framewbuttons implements ActionListener {

    private JButton b1, b2, b3;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new framewbuttons().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Button Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1 = new JButton("Disable middle button", createImageIcon("images/right.gif"));
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");
        b1.addActionListener(this);
        b1.setToolTipText("Click this button to disable the middle button.");

        b2 = new JButton("Middle button", createImageIcon("images/middle.gif"));
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setToolTipText("This middle button does nothing when you click it.");

        b3 = new JButton("Enable middle button", createImageIcon("images/left.gif"));
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.addActionListener(this);
        b3.setToolTipText("Click this button to enable the middle button.");

        JPanel panel = new JPanel();
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("disable".equals(e.getActionCommand())) {
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
        } else if ("enable".equals(e.getActionCommand())) {
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = framewbuttons.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
