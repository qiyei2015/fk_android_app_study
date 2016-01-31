package ieee.app_022_framelayouttest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/*周期性的改变6个TextView的颜色，实现霓虹灯效果*/
public class MainActivity extends AppCompatActivity {

    private int currentColor = 0;

    //定义一个颜色数组，color1 等在values/colors.xml文件定义
    final int[] colors = new int[] {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };

    final int[] names = new int[] {
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };

    TextView [] views = new TextView[names.length];

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg){
            //表明消息来自本程序发送的
            if(msg.what == 0x123)
            {
                for(int i = 0;i < names.length; i++)
                {
                    views[i].setBackgroundResource(colors[(i + currentColor) % names.length]);
                }

                currentColor++;
            }
            super.handleMessage(msg);
        }

    };

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

        //初始化views
        for (int i = 0;i < names.length;i++){
            views[i] = (TextView) findViewById(names[i]);

        }

        //定义一个线程，周期性的改变的currentColor的值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                handler.sendEmptyMessage(0x123);
            }
        },0,200);

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
