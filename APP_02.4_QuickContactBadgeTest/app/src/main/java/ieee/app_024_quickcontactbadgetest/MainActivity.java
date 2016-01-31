package ieee.app_024_quickcontactbadgetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    private QuickContactBadge badge = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        badge = (QuickContactBadge) findViewById(R.id.badge);

        badge.assignContactFromPhone("13348930525",false);

    }
}
