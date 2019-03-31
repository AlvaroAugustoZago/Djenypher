package com.example.alfarrthebard.chatfaq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.campoNome);
        Password = (EditText) findViewById(R.id.campoSenha);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btnLogin);

    Info.setText("Restam 3 tentativas");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


//        Login.setOnContextClickListener(new View.OnClickListener(){
//            @Override
//                 public void OnClick(View view){
//                    validate(Name.getText().toString(), Password.getText().toString());
//
//                }
//            });

    }

    private void validate (String userName, String userPassword){
        if((userName.equals("neogrid")) && (userPassword.equals("neogrid"))){
            Intent intent = new Intent(login.this, Main.class);
            startActivity(intent);
        }else{
            counter--;


            Info.setText("Usuário ou senha incorretos"+"\n"+"Restam "+String.valueOf(counter)+" tentativas");
                        if(counter==0){
                Login.setEnabled(false);
            }
        }

    }


    public class MaterialDesignLogInForm extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
        }
    }


}
