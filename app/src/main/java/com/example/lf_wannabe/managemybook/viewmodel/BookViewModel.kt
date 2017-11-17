package com.example.lf_wannabe.managemybook.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.model.BookDao
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

/**
 * Created by mangob on 2017. 11. 8..
 */
class BookViewModel : ViewModel() {

    private var realm = Realm.getDefaultInstance()

    private var bookDao = BookDao(realm)

    override fun onCleared() {
        realm.close()
        super.onCleared()
    }

    fun insertOrUpdateBook(book: Book) {
        bookDao.create(book)
    }

    fun deleteBook(book: Book) {
        bookDao.delete(book)
    }

    fun deleteBook(title: String) {
        bookDao.delete(title)
    }

    fun readAll(): RealmList<Book> {
        return RealmList<Book>().apply { addAll(bookDao.readAll()) }
    }

}