import calculator.calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField display;
    private calc calculator;
    private double currentResult;
    private String currentOperation;

    public Calculator() {
        calculator = new calc();
        currentResult = 0;
        currentOperation = "";

        setTitle("Advanced Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

      JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sqrt", "cbrt", "^", "log",
                "log10", "exp", "sin", "cos",
                "tan"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                display.setText(display.getText() + command);
            } else if ("+-*/".contains(command)) {
                currentResult = Double.parseDouble(display.getText());
                currentOperation = command;
                display.setText("");
            } else if ("=".equals(command)) {
                double secondOperand = Double.parseDouble(display.getText());
                switch (currentOperation) {
                    case "+":
                        currentResult = calculator.add(currentResult, secondOperand);
                        break;
                    case "-":
                        currentResult = calculator.subtract(currentResult, secondOperand);
                        break;
                    case "*":
                        currentResult = calculator.multiply(currentResult, secondOperand);
                        break;
                    case "/":
                        try {
                            currentResult = calculator.divide(currentResult, secondOperand);
                        } catch (ArithmeticException ex) {
                            display.setText("Error");
                            return;
                        }
                        break;
                    case "^":
                        currentResult = calculator.power(currentResult, secondOperand);
                        break;
                }
                display.setText(String.valueOf(currentResult));
                currentOperation = "";
            } else if ("sqrt".equals(command)) {
                currentResult = calculator.squareRoot(Double.parseDouble(display.getText()));
                display.setText(String.valueOf(currentResult));
            } else if ("cbrt".equals(command)) {
                currentResult = calculator.cubeRoot(Double.parseDouble(display.getText()));
                display.setText(String.valueOf(currentResult));
            } else if ("log".equals(command)) {
                currentResult = calculator.logarithm(Double.parseDouble(display.getText()));
                display.setText(String.valueOf(currentResult));
            } else if ("log10".equals(command)) {
                currentResult = calculator.logBase10(Double.parseDouble(display.getText()));
                display.setText(String.valueOf(currentResult));
            } else if ("exp".equals(command)) {
                currentResult = calculator.exponential(Double.parseDouble(display.getText()));
                display.setText(String.valueOf(currentResult));
            } else if ("sin".equals(command)) {
                currentResult = calculator.sine(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(String.valueOf(currentResult));
            } else if ("cos".equals(command)) {
                currentResult = calculator.cosine(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(String.valueOf(currentResult));
            } else if ("tan".equals(command)) {
                currentResult = calculator.tangent(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(String.valueOf(currentResult));
            }
        }
    }

   public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Calculator calculatorGUI = new Calculator();
            calculatorGUI.setVisible(true);
        }
    });
}

}
