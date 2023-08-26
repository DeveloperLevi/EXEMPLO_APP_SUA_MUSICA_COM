package com.example.exemplo_app_sua_musica_com.pageTransformes;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_StackTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(position < 0.0F ? 0.0F : (float)(-page.getWidth()) * position);
    }
}
