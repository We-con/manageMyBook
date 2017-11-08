package com.example.lf_wannabe.managemybook.model

import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by mangob on 2017. 11. 8..
 */
class BookDao(val realm: Realm) {

    private val table = Book::class.java

    fun create(book: Book) {
        realm.insertOrUpdate(book)
    }

    fun readAll(): RealmResults<Book> {
        return realm.where(table).findAll()
    }

    fun readFromName(title: String): RealmResults<Book> {
        return realm.where(table)
                .equalTo("title", title)
                .findAll()
    }

    fun delete(book: Book) {
        book.deleteFromRealm()
    }
}