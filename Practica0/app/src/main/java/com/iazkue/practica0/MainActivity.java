package com.iazkue.practica0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void displayMessage(View view) {
        TextView textView =((TextView) findViewById(R.id.textViewMainDisplay));
        String name = textView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1); // Request Code = 1
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String name= bundle.getString("name");
            TextView textView =((TextView) findViewById(R.id.textViewMainDisplay));
            textView.setText(name);
        }
    }
}