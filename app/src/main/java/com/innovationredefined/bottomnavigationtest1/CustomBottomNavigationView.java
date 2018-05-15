package com.innovationredefined.bottomnavigationtest1;

import android.content.Context;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class CustomBottomNavigationView extends BottomNavigationView {
    public CustomBottomNavigationView(Context context) {
        super(context);
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        centerMenuIcon();
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        centerMenuIcon();
    }

    private void centerMenuIcon() {
        CustomBottomNavigationMenuView menuView = getBottomMenuView();

        if (menuView != null) {
            for (int i = 0; i < menuView.getChildCount(); i++) {
                CustomBottomNavigationItemView menuItemView = (CustomBottomNavigationItemView) menuView.getChildAt(i);


                AppCompatImageView icon = (AppCompatImageView) menuItemView.getChildAt(0);

                FrameLayout.LayoutParams params = (LayoutParams) icon.getLayoutParams();
                params.gravity = Gravity.CENTER;

                menuItemView.hideLargeLabel();
                //TextView label = (TextView) menuItemView.getChildAt(1);
               // Log.v("TESTTTTTTT",label.getText().toString());
                //menuItemView.setShiftingMode(true);
            }
        }
    }

    private CustomBottomNavigationMenuView getBottomMenuView() {
        Object menuView = null;
        try {
            Field field = CustomBottomNavigationView.class.getDeclaredField("mMenuView");
            field.setAccessible(true);
            menuView = field.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (CustomBottomNavigationMenuView) menuView;
    }


}