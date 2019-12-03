package io.gorrion.fullstack

interface UserListListener {
    fun getUser(position: Int) : User
    val usersCount: Int
    fun moreClicked(position: Int)
}