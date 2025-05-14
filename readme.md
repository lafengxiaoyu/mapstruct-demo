```text
[Order]                                [OrderDTO]
├─ id: Long                            ├─ orderId: String 
├─ customer.name: String               ├─ customerName: String
├─ items: List<OrderItem>              ├─ items: List<OrderItemDTO>
│  ├─ product.sku: String              │  ├─ sku: String
│  ├─ quantity: int                    │  ├─ quantity: int
│  └─ price: double                    │  ├─ unitPrice: double
│                                      │  └─ subtotal: double
├─ deliveryAddress.street: String      ├─ deliveryStreet: String
├─ deliveryAddress.city: String        ├─ deliveryCity: String
├─ deliveryAddress.postalCode: String  ├─ deliveryZipCode: String
└─ creationDate: Date                  ├─ orderDate: Date
                                       └─ total: double
```