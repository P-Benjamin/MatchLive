package org.example.matchlive.entities

import jakarta.persistence.*

@Entity
@Table(name = "matchs")
data class MatchEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     val id: Long? = null,
    val team1: String? = null,
    val team2: String? = null,
    var scoreTeam1 : Int = 0,
    var scoreTeam2 : Int = 0,
    val isFinish : Boolean = false,
    val isStarted : Boolean = false,
)