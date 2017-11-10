package com.example.lf_wannabe.managemybook.model

import com.google.gson.annotations.SerializedName

/**
 * Created by lf_wannabe on 10/11/2017.
 */
class BookList {
    @SerializedName("items")
    lateinit var books: List<Book>
}