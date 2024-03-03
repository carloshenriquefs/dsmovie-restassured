# :construction: - Desafio DSMovie-RestAssured

- Projeto de filmes e avaliações de filmes;

##

## :clipboard: - Competências avaliadas:

- Testes de API com RestAssured e Spring Boot;

##

## :white_check_mark: - Critérios de correção:

- GET /movies deve retornar 200 quando não forem informados argumentos;
- GET /movies deve retornar 200 com página de filmes quando um título for informado;
- GET /movies/{id} deve retornar 200 com um filme quando o id existir;
- GET /movies/{id} deve retornar 404 quando id não existir;
- POST /movies deve retornar 422 quando informado nome em branco;
- POST /movies deve retornar 403 quando CLIENT logado;
- POST /movies deve retornar 401 quando token for inválido;
- POST /scores deve retornar 404 quando id do filme não existir;
- POST /scores deve retornar 422 quando id do filme não for informado;
- POST /scores deve retornar 422 quando valor do score for menor que zero;

##

## :paintbrush: - Testes de API com RestAssured:

#### :open_file_folder: - MovieControllerRA:

- ##### findAllShouldReturnOkWhenMovieNoArgumentsGiven;
- ##### findAllShouldReturnPagedMoviesWhenMovieTitleParamsIsNotEmpty;
- ##### findByIdShouldReturnMovieWhenIdExists;
- ##### findByIdShouldReturnNotFoundWhenIdDoesNotExist;
- ##### insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankTitle;
- ##### insertShouldReturnForbiddenWhenClientLogged;
- ##### insertShouldReturnUnauthorizedWhenInvalidToken;


#### :open_file_folder: - ScoreControllerRA:

- ##### saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist;
- ##### saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId;
- ##### saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero;

##

## :clipboard: - Diagrama:

![dsmovie-jacoco drawio (1)](https://github.com/carloshenriquefs/dsmovie-restassured/assets/54969405/88ec6b30-2cb4-45a4-b198-8c0e085264f9)
