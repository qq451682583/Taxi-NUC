package app.ui.fragment;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import app.ui.BaseFragment;
import app.ui.activity.MainActivity;
import app.ui.activity.R;

public class SessionFragment extends BaseFragment{
	
	protected ListView mListview;
	
	

	BmobPushManager<BmobInstallation> bmobPush;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    		
		
        return inflater.inflate(R.layout.fragment_session, container, false);
    }
    /* (non-Javadoc)
     * @see app.ui.BaseFragment#onViewCreated(android.view.View, android.os.Bundle)
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        BmobPush.setDebugMode(true);		
		bmobPush = new BmobPushManager<BmobInstallation>(getActivity());		
		BmobInstallation.getCurrentInstallation(getActivity()).save();
		BmobPush.startWork(getActivity(), MainActivity.APPID);
		
		mListview = (ListView)view.findViewById(R.id.mylistView);
		ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();
		Map<String,Object> item = new HashMap<String,Object>();  
		item.put("myImg", R.drawable.nuctaxi);  
		item.put("myTitle", "高校通官方");  
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日    HH:mm");       
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间       
		String str = formatter.format(curDate);   

		item.put("Time", str);  
		item.put("myText", "1111111");  
		mData.add(item); 
		SimpleAdapter mAdapter = new SimpleAdapter(getActivity(),mData,R.layout.item_layout,  
				       new String[]{"myImg","myTitle","Time","myText"},new int[]{R.id.myImg,R.id.myTitle,R.id.Time,R.id.myText});  

		mListview.setAdapter(mAdapter);


		
		
    }

}
