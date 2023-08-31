package com.example.exemplo_app_sua_musica_com.pageTransformes

import android.view.View
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class Pager2_ZoomInTransformer_Kotlin: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if (position > 0 ){
            page.translationX = - (position * 250f)
            page.scaleY = ( 1.1f - ( abs(position) / 10 ) )
        }
        if (position < 0) {
            page.translationX = ( abs(position) * 250f)
            page.scaleY = ( 1.1f - ( abs(position) / 10 ) )
            }
        if ( position == 0f ){
            page.translationX = 0f
            page.scaleY = 1.1f
        }
    }
}