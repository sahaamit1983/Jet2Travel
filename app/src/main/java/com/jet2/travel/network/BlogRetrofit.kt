package com.jet2.travel.network

import com.jet2.travel.model.Blogs
import com.jet2.travel.util.Constants
import retrofit2.http.GET

interface BlogRetrofit {

    @GET(Constants.BLOG_API)
    suspend fun get() : List<Blogs>
}