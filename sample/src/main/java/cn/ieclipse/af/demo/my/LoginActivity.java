package cn.ieclipse.af.demo.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cn.ieclipse.af.demo.R;
import cn.ieclipse.af.demo.common.api.BaseResponse;
import cn.ieclipse.af.demo.common.ui.BaseActivity;
import cn.ieclipse.af.util.DialogUtils;
import cn.ieclipse.af.volley.RestError;

public class LoginActivity extends BaseActivity implements LoginController.LoginListener {

    private static LoginController mLoginController;
    private int REQ_REGISTER = 0x12;

    private TextView mReg;

    @Override
    protected int getContentLayout() {
        return 0;//R.layout.activity_login;
    }
    
    @Override
    protected void initHeaderView() {
        super.initHeaderView();
        mTitleTextView.setText(R.string.login_title);
        mTitleTextView.setTextColor(getResources().getColor(R.color.white));

        mReg = (TextView) View.inflate(this, R.layout.title_right_tv, null);
        mReg.setText(R.string.reg_title);
        mTitleBar.addRight(mReg);
        setOnClickListener(mReg);
    }

    @Override
    protected void initContentView(View view) {
        super.initContentView(view);
    }

    @Override
    protected int getStatusBarColor() {
        return android.R.color.transparent;
    }

    @Override
    protected void initData() {
        mLoginController = new LoginController(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    
    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view == mReg) {
            RegisterActivity.go(this, REQ_REGISTER);
        }
    }

    @Override
    protected void initIntent(Bundle bundle) {
        super.initIntent(bundle);
    }

    @Override
    public void onLoginSuccess(LoginResponse out) {
        finish();
    }

    @Override
    public void onLoginFailure(RestError error) {
        toastError(error);
    }

    @Override
    public void onLoginCodeSuccess(BaseResponse out) {
        String msg = getString(R.string.reg_code_sent);
        if (out != null && !TextUtils.isEmpty(out.getMessage())) {
            msg = out.getMessage();
        }
        DialogUtils.showToast(this, msg);
    }

    @Override
    public void onLoginCodeFail(RestError error) {
        toastError(error);
    }
}
