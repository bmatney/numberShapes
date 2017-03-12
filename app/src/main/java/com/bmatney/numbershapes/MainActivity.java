package com.bmatney.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
            int number;
            public boolean isSquare(){
                double squareRoot = Math.sqrt(number);
                if(squareRoot == Math.floor(squareRoot)){
                    return true;
                }else{
                    return false;
                }
            }

            public boolean isTriangular(){
                int x = 1;
                int triangularNum = 1;
                while(triangularNum < number){
                    x++;
                    triangularNum = triangularNum + x;
                }
                if(triangularNum == number){
                    return true;
                }else{
                    return false;
                }
            }
        }


    public void testNumber(View view) {

        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);

        String message = "";

        if (usersNumber.getText().toString().isEmpty()) {

            message = "Please enter a Number";

        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both Square and Triangular!";
                } else {
                    message = myNumber.number + " is square, but not triangular";
                }
            } else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is Triangular, but not Square.";
                } else {
                    message = myNumber.number + " is neither Square, nor is it Triangular";
                }
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
