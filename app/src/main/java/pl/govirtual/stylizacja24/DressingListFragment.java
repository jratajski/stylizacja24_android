package pl.govirtual.stylizacja24;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.StreamHandler;

import pl.govirtual.stylizacja24.POJO.ImageContent;
import pl.govirtual.stylizacja24.POJO.ImageResponse;
import pl.govirtual.stylizacja24.POJO.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 27.04.16.
 */
public class DressingListFragment extends ListFragment {
    ArrayList<String> itemCaption;
    ArrayList<String> itemImageUrl;
    ImageAndTextArrayAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.dressing_list_layout, container, false);

        itemCaption = new ArrayList<String>();
        itemImageUrl = new ArrayList<String>();

        mListAdapter = new ImageAndTextArrayAdapter(this.getActivity(), itemCaption, itemImageUrl);

        this.setListAdapter(mListAdapter);

        return rootView;
    }

    public void updateData(List<ImageContent> data)
    {
        itemCaption.clear();
        itemImageUrl.clear();
        for (ImageContent ic : data) {
            itemCaption.add(Html.fromHtml(ic.getCaption()).toString());
            String imageUrl = ServiceGenerator.API_BASE_URL + "/api/v1/private-images/" + ic.getPath();
            itemImageUrl.add(imageUrl);
        }
        Handler mainHandler = new Handler(getActivity().getApplicationContext().getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                mListAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "Dataset changed notification", Toast.LENGTH_LONG).show();
            }
        };
        mainHandler.post(myRunnable);
    }
}
