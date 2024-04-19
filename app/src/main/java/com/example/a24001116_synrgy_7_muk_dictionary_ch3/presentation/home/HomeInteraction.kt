package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.home

import android.view.View
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.alphabet.AlphabetModel

interface HomeInteraction {
    fun onClick(position: Int, item: AlphabetModel, view: View)
    fun onLongClick(position: Int, item: AlphabetModel, view: View)
}