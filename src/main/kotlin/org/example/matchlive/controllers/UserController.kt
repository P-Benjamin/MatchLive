package org.example.matchlive.controllers

import org.example.matchlive.services.MatchService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/match")
class UserController (private val matchService: MatchService) {

    @GetMapping("/show")
    fun getMatches(model: Model): String {
        model.addAttribute("ongoingMatches",matchService.getOngoingMatches())
        model.addAttribute("finishedMatches", matchService.getFinishedMatches())
        return "displayMatchs"
    }
}