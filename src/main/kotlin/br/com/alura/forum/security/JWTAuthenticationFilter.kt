package br.com.alura.forum.security

import br.com.alura.forum.config.JWTUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(private val jwtUtil: JWTUtil) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        val jwt = getTokenDetail(token)
        if(jwtUtil.isValid(jwt)){ //verifica se o JWT é valido
            val autenthication = jwtUtil.getAutenthication(jwt) //pega autenticacao gerada
            SecurityContextHolder.getContext().authentication = autenthication //seta no contexto da nossa aplicacao
        }
        filterChain.doFilter(request, response) //adiciona no chain nossa request e response
    }

    private fun getTokenDetail(token: String?): String? {
        return token?.let { jwt ->
            jwt.startsWith("Bearer ")
            jwt.substring(7, token.length) //pega o token do Bearer
        }
    }

}
