package com.izhal.dicodingsubmission1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.izhal.dicodingsubmission1.R.layout.*
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val context: Context) : BaseAdapter() {
  internal var users = arrayListOf<User>()

  override fun getCount(): Int = users.size

  override fun getItem(i: Int): User = users[i]

  override fun getItemId(i: Int): Long = i.toLong()

  override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
    var itemView = view

    if (itemView == null) {
      itemView = LayoutInflater.from(context).inflate(item_user, viewGroup, false)
    }

    val viewHolder = ViewHolder(itemView!!)

    val user = getItem(position)
    viewHolder.bind(user)

    return itemView
  }

  private inner class ViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(user: User) {
      itemView.txt_name.text = user.name
      itemView.txt_location.text = user.location
      itemView.txt_company.text = user.company
      itemView.img_photo.setImageResource(user.avatar)
    }
  }
}