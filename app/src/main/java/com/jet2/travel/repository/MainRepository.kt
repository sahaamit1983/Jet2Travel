package com.jet2.travel.repository

import com.jet2.travel.network.BlogRetrofit
import com.jet2.travel.util.DataState
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepository
    @Inject constructor(
    private val blogRetrofit: BlogRetrofit
) {
    suspend fun getBlog() = flow {
        emit(DataState.Loading)
        try {
            val blogs = blogRetrofit.get()
            emit(DataState.Success(blogs))
        } catch (e : Exception){
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }
}