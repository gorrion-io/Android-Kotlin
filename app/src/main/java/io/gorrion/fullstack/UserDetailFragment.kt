package io.gorrion.fullstack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_user_detail.*
import kotlinx.android.synthetic.main.item_user.tvName
import kotlinx.android.synthetic.main.item_user.tvSurname

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    val args by navArgs<UserDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = args.user
        tvName.text = user.firstName
        tvSurname.text = user.lastName
        Glide.with(ivAvatar).load(user.avatarUrl).into(ivAvatar)
    }

}