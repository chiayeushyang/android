package com.firstapp.viewsandevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 =  (TextView)findViewById(R.id.t1);
        b1 = (Button)findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        t1.setText("You Clicked Button 1");
    }

    public  void  doSomething(View v) {
        t1.setText("You Clicked Button 2");
    }
}