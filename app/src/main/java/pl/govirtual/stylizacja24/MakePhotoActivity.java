package pl.govirtual.stylizacja24;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakePhotoActivity extends Activity {
    private Camera mCamera;
    private CameraPreview mPreview;
    private Camera.PictureCallback mPicture;
    private Button capture;
    private Context myContext;
    private LinearLayout cameraPreview;
    private boolean for_visage = false;

    public static final String IMAGE_BYTE_ARRAY_EXTRA = "IMAGE_BYTE_ARRAY_EXTRA";

    public enum CameraFacing {
        FRONT_FACING,
        REAR_FACING
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for_visage = getIntent().getBooleanExtra(AddImageFragment.IS_VISAGE_EXTRA, false);
        setContentView(R.layout.take_visage_photo_layout);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        myContext = this;

        CameraFacing cameraFacing;
        if(for_visage){
            cameraFacing = CameraFacing.FRONT_FACING;
        } else{
            cameraFacing = CameraFacing.REAR_FACING;
        }
        if (findCamera(cameraFacing) < 0) {
            Toast.makeText(this, "No camera found.", Toast.LENGTH_LONG).show();
//            switchCamera.setVisibility(View.GONE);
        }
        mCamera = Camera.open(findCamera(cameraFacing));
        mPicture = getPictureCallback();

        initialize();
    }

    private int findCamera(CameraFacing cameraFacing) {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            CameraInfo info = new CameraInfo();
            Camera.getCameraInfo(i, info);
            if (cameraFacing == CameraFacing.FRONT_FACING) {
                if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
                    cameraId = i;
                    break;
                }
            } else {
                if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
                    cameraId = i;
                    break;
                }
            }
        }

        return cameraId;
    }

    public void onResume() {
        super.onResume();
        if (!hasCamera(myContext)) {
            Toast toast = Toast.makeText(myContext, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        if (mCamera == null) {
            //if the front facing camera does not exist
            CameraFacing cameraFacing;
            if(for_visage){
                cameraFacing = CameraFacing.FRONT_FACING;
            } else{
                cameraFacing = CameraFacing.REAR_FACING;
            }
            if (findCamera(cameraFacing) < 0) {
                Toast.makeText(this, "No camera found.", Toast.LENGTH_LONG).show();
//                switchCamera.setVisibility(View.GONE);
            }
            mCamera = Camera.open(findCamera(cameraFacing));
            mPicture = getPictureCallback();
            mPreview.refreshCamera(mCamera);
        }
    }

    public void initialize() {
        cameraPreview = (LinearLayout) findViewById(R.id.camera_preview);
        mPreview = new CameraPreview(myContext, mCamera);
        cameraPreview.addView(mPreview);

        capture = (Button) findViewById(R.id.button_capture);
        capture.setOnClickListener(captrureListener);

//        switchCamera = (Button) findViewById(R.id.button_ChangeCamera);
//        switchCamera = (Button) findViewById(R.id.button_ChangeCamera);
//        switchCamera.setOnClickListener(switchCameraListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //when on Pause, release camera in order to be used from other applications
        releaseCamera();
    }

    private boolean hasCamera(Context context) {
        //check if the device has camera
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    private Camera.PictureCallback getPictureCallback() {
        Camera.PictureCallback picture = new Camera.PictureCallback() {

            @Override
            public void onPictureTaken(byte[] data, Camera camera)
            {
                Intent intent = new Intent(MakePhotoActivity.this, ApprovePhotoActivity.class);
                intent.putExtra(IMAGE_BYTE_ARRAY_EXTRA, data);
                intent.putExtra(AddImageFragment.IS_VISAGE_EXTRA, for_visage);
                startActivity(intent);
                releaseCamera();

                MakePhotoActivity.this.finish();

            }
        };
        return picture;
    }

    View.OnClickListener captrureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCamera.takePicture(null, null, mPicture);
        }
    };

    //make picture and save to a folder
    private static File getOutputMediaFile() {
        //make a new file directory inside the "sdcard" folder
        File mediaStorageDir = new File("/sdcard/", "JCG Camera");

        //if this "JCGCamera folder does not exist
        if (!mediaStorageDir.exists()) {
            //if you cannot make this folder return
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        //take the current timeStamp
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        //and make a media file:
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");

        return mediaFile;
    }

    private void releaseCamera() {
        // stop and release camera
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }
}