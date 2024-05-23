package ru.alphadrow.gb.mycalculatorapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesRepository {

    public SharedPreferencesRepository() {
    }

    private static final String KEY_SP = "sp";
    private static final String KEY_CURRENT_THEME = "currentTheme";

    SharedPreferences sp;

    public void init(Context context) {
        sp = context.getSharedPreferences(KEY_SP, MODE_PRIVATE);
    }

    public void saveTheme(int id) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(KEY_CURRENT_THEME, id);
        editor.apply();
    }

    public int getThemeId() {
        return sp.getInt(KEY_CURRENT_THEME, 1); // если -1, то проверяем на несуществующие
        // значения. В данном случае лучше задать какую то тему по умолчанию, т.е. 1
    }

    public void dispose() {
        sp = null;
    }

}
