package app.ui.activity;


import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import app.ui.TitleActivity;
import app.ui.activity.setting.AboutActivity;

public class HelpActivity extends TitleActivity {

    private static final String TAG = HelpActivity.class.getSimpleName();

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }


    private void setupViews() {
        setContentView(R.layout.activity_help);
        setTitle(R.string.text_help);
        showBackwardView(R.string.button_backward, true);

        
    }
    
    @Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
    }

}
