package com.wecon.lf_wannabe.walkonnovel.model

/**
 * Created by mangob on 2017. 11. 24..
 */
data class TestBook(
        var initDate: String = "",
        var fixedDate: String = "",
        var title: String = "",
        var author: String = "",
        var publisher: String = "",
        var image: String = "",
        var totalPageNum: Int = 0,
        var currentPageNum: Int = 0,
        var totalPostNum: Int = 0,
        var posts: ArrayList<Post> = ArrayList<Post>()
)