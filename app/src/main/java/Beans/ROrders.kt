package Beans

class ROrders {
    var price: Double
    var quantity: Int
    var total: Double

    constructor(price: Double, quantity: Int, total: Double) {
        this.price = price
        this.quantity = quantity
        this.total = total
    }
}