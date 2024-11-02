package Model;

/**
 *
 * @author Renzo
 */
public class Calculations {
    private double result = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public Calculations() {
    }
    
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isStartNewNumber() {
        return startNewNumber;
    }

    public void setStartNewNumber(boolean startNewNumber) {
        this.startNewNumber = startNewNumber;
    }

    
    
    
}
