package com.example.exemplo_app_sua_musica_com.pageTransformes

import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.exemplo_app_sua_musica_com.R
import java.lang.Math.abs

class Pager2_ZoomInTransformer_Kotlin: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val scale = if (position < 0.0f) position + 1.0f else abs(1.0f - position)
     //   page.scaleX = scale
     //   page.scaleY = scale
     //   page.setPadding(-200,10,-200,10)
     //   page.setPa
        if (position  < 0f){
        page.translationX = 500f }
        if (position > 1f){
            page.translationX = -500f
        }
        if(position == 0f){
            page.translationX = 0f
        }

        page.pivotX = page.width.toFloat() * 0.5f
        page.pivotY = page.height.toFloat() * 0.5f
        page.alpha = if (position >= -1.0f && position <= 1.0f) 1.0f - (scale - 1.0f) else 0.0f


    }
}
