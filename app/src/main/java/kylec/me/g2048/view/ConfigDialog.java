package kylec.me.g2048.view;

import android.content.Context;

import androidx.annotation.NonNull;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kylec.me.g2048.R;
import kylec.me.g2048.app.Config;

/**
 * 自定义配置对话框
 * <p>
 * Created by KYLE on 2018/10/4
 */
public class ConfigDialog extends BaseDialog {

    private View.OnClickListener onPositiveClickListener;
    private View.OnClickListener onNegativeClickListener;

    /**
     * 游戏难度
     */
    private int difficulty = Config.GRIDColumnCount;

    /**
     * 游戏音效状态
     */
    private boolean volumeState = Config.VolumeState;

    public ConfigDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected int setView() {
        return R.layout.dialog_config;
    }

    @Override
    protected void initData() {
        init();
    }

    private void init() {
        Button cancel = findViewById(R.id.btn_return);
        Button confirm = findViewById(R.id.btn_confirm);
        Button difficulty4 = findViewById(R.id.btn_difficulty_4);
        Button difficulty5 = findViewById(R.id.btn_difficulty_5);
        Button difficulty6 = findViewById(R.id.btn_difficulty_6);
        Button volumeON = findViewById(R.id.btn_volume_on);
        Button volumeOFF = findViewById(R.id.btn_volume_off);
        TextView getGoalTime = findViewById(R.id.tv_goal_get_time);
        // 根据游戏难度选中按钮
        switch (Config.GRIDColumnCount) {
            case 4:
                difficulty4.setBackgroundResource(R.drawable.bg_button_select);
                difficulty = 4;
                break;
            case 5:
                difficulty5.setBackgroundResource(R.drawable.bg_button_select);
                difficulty = 5;
                break;
            case 6:
                difficulty6.setBackgroundResource(R.drawable.bg_button_select);
                difficulty = 6;
                break;
            default:
                break;
        }
        // 根据配置参数选中按钮
        if (Config.VolumeState) {
            volumeON.setBackgroundResource(R.drawable.bg_button_select);
        } else {
            volumeOFF.setBackgroundResource(R.drawable.bg_button_select);
        }

        if (onNegativeClickListener != null) {
            cancel.setOnClickListener(onNegativeClickListener);
        }
        if (onPositiveClickListener != null) {
            confirm.setOnClickListener(onPositiveClickListener);
        }

        difficulty4.setOnClickListener(v -> {
            difficulty = 4;
            difficulty4.setBackgroundResource(R.drawable.bg_button_select);
            difficulty5.setBackgroundResource(R.drawable.bg_button_white);
            difficulty6.setBackgroundResource(R.drawable.bg_button_white);
        });
        difficulty5.setOnClickListener(v -> {
            difficulty = 5;
            difficulty4.setBackgroundResource(R.drawable.bg_button_white);
            difficulty5.setBackgroundResource(R.drawable.bg_button_select);
            difficulty6.setBackgroundResource(R.drawable.bg_button_white);
        });
        difficulty6.setOnClickListener(v -> {
            difficulty = 6;
            difficulty4.setBackgroundResource(R.drawable.bg_button_white);
            difficulty5.setBackgroundResource(R.drawable.bg_button_white);
            difficulty6.setBackgroundResource(R.drawable.bg_button_select);
        });
        volumeON.setOnClickListener(v -> {
            volumeState = true;
            volumeON.setBackgroundResource(R.drawable.bg_button_select);
            volumeOFF.setBackgroundResource(R.drawable.bg_button_white);
        });
        volumeOFF.setOnClickListener(v -> {
            volumeState = false;
            volumeON.setBackgroundResource(R.drawable.bg_button_white);
            volumeOFF.setBackgroundResource(R.drawable.bg_button_select);
        });
        getGoalTime.setText(Config.GetGoalTime == 0 ? "暂未达成" : String.valueOf(Config.GetGoalTime));
        // 无限模式下游戏难度不可设置
        if (Config.CurrentGameMode == 1) {
            difficulty4.setBackgroundResource(R.drawable.bg_button_useless);
            difficulty5.setBackgroundResource(R.drawable.bg_button_useless);
            difficulty6.setBackgroundResource(R.drawable.bg_button_useless);
            difficulty4.setEnabled(false);
            difficulty5.setEnabled(false);
            difficulty6.setEnabled(false);
        }
    }

    /**
     * 确认按钮点击
     */
    public ConfigDialog setOnPositiveClickListener(
            View.OnClickListener onPositiveClickListener) {
        this.onPositiveClickListener = onPositiveClickListener;
        return this;
    }

    /**
     * 取消按钮点击
     */
    public ConfigDialog setOnNegativeClickListener(
            View.OnClickListener onNegativeClickListener) {
        this.onNegativeClickListener = onNegativeClickListener;
        return this;
    }

    /**
     * 获取选择的游戏难度
     */
    public int getSelectDifficulty() {
        return difficulty;
    }

    /**
     * 获取游戏音效状态
     */
    public boolean getVolumeState() {
        return volumeState;
    }

}
