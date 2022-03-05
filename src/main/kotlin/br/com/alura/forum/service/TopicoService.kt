package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicoDto
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: MutableList<Topico>,
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {


    fun listar(): List<Topico> = topicos

    fun buscaPorId(id: Long): Topico =
        topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()

    fun cadastrar(dto: TopicoDto) {
        val topico = Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscaPorId(dto.idCurso),
            autor = usuarioService.buscaPorId(dto.idUsuario)
        )

        topicos.add(topico)
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