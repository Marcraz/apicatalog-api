# Anotaciones del proyecto

## GraphiQL

Para abrir la consola de pruebas de graphQL y comprobar la funcionalidad de las Query usaremos la siguiente URL: `http://localhost:8080/graphiql?path=/graphql`

### Ejemplo de una consulta en GrapiQL

```graphql
query{
  getAplicaciones{
    id
  }
 }
```
Respuesta:
```json
{
  "data": {
    "getAplicaciones": [
      {
        "id": "1"
      },
      {
        "id": "2"
      },
      {
        "id": "3"
      }
    ],
  }
}
```


## Consola H2

Para abrir el SGBD de nuestra BD debemos de usar la siguiente URL: `http://localhost:8080/console`    `user:sa password:sa`

## Relación @ManyToOne

Cuando dos entidades estan relacionadas mediante la relación ManyToOne, debemos cambiar el tipo de fech a `EAGER` ya que si lo definimos como `LAZY` nos producirá un error.

Ejemplo:
```java
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
```

## Input Mutation

Cuando queremos pasar como parámetros un objeto, debemos definir un input correspondiente a los datos que ese objeto va a llevar ya que es necesario definirlo en el schema para que la Query reconozca el objeto que estamos pasando.

De esta manera:
```graphql
input AplicacionInput{
	nombre: String!
	version: String!
}

type Mutation {
    editAplicacion(id: ID!, input: AplicacionInput!): Aplicacion!
}
```