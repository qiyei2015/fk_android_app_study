package ieee.app_033_callbackhandler;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * Created by daner1125 on 2016/1/11.
 */
public class MyButton extends Button {

    public MyButton(Context context,AttributeSet set){

        super(context,set);

    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        super.onKeyDown(keyCode,event);
        Log.v("MyButton", "the onKeyDown int MyButton");
        
        return true;

    }

}
