package ru.alphadrow.gb.mycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String TAG = "calculator";
    Calculator calculator;
    Button[] buttons = new Button[10];
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivision;
    Button buttonEquals;
    TextView textView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(TAG, calculator);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(TAG);
        setContent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calculator = new Calculator();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setContent();

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id._0) {
            calculator.append(0);
        } else if (id == R.id._1) {
            calculator.append(1);
        } else if (id == R.id._2) {
            calculator.append(2);
        } else if (id == R.id._3) {
            calculator.append(3);
        } else if (id == R.id._4) {
            calculator.append(4);
        } else if (id == R.id._5) {
            calculator.append(5);
        } else if (id == R.id._6) {
            calculator.append(6);
        } else if (id == R.id._7) {
            calculator.append(7);
        } else if (id == R.id._8) {
            calculator.append(8);
        } else if (id == R.id._9) {
            calculator.append(9);
        } else if (id == R.id.buttonPlus) {
            calculator.plus();
        } else if (id == R.id.buttonMinus) {
            calculator.minus();
        } else if (id == R.id.buttonMultiply) {
            calculator.multiply();
        } else if (id == R.id.buttonDivide) {
            calculator.divide();
        } else if (id == R.id.buttonEquals) {
            calculator.myEquals();
        }
        textView.setText(calculator.getDisplayNumber());

    }

    private void setContent() {
        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        textView.setText(calculator.getDisplayNumber());
    }

    private void initView() {
        buttons[0] = findViewById(R.id._0);
        buttons[1] = findViewById(R.id._1);
        buttons[2] = findViewById(R.id._2);
        buttons[3] = findViewById(R.id._3);
        buttons[4] = findViewById(R.id._4);
        buttons[5] = findViewById(R.id._5);
        buttons[6] = findViewById(R.id._6);
        buttons[7] = findViewById(R.id._7);
        buttons[8] = findViewById(R.id._8);
        buttons[9] = findViewById(R.id._9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivision = findViewById(R.id.buttonDivide);
        buttonEquals = findViewById(R.id.buttonEquals);
        textView = findViewById(R.id.mainView);
    }
}