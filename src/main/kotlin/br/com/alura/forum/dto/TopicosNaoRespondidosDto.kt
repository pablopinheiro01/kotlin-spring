package br.com.alura.forum.dto

import br.com.alura.forum.model.StatusTopico

data class TopicosNaoRespondidosDto(
    val topico: StatusTopico,
    val id: Long,
    val mensagem: String,
    val titulo: String
)
