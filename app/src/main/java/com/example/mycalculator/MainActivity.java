package com.example.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result, exercise;
    String operator = "";
    double firstNumber = 0, secondNumber = 0, res = 0;

    boolean calculated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
        exercise = findViewById(R.id.textViewMath);
    }

    public void buttonFunctionOperator(View view) {
        if(view instanceof Button) {
            Button oper = (Button) view;
            String str = oper.getText().toString();
            operator = str;

            firstNumber = getNumber(result);
            res = firstNumber;
            calculated = false;
            result.setText("");
            if (operator.equals("AC")) {
                exercise.setText("");
            } else {
                exercise.append(str);
            }
        }
    }

    public void buttonFunctionNumber(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String str = button.getText().toString();

            if (str.equals("=")) {
                if(!calculated) {
                    secondNumber = getNumber(result);
                    calculated = true;
                    exercise.append(str);
                }

                switch (operator) {
                    case "+":
                        res += secondNumber;
                        str = Double.toString(res).replaceAll((String)"\\.0$", "");
                        result.setText("");
                        break;

                    case "-":
                        res -= secondNumber;
                        str = Double.toString(res).replaceAll((String)"\\.0$", "");
                        result.setText("");
                        break;

                    case "X":
                        res *= secondNumber;
                        str = Double.toString(res).replaceAll((String)"\\.0$", "");
                        result.setText("");
                        break;

                    case "/":
                        if(secondNumber == 0) {
                            result.setText("Error");
                            str = "";
                        } else {
                            res /= secondNumber;
                            str = Double.toString(res).replaceAll((String)"\\.0$", "");
                            result.setText("");
                        }
                        break;
                    default:
                        result.setText("ERROR");
                        exercise.setText("");
                }
            }
            if (str.equals("Delete")) {
                initialize();
                return;
            }
            result.append(str);
            exercise.append(str);
        }
    }

    public double getNumber(TextView result) {
        try {
            double num = Double.parseDouble(result.getText().toString());
            return num;
        }catch (NumberFormatException e) {
            result.setText("");
            exercise.setText("");
            return 0;
        }
    }

    public void initialize() {
        calculated = false;
        firstNumber = 0;
        secondNumber = 0;
        res = 0;
        result.setText("");
        exercise.setText("");
    }
}