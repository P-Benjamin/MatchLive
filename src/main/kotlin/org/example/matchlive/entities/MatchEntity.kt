package org.example.matchlive.entities

import jakarta.persistence.*

@Entity
@Table(name = "matchs")
data class MatchEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     val id: Long? = null,
    var team1: String? = null,
    var team2: String? = null,
    var scoreTeam1 : Int = 0,
    var scoreTeam2 : Int = 0,
    var isFinish : Boolean = false,
    var isStarted : Boolean = false,
)