package com.example.lf_wannabe.managemybook.network

import com.example.lf_wannabe.managemybook.model.Book
import com.example.lf_wannabe.managemybook.model.BookList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by lf_wannabe on 09/11/2017.
 */

interface BookService {
    companion object {
        val clientID = "5F6wfGUXJtWbxWI8VS42"
        val clientSecret = "kiudshEENo"
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://openapi.naver.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build()

        // 통신 로그 확인을 위한 http intercepter 추가
        private fun createOkHttpClient(): OkHttpClient =
                OkHttpClient().newBuilder()
                        .addInterceptor(HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
    }

    @Headers("X-Naver-Client-Id:5F6wfGUXJtWbxWI8VS42", "X-Naver-Client-Secret:kiudshEENo")
    @GET("v1/search/book")
    fun getBooks(@Query("query") query: String): Call<BookList>

}