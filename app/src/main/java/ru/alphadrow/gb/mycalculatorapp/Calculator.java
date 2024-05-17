package ru.alphadrow.gb.mycalculatorapp;
public class Calculator {
    private String displayNumber;
    private int result;
    private int currentNumber;
    public String getCurrentNumber(){
       return String.valueOf(currentNumber);
    }
    action currentAction = action.NONE;

    public String getDisplayNumber() {
        return displayNumber;
    }

    enum action {
        DIVIDE,
        MINUS,
        MULTIPLY,
        PLUS,
        NONE
    }
    public void plus() {
        doCalc();
        currentAction = action.PLUS;
    }

    public void minus() {
        doCalc();
        currentAction = action.MINUS;
    }

    public void multiply() {
        doCalc();
        currentAction = action.MULTIPLY;
    }

    public void  divide() {
        doCalc();
        currentAction = action.DIVIDE;
    }

    public void myEquals() {
        doCalc();
        displayNumber = String.valueOf(result);
    }


    public void append(int i) {
        currentNumber = currentNumber * 10 + i;
        displayNumber = String.valueOf(currentNumber);
    }

    public String getResult(){
        return String.valueOf(result);
    }
    private void doCalc() {
        switch (currentAction) {
            case PLUS:
                result += currentNumber;
                break;
            case MINUS:
                result -= currentNumber;
                break;
            case MULTIPLY:
                result *= currentNumber;
                break;
            case DIVIDE:
                result /= currentNumber;
                break;
            case NONE:
                result = currentNumber;
                break;
        }
        currentNumber = 0;
        displayNumber = String.valueOf(result);
    }

}
