# API Rest - Order Crud

# Leonardo Neves Porto - 88513
# Lucas Rocha Relva - 88511

## Para rodar essa aplicação é nescessário:

- Java SDK 17
- [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/) (suggested)
- [Lombok plugin](https://projectlombok.org/)

## Como rodar localmente:

- Entrar no localhost:8080/h2-console e configurar a datasource url para:
  - datasource.url=jdbc:h2:mem:order-crud

## ENDPOINTS:

- GET localhost:8080/order (retorna todos os pedidos cadastarados)

- GET localhost:8080/order/{id} (retorna os detalhes do pedido com id)

- DELETE localhost:8080/order/{id} (deleta o pedido com id informado)

- POST localhost:8080/order (cria pedido //usar request body json como exemplo abaixo)
    - {
      "totalValue": 10000,
      "customerCode": 10,
      "orderDate": "2022-10-06T13:00:50.518Z",
    - "createdAt": "2022-10-06T13:00:50.518Z"
      }

- PUT localhost:8080/product/{id} (Atualiza o pedido do id informado // usar request body json como exemplo abaixo)
    - {
      "totalValue": 50000,
      "customerCode": 15,
      "orderDate": "2022-10-06T13:00:50.518Z",
    - "createdAt": "2022-10-06T13:00:50.518Z"
      }