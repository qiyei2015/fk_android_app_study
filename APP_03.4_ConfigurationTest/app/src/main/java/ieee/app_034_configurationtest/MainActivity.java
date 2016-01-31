package ieee.app_034_configurationtest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ori = null;
    EditText navigation = null;
    EditText touch = null;
    EditText mnc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //获取界面组件
        ori = (EditText)findViewById(R.id.textView1);
        navigation = (EditText)findViewById(R.id.textView2);
        touch = (EditText)findViewById(R.id.textView3);
        mnc = (EditText)findViewById(R.id.textView4);
        Button bn = (Button)findViewById(R.id.bn);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取系统的configuration对象
                Configuration cfg = getResources().getConfiguration();
                String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕":"竖向屏幕";
                String mncCode = cfg.mnc+"";
                String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "没有方向控制":
                        cfg.orientation == Configuration.NAVIGATION_WHEEL ? "滚轮控制":
                        cfg.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向":"轨迹球控制方向";

                navigation.setText(naviName);

                String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ? "无触摸屏":"支持触摸屏";
                ori.setText(screen);
                mnc.setText(mncCode);
                touch.setText(touchName);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
