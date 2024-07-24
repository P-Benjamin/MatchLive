package org.example.matchlive.controllers

import org.example.matchlive.configurations.CHANNEL_NAME
import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.entities.MatchEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ws") // Chemin de base pour toutes les méthodes de ce contrôleur
class WebSocketController(private val messagingTemplate: SimpMessagingTemplate) {

    private val messageHistory = ArrayList<MatchEntity>()

    @MessageMapping("/chat")
    fun receiveMatch(match: MatchEntity) {
        println("/ws/chat $match")
        messageHistory.add(match)

        // Envoyer la liste des messages sur le channel
        //Si la variable est dans le même package il faut enlever WebSocketConfig.
        messagingTemplate.convertAndSend(CHANNEL_NAME, messageHistory)
    }
}