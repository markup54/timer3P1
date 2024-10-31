package pl.zabrze.zs10.timer3p1;


import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    int liczbaSekund = 180;
    boolean czyAktywny = false;
    CountDownTimer countDownTimer;
    Button button;

    public Gracz( boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
    }

    public void liczCzas(){
        czyAktywny = true;
        countDownTimer = new CountDownTimer(liczbaSekund*1000,1000) {
            @Override
            public void onTick(long l) {
                int s60 = liczbaSekund % 60;
                int h60 = liczbaSekund / 3600;
                int m60 = (liczbaSekund - h60 * 3600) / 60;

                button.setText(String.format("%02d:%02d:%02d", h60, m60, s60));
                liczbaSekund = (int)l/1000;
            }

            @Override
            public void onFinish() {
button.setText("KONIEC");
button.setActivated(false);
            }
        };
        countDownTimer.start();

    }

    public void stopCzas(){
        czyAktywny = false;
        countDownTimer.cancel();
    }

}
