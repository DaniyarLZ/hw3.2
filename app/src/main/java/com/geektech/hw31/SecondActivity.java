package com.geektech.hw31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    private static final int GALLERY = 123;
    private static final int CAMERA = 777;
    private EditText email, pas;
    private ImageView IVPhoto;
    private TextView editph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        email = findViewById(R.id.dedit);
        pas = findViewById(R.id.dedit2);
        IVPhoto = findViewById(R.id.IVPhoto);
        editph = findViewById(R.id.editph);
        getInfo();
        editph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(intent,GALLERY);
            }
        });
        IVPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA);
            }
        });


    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == GALLERY && resultCode == RESULT_OK && data != null) {
                Glide.with(this).load(data.getData().toString()).circleCrop().into(IVPhoto);
            }
            if (requestCode == CAMERA && resultCode == RESULT_OK && data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                Glide.with(this).load(imageBitmap).circleCrop().into(IVPhoto);
            }
        }


    private void getInfo() {
        email.setText(getIntent().getStringExtra("key1"));
        pas.setText(getIntent().getStringExtra("123456"));
    }

}