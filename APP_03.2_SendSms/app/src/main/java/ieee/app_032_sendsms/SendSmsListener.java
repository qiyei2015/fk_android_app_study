package ieee.app_032_sendsms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by qiyei on 2016/1/10.
 */
public class SendSmsListener implements View.OnLongClickListener {

    private Activity activity;
    private EditText address;
    private EditText content;

    public SendSmsListener(Activity act,EditText addr,EditText content){

        this.activity = act;
        this.address = addr;
        this.content = content;
    }

    @Override
    public boolean onLongClick(View source){

        String addrStr = address.getText().toString();
        String conStr = content.getText().toString();

        //获取短信管理器
        SmsManager smsManager = SmsManager.getDefault();
        //创建发送短信的PendingIntent
        PendingIntent sentIntent = PendingIntent.getBroadcast(activity,0,new Intent(),0);

        //发送文本短信
        smsManager.sendTextMessage(addrStr, null, conStr, sentIntent, null);

        Toast.makeText(activity,"短信发送完成",Toast.LENGTH_LONG).show();
        
        return false;
    }
}
