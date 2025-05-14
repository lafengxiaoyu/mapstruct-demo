[Order]                          [OrderDTO]
├─ id: Long                      ├─ orderId: String (transformed)
├─ customer: Customer            │
│  └─ name: String               ├─ customerName: String (customer.name)
├─ items: List<OrderItem>        ├─ items: List<OrderItemDTO>
│  ├─ product: Product           │  │ 
│  │  ├─  sku: String            │  ├─ sku: String (product.sku)
│  │  └─  name: String           │  │
│  ├─ quantity: int              │  ├─ quantity: int (copied)
│  └─ price: double              │  ├─ unitPrice: double (price renamed)
│                                │  └─ subtotal: double (calculated)
├─ deliveryAddress: Address      │
│  ├─ street: String             ├─ deliveryStreet: String (address.street)
│  ├─ city: String               ├─ deliveryCity: String (address.city)
│  └─ postalCode: String         ├─ deliveryZipCode: String (address.postalCode)
└─ creationDate: Date            ├─ orderDate: Date (renamed)
                                 └─ total: double (calculated)
