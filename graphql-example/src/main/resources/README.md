#### Example Query

```graphql
mutation{
    createInvoice(
        invoice: {
            description: "e-invoice",
            status: "CORPORATE"
        })
    {
        id,
        description,
        createdAt,
        status
    }
}
```

```graphql
query{
    getInvoiceByDescriptionLike(description:"e-invoice"){
        id,
        description,
        createdAt,
        status
    }
}
```

```graphql
query{
    getById(id: 2)
    {
        id,
        description,
        createdAt,
        status
    }
}
```