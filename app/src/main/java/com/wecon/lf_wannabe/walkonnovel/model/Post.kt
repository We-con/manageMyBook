package com.wecon.lf_wannabe.walkonnovel.model

import io.realm.PostRealmProxy
import io.realm.RealmObject
import org.parceler.Parcel

/**
 * Created by lf_wannabe on 23/11/2017.
 */
@Parcel(implementations = arrayOf(PostRealmProxy::class),
        value = Parcel.Serialization.BEAN,
        analyze = arrayOf(Post::class))
open class Post(
        var initDate: String = "",
        var fixedDate: String = "",
        var title: String = "",
        var image: String = "",
        var pageNum: Int = 0
): RealmObject()
