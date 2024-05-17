package ru.alphadrow.gb.mycalculatorapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Calculator implements Parcelable {
    private String displayNumber;
    private int result;
    private int currentNumber;

    protected Calculator(Parcel in) {
        displayNumber = in.readString();
        result = in.readInt();
        currentNumber = in.readInt();
    }

    protected Calculator(){}

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

    public String getCurrentNumber(){
       return String.valueOf(currentNumber);
    }
    action currentAction = action.NONE;

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
        dest.writeInt(result);
        dest.writeInt(currentNumber);
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
