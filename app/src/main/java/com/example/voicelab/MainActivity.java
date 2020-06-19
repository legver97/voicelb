package com.example.voicelab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private TextView Textview;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textview = findViewById(R.id.t1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 23) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Textview.setText(result.get(0));
        }
    }

    public void StartSpeech(View view){

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        startActivityForResult(intent, 23);
    }
}
