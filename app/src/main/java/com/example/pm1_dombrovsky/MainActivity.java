package com.example.pm1_dombrovsky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    int i, res, shet, revshet, chek;
   // Random random;
    //Изменения
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random();

    }
    protected void Random(){
        int min = 1;
        int max = 10;
        int diff = (max - min);
        Random random = new Random();
        i = random.nextInt(diff + 1);
        i += min;
        textView = findViewById(R.id.Znak);
        shet = 0;
        revshet = 3;
        chek = 0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button1:
                res = 1;
                break;
            case R.id.Button2:
                res = 2;
                break;
            case R.id.Button3:
                res = 3;
                break;
            case R.id.Button4:
                res = 4;
                break;
            case R.id.Button5:
                res = 5;
                break;
            case R.id.Button6:
                res = 6;
                break;
            case R.id.Button7:
                res = 7;
                break;
            case R.id.Button8:
                res = 8;
                break;
            case R.id.Button9:
                res = 9;
                break;
            case R.id.Button10:
                res = 10;
                break;
        }
        //String s = Integer.toString(res);
        if (shet == 3){
            chek = 1;
        }
        if (res > i && chek != 1) {
            textView.setText(">");
            shet += 1;
            revshet -= 1;
            Toast toast = Toast.makeText(this, "Загаданное число меньше! Осталось попыток: " + revshet, Toast.LENGTH_SHORT);
            toast.show();

        }
        if (res < i && chek != 1) {
            textView.setText("<");
            shet += 1;
            revshet -= 1;
            Toast toast = Toast.makeText(this, "Загаданное число больше! Осталось попыток: " + revshet, Toast.LENGTH_SHORT);
            toast.show();
        }
        if (res == i ){
            textView.setText("!Успех!");
            Toast toast = Toast.makeText(this, "Верно! Загаданное число: " + i, Toast.LENGTH_SHORT);
            toast.show();
        }
        if (revshet == 0){
            textView.setText("Нажмите еще раз");
            Toast toast = Toast.makeText(this, "Попыток больше не осталось ", Toast.LENGTH_SHORT);
            toast.show();
        }

        //textView.setText(res +"");
    }
    public void Reset(View v){
        Random();
        textView.setText("");
    }
}