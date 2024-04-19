package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText operand1;
    EditText operand2;
    TextView result;
    Button addButton;
    Button subtractButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1 = findViewById(R.id.operand1);
        operand2 = findViewById(R.id.operand2);
        result = findViewById(R.id.result);
        addButton = findViewById(R.id.add);
        subtractButton = findViewById(R.id.subtract);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no input present
                if (operand1.getText().toString().isEmpty() || operand2.getText().toString().isEmpty()) {
                    // Show error message
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return; // Exit the method as there's nothing to process
                }
                //gather data in edit texts and perform arithmetic
                double input1 = Double.parseDouble(operand1.getText().toString());
                double input2 = Double.parseDouble(operand2.getText().toString());
                String answer = String.valueOf(add(input1, input2));
                //set text view to answer
                result.setText(answer);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no input present
                if (operand1.getText().toString().isEmpty() || operand2.getText().toString().isEmpty()) {
                    // Show error message
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return; // Exit the method as there's nothing to process
                }
                //gather data in edit texts and perform arithmetic
                double input1 = Double.parseDouble(operand1.getText().toString());
                double input2 = Double.parseDouble(operand2.getText().toString());
                String answer = String.valueOf(subtract(input1, input2));
                //set text view to answer
                result.setText(answer);
            }
        });
    }

    public double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }
}