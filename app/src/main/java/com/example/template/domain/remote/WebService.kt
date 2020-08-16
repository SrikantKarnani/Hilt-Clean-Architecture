package com.example.template.domain.remote

import com.example.template.data.model.CocktailList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getCocktailData(@Query(value = "s") name: String): CocktailList?
}