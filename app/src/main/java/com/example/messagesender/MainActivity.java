package com.example.messagesender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String MESSAGE = "CUSTOM_BROADCAST_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.sendButton);
        final EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MESSAGE);
                intent.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
                intent.putExtra("message", editText.getText().toString());
                sendBroadcast(intent);

            }
        });

    }
}
