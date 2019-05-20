package kylec.me.g2048.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import kylec.me.g2048.R;
import kylec.me.g2048.app.Config;

/**
 * 小格子
 * <p>
 * Created by KYLE on 2018/10/2
 */
public class Cell extends FrameLayout {

    /**
     * 显示数字的TextView
     */
    private TextView cellShowText;

    /**
     * 显示的数字
     */
    private int digital;

    public Cell(Context context) {
        super(context);
    }

    public Cell(@NonNull Context context, int leftMargin, int topMargin, int bottomMargin) {
        super(context);
        init(context, leftMargin, topMargin, bottomMargin);
    }

    /**
     * 初始化
     */
    private void init(@NonNull Context context, int leftMargin, int topMargin, int bottomMargin) {
        cellShowText = new TextView(context);
        // 不同难度设置不同字体大小
        switch (Config.GRIDColumnCount) {
            case 4:
                cellShowText.setTextSize(36);
                break;
            case 5:
                cellShowText.setTextSize(28);
                break;
            case 6:
                cellShowText.setTextSize(20);
                break;
            default:
                cellShowText.setTextSize(36);
                break;
        }
        cellShowText.setGravity(Gravity.CENTER);
        // 抗锯齿
        cellShowText.getPaint().setAntiAlias(true);
        // 粗体
        cellShowText.getPaint().setFakeBoldText(true);
        // 颜色
        cellShowText.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        // 填充整个父容器
        LayoutParams params = new LayoutParams(-1, -1);
        params.setMargins(leftMargin, topMargin, 0, bottomMargin);
        addView(cellShowText, params);
        setDigital(0);
    }

    /**
     * 获取卡片
     */
    public TextView getItemCell() {
        return cellShowText;
    }

    /**
     * 获取数字
     */
    public int getDigital() {
        return digital;
    }

    /**
     * 设置数字
     */
    public void setDigital(int digital) {
        this.digital = digital;
        cellShowText.setBackgroundResource(getBackgroundResource(digital));
        if (digital <= 0) {
            cellShowText.setText("");
        } else {
            cellShowText.setText(String.valueOf(digital));
        }
    }

    /**
     * 根据数字获取相应的背景
     *
     * @return 相应的背景
     */
    private int getBackgroundResource(int number) {
        switch (number) {
            case 0:
                return R.drawable.bg_cell_0;
            case 2:
                return R.drawable.bg_cell_2;
            case 4:
                return R.drawable.bg_cell_4;
            case 8:
                return R.drawable.bg_cell_8;
            case 16:
                return R.drawable.bg_cell_16;
            case 32:
                return R.drawable.bg_cell_32;
            case 64:
                return R.drawable.bg_cell_64;
            case 128:
                return R.drawable.bg_cell_128;
            case 256:
                return R.drawable.bg_cell_256;
            case 512:
                return R.drawable.bg_cell_512;
            case 1024:
                return R.drawable.bg_cell_1024;
            case 2048:
                return R.drawable.bg_cell_2048;
            default:
                return R.drawable.bg_cell_default;
        }
    }

}
