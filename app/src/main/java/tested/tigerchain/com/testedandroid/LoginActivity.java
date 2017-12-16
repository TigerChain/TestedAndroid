package tested.tigerchain.com.testedandroid;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @Description
 * @Creator junjun（创建者）
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText et_username ,et_userpass ;
    private Button btn_login ,btn_clear ;

    @Override
    protected int getContentResLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void init() {
        initView() ;
    }

    private void initView() {
        et_username = this.findViewById(R.id.et_username) ;
        et_userpass = this.findViewById(R.id.et_userpass) ;
        btn_login = this.findViewById(R.id.btn_login) ;
        btn_clear = this.findViewById(R.id.btn_clear) ;


        btn_clear.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }


    @Override
    protected boolean isShowTitleBar() {
        return false ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String username = et_username.getText().toString().trim() ;
                String userpass = et_userpass.getText().toString().trim() ;
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(userpass)){
                    Toast.makeText(LoginActivity.this,"用户名或密码不能为空!!!",Toast.LENGTH_SHORT).show();
                    return ;
                }

                startActivity(new Intent(LoginActivity.this,MainActivity.class));

                break ;
            case R.id.btn_clear:
                et_username.setText("");
                et_userpass.setText("");
                break ;
            default:
                break ;
        }
    }
}
