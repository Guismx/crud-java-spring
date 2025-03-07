# Projeto Backend

## Descrição
Este é o backend para o projeto de cadastro e listagem de cidades. Ele foi desenvolvido utilizando tecnologias modernas para garantir alta performance e facilidade de manutenção.

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **MySQL**

## Requisitos
- **Java 11** ou superior
- **Maven**
- **MySQL**

## Configuração do Ambiente

### 1. Clone o Repositório
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio/backend
```

### 2. Configure o Banco de Dados
Crie um banco de dados MySQL para o projeto:

```sql
CREATE DATABASE seu_banco_de_dados;
```

### 3. Configure o `application.properties`
Edite o arquivo `src/main/resources/application.properties` para definir as configurações do seu banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Build e Execute o Projeto
Use o Maven para construir e executar o projeto:

```bash
mvn clean install
mvn spring-boot:run
```

## Endpoints da API

### 1. Listar Cidades
**GET** `/api/cidades`

Retorna uma lista de todas as cidades.

### 2. Adicionar Cidade
**POST** `/api/cidades`

Adiciona uma nova cidade.

**Body:**

```json
{
  "nome": "Nome da Cidade",
  "uf": "UF",
  "capital": true
}
```

### 3. Atualizar Cidade
**PUT** `/api/cidades`

Atualiza uma cidade existente.

**Body:**

```json
{
  "id": 1,
  "nome": "Nome da Cidade",
  "uf": "UF",
  "capital": true
}
```

### 4. Excluir Cidade
**DELETE** `/api/cidades/delete/{id}`

Exclui a cidade com o ID especificado.

## Contribuição
Para contribuir com este projeto:

1. Faça um fork do repositório.
2. Crie uma nova branch:
   ```bash
   git checkout -b feature/nova-feature
   ```
3. Faça suas alterações e commit:
   ```bash
   git commit -m 'Adiciona nova feature'
   ```
4. Envie para o branch original:
   ```bash
   git push origin feature/nova-feature
   ```
5. Crie um pull request.
