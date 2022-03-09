package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView>{

    override fun map(topico: Topico): TopicoView =
        TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriaca = topico.dataCriacao,
            status = topico.status
        )


}