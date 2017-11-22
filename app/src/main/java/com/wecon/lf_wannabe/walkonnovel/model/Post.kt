package com.wecon.lf_wannabe.walkonnovel.model

import io.realm.RealmObject

/**
 * Created by lf_wannabe on 23/11/2017.
 */
open class Post(
        var initDate: String = "",
        var fixedDate: String = "",
        var title: String = "",
        var image: String = "",
        var pageNum: Int = 0
): RealmObject()