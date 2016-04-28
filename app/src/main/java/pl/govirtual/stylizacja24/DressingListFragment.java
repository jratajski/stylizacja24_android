package pl.govirtual.stylizacja24;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.govirtual.stylizacja24.POJO.ImageResponse;
import pl.govirtual.stylizacja24.POJO.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 27.04.16.
 */
public class DressingListFragment extends ListFragment {
    String[] itemCaption;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.dressing_list_layout, container, false);

        itemCaption = new String[]{"Test 1", "Test 2", "Test 3"};

        this.setListAdapter(    new ArrayAdapter<String>(
                                        this.getActivity(),
                                        R.layout.image_and_text_row,
                                        R.id.image_caption, itemCaption)
                            );



        return rootView;
    }
}
