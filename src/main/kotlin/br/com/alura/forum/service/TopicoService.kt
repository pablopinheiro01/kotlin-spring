package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado"
) {


    fun listar(): List<TopicoView>{
        return repository.findAll().stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscaPorId(id: Long): TopicoView {

        val topicoFilter = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topicoFilter)
    }

    fun cadastrar(form: TopicoForm) : TopicoView {
        var topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{

        val topicoFilter = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}

        topicoFilter.titulo = form.titulo
        topicoFilter.mensagem = form.mensagem

        return topicoViewMapper.map(topicoFilter)

    }

    fun delete(id: Long) {

        repository.deleteById(id)

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