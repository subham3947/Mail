package com.example.nakul.mail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText email_text,email_add,email_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=(Button)findViewById(R.id.send);
        email_add=(EditText)findViewById(R.id.add) ;
        email_sub=(EditText)findViewById(R.id.sub) ;
        email_text=(EditText)findViewById(R.id.body) ;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = email_text.getText().toString();
                String sub = email_sub.getText().toString();
                String add = email_add.getText().toString();
                if ((add.equals("")) || (sub.equals("")) || (text.equals(""))) {
                    if (add.equals("")) {
                        Toast.makeText(MainActivity.this, "No mail Body!!", Toast.LENGTH_SHORT).show();
                    }
                    if (sub.equals("")) {
                        Toast.makeText(MainActivity.this, "No Subject!!", Toast.LENGTH_SHORT).show();
                    }

                    if (text.equals("")) {
                        Toast.makeText(MainActivity.this, "No mail Body!!", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Intent mailIntent = new Intent(Intent.ACTION_SEND);
                    mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{add});
                    mailIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                    mailIntent.putExtra(Intent.EXTRA_TEXT, text);
                    mailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(mailIntent, "Select an Email Client:"));
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("CurrentState","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("CurrentState","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("CurrentState","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("CurrentState","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("CurrentState","onRestart");
    }
}
