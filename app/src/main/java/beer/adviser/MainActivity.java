package beer.adviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //array unutar kojeg smo spremili elemente spinnera
        String[] arraySpinner = new String[]{"light","amber","brown","dark"};
        //stvorili spinner objekt od XML elementa
        Spinner spinner = findViewById(R.id.spinner);

        //adapter objekt koji nam sluzi za spremanje informacija kako cemo prikazati
        //elemente unutar spinnera i koje podatke cemo prikazati u spinner-u
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,arraySpinner);

        //ovako govorimo adapteru kako ce izgledati drop down lista kao argument
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        //ovdje upogonjujemo taj adapter unutar spinnera
        spinner.setAdapter(arrayAdapter);

        Button button = findViewById(R.id.find_beer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.brands);
            }
        });

    }
}