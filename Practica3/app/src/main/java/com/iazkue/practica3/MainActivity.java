package com.iazkue.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        ListView listView = findViewById(R.id.list);

        // Crear una lista de 30 elementos
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            items.add("Elemento " + i);
        }

        // Configurar el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(adapter);

        // Configurar el listener para los clics en los elementos
        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            // Crear un intent para navegar a DisplayActivity
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("item", items.get(position));
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addItem(View view){
        Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reload) {
// Reload
            initItemList();
            itemsAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}