package com.wecon.lf_wannabe.walkonnovel.model

import io.realm.RealmObject
import java.io.Serializable

/**
 * Created by lf_wannabe on 07/11/2017.
 */
//TODO : Post model 정의 후 관계 추가해야함
open class Book(
        var initDate: String = "",
        var fixedDate: String = "",
        var title: String = "",
        var author: String = "",
        var publisher: String = "",
        var image: String = "",
        var totalPageNum: Int = 0,
        var currentPageNum: Int = 0,
        var totalPostNum: Int = 0
): RealmObject(), Serializable