package com.example.akhme.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Double;
import java.util.regex.*;
import android.widget.EditText;
import android.content.Intent;


/*
АХТУНГ
Шутка про 28 ударов нулем
28 делений на ноль - редирект на пасту
Листал медведь телефон, видит - калькулятор открыт, поделил на ноль и сгорел
Ввел мужик 9 символов, а они ему как раз
Пожестче: зига на 1488, косяк на 228
 */


public class MainActivity extends AppCompatActivity {

    String totalResult;
    boolean isSignEntered = false;

    public void textInput(Button btn){
        TextView table = findViewById(R.id.table);
        if( table.getText().toString().length() < 9) {
            table.setText(table.getText().toString().concat(btn.getText().toString()));
        }
    }

    public boolean isSign(char sym){
        if(sym == '+' || sym == '-' || sym == '×' || sym == '÷' ){
            return true;
        } else {
            return false;
        }
    }

    public double newRes(char sym, double res1, double res2){
        switch(sym){
            case '×':
                return res1 * res2;
            case '÷':
                return res1 / res2;
            case '+':
                return res1 + res2;
            default:
                return res1 - res2;
        }
    }

    public double equal(String str) {
        double res1 = 0, res2 = 0;
        //String res1;
        int signPos = 0;
        for(int i = 0; i < str.length(); i++) {
            if (isSign(str.charAt(i))) {
                signPos = i;
                res1 = Double.parseDouble(str.substring(0, i));
                if (i < str.length() - 1) {
                    res2 = Double.parseDouble(str.substring(i + 1, str.length()));
                } else {
                    return res1;
                }
                break;
            }
            //break;
        }
        //return str.substring(signPos, signPos + 1);
        return newRes(str.charAt(signPos), res1, res2);
    }

    public void resultProcessed(){
        TextView table = findViewById(R.id.table);
        totalResult = totalResult.concat(table.getText().toString());
        double res = equal(totalResult);
        totalResult = Double.toString(res);
        table.setText(totalResult);
    }

    /*
    public void textInput(Button btn) {
        TextView table = findViewById(R.id.table);
        if (isSign(btn.getText().charAt(0))) {
            if (isSignEntered) {
                //resultProcessed();
                //isSignEntered = false;
                //basicTextInput(btn);
                while(isSign(btn.getText().charAt(0))){
                    table.setText("Try again");
                }
                isSignEntered = false;
            }
            isSignEntered = true;
            basicTextInput(btn);
        } else {
            basicTextInput(btn);
        }
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btn0 = (Button)findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn0);
            }
        });

        final Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn1);
            }
        });

        final Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn2);
            }
        });

        final Button btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn3);
            }
        });

        final Button btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn4);
            }
        });

        final Button btn5 = (Button)findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn5);
            }
        });

        final Button btn6 = (Button)findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn6);
            }
        });

        final Button btn7 = (Button)findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn7);
            }
        });

        final Button btn8 = (Button)findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn8);
            }
        });

        final Button btn9 = (Button)findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btn9);
            }
        });

        final Button btnPoint = (Button)findViewById(R.id.point);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput(btnPoint);
            }
        });

        final Button del = (Button)findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                String string = table.getText().toString();
                if( string.length() != 0) {
                    table.setText(string.substring(0, string.length() - 1));
                }
            }
        });

        final Button btnPlus = (Button)findViewById(R.id.plus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                totalResult = table.getText().toString();
                table.setText(btnPlus.getText().toString());
            }
        });

        final Button btnMinus = (Button)findViewById(R.id.minus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                totalResult = table.getText().toString();
                table.setText(btnMinus.getText().toString());
            }
        });

        final Button btnMulti = (Button)findViewById(R.id.multiplication);
        btnMulti.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                totalResult = table.getText().toString();
                table.setText(btnMulti.getText().toString());
            }
        });

        final Button btnDiv = (Button)findViewById(R.id.division);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                totalResult = table.getText().toString();
                table.setText(btnDiv.getText().toString());
            }
        });

        final Button btnEqual = (Button)findViewById(R.id.equal);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            TextView table = findViewById(R.id.table);
            @Override
            public void onClick(View v) {
                resultProcessed();
                /*totalResult = totalResult.concat(table.getText().toString());
                double res = equal(totalResult);
                totalResult = Double.toString(res);
                table.setText(totalResult);*/
            }
        });

    }




}
