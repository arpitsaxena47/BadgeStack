package com.arpit.badgestack.ui.CodeScanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arpit.badgestack.MainActivity;
import com.arpit.badgestack.R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CodeScannerActivity extends AppCompatActivity {
    //    private PreviewView previewView;
//    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
//
//    private Button qrCodeFoundButton;
//    private String qrCode;
//    private static final int PERMISSION_REQUEST_CAMERA = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_code_scanner);
//
//        previewView = findViewById(R.id.activity_main_previewView);
//
//        qrCodeFoundButton = findViewById(R.id.activity_main_qrCodeFoundButton);
//        qrCodeFoundButton.setVisibility(View.INVISIBLE);
//        qrCodeFoundButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), qrCode, Toast.LENGTH_SHORT).show();
//                Log.i(MainActivity.class.getSimpleName(), "QR Code Found: " + qrCode);
//            }
//        });
//
//        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
//        requestCamera();
//    }
//
//    private void requestCamera() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//            startCamera();
//        } else {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
//                ActivityCompat.requestPermissions(CodeScannerActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == PERMISSION_REQUEST_CAMERA) {
//            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                startCamera();
//            } else {
//                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void startCamera() {
//        cameraProviderFuture.addListener(() -> {
//            try {
//                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
//                bindCameraPreview(cameraProvider);
//            } catch (ExecutionException | InterruptedException e) {
//                Toast.makeText(this, "Error starting camera " + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }, ContextCompat.getMainExecutor(this));
//    }
//
//
//    private void bindCameraPreview(@NonNull ProcessCameraProvider cameraProvider) {
//        previewView.setPreferredImplementationMode(PreviewView.ImplementationMode.SURFACE_VIEW);
//
//        Preview preview = new Preview.Builder()
//                .build();
//
//        CameraSelector cameraSelector = new CameraSelector.Builder()
//                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
//                .build();
//
//        preview.setSurfaceProvider(previewView.createSurfaceProvider());
//
//        ImageAnalysis imageAnalysis =
//                new ImageAnalysis.Builder()
//                        .setTargetResolution(new Size(1280, 720))
//                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                        .build();
//
//        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), new QRCodeImageAnalyzer(new QRCodeFoundListner() {
//            @Override
//            public void onQRCodeFound(String _qrCode) {
//                qrCode = _qrCode;
//                Toast.makeText(CodeScannerActivity.this , qrCode , Toast.LENGTH_SHORT).show();
//                qrCodeFoundButton.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void qrCodeNotFound() {
//                Toast.makeText(CodeScannerActivity.this , "qrCode not found" , Toast.LENGTH_SHORT).show();
//                qrCodeFoundButton.setVisibility(View.INVISIBLE);
//            }
//        }));
//
//        Camera camera = cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, imageAnalysis, preview);
//    }
    SurfaceView cameraPreview;
    TextView txtResult;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    private  static final int RequestCameraPermissionId = 1001;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionId:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    try {
                        cameraSource.start(cameraPreview.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_code_scanner);

        cameraPreview = findViewById(R.id.surfaceView);
        txtResult = findViewById(R.id.txtResult);

        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector).setRequestedPreviewSize(640, 480).setAutoFocusEnabled(true).build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(CodeScannerActivity.this , new String[]{Manifest.permission.CAMERA}
                    , RequestCameraPermissionId);
                    return;
                }

                try {
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {

                SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if(qrCodes.size() != 0)
                {
                    txtResult.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            txtResult.setText(qrCodes.valueAt(0).displayValue);
                            cameraSource.stop();
                        }
                    });
                }
            }
        });
    }
}