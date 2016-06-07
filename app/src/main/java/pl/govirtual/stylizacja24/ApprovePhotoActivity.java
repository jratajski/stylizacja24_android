package pl.govirtual.stylizacja24;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pl.govirtual.stylizacja24.POJO.UploadResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 27.05.16.
 */
public class ApprovePhotoActivity extends Activity
{
    boolean is_for_visage;
    Bitmap bMap;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approve_layout_activity);
        Intent i = getIntent();
        is_for_visage = i.getBooleanExtra(AddImageFragment.IS_VISAGE_EXTRA, false);
        byte [] imageData = i.getByteArrayExtra(MakePhotoActivity.IMAGE_BYTE_ARRAY_EXTRA);
        bMap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        Matrix matrix = new Matrix();
        matrix.postRotate(270);
        bMap = Bitmap.createBitmap(bMap, 0, 0, bMap.getWidth(), bMap.getHeight(), matrix, true);

        ImageView imageView = (ImageView)findViewById(R.id.image_to_approve);
        imageView.setImageBitmap(bMap);

        Button acceptButton = (Button)findViewById(R.id.accept_button);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile();
            }
        });

        Button rejectbutton = (Button)findViewById(R.id.reject_button);
        rejectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApprovePhotoActivity.this, MakePhotoActivity.class);
                intent.putExtra(AddImageFragment.IS_VISAGE_EXTRA, is_for_visage);
                startActivity(intent);
                ApprovePhotoActivity.this.finish();
            }
        });
    }

    private void uploadFile() {
        // create upload service client
        Stylizacja24API service =
                ServiceGenerator.createService(Stylizacja24API.class);

        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
//        File file = FileUtils.getFile(this, fileUri);
        //create a file to write bitmap data
        File file = new File(getCacheDir(), "zdjecie.jpg");
        try {
            file.createNewFile();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bMap.compress(Bitmap.CompressFormat.JPEG, 85, bos);
            byte[] bitmapdata = bos.toByteArray();

            //write the bytes in file
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Convert bitmap to byte array



        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("uploadFile", file.getName(), requestFile);

        // finally, execute the request
        Call<UploadResponse> call;
            if(is_for_visage) {
                call = service.uploadVisage(body);
            } else {
                call = service.uploadSiluette(body);
            }

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call,
                                   Response<UploadResponse> response) {
                Log.v("Upload", "success");
                ApprovePhotoActivity.this.finish();
            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }
}
