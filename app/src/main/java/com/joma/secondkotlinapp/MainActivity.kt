package com.joma.secondkotlinapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joma.secondkotlinapp.databinding.ActivityMainBinding
import com.joma.secondkotlinapp.ui.getToast
import com.joma.secondkotlinapp.ui.loadUrl
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list: MutableList<String> = mutableListOf()
    private val URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initList()
        initBtnRandom()
        initBtnAdd()
    }

    private fun initBtnAdd() {
        binding.btnAdd.setOnClickListener {
            val url = binding.etUrl.text.toString()
            val p: Pattern = Pattern.compile(URL_REGEX)
            val m: Matcher = p.matcher(url)
            if (m.find()) {
                list.add(url)
            } else {
                getToast(getString(R.string.notUrl))
            }
        }
    }

    private fun initBtnRandom() {
        binding.bntRandom.setOnClickListener {
            val randomNum = list.random()
            Log.e("-----", randomNum+ "")
            binding.imgRandom.loadUrl(randomNum)
        }
    }

    private fun initList() {
        list.add("https://cdn.pixabay.com/user/2019/12/22/16-48-03-254_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2022/03/01/12-32-48-46_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2020/01/20/08-28-52-707_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2022/01/25/03-16-01-988_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2016/04/25/20-19-38-614_250x250.jpg")
    }

}