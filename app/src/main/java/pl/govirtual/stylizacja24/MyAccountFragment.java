package pl.govirtual.stylizacja24;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pl.govirtual.stylizacja24.POJO.UserInfo;

/**
 * Created by Admin on 09.06.16.
 */
public class MyAccountFragment extends Fragment {

    TextView info_view;
    String validToDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.my_account_layout, container, false);
        info_view = (TextView)rootView.findViewById(R.id.my_account_validity_textview);
        if(validToDate != null)
            info_view.setText("Jesteś zalogowany/a \n ważność twojego konta \n do " + validToDate);

        Button logout_button =  (Button)rootView.findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences loginPreferences = getActivity().getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor loginPreferencesEditor = loginPreferences.edit();
                loginPreferencesEditor.remove(LoginActivity.API_TOKEN_KEY);
                loginPreferencesEditor.commit();

                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(loginIntent);
                getActivity().finish();
            }
        });

        return rootView;
    }

    public void updateDate(UserInfo data){
        validToDate = new SimpleDateFormat("dd.MM.yyyy").format(data.getPremiumExpiration() * 1000L);

        if(info_view != null)
            info_view.setText("Jesteś zalogowany/a \n ważność twojego konta \n do " + validToDate);


    }
}
