package com.example.projecttest.presentation.screen.estatelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttest.R
import com.example.projecttest.domain.model.EstateObject

class EstateListAdapter(
    private val listener: EstateListener? = null
) : ListAdapter<EstateObject, EstateListAdapter.EstateObjectViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstateObjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_estate_object, parent, false)
        return EstateObjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: EstateObjectViewHolder, position: Int) = with(holder) {
        val item = getItem(position)
        name.text = item.name
        price.text = item.price
        delete.setOnClickListener {
            listener?.deleteObject(item)
        }
        element.setOnClickListener {
            listener?.clickObject(item.id)
        }
    }

    class EstateObjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.preview)
        val element: LinearLayout = view.findViewById(R.id.element)
        val name: TextView = view.findViewById(R.id.name)
        val delete: TextView = view.findViewById(R.id.delete)
        val price: TextView = view.findViewById(R.id.price)
    }

    interface EstateListener {
        fun deleteObject(estateObject: EstateObject)
        fun clickObject(id: Int)
    }
}

