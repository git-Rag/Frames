import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatorproj extends JFrame {
    private JTextField textField;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public calculatorproj() {
        super("Calculator");
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.matches("[0-9]")) {
                handleDigitClick(buttonText);
            } else if (buttonText.matches("[\\+\\-\\*/]")) {
                handleOperatorClick(buttonText);
            } else if (buttonText.equals(".")) {
                handleDecimalPointClick();
            } else if (buttonText.equals("=")) {
                handleEqualClick();
            }
        }

        private void handleDigitClick(String digit) {
            if (startNewInput) {
                textField.setText(digit);
                startNewInput = false;
            } else {
                textField.setText(textField.getText() + digit);
            }
        }

        private void handleOperatorClick(String newOperator) {
            calculate();
            operator = newOperator;
            startNewInput = true;
        }

        private void handleDecimalPointClick() {
            if (startNewInput) {
                textField.setText("0.");
                startNewInput = false;
            } else if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }

        private void handleEqualClick() {
            calculate();
            operator = "";
            startNewInput = true;
        }

        private void calculate() {
            if (!operator.isEmpty()) {
                double secondNumber = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        firstNumber += secondNumber;
                        break;
                    case "-":
                        firstNumber -= secondNumber;
                        break;
                    case "*":
                        firstNumber *= secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            firstNumber /= secondNumber;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                        }
                        break;
                }

                textField.setText(String.valueOf(firstNumber));
            } else {
                firstNumber = Double.parseDouble(textField.getText());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new calculatorproj();
        });
    }
}
