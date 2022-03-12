package br.com.alura.forum.repository

import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {

    //padrao JPA de nomenclatura busca na tabela Curso a propriedade Nome
    fun findByCursoNome(nomeCurso: String,paginacao: Pageable): Page<Topico>

}