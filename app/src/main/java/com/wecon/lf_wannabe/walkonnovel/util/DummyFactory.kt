package com.wecon.lf_wannabe.walkonnovel.util

import com.wecon.lf_wannabe.walkonnovel.model.Book
import com.wecon.lf_wannabe.walkonnovel.model.Post
import com.wecon.lf_wannabe.walkonnovel.model.TestBook
import io.realm.RealmList

/**
 * Created by mangob on 2017. 11. 7..
 */
class DummyFactory {

    companion object {
        fun createBooksDummy() = ArrayList<Book>().apply {
            add(Book(
                    "201708110920",
                    "201708110920",
                    "블록체인의 충격",
                    "마부치 구니요시",
                    "BookStar",
                    "image",
                    100,
                    0,
                    0
            ))
            add(Book(
                    "201708131330",
                    "201708131330",
                    "201708131330",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    5,
                    0
            ))
            add(Book(
                    "201708180920",
                    "201708180920",
                    "201708180920",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    10,
                    0
            ))
            add(Book(
                    "201708181930",
                    "201708181930",
                    "201708181930",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    15,
                    0
            ))
            add(Book(
                    "201710110920",
                    "201710110920",
                    "201710110920",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    20,
                    0
            ))
            add(Book(
                    "201710120920",
                    "201710120920",
                    "201710120920",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    25,
                    0
            ))
            add(Book(
                    "201711110920",
                    "201711110920",
                    "201711110920",
                    "이탈로 칼비노",
                    "민음사",
                    "image",
                    100,
                    30,
                    0
            ))
            add(Book(
                    "201710010920",
                    "201710010920",
                    "201710010920",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    40,
                    0
            ))
            add(Book(
                    "201704050920",
                    "201704050920",
                    "201704050920",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    50,
                    0
            ))
            add(Book(
                    "201706100920",
                    "201706100920",
                    "201706100920",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    60,
                    0
            ))
            add(Book(
                    "201709150920",
                    "201709150920",
                    "201709150920",
                    "이탈로 칼비노",
                    "민음사",
                    "thumnail",
                    100,
                    100,
                    0
            ))
        }

        fun createBookDummy(): TestBook {
            return TestBook("20171122", "20171122", "인새의 단맛", "황규정", "고전음악회", "", 100, 26, 5,
                    ArrayList<Post>().apply {
                        add(Post("20171122", "삶이란 실수의 연속", ""))
                        add(Post("20171123", "인생이 고달프다", ""))
                        add(Post("20171125", "세월이 흐른다", ""))
                    })

        }
    }

}