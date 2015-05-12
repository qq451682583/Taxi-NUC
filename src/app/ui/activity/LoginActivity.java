package app.ui.activity;




import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;


import cn.bmob.v3.update.BmobUpdateAgent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import app.ui.BaseActivity;
import app.ui.TitleActivity;
import app.ui.activity.setting.User;
import app.util.Util;

public class LoginActivity extends TitleActivity implements OnClickListener{

	private static final String TAG = LoginActivity.class.getSimpleName();
	
	
	private EditText etUsername;
	private EditText etPassword;
	
	private String username;
	private String password;
	private Button login;
	private Button register;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }


    private void setupViews() {    	
    	
    	setContentView(R.layout.activity_login);
        setTitle(R.string.title_activity_login);
        showBackwardView(R.string.button_backward, true);
    	etUsername = (EditText)findViewById(R.id.Ledit_name);   	
    	etPassword = (EditText)findViewById(R.id.Ledit_password);
    	login = (Button)findViewById(R.id.login);
    	register = (Button)findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
  
        

        
    }
    
    @Override
    public void onClick(View v) {
    	super.onClick(v);
        switch (v.getId()) {
            case R.id.register:
            	register(v);
                break;   
            case R.id.login:                  	
            	login(v);
    			break;
            default:
                break;
        }
    }
    
    
  //保存用户的登陆记录
  	private void saveUserInfo(String username, String password) {
  		SharedPreferences sp = getSharedPreferences("User", 0);
  		Editor editor = sp.edit();
  		editor.putString("username", username);
  		editor.putString("password", password);
  		
 		editor.commit();
  	}
    
    private void login(View v) {
		// TODO Auto-generated method stub
    	final User bu2 = new User();
    	username = etUsername.getText().toString();
    	Log.i(TAG, username);
		password = etPassword.getText().toString();
		
		if(!Util.isNetworkConnected(this) ){
			toast("请检查网络连接！ ");
		 
		}else if ("".equals(username) || "".equals(password)) {
			toast("账号和密码不能为空！");
			
		}else if(!Util.isEmailValid(username)){
			toast("请正确填写邮箱！");
			
		}else{
			bu2.setUsername(username);
			bu2.setEmail(username);
			bu2.setPassword(password);
			
			bu2.login(this, new SaveListener() {
			
				@Override
				public void onSuccess() {										
					// 跳转到主页
					if(bu2.getEmailVerified()){
						toast("~登陆成功~");
						//保存用户信息
						saveUserInfo(username, password);
						Intent toHome = new Intent(LoginActivity.this,
								StartActivity.class);
						startActivity(toHome);
					}else{
						toast("请前往"+bu2.getUsername()+"验证邮箱！");
					}
				}

				@Override
				public void onFailure(int arg0, String msg) {
					Log.i(TAG, msg);
					toast("用户名或密码错误！");
				}
				
			});
			
		}
	}


	private void register(View register) {
		// TODO Auto-generated method stub
    	startActivity(new Intent(this, RegisterActivity.class));
                
	}


	@Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
    }

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

}
