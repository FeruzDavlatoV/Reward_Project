package uz.behad.rewardsapp

data class Reward(

    val title: String,
    val level: String,
    val star: Int,
    var gained: Boolean,
    val type: Int,

    )
