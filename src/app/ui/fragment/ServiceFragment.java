package app.ui.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.ui.BaseFragment;
import app.ui.activity.FastActivity;
import app.ui.activity.R;
import app.ui.activity.SecondActivity;
import app.ui.activity.setting.AboutActivity;
import app.ui.adapter.ViewPaperAdapter;

public class ServiceFragment extends BaseFragment implements Runnable,OnClickListener{

    private ViewPager mViewPager;
    private ViewGroup group;
    private ViewPaperAdapter mAdapter;
    private List<View> mViewPicture;
    private ImageView[] mImageViews = null;
    private ImageView imageView = null;
    private AtomicInteger what = new AtomicInteger(0);
    private boolean isContinue = true;
    private LinearLayout mLinearLayout;
    private LinearLayout mTQ;
    private LinearLayout mWZ;
    private LinearLayout mCX;
    private LinearLayout mZL;
    private LinearLayout mZB;
    private LinearLayout mES;
    private LinearLayout mXXSY;
    private LinearLayout mJWXX;
    private LinearLayout mZYHD;
    private LinearLayout mXYWH;
    private LinearLayout mZHJG;
    private LinearLayout mCJCX;
    private LinearLayout mTCBM;
    private LinearLayout mTYXX;
    private LinearLayout mKCXX;
    private LinearLayout mTSYY;
    private final Handler viewHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mViewPager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service, container, false);
    }
    /* (non-Javadoc)
     * @see app.ui.BaseFragment#onViewCreated(android.view.View, android.os.Bundle)
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTQ = (LinearLayout)view.findViewById(R.id.img_TQ);
        mJWXX = (LinearLayout)view.findViewById(R.id.img_JWXX);
        mKCXX = (LinearLayout)view.findViewById(R.id.img_KCXX);
        mCX = (LinearLayout)view.findViewById(R.id.img_CX);
        mCJCX = (LinearLayout)view.findViewById(R.id.img_CJCX);
        mES = (LinearLayout)view.findViewById(R.id.img_ES);
        mTCBM = (LinearLayout)view.findViewById(R.id.img_TCBM);
        mTSYY = (LinearLayout)view.findViewById(R.id.img_TSYY);
        mTYXX = (LinearLayout)view.findViewById(R.id.img_TYXX);
        mWZ = (LinearLayout)view.findViewById(R.id.img_WZ);
        mXXSY = (LinearLayout)view.findViewById(R.id.img_XXSY);
        mXYWH = (LinearLayout)view.findViewById(R.id.img_XYWH);
        mZB = (LinearLayout)view.findViewById(R.id.img_ZB);
        mZHJG = (LinearLayout)view.findViewById(R.id.img_ZZJG);
        mZYHD = (LinearLayout)view.findViewById(R.id.img_ZYHD);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        group = (ViewGroup)view.findViewById(R.id.viewGroup);
        mZL = (LinearLayout)view.findViewById(R.id.img_ZL);
        mTQ.setOnClickListener(this);
        mWZ.setOnClickListener(this);
        mCX.setOnClickListener(this);
        mZB.setOnClickListener(this);
        mXXSY.setOnClickListener(this);
        mJWXX.setOnClickListener(this);
        mZYHD.setOnClickListener(this);
        mXYWH.setOnClickListener(this);
        mZHJG.setOnClickListener(this);
        mCJCX.setOnClickListener(this);
        mTCBM.setOnClickListener(this);
        mTYXX.setOnClickListener(this);
        mKCXX.setOnClickListener(this);
        mTSYY.setOnClickListener(this);
        mZL.setOnClickListener(this);
        
        
        mLinearLayout = (LinearLayout)view.findViewById(R.id.img_CG);
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.img_CG:
					startActivity(new Intent(getActivity(),FastActivity.class));
					break;

				default:
					break;
				}
			}
		});

        mViewPicture = new ArrayList<View>();
        ImageView img1 = new ImageView(getActivity());
        img1.setBackgroundResource(R.drawable.advertising_default_1);
        mViewPicture.add(img1);

        ImageView img2 = new ImageView(getActivity());
        img2.setBackgroundResource(R.drawable.advertising_default_2);
        mViewPicture.add(img2);

        ImageView img3 = new ImageView(getActivity());
        img3.setBackgroundResource(R.drawable.advertising_default_3);
        mViewPicture.add(img3);

        ImageView img4 = new ImageView(getActivity());
        img4.setBackgroundResource(R.drawable.advertising_default);
        mViewPicture.add(img4);

        mImageViews = new ImageView[mViewPicture.size()];

        for (int i = 0; i < mViewPicture.size(); i++) {
            imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new LayoutParams(20, 20));
            imageView.setPadding(5, 5, 5, 5);
            mImageViews[i] = imageView;
            if (i == 0) {
                mImageViews[i].setBackgroundResource(R.drawable.ic_viewpager_select);
            } else {
                mImageViews[i].setBackgroundResource(R.drawable.ic_viewpager_noselect);
            }
            group.addView(mImageViews[i]);
        }

        mViewPager.setOnPageChangeListener(new GuidePageChangeListener());
        mAdapter = new ViewPaperAdapter(mViewPicture);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnTouchListener(new GuideOnTouchListener());
        new Thread(this).start();
        
        
    }


   


	private final class GuidePageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            what.getAndSet(arg0);
            for (int i = 0; i < mImageViews.length; i++) {
                mImageViews[arg0].setBackgroundResource(R.drawable.ic_viewpager_select);
                if (arg0 != i) {
                    mImageViews[i].setBackgroundResource(R.drawable.ic_viewpager_noselect);
                }
            }
        }
    }

    private final class GuideOnTouchListener implements OnTouchListener{

        /* (non-Javadoc)
         * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
         */
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    isContinue = false;
                    break;
                case MotionEvent.ACTION_UP:
                    isContinue = true;
                    break;
                default:
                    isContinue = true;
                    break;
            }
            return false;
        }

    }

    private void whatOption() {
        what.incrementAndGet();
        if (what.get() > mImageViews.length - 1) {
            what.getAndAdd(-4);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (true) {
            if (isContinue) {
                viewHandler.sendEmptyMessage(what.get());
                whatOption();
            }
        }
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_ZL:
			startActivity(new Intent(getActivity(), SecondActivity.class));
			break;
		case R.id.img_TQ:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.weather.com.cn/static/html/weather.shtml")));
			break;
		case R.id.img_WZ:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://map.baidu.com/")));
			break;
		case R.id.img_CX:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://bj.meituan.com/?utm_campaign=baidu&utm_medium=brand&utm_source=baidu&utm_content=1&utm_term=&_rdt=1")));
			break;
		case R.id.img_ZB:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ctrip.com/?utm_source=baidu&utm_medium=cpc&utm_campaign=baidu81&campaign=CHNbaidu81&adid=index&gclid=&isctrip=T")));
			break;
		case R.id.img_XXSY:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nuc.edu.cn/")));
			break;
		case R.id.img_ZZJG:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nuc.edu.cn/zzjg/jgzl.htm")));
			break;
		case R.id.img_JWXX:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www1.nuc.edu.cn/jwc/")));
			break;
		case R.id.img_XYWH:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www4.nuc.edu.cn/xtw/index.php")));
			break;
		case R.id.img_ZYHD:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nucxiaoxueshenghui.icoc.cc/")));
			break;
		case R.id.img_CJCX:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://202.207.177.39:8088/")));
			break;
		case R.id.img_TYXX:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://202.207.177.23/")));
			break;
		case R.id.img_TCBM:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://202.207.177.9/tyxyy/")));
			break;
		case R.id.img_KCXX:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://202.207.177.15:7777/zhxt_bks/zhxt_bks.html")));
			break;
		case R.id.img_TSYY:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://lib.nuc.edu.cn/new/index1.action")));
			break;
		

		default:
			break;
		}
		
	}
}
