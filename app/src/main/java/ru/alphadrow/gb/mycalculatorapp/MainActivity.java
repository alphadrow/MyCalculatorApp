package ru.alphadrow.gb.mycalculatorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String TAG = "calculator";
    Calculator calculator;
    Button[] buttons = new Button[10];
    Button buttonPlus;
    static final int orangeTheme = 2;
    static final int purpleTheme = 1;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivision;
    Button buttonEquals;
    Button buttonSettings;
    Button buttonClear;
    TextView textView;

    static final String KEY_SP = "sp";
    static final String KEY_CURRENT_THEME = "currentTheme";


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(TAG, calculator);
    }


    public int getRealId(int currentTheme) {
        switch (currentTheme){
            case purpleTheme:
                return R.style.PurpleTheme;
            case orangeTheme:
                return R.style.OrangeTheme;
            default: return R.style.Base_Theme_MyCalculatorApp;
        }
    }
    private int getCurrentTheme() {
        SharedPreferences sp = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        return sp.getInt(KEY_CURRENT_THEME, -1);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(TAG);
        setContent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new Calculator();
        setTheme(getRealId(getCurrentTheme()));
        setContentView(R.layout.activity_main);
        initView();
        setContent();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.zero) {
            calculator.append(0);
        }
        if (id == R.id.one) {
            calculator.append(1);
        }
        if (id == R.id.two) {
            calculator.append(2);
        }
        if (id == R.id.three) {
            calculator.append(3);
        }
        if (id == R.id.four) {
            calculator.append(4);
        }
        if (id == R.id.five) {
            calculator.append(5);
        }
        if (id == R.id.six) {
            calculator.append(6);
        }
        if (id == R.id.seven) {
            calculator.append(7);
        }
        if (id == R.id.eight) {
            calculator.append(8);
        }
        if (id == R.id.nine) {
            calculator.append(9);
        }
        if (id == R.id.buttonPlus) {
            calculator.plus();
        }
        if (id == R.id.buttonMinus) {
            calculator.minus();
        }
        if (id == R.id.buttonMultiply) {
            calculator.multiply();
        }
        if (id == R.id.buttonDivide) {
            calculator.divide();
        }
        if (id == R.id.buttonEquals) {
            calculator.myEquals();
        }
        if (id == R.id.buttonClear){
            calculator.clear();
        }
        if (id == R.id.buttonSettings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        textView.setText(calculator.getDisplayNumber());

    }

    private void setContent() {
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        textView.setText(calculator.getDisplayNumber());
    }

    private void initView() {
        buttons[0] = findViewById(R.id.zero);
        buttons[1] = findViewById(R.id.one);
        buttons[2] = findViewById(R.id.two);
        buttons[3] = findViewById(R.id.three);
        buttons[4] = findViewById(R.id.four);
        buttons[5] = findViewById(R.id.five);
        buttons[6] = findViewById(R.id.six);
        buttons[7] = findViewById(R.id.seven);
        buttons[8] = findViewById(R.id.eight);
        buttons[9] = findViewById(R.id.nine);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivision = findViewById(R.id.buttonDivide);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonClear = findViewById(R.id.buttonClear);
        textView = findViewById(R.id.mainView);
    }
}