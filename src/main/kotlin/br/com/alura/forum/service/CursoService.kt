package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {


    fun buscaPorId(id: Long): Curso = repository.getById(id)

}
