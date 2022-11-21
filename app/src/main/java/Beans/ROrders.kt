package Beans

class ROrders {
    var orderId: Int
    var price: Double
    var quantity: Int
    var total: Double

    constructor(price: Double, quantity: Int, total: Double, orderId: Int) {
        this.price = price
        this.quantity = quantity
        this.total = total
        this.orderId = orderId
    }
}