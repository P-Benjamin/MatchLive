package org.example.matchlive.controllers

import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.entities.MatchEntity
import org.example.matchlive.services.MatchService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("match")
class MatchController (val matchService: MatchService){

    @PostMapping("/add")
    fun addMatch(@RequestBody matchDto: MatchDto): MatchEntity? {
        return matchService.createMatch(matchDto);
    }

    @GetMapping("/get")
    fun getMatch(matchId : String): MatchEntity? {
        var id = matchId.toLong()
        return matchService.getMatchById(id);
    }

    @GetMapping("/getAll")
    fun getAllMatchs(): List<MatchEntity> {
        return matchService.getAllMatches();
    }

    @GetMapping("/delete")
    fun deleteMatchById(matchId: String): Long {
        var id = matchId.toLong()
        return matchService.deleteMatch(id);
    }

    @PostMapping("/update")
    fun updateMatch(@RequestBody matchDto: MatchDto): MatchEntity? {
        return matchService.updateMatch(matchDto);
    }

}