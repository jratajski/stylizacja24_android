package pl.govirtual.stylizacja24;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by Admin on 07.06.16.
 */
public class StartActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences loginPreferences = getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, Context.MODE_PRIVATE);
        if(loginPreferences.getString(LoginActivity.API_TOKEN_KEY, null) != null)
        {
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            StartActivity.this.finish();
        }
        else
        {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            StartActivity.this.finish();
        }
    }
}
