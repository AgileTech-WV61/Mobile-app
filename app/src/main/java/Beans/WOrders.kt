package Beans

class WOrders {
    var orderId: Int
    var price: Double
    var quantity: Int
    var total: Double

    constructor(orderId: Int, price: Double, quantity: Int, total: Double) {
        this.orderId = orderId
        this.price = price
        this.quantity = quantity
        this.total = total
    }
}