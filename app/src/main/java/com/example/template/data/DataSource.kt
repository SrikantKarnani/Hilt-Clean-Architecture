package com.example.template.data

import com.example.template.data.model.Cocktail
import com.example.template.util.Resource
import kotlinx.coroutines.flow.Flow

interface DataSource {
    suspend fun getCocktailData(name:String): Flow<Resource<List<Cocktail>>>
}