package beer.adviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.find_beer);
        TextView textView = findViewById(R.id.brands);

        String[] arraySpinner = new String[]{"light","amber","brown","dark"};
        String[] versionsOfBeer = new String[]{"Ozujsko","Karlovacko","Pan","Osjecko"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,arraySpinner);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = spinner.getSelectedItem().toString();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (text == arraySpinner[0]){
                            textView.setText(versionsOfBeer[0]);
                        }else if (text == arraySpinner[1]){
                            textView.setText(versionsOfBeer[1]);
                        }else if (text == arraySpinner[2]){
                            textView.setText(versionsOfBeer[2]);
                        }else if (text == arraySpinner[3]){
                            textView.setText(versionsOfBeer[3]);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}