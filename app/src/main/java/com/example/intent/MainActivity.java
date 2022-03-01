package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    private EditText mTextTo;
    private EditText mSubject;
    private EditText mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextTo=findViewById(R.id.email);
        mSubject=findViewById(R.id.subject);
        mMessage=findViewById(R.id.message);
    }

    public void submit(View view){
        String[] mailAdd=mTextTo.getText().toString().split(",");
        String sub=mSubject.getText().toString();
        String mess=mMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, mailAdd);
        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
        intent.putExtra(Intent.EXTRA_TEXT, mess);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        }
    }