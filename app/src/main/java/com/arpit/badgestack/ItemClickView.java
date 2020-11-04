package com.arpit.badgestack;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.squareup.picasso.Picasso;

public class ItemClickView extends AppCompatActivity {

    ImageView badgeImage;
    ImageView qrCodeImage;
    Button btnGenerateQr;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_click_view);

        String imageUrl = getIntent().getStringExtra("imageURL");
        String badgeName = getIntent().getStringExtra("badgeName");
        String companyName = getIntent().getStringExtra("companyName");
        String issueDate = getIntent().getStringExtra("issueDate");

        btnGenerateQr = findViewById(R.id.btnGenerateQR);
        qrCodeImage = findViewById(R.id.imgQR);
        qrCodeImage.setVisibility(View.INVISIBLE);
        badgeImage = findViewById(R.id.BadgeImageView);
        Picasso.get().load(imageUrl).into(badgeImage);

        badgeImage.setElevation(50f);

        btnGenerateQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGenerateQr.setVisibility(View.INVISIBLE);
                QrConversionMethod(companyName , badgeName , issueDate);
            }
        });


    }

    void QrConversionMethod(String companyName , String badgeName , String issueDate)
    {
        String text= "Name of Badge = " + badgeName + "\n Issuing Authority = "
                + companyName + "\n Issue Date = " + issueDate + "\n This Badge Is Verified";
        // Whatever you need to encode in the QR code
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

            qrCodeImage.setVisibility(View.VISIBLE);
            qrCodeImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
