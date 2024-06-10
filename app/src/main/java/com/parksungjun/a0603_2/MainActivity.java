package com.parksungjun.a0603_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.FloatBuffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void onClicked(View view) {
        EditText text = findViewById(R.id.number);
        if (view.getId() == R.id.convert); {
            RadioButton cm = findViewById(R.id.cm);
            RadioButton inch = findViewById(R.id.inch);
            if (text.getText().length() == 0) {
                Toast.makeText(this, "정확한 값을 입력하시오.", Toast.LENGTH_SHORT).show();
                return;
            }
            float inputValue = Float.parseFloat(text.getText().toString());
            if (cm.isChecked()) {
                text.setText(String.format("%.2f", convertcmtoinch(inputValue)));
                cm.setChecked(false);
                inch.setChecked(true);
            } else {
                text.setText(String.format("%.2f", convertinchtocm(inputValue)));
                inch.setChecked(false);
                cm.setChecked(true);
            }
        }
    }

    private float convertcmtoinch(float cmtoinch) {
        return (float) (cmtoinch * 2.54);
    }
    private float convertinchtocm(float inchtocm) {
        return (float) (inchtocm * 0.39370);
    }
}