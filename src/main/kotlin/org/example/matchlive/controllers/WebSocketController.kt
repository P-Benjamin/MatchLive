package org.example.matchlive.controllers

import org.example.matchlive.configurations.CHANNEL_NAME
import org.example.matchlive.dtos.MatchDto
import org.example.matchlive.entities.MatchEntity
import org.example.matchlive.services.MatchService
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.socket.messaging.SessionSubscribeEvent

@Controller
@RequestMapping("/ws") // Chemin de base pour toutes les méthodes de ce contrôleur
class WebSocketController(private val messagingTemplate: SimpMessagingTemplate, private val messageService: MatchService) {

    @EventListener
    fun handleWebSocketSubscribeListener(event: SessionSubscribeEvent) {
        val headerAccessor = StompHeaderAccessor.wrap(event.message)
        if ((CHANNEL_NAME) == headerAccessor.destination) {
            val messageHistory = messageService.getAllMatches()
            messagingTemplate.convertAndSend(CHANNEL_NAME, messageHistory)
        }
    }
}