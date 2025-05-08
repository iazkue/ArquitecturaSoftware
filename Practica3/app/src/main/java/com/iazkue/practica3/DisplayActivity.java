package com.iazkue.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intentget = getIntent();
        Bundle getbundle = intentget.getExtras();

        String string = getbundle.getString("item");

        // Mostrar el elemento en el TextView
        TextView textView = findViewById(R.id.editTextText);
        textView.setText(string);
    }

}