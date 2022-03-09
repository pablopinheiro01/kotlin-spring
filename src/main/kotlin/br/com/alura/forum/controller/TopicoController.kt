package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService){

    @GetMapping
    fun listar(): List<TopicoView> = topicoService.listar()

    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id:Long): TopicoView = topicoService.buscaPorId(id)

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoForm){
        topicoService.cadastrar(dto)
    }


}