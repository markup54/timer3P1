package pl.zabrze.zs10.timer3p1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int sekundy = 0;
    private TextView textViewCzas;
    private boolean dziala = false;
    String czasDowyswietlenia;
    String czasyZapisane = "Zapisane czasy: \n";

    Button buttonStart;
    Button buttonStop;
    Button buttonReset;
    Button buttonZapisz;
    TextView textViewCzasyZapisane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCzas = findViewById(R.id.textViewAktualnyCzas);
        buttonStart = findViewById(R.id.buttonStart);
        textViewCzasyZapisane =findViewById(R.id.textViewZapisaneCzasy);
        if(savedInstanceState !=null){
            sekundy = savedInstanceState.getInt("SEKUNDY");
        }

        uruchomZegar();
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dziala = true;

                    }
                }
        );
        buttonStop = findViewById(R.id.buttonPauza);
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dziala =false;
                    }
                }
        );
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy = 0;
                        dziala = false;
                        wyswietl(sekundy);
                    }
                }
        );
        buttonZapisz = findViewById(R.id.buttonZapisz);
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czasyZapisane += czasDowyswietlenia+"\n";
                        //TODO wyswietlic w textView pod przyciskami
                        textViewCzasyZapisane.setText(czasyZapisane);
                    }
                }
        );
    }

    private void uruchomZegar(){
        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(dziala) {
                            sekundy++;
                            //TODO wyswietlić czas
                            wyswietl(sekundy);
                        }
                        handler.postDelayed(this,1000);
                    }

                }

        );


    }
private void wyswietl(int sekundy){
    int s60 = sekundy % 60;
    int h60 = sekundy / 3600;
    int m60 = (sekundy - h60 * 3600) / 60;
    czasDowyswietlenia = String.format("%02d:%02d:%02d", h60, m60, s60);
    textViewCzas.setText(czasDowyswietlenia);
}

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SEKUNDY",sekundy);
    }
}