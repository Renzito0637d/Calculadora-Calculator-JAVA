package Controller;

import View.UI_Basic;
import Model.Calculations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Renzo
 */
public class BasicController implements ActionListener{

    UI_Basic view;
    Calculations cal;
    
    public BasicController(UI_Basic bc){
        view = bc;
        cal=new Calculations();
        view.btn0.addActionListener(this);
        view.btn1.addActionListener(this);
        view.btn2.addActionListener(this);
        view.btn3.addActionListener(this);
        view.btn4.addActionListener(this);
        view.btn5.addActionListener(this);
        view.btn6.addActionListener(this);
        view.btn7.addActionListener(this);
        view.btn8.addActionListener(this);
        view.btn9.addActionListener(this);
        
        view.btnEquals.addActionListener(this);
        view.btnSum.addActionListener(this);
        view.btnC.addActionListener(this);
        view.btnCE.addActionListener(this);
        
        BasicProcesses.Presentation(bc);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if ("0123456789".contains(buttonText)) {
            handleNumber(buttonText);
        } else if ("+-×÷".contains(buttonText)) {
            handleOperator(buttonText);
        } else if (buttonText.equals("=")) {
            calculateResult();
        } else if (buttonText.equals("C")) {
            clear();
        }
    }

    private void handleNumber(String number) {
        if (cal.isStartNewNumber()) {
            view.labRpt.setText(number);
            cal.setStartNewNumber(false);
        } else {
            view.labRpt.setText(view.labRpt.getText() + number);
        }
    }

    private void handleOperator(String op) {
        cal.setOperator(op);
        cal.setResult(Double.parseDouble(view.labRpt.getText()));
        cal.setStartNewNumber(true);
    }

    private void calculateResult() {
        double currentNumber = Double.parseDouble(view.labRpt.getText());
        double result = cal.getResult();

        switch (cal.getOperator()) {
            case "+" -> result += currentNumber;
            case "-" -> result -= currentNumber;
            case "×" -> result *= currentNumber;
            case "÷" -> result /= currentNumber;
        }

        cal.setResult(result);
        view.labRpt.setText(String.valueOf(result));
        cal.setStartNewNumber(true);
    }

    private void clear() {
        view.labRpt.setText("0");
        cal.setResult(0);
        cal.setOperator("");
        cal.setStartNewNumber(true);
    }
}
