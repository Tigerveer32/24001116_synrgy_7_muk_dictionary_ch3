package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.base

import androidx.lifecycle.ViewModel
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.words.WordsModel
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.domain.base.BaseRepository
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.domain.base.BaseRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BaseViewModel : ViewModel() {
    private val repository: BaseRepository by lazy { BaseRepositoryImpl() }
    private var _getAll = MutableStateFlow(listOf<WordsModel>())

    val getAll: StateFlow<List<WordsModel>> = _getAll.asStateFlow()

    fun getAll(key:String?, sort: Boolean) {
        if (sort) {
            _getAll.value = repository.listWord(key ?: "").sortedByDescending { it.word }
        } else {
            _getAll.value = repository.listWord(key ?: "").sortedBy { it.word }
        }
    }
}