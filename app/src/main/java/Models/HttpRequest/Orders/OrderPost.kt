package Models.HttpRequest.Orders

class OrderPost {
    var quantity: Int
    var retailSellerId: Int
    var productId: Int

    constructor(quantity: Int, retailSellerId: Int, productId: Int) {
        this.quantity = quantity
        this.retailSellerId = retailSellerId
        this.productId = productId
    }
}