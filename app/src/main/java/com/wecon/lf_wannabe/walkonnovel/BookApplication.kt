package com.wecon.lf_wannabe.walkonnovel

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.wecon.lf_wannabe.walkonnovel.model.BookDao
import com.wecon.lf_wannabe.walkonnovel.util.DummyFactory
import io.realm.Realm

/**
 * Created by lf_wannabe on 06/11/2017.
 */
class BookApplication : MultiDexApplication() {
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