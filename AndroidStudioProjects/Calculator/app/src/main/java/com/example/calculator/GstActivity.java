package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GstActivity extends AppCompatActivity {

    private EditText editTextAmount, editTextRate;
    private Button buttonCalculate;

    private Button buttonBack;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        editTextRate = findViewById(R.id.editTextRate);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonBack = findViewById(R.id.buttonback);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GstActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGST();
            }
        });
    }

    private void calculateGST() {
        double amount = Double.parseDouble(editTextAmount.getText().toString());
        double rate = Double.parseDouble(editTextRate.getText().toString());
        double gstAmount = (amount * rate) / 100;

        textViewResult.setText("GST Amount: " + gstAmount);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GstActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
