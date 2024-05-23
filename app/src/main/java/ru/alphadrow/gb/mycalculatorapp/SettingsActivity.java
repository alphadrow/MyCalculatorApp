package ru.alphadrow.gb.mycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    static final int orangeTheme = 2;
    static final int purpleTheme = 1;

    RadioButton radioButtonSchemePurple;
    RadioButton radioButtonSchemeOrange;

    SharedPreferencesRepository spRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSharedPref();
        setTheme(getRealId(getCurrentTheme()));
        setContentView(R.layout.activity_settings);
        initView();
        setContent(); //не самое удачное имя для метода. Да и действие скорее я бы к initView отнес.
    }

    private void initSharedPref() {
        spRepo = new SharedPreferencesRepository();
        spRepo.init(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        spRepo.dispose();
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
        spRepo.saveTheme(currentTheme);
    }

    private int getCurrentTheme() {
        return spRepo.getThemeId();
    }

    public int getRealId(int currentTheme) {
        switch (currentTheme) {
            case purpleTheme:
                return R.style.PurpleTheme;
            case orangeTheme:
                return R.style.OrangeTheme;
            default:
                return R.style.Base_Theme_MyCalculatorApp;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void setContent() {
        radioButtonSchemePurple.setOnClickListener(this);
        radioButtonSchemeOrange.setOnClickListener(this);
    }

    private void initView() {
        radioButtonSchemePurple = findViewById(R.id.radioButtonSchemePurple);
        radioButtonSchemeOrange = findViewById(R.id.radioButtonSchemeOrange);

    }
}