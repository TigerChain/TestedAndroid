package tested.tigerchain.com.testedandroid;


import android.content.Intent;
import android.os.Handler;

/**
 * @Description
 * @Creator junjun（创建者）
 */
public class SplashActivity  extends BaseActivity{


    @Override
    protected int getContentResLayoutId() {
        return R.layout.spalsh_activity;
    }

    @Override
    protected void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();
            }
        },2000) ;
    }

    @Override
    protected boolean isShowTitleBar() {
        return false ;
    }
}
