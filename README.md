# jsf-example
Projeto utilizando as tecnologias JSF + JPA + CDI.

### Configurando ambiente

Projeto testado com o servidor de aplicação Wildfly 9.0.2.Final

Para configurar o servidor rode o comando abaixo que irá instalar o driver do banco, configurar o datasource e a módulo de segurança JAAS:
```
$ mvn install -Psetup
```

### Configurando o ambiente 

Projeto testado com o servidor de aplicação Mysql 5.1.38 instalado localmente.

Para configurar o banco, crie um banco de dados no servidro com o nome ```example``` e rode o comando abaixo que irá criar a estrutura e inserir os dados iniciais:
```
$ mvn install -Pdb-migrate
```

### Executando a aplicação

IDE utilizada Eclipse Mars.1 com o plugin Jboss Tools

Após incluir o servidor de aplicação Wildfly no Eclipse, execute o projeto com a opção ```Run on Server```