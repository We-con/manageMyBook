package com.example.lf_wannabe.managemybook.model

import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

/**
 * Created by mangob on 2017. 11. 8..
 */
class BookDao(val realm: Realm) {

    private val table = Book::class.java

    fun create(book: Book) {
        realm.insertOrUpdate(book)
    }

    fun create(books: RealmList<Book>) {
        realm.insertOrUpdate(books)
    }

    fun readAll(): RealmResults<Book> {
        return realm.where(table).findAll()
    }

    fun readFromName(title: String): Book {
        return realm.where(table)
                .equalTo("title", title)
                .findFirst()
    }

    fun delete(book: Book) {
        realm.executeTransaction {
            book.deleteFromRealm()
        }
    }

    fun delete(title: String) {
        var book: Book = realm.where(table)
                .equalTo("title", title)
                .findFirst()
        if(!book.isValid) {
            Log.i("Mangob/BookDao", "book is null : $title")
        } else {
            realm.executeTransaction {
                book.deleteFromRealm()
            }
        }

    }

}