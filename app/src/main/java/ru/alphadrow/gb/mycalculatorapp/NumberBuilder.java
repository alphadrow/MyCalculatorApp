package ru.alphadrow.gb.mycalculatorapp;public class NumberBuilder {
    public int getCurrentNumber() {
        return currentNumber;
    }

    private int currentNumber;
    public void append(int i) {
        currentNumber = currentNumber * 10 + i;
    }


}
