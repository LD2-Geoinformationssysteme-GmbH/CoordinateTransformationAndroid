package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.cts.ClassForUnity;
import org.cts.IllegalCoordinateException;
import org.cts.crs.CRSException;
import org.cts.op.CoordinateOperationException;

public class MainActivity extends AppCompatActivity {

    Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testButton = (Button) findViewById(R.id.button2);//get id of button

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ClassForUnity.calculateWithEPSGCode();
                } catch (CRSException e) {
                    e.printStackTrace();
                } catch (CoordinateOperationException e) {
                    e.printStackTrace();
                } catch (IllegalCoordinateException e) {
                    e.printStackTrace();
                }
            }
        });

    }



}