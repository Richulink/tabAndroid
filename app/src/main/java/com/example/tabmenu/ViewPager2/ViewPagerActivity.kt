package com.example.tabmenu.ViewPager2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.tabmenu.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        supportActionBar?.hide()

        val collapsingToolbarLayout: CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout)
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE)




        val coverImageUrl = "https://picsum.photos/400/200" // Ejemplo de URL de portada
        val coverImage: ImageView = findViewById(R.id.coverImage)
        Glide.with(this)
            .load(coverImageUrl)
            .centerCrop()
            .into(coverImage)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.pager)

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "novedades y ofertas "
                1 -> "productos"
                else -> "categorias"
            }
            tab.view.contentDescription = tab.text
        }.attach()

    }

    class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 3 // Número total de páginas
        }

        override fun createFragment(position: Int): Fragment {
            // Devuelve el Fragment correspondiente a la página en la posición dada
            return when (position) {
                0 -> Fragment1()
                1 -> Fragment2()
                else -> Fragment3()
            }
        }
    }
}