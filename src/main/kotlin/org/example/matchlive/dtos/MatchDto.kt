package org.example.matchlive.dtos

data class MatchDto (
    val id : Long? = null,
    val team1: String?,
    val team2: String?,
    val scoreTeam1 : Int? = 0,
    val scoreTeam2 : Int? = 0,
)