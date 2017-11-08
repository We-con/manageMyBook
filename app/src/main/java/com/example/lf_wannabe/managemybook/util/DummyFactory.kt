package com.example.lf_wannabe.managemybook.util

import com.example.lf_wannabe.managemybook.model.Book
import io.realm.RealmList

/**
 * Created by mangob on 2017. 11. 7..
 */
class DummyFactory {

    companion object {
        fun createBookDummy() = RealmList<Book>().apply {
            add(Book(
                    "블록체인의 충격",
                    "마부치 구니요시",
                    "BookStar",
                    "thumnail",
                    100,
                    0,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    5,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    10,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    15,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    20,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    25,
                    0
            ))
            add(Book(
                    "어느 겨울밤 한 여행자가",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    100,
                    0
            ))
        }
    }

}