package com.example.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class second_activity extends AppCompatActivity implements BlankFragmentSizes.CheckboxListener, BlankFragmentSnacks.CheckboxListener {

    private Button btn, btn_frag1, btn_frag2;
    private BlankFragmentSizes sizeFragment;
    private ArrayList<String> selectedMessages = new ArrayList<>();
    private int lastCheckedCheckbox = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        int imageResource = getIntent().getIntExtra("image_resource", 0);
        String imageDescription = getIntent().getStringExtra("image_description");

        ImageView imageView = findViewById(R.id.imageView);
        if (imageResource != 0) {
            imageView.setImageResource(imageResource);
        }

        TextView textView = findViewById(R.id.title1);
        if (imageDescription != null) {
            textView.setText(imageDescription);
        }

        btn = findViewById(R.id.button_in);
        btn_frag1 = findViewById(R.id.button_size);
        btn_frag2 = findViewById(R.id.button_snacks);

        sizeFragment = new BlankFragmentSizes();

        setNewFragment(sizeFragment);

        btn_frag1.setOnClickListener(v -> setNewFragment(sizeFragment));

        btn_frag2.setOnClickListener(v -> {
            BlankFragmentSnacks snacksFragment = new BlankFragmentSnacks();
            setNewFragment(snacksFragment);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn.setOnClickListener(v -> goInto(selectedMessages, imageDescription));
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckboxClicked(boolean isChecked, int checkboxNumber) {
        String message = getMessageForCheckbox(checkboxNumber);
        if (isChecked) {
            selectedMessages.add(message);
        } else {
            selectedMessages.remove(message);
        }
    }

    private void goInto(ArrayList<String> messages, String coffeeName) {
        Intent intent = new Intent(this, third_activity.class);
        intent.putStringArrayListExtra("MESSAGES_KEY", messages);
        intent.putExtra("image_description", coffeeName);
        startActivity(intent);
    }

    private String getMessageForCheckbox(int checkboxNumber) {
        String messageToSend = null;
        switch (checkboxNumber) {
            case 1: messageToSend = "Size: Demi"; break;
            case 2: messageToSend = "Size: Short"; break;
            case 3: messageToSend = "Size: Tall"; break;
            case 4: messageToSend = "Size: Grande"; break;
            case 5: messageToSend = "Size: Venti"; break;
            case 6: messageToSend = "Size: Trenta"; break;
            case 7: messageToSend = "Snack: Pizza"; break;
            case 8: messageToSend = "Snack: Donut"; break;
            case 9: messageToSend = "Snack: Cake"; break;
            case 10: messageToSend = "Snack: Croissant"; break;
        }
        return messageToSend;
    }
}
