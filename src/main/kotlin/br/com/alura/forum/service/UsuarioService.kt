package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    var list: List<Usuario>
){
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Paulo",
            email = "pp@pmonster.com.br"
        )

        list = Arrays.asList(usuario)
    }

    fun buscaPorId(id: Long): Usuario {
        return list.stream().filter({ u ->
            u.id == id
        }).findFirst().get()
    }
}
