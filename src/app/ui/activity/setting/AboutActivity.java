
package app.ui.activity.setting;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import app.ui.TitleActivity;
import app.ui.activity.HelpActivity;
import app.ui.activity.R;

/**
 * @author Administrator
 *
 */
public class AboutActivity extends TitleActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }


    private void setupViews() {
        setContentView(R.layout.activity_about);
        setTitle(R.string.text_about);
        showBackwardView(R.string.button_backward, true);

        final StringBuffer buffer = new StringBuffer(getString(R.string.app_name));
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            buffer.append(" V");
            buffer.append(packageInfo.versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        final TextView appNameTextView = (TextView) findViewById(R.id.text_app_name);
        appNameTextView.setText(buffer.toString());
    }

    /* (non-Javadoc)
     * @see app.ui.TitleActivity#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.layout_official_website:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://nuctaxi.bmob.cn")));
                break;

            case R.id.layout_rate_app:
                final Intent marketIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName()));
                try {
                    startActivity(marketIntent);
                } catch (ActivityNotFoundException e) {
                    Log.e(TAG, e.getMessage());
                }
                break;
			
            case R.id.layout_help:
                startActivity(new Intent(this, HelpActivity.class));
                break;

            case R.id.layout_feedback:
                

            case R.id.layout_update:
                break;

            default:
                break;
        }
    }
    /* (non-Javadoc)
     * @see app.ui.TitleActivity#onBackward(android.view.View)
     */
    @Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
    }

}
