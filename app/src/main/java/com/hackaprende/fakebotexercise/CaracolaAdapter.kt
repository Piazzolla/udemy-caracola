package com.hackaprende.fakebotexercise

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hackaprende.fakebotexercise.R.color.teal_200
import com.hackaprende.fakebotexercise.databinding.QandaListItemBinding
import java.security.AccessController.getContext

class CaracolaAdapter : ListAdapter<Qora, CaracolaAdapter.CaracolaViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Qora>() {
        override fun areItemsTheSame(oldItem: Qora, newItem: Qora): Boolean {
                return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Qora, newItem: Qora): Boolean {
            return oldItem.text == newItem.text
        }
    }

     override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CaracolaAdapter.CaracolaViewHolder {
         val binding = QandaListItemBinding.inflate(LayoutInflater.from(parent.context))
         return CaracolaViewHolder(binding)
     }

    override fun onBindViewHolder(holder: CaracolaAdapter.CaracolaViewHolder, position: Int) {
        val newListItem = getItem(position)
        holder.bind(newListItem)
    }

    inner class CaracolaViewHolder(private val binding: QandaListItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(newListItem: Qora) {
            binding.qora.text = newListItem.text
            if(!newListItem.isQuestion){
                binding.qora.setBackgroundColor(R.color.material_on_primary_emphasis_medium)
                binding.qora.gravity = Gravity.LEFT
            }

        }

    }
}