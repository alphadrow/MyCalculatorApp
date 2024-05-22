package ru.alphadrow.gb.mycalculatorapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    static final String KEY_SP = "sp";
    static final String KEY_CURRENT_THEME = "currentTheme";
    static final int orangeTheme = 2;
    static final int purpleTheme = 1;

    RadioButton radioButtonSchemePurple;
    RadioButton radioButtonSchemeOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getRealId(getCurrentTheme()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
        setContent();
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.radioButtonSchemeOrange) {
            setCurrentTheme(orangeTheme);
        }
        if (id == R.id.radioButtonSchemePurple) {
            setCurrentTheme(purpleTheme);
        }
        recreate();
    }

    private void setCurrentTheme(int currentTheme) {
        SharedPreferences sp = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(KEY_CURRENT_THEME, currentTheme);
        editor.apply();
    }
    private int getCurrentTheme() {
        SharedPreferences sp = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        return sp.getInt(KEY_CURRENT_THEME, -1);
    }

    private int getRealId(int currentTheme) {
        switch (currentTheme){
            case purpleTheme:
                return R.style.PurpleTheme;
            case orangeTheme:
                return R.style.OrangeTheme;
            default: return R.style.Base_Theme_MyCalculatorApp;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void
    setContent() {
        radioButtonSchemePurple.setOnClickListener(this);
        radioButtonSchemeOrange.setOnClickListener(this);
    }

    private void initView() {
        radioButtonSchemePurple = findViewById(R.id.radioButtonSchemePurple);
        radioButtonSchemeOrange = findViewById(R.id.radioButtonSchemeOrange);

    }
}