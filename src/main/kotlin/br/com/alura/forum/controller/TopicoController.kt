package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService){

    @GetMapping
    fun listar(): List<TopicoView> = topicoService.listar()

    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id:Long): TopicoView = topicoService.buscaPorId(id)

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: TopicoForm){
        topicoService.cadastrar(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: AtualizacaoTopicoForm){
        topicoService.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long){
        topicoService.delete(id)
    }


}