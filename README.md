# compassofrontend

<h1>Projeto Desafio Back-End Compasso</h1>

<h1>REQUISITOS</h1>
A aplicação contempla as seguintes operações expostas como endpoints REST:

<ul>
  <li>Cadastro de cidade</li>
  <li>Cadastro de cliente</li>
  <li>Consulta de cidade pelo nome</li>
  <li>Consulta de cidade pelo estado</li>
  <li>Consulta de cliente pelo nome</li>
  <li>Consulta de cliente pelo Id</li>
  <li>Alterar o nome do cliente</li>
  <li>Remover cliente</li>
</ul>

<h2>ENTIDADES</h2>
<p>Cidade</p>
A entidade Cidade possui: nome e estado
<br>
<p>Cliente</p>
A entidade cliente possui: nome completo, sexo, data de nascimento, idade e cidade onde mora.


<h1>TECNOLOGIAS UTILIZADAS</h1>
Para tornar este projeto possível, as seguintes tecnologias foram utilizadas:

<ul>
  <li>Java 8</li>
  <li>Spring Boot</li>
  <li>Maven</li>
  <li>Hibernate</li>
</ul>

<h1> Examplos de execução </h2>
<p>Nos exemplos abaixo, são usados valores aleatórios, na hora do teste qualquer valor dentro do contexto é válido</p>

<h4>Cadastrar Cidade</h4>
POST - /cidades

  {
    "nome": "Recife",
    "estado": "PE"
  }
<br>

<h4>Cadastrar Cliente</h4>
POST - /clientes
{
    "nome": "RAQUEL",
    "idade": 25,
    "dataNascimento": "1994-06-11",
    "sexo": "F",
    "nomeCidade": "RECIFE"
}
<br>

<h4>Consultar Cidade pelo nome</h4>
GET - /cidades?cidade=recife
<br>

<h4>Consultar Cidade pelo estado</h4>
GET - /estados?estado=pe
<br>

<h4>Consultar Cliente pelo nome</h4>
GET - /clientes?nome=raquel
<br>

<h4>Consultar Cliente pelo ID</h4>
GET - /clientes/1
<br>

<h4>Consultar Remover Cliente</h4>
DELETE - /clientes/1
<br>

<h4>Alterar o nome do Cliente</h4>
PUT - /clientes/1
  {
  	"nome": "Raquel"
  }

