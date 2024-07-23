package org.example.matchlive.repositories

import org.example.matchlive.entities.MatchEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository : JpaRepository<MatchEntity, Long> {
    fun findByIsStartedTrueAndIsFinishFalse(): List<MatchEntity>
    fun findByIsFinishTrue(): List<MatchEntity>

}