package com.example.miniassignment4;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText radiusInput;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusInput = findViewById(R.id.etRadius);
        outputText = findViewById(R.id.tvAreaResult);
        Button calculateButton = findViewById(R.id.buttonCalculate);
        Button clearButton = findViewById(R.id.buttonClear);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateArea();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearForm();
            }
        });

        radiusInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    calculateArea();
                    return true;
                }
                return false;
            }
        });
    }

    private void calculateArea() {
        String input = radiusInput.getText().toString().trim();
        if (input.isEmpty()) {
            radiusInput.setError(getString(R.string.empty_input_warning));
            outputText.setText("");
            return;
        }

        try {
            double radius = Double.parseDouble(input);
            if (!Double.isFinite(radius) || radius < 0) {
                radiusInput.setError(getString(R.string.invalid_radius_warning));
                outputText.setText("");
                return;
            }

            double area = Math.PI * radius * radius;
            outputText.setText(new DecimalFormat("0.0000").format(area));
            radiusInput.setError(null);
        } catch (NumberFormatException exception) {
            radiusInput.setError(getString(R.string.invalid_radius_warning));
            outputText.setText("");
        }
    }

    private void clearForm() {
        radiusInput.setText("");
        radiusInput.setError(null);
        outputText.setText("");
        radiusInput.requestFocus();
    }
}
