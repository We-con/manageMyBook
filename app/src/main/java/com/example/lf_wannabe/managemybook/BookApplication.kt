package com.example.lf_wannabe.managemybook

import android.app.Application
import com.example.lf_wannabe.managemybook.util.DummyFactory
import com.example.lf_wannabe.managemybook.viewmodel.BookViewModel
import io.realm.Realm

/**
 * Created by lf_wannabe on 06/11/2017.
 */
class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
    }
}