package com.ptp.phamtanphat.cuocduakythu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox ckOne, ckTwo, ckThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton imgplay;
    int valueprogessOne, valueprogressTwo, valueprogressThree;
    int index;
    String thongbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventClick();
        checkedCk();
    }

    private void checkedCk() {
        ckOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckTwo.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });

        ckTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckOne.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });

        ckThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckOne.setChecked(false);
                    ckTwo.setChecked(false);
                }
            }
        });
    }

    private void runSeekbar() {
        final Random random = new Random();
        CountDownTimer countDownTimer = new CountDownTimer(60000, 500) {
            @Override
            public void onTick(long l) {

                if (skOne.getProgress() >= 100) {
                    this.cancel();
                    if (ckOne.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da chon dung roi", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Ban da chon sai roi", Toast.LENGTH_SHORT).show();
                    }
                    ResetGame();
                    CheckableView(true);
                } else if (skTwo.getProgress() >= 100) {
                    if (ckTwo.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da chon dung roi", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Ban da chon sai roi", Toast.LENGTH_SHORT).show();
                    }
                    this.cancel();
                    ResetGame();
                    CheckableView(true);
                } else if (skThree.getProgress() >= 100) {
                    if (ckThree.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da chon dung roi", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Ban da chon sai roi", Toast.LENGTH_SHORT).show();
                    }
                    this.cancel();
                    ResetGame();
                    CheckableView(true);
                } else {
                    CheckableView(false);
                    valueprogessOne = random.nextInt(10) + 1;
                    valueprogressTwo = random.nextInt(10) + 1;
                    valueprogressThree = random.nextInt(10) + 1;

                    skOne.setProgress(skOne.getProgress() + valueprogessOne);
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
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ckOne.isChecked() || ckTwo.isChecked() || ckThree.isChecked()) {
                    runSeekbar();
                } else {
                    Toast.makeText(MainActivity.this, "Bạn hãy chọn 1 con vật!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    private void CheckableView(boolean type) {
        skOne.setEnabled(type);
        skTwo.setEnabled(type);
        skThree.setEnabled(type);
        ckOne.setEnabled(type);
        ckTwo.setEnabled(type);
        ckThree.setEnabled(type);
    }

    private void ResetGame() {
        skOne.setProgress(0);
        skTwo.setProgress(0);
        skThree.setProgress(0);
        ckOne.setChecked(false);
        ckTwo.setChecked(false);
        ckThree.setChecked(false);
    }

}
