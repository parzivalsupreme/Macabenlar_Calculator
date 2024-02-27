package com.example.macabenlar_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private TextView textView;
  private String currentNumber = "";
  private String operation = "";
  private double firstNumber = 0;
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
    if (!currentNumber.isEmpty()) {
      firstNumber = Double.parseDouble(currentNumber);
    }

    operation = ((TextView) view).getText().toString();
    isNewOperation = true;
    textView.setText(operation);
  }

  public void onEqualsClick(View view) {
    if (!isNewOperation && !operation.isEmpty()) {
      double secondNumber = Double.parseDouble(currentNumber);
      double result = 0;

      switch (operation) {
        case "+":
          result = firstNumber + secondNumber;
          break;
        case "-":
          result = firstNumber - secondNumber;
          break;
        case "x":
          result = firstNumber * secondNumber;
          break;
        case "÷":
          if (secondNumber != 0) {
            result = firstNumber / secondNumber;
          } else {
            textView.setText("Error");
            return;
          }
          break;
      }

      textView.setText(String.valueOf(result));
      isNewOperation = true;
      currentNumber = "";
      operation = "";
    }
  }
}
