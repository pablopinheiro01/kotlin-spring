package br.com.alura.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome:String,
    val email:String,
    val password:String,

    @JsonIgnore //para evitar exception ao renderizar o objeto
    @ManyToMany(fetch = FetchType.EAGER)//para carregamento de todas as roles do usuario de uma unica vez
    @JoinColumn(name = "usuario_role")
    val role: List<Role> = mutableListOf()
    )
