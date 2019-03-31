package com.example.alfarrthebard.chatfaq;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {

    private boolean validaSenha = false;
    private String primeiraSenha = null;
    private String segundaSenha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.sendMessage);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextInputLayout edit = (TextInputLayout) findViewById(R.id.caixaTexto);
                final TextView tview = (TextView) findViewById(R.id.textChat);
                String result = edit.getEditText().getText().toString();
                tview.append("Você: " + result + "\n");
                tview.setMovementMethod(new ScrollingMovementMethod());
                edit.getEditText().setText("");

                //final JeniferBot botJenifer = new JeniferBot(getApplicationContext());
                AbreChamado chamado = new AbreChamado();

                //botJenifer.getPerguntas();

                if (primeiraSenha != null) {
                    segundaSenha = result;
                    if (primeiraSenha.equals(segundaSenha)) {
                        botJenifer(tview, "Feito! Caso precisar de mais alguma coisa pode me avisar.");
                        primeiraSenha = null;
                        segundaSenha = null;
                        validaSenha = false;

                    } else {
                        botJenifer(tview, "Ops! Senha difere da primeira. Tente novamente");
                        primeiraSenha = null;
                        segundaSenha = null;
                        validaSenha = false;
                        result = "alterar senha";
                    }
                }
                if (validaSenha == true) {
                    primeiraSenha = result;
                    botJenifer(tview, "Confirme a sua senha");
                }
                if (result.contains("alterar") && result.contains("senha") || result.contains("minha senha")) {

                    botJenifer(tview, "Certo. Qual será a nova senha? ");
                    validaSenha = true;
                }

                //Abertura de chamado
                if (result.contains("como está") || result.contains("o meu último chamado")) {
                    botJenifer(tview, "Vou verificar para você em 1 minuto!");
                    timerTask(tview, "Ainda está em triagem!" + "\n" + "Pode deixar que te aviso quando o status mudar ;)");
                    timerNotification();
                }
            }

            //Mensagens da Jenifer
            public void botJenifer(TextView tview, String botMessage) {
                tview.append("Bot: " + botMessage + "\n");
            }

            //Task timer
            public void timerTask(final TextView tview, final String message) {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        botJenifer(tview, message);
                    }
                };

                Timer timer = new Timer();
                timer.schedule(task, 3000L);
            }

            //chama notificacao
            public void timerNotification() {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {

                        AbreChamado chamado = new AbreChamado();

                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        NotificationChannel channel = new NotificationChannel("default",
                                "YOUR_CHANNEL_NAME",
                                NotificationManager.IMPORTANCE_DEFAULT);
                        channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
                        mNotificationManager.createNotificationChannel(channel);

                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Main.this, "default")
                                .setSmallIcon(R.drawable.jennifer)
                                .setContentTitle("Informação sobre o seu chamado: " + chamado.getTicket())
                                .setContentText("Está em " + chamado.getStatus() + " com o analista " + chamado.getAnalista())
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        mNotificationManager.notify(100, mBuilder.build());
                    }
                };

                Timer timer = new Timer();
                timer.schedule(task, 15000L);
            }
        });
    }
}
