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
            match?.scoreTeam1 = matchDto.scoreTeam1!!;
            match?.scoreTeam2 = matchDto.scoreTeam2!!;
            if (match != null) {
                matchRepository.save(match)
                return match
            };
        return null;
    }
}