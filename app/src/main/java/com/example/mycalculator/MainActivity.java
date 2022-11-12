package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    String operator = "";
    double res = 0, firstNumber = 0, secondNumber= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewMath);
    }

    public void buttonFunctionOperator(View view) {
        if(view instanceof Button) {
            Button oper = (Button) view;
            operator = oper.getText().toString();
            result.setText("");
            if (operator.equals("AC")){
                firstNumber = 0;
                secondNumber = 0;
            }
        }
    }

    public void buttonFunctionNumber(View view) {
        String str = null;
        if (view instanceof Button) {
            Button button = (Button) view;
            str = button.getText().toString();
        }

        result.append(str);

        if (operator == ""){
            firstNumber = getNumber(result);
        }else{
            secondNumber = getNumber(result);
        }
    }


    public double getNumber(TextView result) {
        try {
            double num = Double.parseDouble(result.getText().toString());
            return num;
        }catch (NumberFormatException e) {
            result.setText("");
            return 0;
        }
    }

    public void initialize() {
        firstNumber = 0;
        secondNumber = 0;
        res = 0;
        result.setText("");
    }

    public void enterSecondActivity(View view) {

            switch (operator) {
                case "+":
                    res = firstNumber + secondNumber;
                    result.setText("");
                    break;

                case "-":
                    res = firstNumber - secondNumber;
                    break;

                case "X":
                    res = firstNumber * secondNumber;
                    break;

                case "/":
                    if (secondNumber == 0) {
                        res = Double.parseDouble("Error");
                    } else {
                        res = firstNumber / secondNumber;
                    }
                    break;
                default:
            }
         Intent intent = new Intent (this, MainActivity2.class);
         intent.putExtra("key1", res + "");
         startActivity(intent);
         operator ="";
         firstNumber = res;
         result.setText(res+"");
    }
}