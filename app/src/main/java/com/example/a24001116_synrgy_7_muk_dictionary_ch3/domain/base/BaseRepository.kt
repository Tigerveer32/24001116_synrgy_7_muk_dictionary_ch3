package com.example.a24001116_synrgy_7_muk_dictionary_ch3.domain.base

import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.alphabet.AlphabetModel
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.words.WordsModel

interface BaseRepository {
    suspend fun listAlphabet(): List<AlphabetModel>
    fun listWord(key: String): List<WordsModel>
}