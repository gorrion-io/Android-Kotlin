package io.gorrion.fullstack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*

class UsersListAdapter(val listener: UserListListener) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {

    override fun getItemCount() = listener.usersCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listener.getUser(position)
        holder.tvName.text = user.firstName
        holder.tvSurname.text = user.lastName
        Glide.with(holder.ivAvatar).load(user.avatarUrl).into(holder.ivAvatar)
        holder.btnMore.setOnClickListener { listener.moreClicked(position) }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.ivAvatar
        val tvName: TextView = itemView.tvName
        val tvSurname: TextView = itemView.tvSurname
        val btnMore: Button = itemView.btnMore
    }

}