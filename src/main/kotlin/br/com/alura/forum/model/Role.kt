package br.com.alura.forum.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val nome: String,

): GrantedAuthority{

    override fun getAuthority(): String  = this.nome

}