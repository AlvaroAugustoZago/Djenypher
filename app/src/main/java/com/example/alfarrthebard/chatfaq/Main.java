package com.example.alfarrthebard.chatfaq;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.sendMessage);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextInputLayout edit = (TextInputLayout) findViewById(R.id.caixaTexto);
                TextView tview = (TextView) findViewById(R.id.textChat);
                String result = edit.getEditText().getText().toString();
                tview.append("Você: " + result + "\n");
                tview.setMovementMethod(new ScrollingMovementMethod());
                edit.getEditText().setText("");

            }
        });
    }


}


