package com.example.practical7task1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText number1EditText;
    private EditText number2EditText;
    private RadioGroup operationRadioGroup;
    private Button calculateButton;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Basic Calculator (02, 14, 43)");
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        operationRadioGroup = findViewById(R.id.operationRadioGroup);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected operation
                int selectedId = operationRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                // Get the input numbers
                String number1String = number1EditText.getText().toString();
                String number2String = number2EditText.getText().toString();
                // Check if the input numbers are valid
                if (number1String.isEmpty() || number2String.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }
                double number1 = Double.parseDouble(number1String);
                double number2 = Double.parseDouble(number2String);
                // Perform the selected operation
                double result = 0;
                String operation = selectedRadioButton.getText().toString();
                switch (operation) {
                    case "Add":
                        result = number1 + number2;
                        break;
                    case "Subtract":
                        result = number1 - number2;
                        break;
                    case "Multiply":
                        result = number1 * number2;
                        break;
                    case "Divide":
                        if (number2 == 0) {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = number1 / number2;
                        break;
                }
                // Display the result
                resultTextView.setText("Result: " + result);
            }
   });
}
}