package com.example.template.ui.page1

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.template.domain.Repo
import com.example.template.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect

class ViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    fun fetchCocktailList(cocktailName: String) =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                repo.getCocktailList(cocktailName).collect {
                    emit(it)
                }
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
}