package com.aries.progressview;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.aries.ui.widget.progress.UIProgressView;

import butterknife.BindView;
import butterknife.OnClick;
import com.aries.progressview.R;
/**
 * Created: AriesHoo on 2017/7/18 16:38
 * Function: UIProgressView示例
 * Desc:
 */
public class LoadingActivity extends BaseActivity {

    @BindView(R2.id.sBtn_msgLoading) SwitchCompat sBtnMsg;
    @BindView(R2.id.sBtn_viewBackLoading) SwitchCompat sBtnViewBack;
    @BindView(R2.id.sBtn_progressLoading) SwitchCompat sBtnProgress;
    @BindView(R2.id.sBtn_backLoading) SwitchCompat sBtnBack;

    private boolean isShowMsg = true;
    private boolean isDefaultViewBack = true;
    private boolean isDefaultProgress = true;
    private boolean isBackDim = true;
    private int style = UIProgressView.STYLE_NORMAL;

    @Override
    protected void setTitleBar() {
        titleBar.setTitleMainText("UIProgressView");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_loading;
    }

    @Override
    protected void initView(Bundle var1) {
        sBtnMsg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isShowMsg = isChecked;
                sBtnMsg.setText(isShowMsg ? "显示Message" : "隐藏Message");
            }
        });
        sBtnViewBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefaultViewBack = isChecked;
                sBtnViewBack.setText(isDefaultViewBack ? "默认View背景" : "自定义View背景");
            }
        });
        sBtnProgress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefaultProgress = isChecked;
                sBtnProgress.setText(isDefaultProgress ? "默认Progress" : "自定义Progress");
            }
        });
        sBtnBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isBackDim = isChecked;
                sBtnBack.setText(isBackDim ? "背景半透明" : "背景全透明");
            }
        });

        sBtnMsg.setChecked(true);
        sBtnViewBack.setChecked(true);
        sBtnProgress.setChecked(true);
        sBtnBack.setChecked(true);
    }

    @OnClick({R2.id.rtv_showLoading, R2.id.rtv_showWeiBoLoading, R2.id.rtv_showWeiXinLoading, R2.id.rtv_showMaterialLoading})
    public void onViewClicked(View view) {
        style = UIProgressView.STYLE_WEI_XIN;
        UIProgressView loading = new UIProgressView(mContext, style);
        if (isShowMsg) {
            loading.setMessage(R.string.loading);
        }
        if (!isDefaultViewBack) {
            loading.setBackgroundColor(Color.MAGENTA);
        }
        if (!isDefaultProgress) {
            loading.setIndeterminateDrawable(R.drawable.progress_loading);
        }
        if (!isBackDim) {
            loading.setDimAmount(0f);
        }
        loading.setLoadingColor(getResources().getColor(R.color.colorAccent));
        loading.show();
    }
}
