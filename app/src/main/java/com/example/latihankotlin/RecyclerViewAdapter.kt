package com.example.latihankotlin

import android.content.Context
import android.content.Intent
import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihankotlin.model.Item
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*
import javax.security.auth.callback.Callback


class RecyclerViewAdapter(
    private val context: Context,
    private val items: List<Item>
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
//        holder.containerView.setOnClickListener {
//
//        }
    }

    override fun getItemCount(): Int = items.size

   inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(items: Item) {
            itemView.name.text = items.name
            itemView.desc.text = items.desc
            itemView.image.setImageResource(items.image)
            itemView.setOnClickListener {
                val moveData = Intent(context, DetailActivity::class.java)
                moveData.putExtra("nama", items.name)
                moveData.putExtra("desc",items.detail)
                moveData.putExtra("img", items.image)
                context.startActivity(moveData)
            }
        }
    }

//    interface OnItemClickCallback {
//        fun onItemClicked(data: Item)
//    }
}