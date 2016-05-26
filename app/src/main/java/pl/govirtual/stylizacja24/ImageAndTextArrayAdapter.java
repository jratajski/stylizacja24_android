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

public class ImageAndTextArrayAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final List<String> itemname;
        private final List<String> imgUrl;
        private final OkHttpClient client;
        private final Picasso picasso;

        public ImageAndTextArrayAdapter(Activity context, List<String> itemname, List<String> imgUrl) {
            super(context, R.layout.image_and_text_row, itemname);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.itemname=itemname;
            this.imgUrl=imgUrl;
            String apiToken = context.getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, Context.MODE_PRIVATE).getString(LoginActivity.API_TOKEN_KEY, "");
            this.client = ServiceGenerator.getClient(apiToken);

            picasso = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(client))
                    .build();
        }

        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.image_and_text_row, null,true);

            final ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            TextView extratxt = (TextView) rowView.findViewById(R.id.image_caption);

            picasso.load(imgUrl.get(position)).resize(50, 50).into(imageView);

            extratxt.setText(itemname.get(position));
            return rowView;

        };

}
