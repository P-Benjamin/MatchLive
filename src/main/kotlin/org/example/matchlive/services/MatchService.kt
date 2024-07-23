package org.example.matchlive.services

import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.entities.MatchEntity
import org.example.matchlive.repositories.MatchRepository
import org.springframework.stereotype.Service

@Service
class MatchService (val matchRepository: MatchRepository){

    fun createMatch(matchDto: MatchDto): MatchEntity? {
        val match = MatchEntity(null, matchDto.team1, matchDto.team2);
        matchRepository.save(match)
        return match;
    }

    fun getMatchById(id : Long): MatchEntity {
        val match = matchRepository.findById(id).orElseThrow(){RuntimeException("Match not found")};
        return match;
    }

    fun getAllMatches(): List<MatchEntity> {
        val match = matchRepository.findAll();
        return match;
    }

    fun deleteMatch(id : Long) : Long {
        val match = matchRepository.deleteById(id);
        return id
    }

    fun updateMatch(matchDto: MatchDto) : MatchEntity? {
        val match = matchDto.id?.let { getMatchById(it) };
        if(match != null){

            if(matchDto.team1 != null){
                match.team1 = matchDto.team1;
            }

            if(matchDto.team2 != null) {
                match.team2 = matchDto.team2;
            }

            if(matchDto.scoreTeam1 != null){
                match.scoreTeam1 = matchDto.scoreTeam1;
            }

            if(matchDto.scoreTeam2 != null) {
                match.scoreTeam2 = matchDto.scoreTeam2;
            }

            if(matchDto.isFinish != null){
                match.isFinish = matchDto.isFinish;
            }

            if(matchDto.isStarted != null) {
                match.isStarted = matchDto.isStarted;
            }

            matchRepository.save(match)
            return match
        }
        println("UPDATE FAILED")
        return null;
    }

    fun getOngoingMatches(): List<MatchEntity> {
        return matchRepository.findByIsStartedTrueAndIsFinishFalse()
    }

    fun getFinishedMatches(): List<MatchEntity> {
        return matchRepository.findByIsFinishTrue()
    }
}