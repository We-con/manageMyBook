package com.example.lf_wannabe.managemybook

import android.app.Application
import com.example.lf_wannabe.managemybook.model.BookDao
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

        // dummy
        Realm.getDefaultInstance().let {
            it.executeTransaction {
                it.deleteAll()
                BookDao(it).create(DummyFactory.createBookDummy())
            }
        }

    }
}