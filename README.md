<h1>Projeto  - Blog Pessoal - Iniciando o Projeto Spring</h1>

O que veremos por aqui:

1. Apresentação do Projeto Blog Pessoal
2. Criar o Projeto no STS
3. Conhecer o arquivo pom.xml
4. Configurar o Banco de dados no arquivo application.properties
<h2>1. O Projeto Blog Pessoal</h2>

O Projeto Blog Pessoal será o Projeto Guia no aprendizado do Framework Spring e suas principais funcionalidades.
<div align="center"><img src="https://i.imgur.com/G71SCJ0.png" title="source: imgur.com" /></div>

<br />

O Projeto será composto por 3 Recursos (*Conjunto de Classes e Interfaces responsáveis por mapear um tipo de Objeto e persistir no Banco de dados Relacional*) e uma Classe auxiliar:

| Classe           | Descrição                                                    |
| ---------------- | ------------------------------------------------------------ |
| **Postagem**     | Recurso responsável por definir  Objeto Postagem (posts) do Blog Pessoal |
| **Tema**         | Recurso responsável por classificar as postagens através do Objeto Tema |
| **Usuario**      | Recurso responsável por definir o Objeto Usuário, que poderá acessar e criar postagens no Blog Pessoal |
| **UsuarioLogin** | Classe auxiliar, que será utilizada para efetuar login no Blog Pessoal |

Cada Recurso irá gerar uma tabela no Banco de dados da aplicação. A Classe auxiliar não irá gerar uma tabela no Banco de dados da aplicação porquê ela servirá de Classe auxiliar na implementação da Segurança da aplicação. Os Recursos serão implementados na mesma sequência da tabela acima. Veja o Diagrama de Entidade e Relacionamentos do Projeto Blog Pessoal completo na figura abaixo:


<div align="center"><img src="https://i.imgur.com/4E1xYYx.png" title="source: imgur.com" /></div>

Documentação: https://github.com/rafaelq80/cookbook_spring/blob/main/03_spring/04.md
