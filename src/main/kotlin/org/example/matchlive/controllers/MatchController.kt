package org.example.matchlive.controllers

import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.entities.MatchEntity
import org.example.matchlive.services.MatchService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class MatchController (val matchService: MatchService){

    @PostMapping("/admin/add")
    fun addMatch(@RequestBody matchDto: MatchDto): MatchEntity? {
        return matchService.createMatch(matchDto);
    }

    @GetMapping("/public/get")
    fun getMatch(matchId : String): MatchEntity? {
        var id = matchId.toLong()
        return matchService.getMatchById(id);
    }

    @GetMapping("/public/getAll")
    fun getAllMatchs(): List<MatchEntity> {
        return matchService.getAllMatches();
    }

    @GetMapping("/admin/delete")
    fun deleteMatchById(matchId: String): Long {
        var id = matchId.toLong()
        return matchService.deleteMatch(id);
    }

    @PostMapping("/admin/update")
    fun updateMatch(@RequestBody matchDto: MatchDto): MatchEntity? {
        return matchService.updateMatch(matchDto);
    }

    @GetMapping("/public/onGoing")
    fun getOnGoingMatchs(): List<MatchEntity> {
        return matchService.getOngoingMatches();
    }

    @GetMapping("/public/finished")
    fun getFinishedMatchs(): List<MatchEntity> {
        return matchService.getFinishedMatches();
    }
}