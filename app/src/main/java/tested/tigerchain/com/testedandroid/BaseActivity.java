package tested.tigerchain.com.testedandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * @Description
 * @Creator junjun（创建者）
 */
public abstract class BaseActivity extends AppCompatActivity {


    private Button btn_leftbutton;
    private Button btn_rightbutton;
    private TextView tv_center;

    private RelativeLayout titlebar;


    private RelativeLayout content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_activity);
        initBaseView();

        setContentLayout(getContentResLayoutId());

        if (!isShowTitleBar()) {
            titlebar.setVisibility(View.GONE);
        } else {
            titlebar.setVisibility(View.VISIBLE);
        }



        init();

    }

    protected void initTitleBar(String leftText, String centerText, String rightText, final OnLeftListener onLeftListener, final OnRightListener onRightListener){
        if(!TextUtils.isEmpty(leftText)){
            btn_leftbutton.setText(leftText);
        }
        if(!TextUtils.isEmpty(centerText)){
            tv_center.setText(centerText);
        }
        if(!TextUtils.isEmpty(rightText)){
            btn_rightbutton.setText(rightText);
        }

        if(onLeftListener !=null){
            btn_leftbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLeftListener.setOnLefListener(v);
                }
            });
        }

        if(onRightListener!=null){
            btn_rightbutton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onRightListener.setOnRightListener(v);
                }
            });
        }
    }

    protected abstract void init();

    protected boolean isShowTitleBar() {
        return true;
    }

    private void setContentLayout(int contentResLayoutId) {
        LayoutInflater.from(this).inflate(contentResLayoutId, content);
    }

    protected abstract int getContentResLayoutId();

    protected void initBaseView() {
        titlebar = this.findViewById(R.id.titlebar);
        btn_leftbutton = titlebar.findViewById(R.id.btn_leftbutton);
        btn_rightbutton = titlebar.findViewById(R.id.btn_rightbutton);
        tv_center = titlebar.findViewById(R.id.tv_center);


        content = this.findViewById(R.id.content);
    }

    protected RelativeLayout getContent() {
        return this.content;
    }


    public interface OnRightListener {
        void setOnRightListener(View view);
    }

    public interface OnLeftListener {
        void setOnLefListener(View view);
    }

}
