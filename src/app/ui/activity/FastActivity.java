package app.ui.activity;


import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import app.ui.TitleActivity;
import app.ui.activity.setting.AboutActivity;
import app.ui.activity.setting.Commit;
import app.ui.activity.setting.User;

public class FastActivity extends TitleActivity {

    private static final String TAG = FastActivity.class.getSimpleName();
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }


    private void setupViews() {
        setContentView(R.layout.viewpager_shopinfo);
        setTitle(R.string.text_fast);
        showBackwardView(R.string.button_backward, true);
        
        
    }
    
   
	
	public void toast(String msg){
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
		Log.d(TAG, msg);
	}
    @Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
    }

}
