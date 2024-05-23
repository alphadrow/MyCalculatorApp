package ru.alphadrow.gb.mycalculatorapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Calculator implements Parcelable {
    boolean isNumberEntered;
    private String displayNumber;
    private int previousNumber;
    private int currentNumber;

    protected Calculator(Parcel in) {
        displayNumber = in.readString();
        previousNumber = in.readInt();
        currentNumber = in.readInt();
    }

    protected Calculator() {
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    Action currentAction = Action.NONE;

    public String getDisplayNumber() {
        return displayNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(displayNumber);
        dest.writeInt(previousNumber);
        dest.writeInt(currentNumber);
    }

    public void clear() {
        currentNumber = 0;
        previousNumber = 0;
        displayNumber = "0";
    }

    enum Action {
        DIVIDE,
        MINUS,
        MULTIPLY,
        PLUS,
        NONE
    }

    public void plus() {
        doCalc();
        currentAction = Action.PLUS;
    }

    public void minus() {
        doCalc();
        currentAction = Action.MINUS;
    }

    public void multiply() {
        doCalc();
        currentAction = Action.MULTIPLY;
    }

    public void divide() {
        doCalc();
        currentAction = Action.DIVIDE;
    }

    public void myEquals() {
        doCalc();
        currentAction = Action.NONE;
    }


    public void append(int i) {
        currentNumber = currentNumber * 10 + i;
        displayNumber = String.valueOf(currentNumber);
        isNumberEntered = true;
    }

    public String getResult() {
        return String.valueOf(previousNumber);
    }

    private void doCalc() {
        if (isNumberEntered) {
            switch (currentAction) {
                case PLUS:
                    previousNumber = previousNumber + currentNumber;
                    break;
                case MINUS:
                    previousNumber = previousNumber - currentNumber;
                    break;
                case MULTIPLY:
                    previousNumber = previousNumber * currentNumber;
                    break;
                case DIVIDE:
                    if (currentNumber != 0) {
                        previousNumber = previousNumber / currentNumber;
                    }
                    break;
                case NONE:
                    previousNumber = currentNumber;
                    break;
            }
            currentNumber = 0;
            isNumberEntered = false;
        }
        displayNumber = String.valueOf(previousNumber);

    }

}
