package com.wecon.lf_wannabe.walkonnovel.model

import io.realm.BookRealmProxy
import io.realm.RealmList

import io.realm.RealmObject
import org.parceler.Parcel
import org.parceler.ParcelPropertyConverter

/**
 * Created by lf_wannabe on 07/11/2017.
 */

@Parcel(implementations = arrayOf(BookRealmProxy::class))
open class Book(
        var initDate: String = "",
        var fixedDate: String = "",
        var title: String = "",
        var author: String = "",
        var publisher: String = "",
        var image: String = "",
        var totalPageNum: Int = 300,
        var currentPageNum: Int = 0,
        var totalPostNum: Int = 0
): RealmObject() {
        @ParcelPropertyConverter(PostListParcelConverter::class)
        open var posts: RealmList<Post>? = null
        set
}
