package ieee.app_023_chronometertest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Chronometer ch = null;
    private Button start = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch = (Chronometer) findViewById(R.id.ch);

        start = (Button) findViewById(R.id.bn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                start.setEnabled(false);
            }
        });


        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000){

                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });


    }
}
