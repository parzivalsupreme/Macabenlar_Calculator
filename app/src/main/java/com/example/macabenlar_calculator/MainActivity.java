package com.example.macabenlar_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private TextView textView;
  private String currentNumber = "";
  private String operation = "";
  private double result = 0;
  private boolean isNewOperation = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = findViewById(R.id.textView);
  }

  public void onNumberClick(View view) {
    if (isNewOperation) {
      currentNumber = "";
      isNewOperation = false;
    }

    String number = ((TextView) view).getText().toString();
    currentNumber += number;
    textView.setText(currentNumber);
  }

  public void onOperationClick(View view) {
    if (!isNewOperation) {
      if (!currentNumber.isEmpty()) {
        double number = Double.parseDouble(currentNumber);
        if (operation.equals("+")) {
          result += number;
        } else if (operation.equals("-")) {
          result -= number;
        } else if (operation.equals("*")) {
          result *= number;
        } else if (operation.equals("/")) {
          if (number != 0) {
            result /= number;
          } else {
            textView.setText("Error");
            return;
          }
        }
        textView.setText(String.valueOf(result));
      }
    }

    operation = ((TextView) view).getText().toString();
    isNewOperation = true;
  }
}
