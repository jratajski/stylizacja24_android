package pl.govirtual.stylizacja24;

/**
 * Created by Admin on 28.04.16.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import okhttp3.OkHttpClient;

public class ImageAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> imgUrl;
    private final OkHttpClient client;
    private final Picasso picasso;

    public ImageAdapter(Activity context, List<String> imgUrl) {
        super(context, R.layout.image_grid_cell, imgUrl);

        this.context=context;
        this.imgUrl=imgUrl;
        String apiToken = context.getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, Context.MODE_PRIVATE).getString(LoginActivity.API_TOKEN_KEY, "");
        this.client = ServiceGenerator.getClient(apiToken);

        picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(client))
                .build();
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.image_grid_cell, null,true);

        final ImageView imageView = (ImageView) rowView.findViewById(R.id.visageImage);

        picasso.load(imgUrl.get(position)).resize(150, 150).into(imageView);

        return rowView;

    };

}
