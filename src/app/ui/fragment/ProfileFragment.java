package app.ui.fragment;


import java.io.File;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import app.ui.BaseFragment;
import app.ui.activity.LoginActivity;
import app.ui.activity.R;
import app.ui.activity.setting.User;

public class ProfileFragment extends BaseFragment implements OnClickListener {
	
	private TextView mUsername;
	private TextView mAge;
	private TextView mSex;
	private TextView mPhone;
	private TextView mGard;
	private TextView mDorPart;
	private TextView mSchool;
	private Button mButton;
	
	
    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.layout_logout:
            	
            	SharedPreferences sp = getActivity().getSharedPreferences("User", 0);
          		Editor editor = sp.edit();
          		//清空登陆信息
          		editor.clear().commit();
          		Log.i("Fragment","清空成功");
          		startActivity(new Intent(getActivity(), LoginActivity.class));  
            	
    			break;
            default:
                break;
        }
    	

    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    	mUsername = (TextView)view.findViewById(R.id.tv_username);
    	mAge = (TextView)view.findViewById(R.id.tv_age);
    	mSex = (TextView) view.findViewById(R.id.tv_sex);
    	mDorPart = (TextView) view.findViewById(R.id.tv_dopart);
    	mGard = (TextView) view.findViewById(R.id.tv_gard);
    	mPhone = (TextView) view.findViewById(R.id.tv_phone);
    	mSchool = (TextView) view.findViewById(R.id.tv_school);
    	mButton = (Button)view.findViewById(R.id.layout_logout);
    	mButton.setOnClickListener(this);
    	
//    	SharedPreferences sp = getActivity().getSharedPreferences("UserInfo", 0);
    	//获取当前登录的用户
    	BmobUser myUser = BmobUser.getCurrentUser(getActivity());
    	final String ob = myUser.getObjectId();
    	BmobQuery<User> query = new BmobQuery<User>();
    	query.getObject(getActivity(), ob, new GetListener<User>() {

    	    @Override
    	    public void onSuccess(User object) {
    	        // TODO Auto-generated method stub
    	    	 mUsername.setText(object.getUsername());
    	         mAge.setText(object.getAge());
    	         mSex.setText(object.getSex());
    	         mDorPart.setText(object.getDorPart());
    	         mGard.setText(object.getGard());
    	         mPhone.setText(object.getPhone());
    	         mSchool.setText(object.getSchool());
    	         Log.i("查询成功：", ob);
    	    }

    	    @Override
    	    public void onFailure(int code, String arg0) {
    	        // TODO Auto-generated method stub
    	        Log.i("查询失败：",arg0);
    	    }

    	});
       
        	    	        
        	    
    	  
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, view, false);
    }

    public void toast(String toast) {
		Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
	}
}

