package com.example.lf_wannabe.managemybook.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import java.io.Serializable

/**
 * Created by lf_wannabe on 07/11/2017.
 */
//TODO : data class로 만드는게 더 좋을지 고민 필요
//TODO : Post model 정의 후 관계 추가해야함
open class Book(
        var title: String = "",
        var author: String = "",
        var publisher: String = "",
        var thumnail: String = "",
        var totalPageNum: Int = 0,
        var currentPageNum: Int = 0,
        var totalPostNum: Int = 0
): RealmObject(), Serializable