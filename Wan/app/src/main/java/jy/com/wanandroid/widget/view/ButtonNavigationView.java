package jy.com.wanandroid.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import jy.com.wanandroid.utils.Logger;

/*
 * created by taofu on 2019-06-17
 **/
public class ButtonNavigationView extends ConstraintLayout implements CompoundButton.OnCheckedChangeListener {

    private OnTabCheckedChangedListener mChangedListener;

    public ButtonNavigationView(Context context) {
        super(context);
    }

    public ButtonNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View button;

        for(int i = 0; i < getChildCount(); i ++){
            button = getChildAt(i);
            if(button instanceof RadioButton){
                ((RadioButton)getChildAt(i)).setOnCheckedChangeListener(this);
            }

        }

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){ // 我们只关注 由未选中变为选中的情况，由选中变为未选中的情况我们不关注
            unCheckOtherButton(buttonView);

            if(mChangedListener != null){
                mChangedListener.onCheckedChanged(buttonView, false);
            }
        }

    }


    /**
     * 当点击一个button 的时候，让其他几个变为未选中
     * @param checkedButton 当前选的button
     */
    private void unCheckOtherButton(CompoundButton checkedButton){
        View button;
        for(int i = 0; i < getChildCount(); i ++){
            button = getChildAt(i);
            if(button instanceof  RadioButton && button != checkedButton){
                ((RadioButton)button).setChecked(false);
            }
        }
    }


    public void setOnTabChangedListener(OnTabCheckedChangedListener mChangedListener) {
        this.mChangedListener = mChangedListener;
    }

    public interface  OnTabCheckedChangedListener{
       void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }
}
