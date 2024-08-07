package org.example.matchlive.controllers

import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.services.MatchService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/admin")
class AdminController (private val matchService: MatchService) {

    @GetMapping("/matches")
    fun getMatches(model: Model): String {
        model.addAttribute("matches", matchService.getAllMatches())
        return "adminPanel"
    }

    @PostMapping("/add")
    fun addMatch(@RequestParam team1: String, @RequestParam team2: String, model: Model): String {
        val matchDto = MatchDto(null, team1, team2)
        matchService.createMatch(matchDto)
        model.addAttribute("matches", matchService.getAllMatches())
        return "redirect:/admin/matches"
    }

    @PostMapping("/update")
    fun updateMatch(@RequestParam id: Long, @RequestParam team1: String, @RequestParam team2: String, @RequestParam score1: Int, @RequestParam score2: Int, @RequestParam isFinish: String?, @RequestParam isStarted: String?, model: Model): String {

        var finish : Boolean = true
        if(isFinish.isNullOrBlank()){
            finish = false
        }

        var started : Boolean = true
        if(isStarted.isNullOrBlank()){
            started = false
        }

        val matchDto = MatchDto(id, team1, team2,score1, score2,finish,started)
        println(matchDto);
        matchService.updateMatch(matchDto)
        model.addAttribute("matches", matchService.getAllMatches())
        return "redirect:/admin/matches"
    }

    @PostMapping("/delete")
    fun deleteMatch(@RequestParam id: Long, model: Model): String {
        matchService.deleteMatch(id)
        model.addAttribute("matches", matchService.getAllMatches())
        return "redirect:/admin/matches"
    }

}