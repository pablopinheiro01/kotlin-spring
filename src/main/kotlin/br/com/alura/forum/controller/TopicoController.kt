package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicoDto
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService){

    @GetMapping
    fun listar(): List<Topico> = topicoService.listar()


    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id:Long): Topico = topicoService.buscaPorId(id)

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoDto){
        topicoService.cadastrar(dto)
    }


}