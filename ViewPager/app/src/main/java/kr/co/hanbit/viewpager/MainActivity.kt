package kr.co.hanbit.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kr.co.hanbit.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())

        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList

        binding.viewPager.adapter = adapter

        val tabTitles = listOf<String>("A", "B", "C", "D")
        TabLayoutMediator(binding.tabLayout2, binding.viewPager){ tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}