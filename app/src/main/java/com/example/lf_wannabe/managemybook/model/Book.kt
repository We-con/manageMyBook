package com.example.lf_wannabe.managemybook.model

import io.realm.RealmObject

/**
 * Created by lf_wannabe on 07/11/2017.
 */
//TODO : data class로 만드는게 더 좋을지 고민 필요
//TODO : Post model 정의 후 관계 추가해야함
open class Book(var title: String = "TEST TITLE",
           var author: String = "TEST AUTHOR",
           var publisher: String = "TEST PUBLISHER",
           var thumnail: String = "http://goo.gl/gEgYUd",
           var totalPageNum: Int = 100,
           var currentPageNum: Int = 50,
           var totalPostNum: Int = 0): RealmObject()