package app.ui.activity;


import cn.bmob.v3.listener.EmailVerifyListener;
import cn.bmob.v3.listener.SaveListener;


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
import android.widget.RelativeLayout;
import android.widget.Toast;
import app.ui.TitleActivity;
import app.ui.activity.setting.User;
import app.util.Util;

public class RegisterActivity extends TitleActivity implements OnClickListener{

	private static final String TAG = RegisterActivity.class.getSimpleName();
	
	private EditText etUsername;
	private EditText etPassword;	
	private EditText etAge;
	private EditText etSex;
	private EditText etGard;
	private EditText etPhone;
	private EditText etDeriction;
	private EditText etCademy;
	private Button mButton;
	private RelativeLayout mRelativeLayout;

	private String age;
	private String sex;
	private String gard;
	private String phone;
	private String dorPart;
	private String cademy;
	private String username;
	private String password;
	private String deriction;


    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }


    private void setupViews() {
    	
        setContentView(R.layout.activity_register);
        setTitle(R.string.title_register);
        showBackwardView(R.string.button_backward, true);
        showBackwardView(R.string.button_backward, true);
    	etUsername = (EditText)findViewById(R.id.Redit_name);
    	etPassword = (EditText)findViewById(R.id.Redit_password);    	
    	etAge = (EditText)findViewById(R.id.Redit_age);
    	etSex = (EditText)findViewById(R.id.Redit_sex);
    	etGard = (EditText)findViewById(R.id.Redit_grad);
    	etPhone = (EditText)findViewById(R.id.Redit_phone);
    	etCademy = (EditText)findViewById(R.id.Redit_cademy);
    	etDeriction = (EditText)findViewById(R.id.Redit_deriction);
    	mButton = (Button)findViewById(R.id.startlogin);
    	mRelativeLayout = (RelativeLayout)findViewById(R.id.next);
    	
    	mButton.setOnClickListener(this);
    	mRelativeLayout.setOnClickListener(this);


        
    }
    
    @Override
    public void onClick(View v) {
    	super.onClick(v);
        switch (v.getId()) {
            case R.id.next:            
                {
        			username = etUsername.getText().toString();
        			password = etPassword.getText().toString();
        			age = etAge.getText().toString();
        			phone = etPhone.getText().toString();        			
        			sex= etSex.getText().toString();
        			cademy= etCademy.getText().toString();
        			dorPart= etDeriction.getText().toString();
        			gard= etGard.getText().toString();
        			deriction = etDeriction.getText().toString();
        			
        			if(!Util.isNetworkConnected(this)) {
        				toast("请检查网络连接！ ");
        			} else if (username.equals("") || password.equals("")
        					|| etAge.equals("") || phone.equals("")) {
        				toast("请填写完整！ ");        			
        			}else if(!Util.isEmailValid(username)){
            				toast("请正确填写邮箱！");
        			} else if(!Util.isPhoneNumberValid(phone)) {
        				toast("请输入正确的手机号码！");
        			}else {
        				Log.i(TAG, username);
        				// 开始提交注册信息
        				final User bu = new User();
        				bu.setUsername(username);
        				bu.setEmail(username);
        				bu.setPassword(password);
        				bu.setAge(age);
        				bu.setGard(gard);
        				bu.setCademy(cademy);
        				bu.setDorPart(dorPart);
        				bu.setPhone(phone);
        				bu.setSex(sex);
        				bu.setSchool(deriction);
        				Log.i(TAG,bu.getTableName()); 				
        				bu.signUp(this, new SaveListener() {
        					
        					@Override
        					public void onSuccess() {
        						toast("注册成功，请及时前往"+bu.getUsername()+"验证邮箱！");
        						//保存注册信息
//        						saveUserInfo(bu.getUsername(), bu.getPassword(),bu.getSex(),bu.getSchool(),bu.getDorPart(),bu.getGard(),bu.getAge(),bu.getPhone());
        						Intent backLogin = new Intent(RegisterActivity.this,
        								LoginActivity.class);
        						startActivity(backLogin);
        						RegisterActivity.this.finish();
        					}

        					@Override
        					public void onFailure(int arg0, String msg) {
        						Log.i(TAG, msg);
        						toast("已经被注册，请换个名字吧.");
        					}

        				});
        			}
        			
                }
                
                break;   
                
            case R.id.startlogin:
            		startActivity(new Intent(this,LoginActivity.class));
            	break;
            default:
                break;
        }
    }
  //保存用户的注册记录
//  	private void saveUserInfo(String username, String password,String age,String phone,String sex,String dopart,String school,String gard) {
//  		SharedPreferences sp = getSharedPreferences("UserInfo", 0);
//  		Editor editor = sp.edit();
//  		editor.putString("username", username);
//  		editor.putString("password", password);
//  		editor.putString("age", age);
//  		editor.putString("sex", sex);
//  		editor.putString("phone", phone);
//  		editor.putString("gard", gard);
//  		editor.putString("dopart", dopart);
//  		editor.putString("school", school);
//  		
// 		editor.commit();
//  	}
    @Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
    }

    public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};
}
