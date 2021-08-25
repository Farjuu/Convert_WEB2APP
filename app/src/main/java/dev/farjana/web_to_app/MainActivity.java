package dev.farjana.web_to_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText urlEditText;
    Button searchButton;
    String urlStringValue;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAll();
        
        urlStringValue = urlEditText.getText().toString();

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
         searchButton.setOnClickListener(view -> {
             intent = new Intent(getApplicationContext(),WebViewScreen.class);
             intent.putExtra("urlText",urlEditText.getText().toString());
             startActivity(intent);
         });

    }

    private void initializeAll() {
        urlEditText = findViewById(R.id.url);
        searchButton = findViewById(R.id.button);

    }

}