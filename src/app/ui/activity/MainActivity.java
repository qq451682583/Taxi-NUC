package app.ui.activity;




import cn.bmob.v3.Bmob;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.Window;
import app.ui.NextActivity;

public class MainActivity extends Activity {

	private String APPID ="c3e5a96f0c1f1aa289b81fd6001e4f55";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		 // 初始化 Bmob SDK
		Bmob.initialize(this, APPID);

		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start);
		new Handler().postDelayed(new Runnable(){

		        @Override
		        public void run() {
		            Intent intent = new Intent(MainActivity.this,NextActivity.class);
		            startActivity(intent);
		            MainActivity.this.finish();
		        }

		        }, 2000);
		    
	}

	
}
