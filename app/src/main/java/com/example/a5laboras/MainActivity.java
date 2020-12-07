package com.example.a5laboras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import static android.R.*;


public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    Spinner currenciesToChoose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        this.currenciesToChoose = findViewById(R.id.currenciesToChoose);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currenciesToChoose.setAdapter(adapter);
    }


    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");
        String currency = currenciesToChoose.getSelectedItem().toString();

        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                tvContent.setText(result);
            }
        }.execute(currency);
    }


}