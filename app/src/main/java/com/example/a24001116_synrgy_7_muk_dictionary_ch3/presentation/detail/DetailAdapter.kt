package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.databinding.ListItemDetailBinding
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.words.WordsModel

class DetailAdapter : ListAdapter<WordsModel, DetailAdapter.KeyModelViewHolder>(KeyModelComparator) {

    private var _onInteraction: DetailInteraction? = null

    private object KeyModelComparator : DiffUtil.ItemCallback<WordsModel>() {
        override fun areItemsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem.word == newItem.word
        }

        override fun areContentsTheSame(oldItem: WordsModel, newItem: WordsModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyModelViewHolder {
        return KeyModelViewHolder(
            ListItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: KeyModelViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class KeyModelViewHolder(private val binding: ListItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                _onInteraction?.let {
                    it.onClick(bindingAdapterPosition, getItem(bindingAdapterPosition), binding.root)
                }
            }
        }

        fun bindItem(item: WordsModel) {
            binding.root.transitionName = item.word
            binding.txtAbjad.text = item.word
        }
    }

    fun onInteraction(listener: DetailInteraction) {
        _onInteraction = listener
    }
}