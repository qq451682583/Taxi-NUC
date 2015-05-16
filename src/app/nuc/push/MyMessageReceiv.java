package app.nuc.push;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import app.ui.activity.R;
import cn.bmob.push.BmobPush;
import cn.bmob.push.PushConstants;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobGeoPoint;


public class MyMessageReceiv extends BroadcastReceiver {
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		// 获取推送消息
		String message = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
		Log.i("nuc", "收到的推送消息："+message);
		// 发送通知
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification n = new Notification();  
        n.icon = R.drawable.nuctaxi;  
        n.tickerText = "高校通收到消息推送";  
        n.when = System.currentTimeMillis();  
        //n.flags=Notification.FLAG_ONGOING_EVENT;  
        Intent i = new Intent();  
        PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0);  
        n.setLatestEventInfo(context, "消息", message, pi);  
        n.defaults |= Notification.DEFAULT_SOUND;
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(1, n);
	}
}
