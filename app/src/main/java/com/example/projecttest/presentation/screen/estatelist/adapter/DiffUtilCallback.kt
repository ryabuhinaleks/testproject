package com.example.projecttest.presentation.screen.estatelist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.projecttest.domain.model.EstateObject

class DiffUtilCallback : DiffUtil.ItemCallback<EstateObject>() {

    override fun areItemsTheSame(oldItem: EstateObject, newItem: EstateObject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EstateObject, newItem: EstateObject): Boolean {
        return oldItem == newItem
    }
}