package com.example.alfarrthebard.chatfaq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Main extends AppCompatActivity {

    private int countId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.sendMessage);
        addChild(getSaudacao() + " Sr. {Usuario}", false, true);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText edit = (EditText) findViewById(R.id.caixaTexto);
                String result = edit.getText().toString();

                addChild(result, true, false);
            }


        });
    }

    private String getSaudacao(){
        Calendar rightNow = Calendar.getInstance();
        int GMT = -3;
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int brazilHour = hour + GMT;

        String saudacao = null;

        if(hour < 12){
            saudacao = "Bom dia";
        } else if(hour < 18){
            saudacao = "Boa Tarde";
        } else {
            saudacao = "Boa Noite";
        }
        return saudacao;
    }


    private void addChild(String msg, boolean isUser, boolean isInit) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.chat);
        RelativeLayout.LayoutParams textparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());

        if (isInit) {

            textparams.setMargins(0, 30, 0, 0);
            linearLayout.setId(countId);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.margin_top);

            ImageView imageView = new ImageView(getApplicationContext());
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            imageView.setImageResource(R.drawable.jennifer);
            lp.width = (int) getResources().getDimension(R.dimen.image_width);
            lp.height = (int) getResources().getDimension(R.dimen.image_height);
            lp.topMargin = (int) getResources().getDimension(R.dimen.image_margin_top);

            imageView.setLayoutParams(lp);
            linearLayout.addView(imageView);

            RelativeLayout.LayoutParams txp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            TextView textView = new TextView(getApplicationContext());
            textView.setText(msg);
            textView.setBackgroundResource(R.drawable.rounded_corner1);
            textView.setPadding(15, 15, 15, 15);

            txp.topMargin = (int) getResources().getDimension(R.dimen.txt_margin_top);


            textView.setLayoutParams(txp);
            linearLayout.addView(textView);
            countId = linearLayout.getId();
            relativeLayout.addView(linearLayout);
            countId++;
        } else {
            if (isUser) {
                int tempid = countId - 1;
                textparams.addRule(RelativeLayout.BELOW, tempid);
                textparams.setMargins(0, 30, 0, 0);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                layoutParams.topMargin = (int) getResources().getDimension(R.dimen.margin_top);
                linearLayout.setId(countId);
                RelativeLayout.LayoutParams txp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

                textparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

                TextView textView = new TextView(getApplicationContext());
                textView.setText(msg);
                textView.setBackgroundResource(R.drawable.rounded_corner);
                textView.setPadding(15, 15, 15, 15);

                txp.topMargin = (int) getResources().getDimension(R.dimen.txt_margin_top);

                textView.setLayoutParams(txp);
                linearLayout.addView(textView);

                ImageView imageView = new ImageView(getApplicationContext());
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                imageView.setImageResource(R.drawable.portrait_mode_male);
                lp.width = (int) getResources().getDimension(R.dimen.image_width);
                lp.height = (int) getResources().getDimension(R.dimen.image_height);
                lp.topMargin = (int) getResources().getDimension(R.dimen.image_margin_top);

                imageView.setLayoutParams(lp);
                linearLayout.addView(imageView);

                countId = linearLayout.getId();
                relativeLayout.addView(linearLayout, textparams);
                countId++;
            } else {
                int tempid = countId - 1;
                textparams.addRule(RelativeLayout.BELOW, tempid);

                textparams.setMargins(0, 30, 0, 0);
                ;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                layoutParams.topMargin = (int) getResources().getDimension(R.dimen.margin_top);
                ImageView imageView = new ImageView(getApplicationContext());
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.setId(countId);
                imageView.setImageResource(R.drawable.jennifer);
                lp.width = (int) getResources().getDimension(R.dimen.image_width);
                lp.height = (int) getResources().getDimension(R.dimen.image_height);
                lp.topMargin = (int) getResources().getDimension(R.dimen.image_margin_top);
//        lp.addRule(RelativeLayout.BELOW, R.id.layout3);

                imageView.setLayoutParams(lp);
                linearLayout.addView(imageView);

                RelativeLayout.LayoutParams txp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

                TextView textView = new TextView(getApplicationContext());
                textView.setText(msg);
                textView.setBackgroundResource(R.drawable.rounded_corner1);
                textView.setPadding(15, 15, 15, 15);

                txp.topMargin = (int) getResources().getDimension(R.dimen.txt_margin_top);


                textView.setLayoutParams(txp);
                linearLayout.addView(textView);

                countId = linearLayout.getId();
                relativeLayout.addView(linearLayout, textparams);
                countId++;
            }

        }


    }

}


