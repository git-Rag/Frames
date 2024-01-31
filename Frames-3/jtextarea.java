import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jtextarea {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            definingstuff();
        });
    }

    public static void definingstuff(){
        JFrame frame = new JFrame("Text Area");
        JButton button = new JButton("Count Words");
        JLabel l1 = new JLabel("Words");
        JLabel l2 = new JLabel("Letters");
        JTextArea ta = new JTextArea(10,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = ta.getText();
                String[] str2 = str1.split("\\s");
                l1.setText("Words: " + str2.length);
                l2.setText("Letters: " + str1.length());

            }
        });
        frame.add(l1);
        frame.add(l2);
        frame.add(ta);
        frame.add(button);

        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
