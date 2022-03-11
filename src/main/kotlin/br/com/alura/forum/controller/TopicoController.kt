package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService){

    @GetMapping
    fun listar(@RequestParam(required = false) nomeCurso: String?): List<TopicoView> = topicoService.listar(nomeCurso)

    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id:Long): TopicoView = topicoService.buscaPorId(id)

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid form: TopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView>{
        val topicoView = topicoService.cadastrar(form)
        var uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView>{
        val topico = topicoService.atualizar(form)
        return ResponseEntity.ok(topico)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:Long){
        topicoService.delete(id)
    }


}