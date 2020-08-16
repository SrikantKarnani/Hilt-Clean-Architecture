package com.example.template.domain

import com.example.template.data.model.Cocktail
import com.example.template.data.remote.RemoteDataSourceImpl
import com.example.template.util.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ExperimentalCoroutinesApi
class RepoImpl @Inject constructor(
    private val defaultDataSource: RemoteDataSourceImpl
) : Repo {

    override suspend fun getCocktailList(cocktailName: String): Flow<Resource<List<Cocktail>?>> {
        return defaultDataSource.getCocktailData(cocktailName)
    }

}