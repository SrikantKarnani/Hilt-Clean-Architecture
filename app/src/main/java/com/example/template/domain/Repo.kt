package com.example.template.domain

import com.example.template.data.model.Cocktail
import com.example.template.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repo {
    suspend fun getCocktailList(cocktailName: String): Flow<Resource<List<Cocktail>?>>
}