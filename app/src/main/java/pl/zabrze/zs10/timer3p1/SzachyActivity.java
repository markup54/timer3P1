package pl.zabrze.zs10.timer3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SzachyActivity extends AppCompatActivity {
    private Button buttonGracz1;
    private Button buttonGracz2;
    private  Gracz gracz1;
    private  Gracz gracz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szachy);
        buttonGracz1 = findViewById(R.id.buttonGracz1);
        buttonGracz2 = findViewById(R.id.buttonGracz2);
        gracz1 = new Gracz(true,buttonGracz1);
        gracz1.liczCzas();
        gracz2 = new Gracz(false,buttonGracz2);

        buttonGracz1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz1.czyAktywny){
                            gracz1.stopCzas();
                            gracz2.liczCzas();
                        }
                    }
                }
        );
        buttonGracz2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz2.czyAktywny){
                            gracz2.stopCzas();
                            gracz1.liczCzas();
                        }
                    }
                }
        );



    }
}