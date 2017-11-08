package com.example.lf_wannabe.managemybook.util

import com.example.lf_wannabe.managemybook.model.Book
import io.realm.RealmList

/**
 * Created by mangob on 2017. 11. 7..
 */
class DummyFactory {

    companion object {
        fun craeteBookDummy() = RealmList<Book>().apply {
            add(Book(
                    "블록체인의 충격",
                    "마부치 구니요시",
                    "BookStar",
                    "thumnail",
                    286,
                    56,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    339,
                    12,
                    0
            ))
        }
    }

}