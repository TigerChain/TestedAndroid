package tested.tigerchain.com.testedandroid;


import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {



    @Override
    protected void init() {
        initTitleBar("设置", "首页", "消息", new OnLeftListener() {
            @Override
            public void setOnLefListener(View view) {
                Toast.makeText(MainActivity.this,"设置",Toast.LENGTH_SHORT).show();
            }
        }, new OnRightListener() {
            @Override
            public void setOnRightListener(View view) {
                Toast.makeText(MainActivity.this,"消息",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getContentResLayoutId() {
        return R.layout.activity_main;
    }

}
