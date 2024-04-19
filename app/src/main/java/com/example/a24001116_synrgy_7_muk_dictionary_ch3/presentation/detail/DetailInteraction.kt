package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.detail

import android.view.View
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.words.WordsModel

interface DetailInteraction {
    fun onClick(position: Int, item: WordsModel, view: View)
}