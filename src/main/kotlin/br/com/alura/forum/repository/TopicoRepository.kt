package br.com.alura.forum.repository

import br.com.alura.forum.dto.TopicoPorCategoriaDto
import br.com.alura.forum.dto.TopicosNaoRespondidosDto
import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {

    //padrao JPA de nomenclatura busca na tabela Curso a propriedade Nome
    fun findByCursoNome(nomeCurso: String,paginacao: Pageable): Page<Topico>

    @Query("SELECT new br.com.alura.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>


    @Query(value = "SELECT new br.com.alura.forum.dto.TopicosNaoRespondidosDto(t.status, t.id, t.mensagem, t.titulo) FROM Topico t WHERE t.status = 'NAO_RESPONDIDO' ")
    fun topicosNaoRespondidos(): List<TopicosNaoRespondidosDto>

    //outra forma de fazer:
    @Query("select t from Topico t where t.respostas is empty")
    fun topicosNaoRespondidosQuery(): List<Topico>

}