package com.example.room_powell.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room_powell.R
import com.example.room_powell.model.User

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val id_txt : TextView = itemView.findViewById(R.id.id_txt)
        val firstName_txt : TextView = itemView.findViewById(R.id.firstName_txt)
        val lastName_txt : TextView = itemView.findViewById(R.id.lastName_txt)
        val age_txt : TextView = itemView.findViewById(R.id.age_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.id_txt.text = currentItem.id.toString()
        holder.firstName_txt.text = currentItem.firstName
        holder.lastName_txt.text = currentItem.lastName
        holder.age_txt.text = currentItem.age.toString()

        holder.itemView.setOnClickListener {

            Toast.makeText(holder.itemView.context, "Now...    $position", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}