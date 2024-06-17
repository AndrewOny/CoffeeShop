package com.example.coffeeshop;

import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class third_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        // Retrieve the list of messages and the coffee name sent from second_activity
        ArrayList<String> messages = getIntent().getStringArrayListExtra("MESSAGES_KEY");
        String coffeeName = getIntent().getStringExtra("image_description");


        // Display the coffee name along with the messages
        TextView textViewMessage = findViewById(R.id.textView);
        StringBuilder displayMessage = new StringBuilder();
        if (coffeeName != null) {
            displayMessage.append(coffeeName).append("\n");
        }
        if (messages != null) {
            for (String message : messages) {
                displayMessage.append(message).append("\n");
            }
        }
        textViewMessage.setText(displayMessage.toString());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, second_activity.class);
        startActivity(intent);
    }
}
