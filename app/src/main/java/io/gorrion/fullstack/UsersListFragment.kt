package io.gorrion.fullstack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersListFragment : Fragment(R.layout.fragment_users_list), UserListListener {

    val users = listOf(
        User(
            "Mateusz",
            "Michalski",
            "https://www.wprost.pl/_thumb/33/f1/6943b529e1973be84e2c165b9a4a.jpeg"
        ),
        User(
            "Jakub",
            "Jadanowski",
            "https://www.wprost.pl/_thumb/33/f1/6943b529e1973be84e2c165b9a4a.jpeg"
        ),
        User(
            "Damian",
            "Fakir",
            "https://www.wprost.pl/_thumb/33/f1/6943b529e1973be84e2c165b9a4a.jpeg"
        )
    )

    override fun getUser(position: Int) = users[position]

    override val usersCount = users.size

    override fun moreClicked(position: Int) {
        val user = users[position]
        val action = UsersListFragmentDirections.actionUsersListFragmentToUserDetailFragment(user)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.adapter = UsersListAdapter(this)
        rvList.layoutManager = LinearLayoutManager(context)
    }

}