import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class notepadproj {
    private static JTextField tf;
    private static JTextArea ta;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad");
        JLabel label = new JLabel("Enter File name: ");
        tf = new JTextField(10);  // Removed redeclaration here
        ta = new JTextArea(10, 20);  // Removed redeclaration here
        JButton button = new JButton("Save");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String filename = tf.getText();
                String insidetext = ta.getText();

                File myfile = new File(filename);

                try {
                    if (myfile.createNewFile()){
                        System.out.println("File was created " + myfile.getName());
                    } else {
                        System.out.println("Could not create file!");
                    }
                } catch (IOException e) {
                    System.out.println("Error!");
                    e.printStackTrace();
                }

                try {
                    FileWriter writein = new FileWriter(filename);
                    writein.write(insidetext);
                    writein.close();
                } catch (IOException e) {
                    System.out.println("I failed master.");
                    e.printStackTrace();
                }
            }

        });

        frame.add(label);
        frame.add(tf);
        frame.add(ta);
        frame.add(button);

        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
