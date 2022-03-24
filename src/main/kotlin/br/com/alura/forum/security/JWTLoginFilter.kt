package br.com.alura.forum.security

import br.com.alura.forum.config.JWTUtil
import br.com.alura.forum.model.Credentials
import br.com.alura.forum.service.UserDetail
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTLoginFilter(
    private val authManager: AuthenticationManager,
    private val jwtUtil: JWTUtil
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        //extrai para um mapper usuario e senha da request
        val(username, password) = ObjectMapper().readValue(request?.inputStream, Credentials::class.java)

        //gera um token para autenticar, a classe indica queo usuario ainda nao esta autenticado
        val token = UsernamePasswordAuthenticationToken(username, password)

        return authManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        //pega o usuario da requisicao
        val username = (authResult?.principal as UserDetail).username

        //gera o token JWT
        val token = jwtUtil.generateToken(username)

        //seta no header o Authorization Bearer
        response?.addHeader("Authorization","Bearer $token")
    }

}
