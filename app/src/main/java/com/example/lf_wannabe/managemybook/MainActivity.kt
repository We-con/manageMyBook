package com.example.lf_wannabe.managemybook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lf_wannabe.managemybook.view.AddBookActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("섹스")

        mainFab.setOnClickListener {
            startActivity(AddBookActivity::class.java)
        }
    }
}
