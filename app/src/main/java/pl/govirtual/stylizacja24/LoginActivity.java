package pl.govirtual.stylizacja24;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pl.govirtual.stylizacja24.POJO.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText login_et;
    private EditText password_et;

    public static final String LOGIN_PREFERENCES = "LoginPReferences";
    public static final String API_TOKEN_KEY = "apiTokenKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_et = (EditText)findViewById(R.id.loginOrEmailTextField);
        password_et = (EditText)findViewById(R.id.passwordTextField);
    }

    public void login(View v)
    {

        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        Call<LoginResponse> call = Stylizacja24Connector.getClient().loginUser(login_et.getEditableText().toString(), password_et.getEditableText().toString());

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                try{
                    int errorCode = Integer.parseInt(response.body().getErrorCode());
                    if(errorCode == 0){
                        String apitoken = response.body().getContent().getApiToken();

                        SharedPreferences loginPreferences = getSharedPreferences(LOGIN_PREFERENCES, Context.CONTEXT_IGNORE_SECURITY);
                        SharedPreferences.Editor loginPreferencesEditor = loginPreferences.edit();

                        loginPreferencesEditor.putString(apitoken, API_TOKEN_KEY);
                    } else if(errorCode == -1001) {
                        Toast.makeText(LoginActivity.this, "Błędny login lub hasło", Toast.LENGTH_LONG).show();
                    }

                    
                } catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
