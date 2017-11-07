package com.example.lf_wannabe.managemybook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lf_wannabe.managemybook.view.AddBookActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar 설정
        setTitle("문학소년")
        setAction(View.OnClickListener { showMessage() })

        // Fab 설정
        mainFab.setOnClickListener {
            startActivity(AddBookActivity::class.java)
        }
    }

    private fun showMessage(message: String = "Comming soon") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
