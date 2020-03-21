package com.example.simplecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button clear, parentheses, percent, division, multiply, add, subtract, zero, one, two, three, four, five, six, seven, eight, nine, equals, decimal;
    TextView input, output;
    String process;
    Boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = findViewById(R.id.clear);
        parentheses = findViewById(R.id.parentheses);
        percent = findViewById(R.id.percent);
        division = findViewById(R.id.division);
        multiply = findViewById(R.id.multiply);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"9");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"÷");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"×");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"+");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"-");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+"%");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process+".");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString()=="") output.setText("");
                process = input.getText().toString();
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("×", "*");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalString = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalString = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                    output.setText(finalString);
                }
                catch(Exception e) {
                    finalString = "Error";
                    output.setText(finalString);
                }
                //output.setText(finalString);
            }
        });
        parentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check) {
                    process = input.getText().toString();
                    input.setText(process+")");
                    check = false;
                }
                else {
                    process = input.getText().toString();
                    input.setText(process+"(");
                    check = true;
                }
            }
        });
    }
}
