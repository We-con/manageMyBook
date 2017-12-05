package com.wecon.lf_wannabe.walkonnovel.model

import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import io.realm.Sort

/**
 * Created by mangob on 2017. 11. 8..
 */
class BookDao(val realm: Realm) {

    private val table = Book::class.java

    fun create(book: Book) {
        realm.executeTransaction {
            realm.insertOrUpdate(book)
        }
    }

    fun create(books: ArrayList<Book>) {
        realm.executeTransaction {
            realm.insertOrUpdate(books)
        }
    }

    fun readAll(): RealmResults<Book> {
        return realm.where(table).findAllSorted("fixedDate", Sort.DESCENDING)
    }
    fun readAll(title: String): RealmResults<Book> {
        return realm.where(table).contains("title", title).findAllSorted("fixedDate", Sort.DESCENDING)
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

    fun deleteAll() {
        realm.executeTransaction {
            realm.deleteAll()
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