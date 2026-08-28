package com.example.miniassignment4;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final TextView outputText = findViewById(R.id.tvAreaResult);
        final EditText radiusInput = findViewById(R.id.etRadius);
        radiusInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    if(i==KeyEvent.KEYCODE_ENTER){
                        if(radiusInput.getText().toString().isEmpty()){
                            outputText.setText(getText(R.string.empty_input_warning));
                        }else{
                                    double radius = Double.parseDouble(radiusInput.getText().toString());
                                    
                        }

                    }
                }
                return false;
            }
        });

    }
}
