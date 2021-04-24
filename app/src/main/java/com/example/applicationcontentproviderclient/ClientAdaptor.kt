package com.example.applicationcontentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ClientAdaptor (private val nCursor: Cursor):RecyclerView.Adapter<ClientAdaptor.ClientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder =
        ClientViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.client_item, parent, false)
        )


    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        nCursor.moveToPosition(position)
        holder.clientTitle.text = nCursor.getString(nCursor.getColumnIndex("title"))
        holder.clientDescription.text = nCursor.getString(nCursor.getColumnIndex("description"))
    }

    override fun getItemCount(): Int = nCursor.count

    class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientTitle = itemView.findViewById(R.id.client_item_title) as TextView
        val clientDescription = itemView.findViewById(R.id.client_item_description) as TextView
    }

}