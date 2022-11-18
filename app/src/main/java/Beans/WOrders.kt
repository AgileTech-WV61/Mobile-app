package Beans

class WOrders {
    var id: Int
    var price: Double
    var quantity: Int
    var total: Double
    var retailSellerId: Int
    var productId: Int

    constructor(
        id: Int,
        price: Double,
        quantity: Int,
        total: Double,
        retailSellerId: Int,
        productId: Int
    ) {
        this.id = id
        this.price = price
        this.quantity = quantity
        this.total = total
        this.retailSellerId = retailSellerId
        this.productId = productId
    }
}