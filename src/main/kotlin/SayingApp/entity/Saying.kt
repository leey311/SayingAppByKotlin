package SayingApp.entity

import kotlinx.serialization.Serializable

@Serializable
data class Saying(val id: Int, val author: String, val saying: String)
