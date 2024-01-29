import javax.swing.*;
import java.awt.*;

public class basicframe {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Setting up a frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 500, 500, 500);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
