package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyAudioPlayer extends AppCompatActivity {

    MediaPlayer mediaPlayer = new MediaPlayer();
    boolean bool = false;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_audio_player);

        btn = findViewById(R.id.hey);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying() && !bool) {
                    play_song();
                    bool = true;
                }else if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                } else if (bool && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                return true;
            }
        });
    }

    public void play_song(){
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/imageviewer-77a86.appspot.com/o/%5BiSongs.info%5D%2004%20-%20Adire%20Hrudayam.mp3?alt=media&token=e380dfe6-d95d-4037-9a22-566198ae5aba");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            mediaPlayer.prepare();
        }catch (Exception exception){
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}