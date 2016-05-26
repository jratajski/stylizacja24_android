package pl.govirtual.stylizacja24;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.govirtual.stylizacja24.POJO.ImageContent;

/**
 * Created by Admin on 26.05.16.
 */
public class VisageGridViewFragment extends Fragment {
    ArrayList<String> itemImageUrl = new ArrayList<String>();
    ImageAdapter mGridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.visage_grid_layout, container, false);
        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this.getActivity(), itemImageUrl));

        mGridAdapter = new ImageAdapter(this.getActivity(), itemImageUrl);
        gridview.setAdapter(mGridAdapter);

        return rootView;
    }

    public void updateData(List<ImageContent> data)
    {
        itemImageUrl.clear();
        for (ImageContent ic : data)
        {
            String imageUrl = ServiceGenerator.API_BASE_URL + "/api/v1/private-images/" + ic.getPath();
            itemImageUrl.add(imageUrl);
        }
        Handler mainHandler = new Handler(getActivity().getApplicationContext().getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
            mGridAdapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), "Dataset changed notification", Toast.LENGTH_LONG).show();
            }
        };
        mainHandler.post(myRunnable);
    }
}
