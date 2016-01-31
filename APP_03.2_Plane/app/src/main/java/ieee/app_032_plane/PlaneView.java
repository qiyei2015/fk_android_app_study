package ieee.app_032_plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by qiyei on 2016/1/9.
 */
public class PlaneView extends View {

    public float currentX = 0;
    public float currentY = 0;
    private Bitmap plane = null;


    public PlaneView(Context context){
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas){

        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(plane,currentX,currentY,p);
    }
}
