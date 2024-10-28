package com.example.statemanagementextended;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count"; // Klucz do przechowywania danych w Bundle
    private TextView textView; // Element widoku do wyświetlania liczby
    private Button button;
    private EditText editText;
    private CheckBox checkBox;
    private Switch switch1;
    private TextView textView2;
    private int count = 0; // Zmienna do przechowywania wartości licznika
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicjalizacja elementów widoku
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkBox);
        switch1 = findViewById(R.id.switch1);
        textView2 = findViewById(R.id.textView2);
        // Odczyt danych ze stanu, jeśli istnieją
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT); // Przywrócenie wartości licznika
        }
        // Aktualizacja tekstu licznika
        updateCountText();
        // Ustawienie akcji kliknięcia przycisku
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++; // Zwiększenie wartości licznika
                updateCountText(); // Aktualizacja widoku TextView
            }
        });
        // Ustawienie akcji dla przełącznika (Switch)
        switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                findViewById(android.R.id.content).setBackgroundColor(Color.rgb(99, 99, 100)); // Zmiana koloru tła
            } else {
                findViewById(android.R.id.content).setBackgroundColor(Color.WHITE); // Przywrócenie domyślnego koloru tła
            }
        });
        // Ustawienie akcji dla CheckBoxa
        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                textView2.setVisibility(View.VISIBLE); // Pokazanie TextView2
            } else {
                textView2.setVisibility(View.GONE); // Ukrycie TextView2
            }
        });
    }
    // Zapisanie stanu licznika
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count); // Zapisanie aktualnej wartości licznika do Bundle
    }
    // Aktualizacja tekstu licznika
    private void updateCountText() {
        textView.setText("Counter: " + count); // Ustawienie tekstu TextView na aktualną wartość licznika
    }
}