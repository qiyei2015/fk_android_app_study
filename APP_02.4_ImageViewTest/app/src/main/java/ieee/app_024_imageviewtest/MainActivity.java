package ieee.app_024_imageviewtest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };

    private int currentImg = 0;
    private int alpha = 255; //图片透明度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button plus = (Button) findViewById(R.id.bn1);
        final Button minus = (Button) findViewById(R.id.bn2);
        final Button next = (Button) findViewById(R.id.bn3);

        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);

        /*定义下一张图片的监听器*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*控制器显示下一幅图片*/
                image1.setImageResource(images[currentImg++ % images.length]);

            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( v == plus){

                    alpha += 20;
                }

                if ( v == minus){

                    alpha -= 20;
                }

                if ( alpha < 0){

                    alpha = 0;
                }

                if ( alpha > 255){

                    alpha = 255;
                }

                /*改变图片透明度*/
                image1.setImageAlpha(alpha);
            }
        };

        /*为两个按钮添加监听器*/
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                BitmapDrawable bitmapDrawable  = (BitmapDrawable) image1.getDrawable();

                /*获取第一个图片中的显示位图*/
                Bitmap bitmap = bitmapDrawable.getBitmap();

                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();

                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);

                if (x + 200 > bitmap.getWidth()){
                    x = bitmap.getWidth() - 200;
                }

                if (y + 200 > bitmap.getHeight()){
                    y = bitmap.getHeight() - 200;
                }

                //显示图片指定区域
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,200,200));
                image2.setImageAlpha(alpha); //显示图片透明度

                return false;
            }
        });

    }
}
