package com.ptp.phamtanphat.cuocduakythu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox ckOne,ckTwo,ckThree;
    SeekBar skOne,skTwo,skThree;
    ImageButton imgplay;
    int valueprogessOne , valueprogressTwo , valueprogressThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventClick();
        runSeekbar();
    }

    private void runSeekbar() {
        final Random random = new Random();
        CountDownTimer countDownTimer = new CountDownTimer(60000,500) {
            @Override
            public void onTick(long l) {

                if (skOne.getProgress() >= 100){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con Cho da ve nhat!!", Toast.LENGTH_SHORT).show();
                    ResetProgress();
                    CheckableView(true);
                }else if(skTwo.getProgress() >= 100){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con Chim da ve nhat!!", Toast.LENGTH_SHORT).show();
                    ResetProgress();
                    CheckableView(true);
                }else if(skThree.getProgress() >= 100){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con Meo da ve nhat!!", Toast.LENGTH_SHORT).show();
                    ResetProgress();
                    CheckableView(true);
                }else{
                    CheckableView(false);
                    valueprogessOne = random.nextInt(10) + 1;
                    valueprogressTwo = random.nextInt(10) + 1;
                    valueprogressThree = random.nextInt(10) + 1;

                    skOne.setProgress(skOne.getProgress() + valueprogressTwo);
                    skTwo.setProgress(skTwo.getProgress() + valueprogressTwo);
                    skThree.setProgress(skThree.getProgress() + valueprogressThree);
                }
                // Chuc nang
//                    1 : Chi duoc chon 1 trong 3 checkbox :setOnCheckedChangeListener
//                      2 : Khi click button play
//                            - Khong duoc chon lai check box
//                            - Phai chon checkbox truoc khi play

//                if (skOne.getProgress() >= 100 && skTwo.getProgress() >= 100){
//
//                }else if(skTwo.getProgress() >= 100 && skThree.getProgress() >= 100){
//
//                }else if (skThree.getProgress() >= 100 && skOne.getProgress() >= 100){
//
//                }


                
                
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void eventClick() {

    }

    private void init() {
        ckOne = findViewById(R.id.checkboxOne);
        ckTwo = findViewById(R.id.checkboxTwo);
        ckThree = findViewById(R.id.checkboxThree);
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        imgplay = findViewById(R.id.imageviewPlay);
    }
    private void CheckableView(boolean type){
        skOne.setEnabled(type);
        skTwo.setEnabled(type);
        skThree.setEnabled(type);
    }
    private void ResetProgress(){
        skOne.setProgress(0);
        skTwo.setProgress(0);
        skThree.setProgress(0);
    }

}
