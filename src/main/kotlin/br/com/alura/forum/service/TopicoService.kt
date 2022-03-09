package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {


    fun listar(): List<TopicoView>{
        return topicos.stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscaPorId(id: Long): TopicoView {

        val topicoFilter = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topicoFilter)
    }

    fun cadastrar(form: TopicoForm) : TopicoView {
        var topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() +1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{

        val topicoFilter = topicos.stream().filter { topico ->
            topico.id == form.id
        }.findFirst().get()

        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topicoFilter.autor,
            dataCriacao = topicoFilter.dataCriacao,
            curso = topicoFilter.curso,
            status = topicoFilter.status,
            respostas = topicoFilter.respostas
        )
        topicos = topicos.minus(topicoFilter).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)

    }

    fun delete(id: Long) {
        val topicoFilter = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()

        topicos = topicos.minus(topicoFilter)

    }


    init {

//        val topico1 = Topico(id = 1,
//            titulo = "Duvida Kotlin",
//            mensagem = "Variaveis no Kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "Joao Apolinario",
//                email = "jhon@teste.com"
//            )
//        )
//
//        val topico2 = Topico(id = 2,
//            titulo = "Duvida Kotlin",
//            mensagem = "Variaveis no Kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 2,
//                nome = "Joao Apolinario",
//                email = "jhon@teste.com"
//            )
//        )
//
//        val topico3 = Topico(id = 3,
//            titulo = "Duvida Kotlin",
//            mensagem = "Variaveis no Kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 3,
//                nome = "Joao Apolinario",
//                email = "jhon@teste.com"
//            )
//        )
//
//        topicos = Arrays.asList(topico1, topico2, topico3)
    }

}