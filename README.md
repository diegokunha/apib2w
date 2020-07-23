# Desafio API B2W - SWAPI

  Projeto desenvolvido como solução a um desafio proposto pelo processo seletivo da B2W.

# Objetivo

  O objetivo deste projeto é criar uma API rest que armazenará dados como nome de um planeta, clima e terreno. Retornando também a quantidade de aparições de cada planeta nos filmes de Star Wars.
  
# Tecnologias
  O projeto foi desenvolvido na linguagem Java 8, Spring Boot e persistência no banco MongoDB. Também foi utilizado o Swagger para a documentação da API.
  
# Funcionalidades
  Tem como funcionalidades:
  
  - Incluir um planeta:
    Para inserir um planeta deve ser feita uma requisição post em json para o endpoint "/api/planeta" conforme o modelo:
    {
        "nome": "nome",
        "clima": "clime",
        "terreno": "terreno"
    }
  
  - Listar todos os planetas cadastrados:
  Para listar todos os planetas basta fazer uma solicitação get para o endpoint "/api/planetas".
  
  - Consultar um planeta pelo ID:
  Para fazer uma busca por id você deverá fazer uma solicitação get para o endpoint "/api/{id}" junto com a id que você quer pesquisar.

  - Consultar um planeta pelo Nome;  
  - Excluir um planeta.

# Considerações finais:
  API criada e documentada por Diego fernando da Cunha. Que a força esteja com voces!!!
