package com.wecon.lf_wannabe.walkonnovel.util

import com.wecon.lf_wannabe.walkonnovel.model.Book
import io.realm.RealmList

/**
 * Created by mangob on 2017. 11. 7..
 */
class DummyFactory {

    companion object {
        fun createBookDummy() = RealmList<Book>().apply {
            add(Book(
                    "201711261420",
                    "201711261420",
                    "여중생 A 세트",
                    "허5파6",
                    "비아북",
                    "http://bookthumb.phinf.naver.net/cover/122/036/12203666.jpg?type=m1&udate=20170715",
                    100,
                    0,
                    0
            ))
            add(Book(
                    "201711261421",
                    "201711261421",
                    "5년 후 나에게 Q&A a day",
                    "포터 스타일",
                    "토네이도",
                    "http://bookthumb.phinf.naver.net/cover/097/434/09743475.jpg?type=m1&udate=20171125",
                    100,
                    5,
                    0
            ))
            add(Book(
                    "201711261422",
                    "201711261422",
                    "Korean food, cuisine, A Handbook of Terminology",
                    "편집부",
                    "온이퍼브",
                    "http://bookthumb.phinf.naver.net/cover/127/794/12779457.jpg?type=m1&udate=20171117",
                    100,
                    10,
                    0
            ))
            add(Book(
                    "201711261423",
                    "201711261423",
                    "클래식 A-yo (가요보다 쉽고 팝송보다 친숙하다 클래식을 A부터 Y까지 쉽게 알려드립니다)",
                    "조윤범",
                    "삼호ETM",
                    "http://bookthumb.phinf.naver.net/cover/121/089/12108932.jpg?type=m1&udate=20171010",
                    100,
                    15,
                    0
            ))
            add(Book(
                    "201711261424",
                    "201711261424",
                    "창의사고력 수학 키즈팩토 원리 키즈 A (6-7세용)",
                    "매스티안편집부",
                    "매스티안",
                    "http://bookthumb.phinf.naver.net/cover/095/101/09510194.jpg?type=m1&udate=20151119",
                    100,
                    20,
                    0
            ))
        }
    }

}