package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.databinding.ListItemHomeBinding
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.data.alphabet.AlphabetModel

class HomeAdapter : ListAdapter<AlphabetModel, HomeAdapter.KeyModelViewHolder>(KeyModelComparator) {

    private var _onInteraction: HomeInteraction? = null

    private object KeyModelComparator : DiffUtil.ItemCallback<AlphabetModel>() {
        override fun areItemsTheSame(oldItem: AlphabetModel, newItem: AlphabetModel): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: AlphabetModel, newItem: AlphabetModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyModelViewHolder {
        return KeyModelViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: KeyModelViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class KeyModelViewHolder(private val binding: ListItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                _onInteraction?.let {
                    it.onClick(bindingAdapterPosition, getItem(bindingAdapterPosition), binding.root)
                }
            }

            itemView.setOnLongClickListener {
                _onInteraction?.let {
                    it.onLongClick(bindingAdapterPosition, getItem(bindingAdapterPosition), binding.root)
                }
                true
            }
        }

        fun bindItem(item: AlphabetModel) {
            val adapter = HomeChildAdapter()

            binding.root.transitionName = item.key
            binding.txtAbjad.text = item.key
            binding.rvChild.setHasFixedSize(true)
            binding.rvChild.itemAnimator = DefaultItemAnimator()
            binding.rvChild.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            binding.rvChild.adapter = adapter

            adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
            adapter.submitList(item.list)
        }
    }

    fun onInteraction(listener: HomeInteraction) {
        _onInteraction = listener
    }
}