package ieee.app_023_togglebuttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggle = null;
    private Switch switcher = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = (ToggleButton) findViewById(R.id.toggle);
        switcher = (Switch) findViewById(R.id.switcher);

        final LinearLayout test = (LinearLayout) findViewById(R.id.test);


        OnCheckedChangeListener listener = new OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton button,boolean isChecked){

                if (isChecked){
                    test.setOrientation(1);
                    toggle.setChecked(true);
                    switcher.setChecked(true);
                } else {
                    test.setOrientation(0);
                    toggle.setChecked(false);
                    switcher.setChecked(false);
                }

            }
        };

        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);
    }
}
