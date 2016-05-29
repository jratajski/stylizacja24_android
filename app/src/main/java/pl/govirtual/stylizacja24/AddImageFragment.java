package pl.govirtual.stylizacja24;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

/**
 * Created by Admin on 26.05.16.
 */
public class AddImageFragment extends Fragment
{
    public final static String IS_VISAGE_EXTRA = "useCameraForVisage";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.add_image_layout, container, false);

        ImageButton take_visage_photo_button =  (ImageButton)rootView.findViewById(R.id.take_visage_photo);
        take_visage_photo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent takePictureIntent = new Intent(getActivity(), MakePhotoActivity.class);
                takePictureIntent.putExtra(IS_VISAGE_EXTRA, true);
                getActivity().startActivity(takePictureIntent);
            }
        });

        ImageButton take_silhouette_photo_button =  (ImageButton)rootView.findViewById(R.id.take_silhouette_photo);
        take_silhouette_photo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent takePictureIntent = new Intent(getActivity(), MakePhotoActivity.class);
                takePictureIntent.putExtra(IS_VISAGE_EXTRA, false);
                getActivity().startActivity(takePictureIntent);
            }
        });

        return rootView;
    }
}
