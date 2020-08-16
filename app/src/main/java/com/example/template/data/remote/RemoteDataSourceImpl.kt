package com.example.template.data.remote

import com.example.template.data.DataSource
import com.example.template.data.model.Cocktail
import com.example.template.domain.remote.WebService
import com.example.template.util.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


@ExperimentalCoroutinesApi
class RemoteDataSourceImpl @Inject constructor(
    private val webService: WebService
) : DataSource {

    override suspend fun getCocktailData(name:String): Flow<Resource<List<Cocktail>>> = callbackFlow {
        offer(Resource.Success(webService.getCocktailData(name)?.cocktailList?: listOf()))
        awaitClose { close() }
    }
}