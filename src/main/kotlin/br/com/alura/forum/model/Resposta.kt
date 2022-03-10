package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem : String,
    val dataCriaca: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: Usuario,
    @ManyToOne//muitos para um, no caso da classe topico mapeamos OneToMany=topico trazendo a ref para essa classe
    val topico: Topico,
    val solucao: Boolean
    )
