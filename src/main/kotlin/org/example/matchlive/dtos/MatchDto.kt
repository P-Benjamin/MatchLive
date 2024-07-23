package org.example.matchlive.dtos

data class MatchDto (
    val id : Long? = null,
    val team1: String? = null,
    val team2: String? = null,
    val scoreTeam1 : Int? = null,
    val scoreTeam2 : Int? = null,
    val isFinish : Boolean? = null,
    val isStarted : Boolean? = null,
)