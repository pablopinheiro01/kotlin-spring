# kotlin-spring
dados de acesso h2:
http://localhost:8080/h2-console/
driverClassName: org.h2.Driver
url: jdbc:h2:mem:forum
usuario: sa
senha: (vazio)

#Usuario do sprintsecurity
joao@webmaster.com.br
senha: 123456
Criptografado com: bcrypt encoder
Hash gerado em: https://bcrypt-generator.com/

#Autenticacao no postman:
Authorization: Basic Auth
Username: joao@webmaster.com.br
pass: 123456

#Autenticacao no Postman com JWT:
Endpoint:
localhost:8080/topicos
Method: POST
Body:
{
"username":"joao@webmaster.com.br",
"password": "123456"
}

EX de Auth:
Bearer eyJhbGciOiJIUzUxMiJ9.
eyJzdWIiOiJqb2FvQHdlYm1hc3Rlci5jb20uYnIiLCJyb2xlIjpbeyJhdXRob3JpdHkiOiJMRUlUVVJBX0VTQ1JJVEEifV0sImV4cCI6MTY0ODA4MTIwM30
.e7PCxYrAIF9hFNiY7lSZrEfTkCuNsR-SZJWmAGm5i1hwUlI6LqneTo_ZZU1JufWsAoyxhI9QrXOnS--tCW6BMw

Tempo de validado: 1 min
Criptografia: HS512
Ex Payload:
{
"sub": "joao@webmaster.com.br",
"role": [
{
"authority": "LEITURA_ESCRITA"
}
],
"exp": 1648081083
}

Url de Request:
localhost:8080/topicos
Header: Bearer ...(acima)

#PRofiles do Spring
Comandos executados apos configuração dos profiles

#Executa o spring
mvn spring-boot:run

#Setando um profile
Para selecionar o profile correto, passe a flag -Dspring.profile.active=${valor_desejado}

mvn spring-boot:run -Dspring.profile.active=prod

#Comando Docker para build do Dockerfile
terminal>docker build -t forum -f Dockerfile .

#Execuçao do comando docker para rodar o projeto
docker run -p 3080:8080 forum

#Rodando no docker os endpoints todos foram alterados para a porta 3080 do docker