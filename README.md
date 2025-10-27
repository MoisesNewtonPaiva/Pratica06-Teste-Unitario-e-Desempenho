# API RESTful de Produtos com Testes Automatizados

## 📝 Descrição do Projeto
[cite_start]Este projeto consiste no desenvolvimento de uma API RESTful completa com operações CRUD para a entidade `Produto`. [cite: 3] [cite_start]A aplicação foi construída utilizando Java com Spring Boot, seguindo uma arquitetura em camadas (Controller, Service, Repository). [cite: 5] [cite_start]O projeto inclui testes unitários para a camada de serviço utilizando Mockito [cite: 18] [cite_start]e testes de desempenho com JMeter para simular múltiplos acessos aos endpoints. [cite: 22]

## ✨ Funcionalidades
A API implementa os seguintes endpoints para a entidade `Produto`:
- [cite_start]`POST /produtos`: Criar um novo produto. [cite: 10]
- [cite_start]`GET /produtos`: Listar todos os produtos. [cite: 11]
- [cite_start]`GET /produtos/{id}`: Buscar um produto por seu ID. [cite: 12]
- [cite_start]`PUT /produtos/{id}`: Atualizar um produto existente. [cite: 13]
- [cite_start]`DELETE /produtos/{id}`: Excluir um produto. [cite: 14]

## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17+, Spring Boot
- [cite_start]**Banco de Dados:** H2 Database (em memória) [cite: 9]
- [cite_start]**Testes Unitários:** JUnit 5, Mockito [cite: 17]
- [cite_start]**Testes de Desempenho:** Apache JMeter [cite: 21]
- **Build e Gerenciamento:** Maven

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java JDK 17 ou superior
- Apache Maven
- Git

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/MoisesNewtonPaiva/Pratica06-Teste-Unitario-e-Desempenho.git
   ```

2. Navegue até a pasta do projeto:
   ```bash
   cd Pratica06-Teste-Unitario-e-Desempenho
   ```

3. Execute a aplicação com o Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
A API estará disponível em `http://localhost:8080`.

## 🧪 Como Rodar os Testes

### Testes Unitários (Mockito)
[cite_start]Para executar os testes unitários que validam a camada de serviço, utilize o seguinte comando na raiz do projeto: [cite: 40]
```bash
./mvnw test
```
Os testes irão rodar e um relatório de sucesso será exibido no console.

### Testes de Desempenho (JMeter)
[cite_start]Para executar o plano de testes de carga e desempenho: [cite: 41]
1. Certifique-se de que a aplicação Spring Boot esteja em execução (`./mvnw spring-boot:run`).
2. Abra o Apache JMeter.
3. [cite_start]No menu, clique em **File > Open** e selecione o arquivo `plano_de_teste.jmx` (ou o nome que você deu) na raiz do projeto. [cite: 36]
4. Com o plano de teste aberto, clique no botão verde "Start" na barra de ferramentas para iniciar a simulação.
5. Os resultados poderão ser vistos nos *Listeners* (View Results Tree, Summary Report, etc.).

## ⚙️ Exemplos de Requisições (curl)

[cite_start]Aqui estão exemplos de como interagir com cada endpoint usando o `curl`. [cite: 42]

**1. Criar Produto (POST)**
```bash
curl -X POST -H "Content-Type: application/json" -d '{"nome":"Notebook Gamer","descricao":"Notebook de alta performance","preco":7500.00}' http://localhost:8080/produtos
```

**2. Listar Todos os Produtos (GET)**
```bash
curl -X GET http://localhost:8080/produtos
```

**3. Buscar Produto por ID (GET)**
```bash
curl -X GET http://localhost:8080/produtos/1
```

**4. Atualizar Produto (PUT)**
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"nome":"Notebook Gamer Pro","descricao":"Modelo atualizado com mais RAM","preco":8200.50}' http://localhost:8080/produtos/1
```

**5. Excluir Produto (DELETE)**
```bash
curl -X DELETE http://localhost:8080/produtos/1
```


## ✒️ Autor

**Moisés Ribeiro Santos**
