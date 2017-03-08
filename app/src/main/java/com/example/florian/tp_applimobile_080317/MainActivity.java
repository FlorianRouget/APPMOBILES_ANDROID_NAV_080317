package com.example.florian.tp_applimobile_080317;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    Button BUTTON_ONE;
    TextView TEXT_PSEUDO;
    TextView TEXT_PASSWORD;
    TextView TEXT_MAIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BUTTON_ONE = (Button) findViewById(R.id.Button_01);
        TEXT_PSEUDO = (TextView) findViewById(R.id.Text_Pseudo);
        TEXT_PASSWORD = (TextView) findViewById(R.id.Text_Password);
        TEXT_MAIL = (TextView) findViewById(R.id.Text_Mail);
        RetrievePrefs();


        BUTTON_ONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });
    }
    private void goToNextActivity(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, 0);
    }

    private void RetrievePrefs(){
        String nv = "Pseudo : "+getPreferences(0).getString("pseudo", "-none-");
        TEXT_PSEUDO.setText(nv);
        nv = "Password : "+getPreferences(0).getString("password", "-none-");
        TEXT_PASSWORD.setText(nv);
        nv = "Mail : "+getPreferences(0).getString("mail", "-none-");
        TEXT_MAIL.setText(nv);
    }

    protected void SetPrefs(String a, String b, String c){
        SharedPreferences.Editor MyEditor = getPreferences(0).edit();
        MyEditor.putString("pseudo",a);
        MyEditor.putString("password",b);
        MyEditor.putString("mail",c);
        if (getPreferences(0).contains("pseudo")){
            MyEditor.commit();
        }else{
            MyEditor.apply();
        }
//        PreviousActivity();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String s_pseudo = data.getStringExtra("pseudo");
        String s_pass = data.getStringExtra("password");
        String s_mail = data.getStringExtra("mail");

        SetPrefs(s_pseudo, s_pass, s_mail);

        Toast.makeText(this, "PSEUDO : "+s_pseudo, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "PASSWORD : "+s_pass, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "MAIL : "+s_mail, Toast.LENGTH_SHORT).show();
        Log.d("STATE","PSEUDO : "+s_pseudo);
        Log.d("STATE","PASSWORD : "+s_pass);
        Log.d("STATE","MAIL : "+s_mail);

        RetrievePrefs();

    }



}