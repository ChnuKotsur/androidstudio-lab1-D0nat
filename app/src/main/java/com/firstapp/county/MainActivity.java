package com.firstapp.county;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewFlag;
    ImageView imageViewBack;
    Resources resources;
    TextView topText;
    TextView AnthemText;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resource = getResources();

        String[] items = getResources().getStringArray(R.array.activity_options);
        Spinner countries = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.activity_options, // Ресурс масиву рядків
                android.R.layout.simple_spinner_item // Макет для відображення елементів у Spinner
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countries.setAdapter(adapter);
        countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner countries = (Spinner) findViewById(R.id.spinner);
                imageViewFlag = findViewById(R.id.imageView2);
                resources = getResources();
                topText = (TextView) findViewById(R.id.textName);
                AnthemText = (TextView) findViewById(R.id.textGimn);

                String country = String.valueOf(countries.getSelectedItem());
                topText.setText(country);

                switch (country) {
                    case "Sudan":
                        imageViewFlag.setImageResource(R.drawable.udan);
                        constraintLayout = findViewById(R.id.main);
                        constraintLayout.setBackgroundResource(R.drawable.arima);
                        AnthemText.setText(resources.getString(R.string.GimnS));

                        break;
                    case "Bulgaria":
                        imageViewFlag.setImageResource(R.drawable.ulgaria);
                        AnthemText.setText(resources.getString(R.string.GimnBu));
                        constraintLayout = findViewById(R.id.main);
                        constraintLayout.setBackgroundResource(R.drawable.bulgaria);
                        break;
                    case "Tonga":
                        imageViewFlag.setImageResource(R.drawable.onga);
                        AnthemText.setText(resources.getString(R.string.GimnT));
                        constraintLayout = findViewById(R.id.main);
                        constraintLayout.setBackgroundResource(R.drawable.ature);
                        break;
                    case "Nederland":
                        imageViewFlag.setImageResource(R.drawable.etherlands);
                        AnthemText.setText(resources.getString(R.string.GimnN));
                        constraintLayout = findViewById(R.id.main);
                        constraintLayout.setBackgroundResource(R.drawable.ftufu);
                        break;
                    case "Argentina":
                        imageViewFlag.setImageResource(R.drawable.rgentina1);
                        AnthemText.setText(resources.getString(R.string.GimnA));
                        constraintLayout = findViewById(R.id.main);
                        constraintLayout.setBackgroundResource(R.drawable.rgentina);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Дія, яка відбувається, коли нічого не вибрано
            }
        });
    }
}