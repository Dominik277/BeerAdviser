package beer.adviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickFindBeer(View view){
        TextView brands = findViewById(R.id.brands);
        Spinner color = findViewById(R.id.color);

        String beerType = (String) color.getSelectedItem();
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for (String brand:brandsList){
            brandsFormatted.append(brand).append("\n");
        }
        brands.setText(brandsFormatted);
    }

}