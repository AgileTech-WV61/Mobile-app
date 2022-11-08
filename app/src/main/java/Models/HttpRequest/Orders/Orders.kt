package Models.HttpRequest.Orders

class Orders {
    var id: Int
    var quantity: Int
    var retailSellerId: Int
    var productId: Int

    constructor(id: Int, quantity: Int, retailSellerId: Int, productId: Int) {
        this.id = id
        this.quantity = quantity
        this.retailSellerId = retailSellerId
        this.productId = productId
    }
}