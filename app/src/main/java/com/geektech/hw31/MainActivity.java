package com.geektech.hw31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText gmail, pin;
    private Button tap;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmail = findViewById(R.id.edit12);
        pin = findViewById(R.id.edit11);
        image = findViewById(R.id.image);
        tap = findViewById(R.id.btn);
        tap.setOnClickListener(v -> {
            if (pin.getText().toString().length() >= 6 && gmail.getText().toString() != null) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                tap.setBackgroundColor(getColor(R.color.black));
                intent.putExtra("key1", gmail.getText().toString());
                intent.putExtra("123456", pin.getText().toString());
                startActivity(intent);
            } else {
                pin.setError("Введите 6 символов");
                gmail.setError("Введите Логин");
                tap.setBackgroundColor(getColor(R.color.gray));
            }

        });

        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(image);




    }


}