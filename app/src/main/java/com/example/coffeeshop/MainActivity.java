package com.example.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton button1 = findViewById(R.id.imageButtonEsp);
        ImageButton button2 = findViewById(R.id.imageButtonAmr);
        ImageButton button3 = findViewById(R.id.imageButtonLatte);
        ImageButton button4 = findViewById(R.id.imageButtonCapp);
        ImageButton button5 = findViewById(R.id.imageButtonFlat);
        ImageButton button6 = findViewById(R.id.imageButtonRaf);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.espresso_pic);
            intent.putExtra("image_description", "Espresso");
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.americano);
            intent.putExtra("image_description", "Americano");
            startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.latte_pic);
            intent.putExtra("image_description", "Latte");
            startActivity(intent);
        });

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.cappuccino_pic);
            intent.putExtra("image_description", "Cappuccino");
            startActivity(intent);
        });

        button5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.flat_white);
            intent.putExtra("image_description", "Flat White");
            startActivity(intent);
        });

        button6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, second_activity.class);
            intent.putExtra("image_resource", R.drawable.raf_pic);
            intent.putExtra("image_description", "Raf");
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
