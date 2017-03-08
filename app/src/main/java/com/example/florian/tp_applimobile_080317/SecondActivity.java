package com.example.florian.tp_applimobile_080317;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by florian on 08/03/2017.
 */

public class SecondActivity extends AppCompatActivity {

    EditText PSEUDO;
    EditText PASSWORD;
    EditText MAIL;
    Button BUTTON_TWO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        PSEUDO = (EditText) findViewById(R.id.Edit_Pseudo);
        PASSWORD = (EditText) findViewById(R.id.Edit_Password);
        MAIL = (EditText) findViewById(R.id.Edit_Mail);
        BUTTON_TWO = (Button) findViewById(R.id.Button_02);

        BUTTON_TWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SetPrefs();
                PreviousActivity();
            }
        });

    }
/*
    protected void SetPrefs(){
        SharedPreferences.Editor MyEditor = getPreferences(0).edit();
        MyEditor.putString("pseudo",PSEUDO.getText().toString());
        MyEditor.putString("password",PASSWORD.getText().toString());
        MyEditor.putString("mail",MAIL.getText().toString());
        if (getPreferences(0).contains("pseudo")){
            MyEditor.commit();
        }else{
            MyEditor.apply();
        }
        PreviousActivity();
    }
*/
    private void PreviousActivity(){
        Intent data = new Intent();
        data.putExtra("pseudo", PSEUDO.getText().toString());
        data.putExtra("password", PASSWORD.getText().toString());
        data.putExtra("mail", MAIL.getText().toString());
        setResult(1, data);
        finish();
    }

}
