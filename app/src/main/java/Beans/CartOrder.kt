package Beans

class CartOrder {
    var productName: String
    var productPrice: Double
    var productQuantity: Int

    constructor(
        productName: String,
        productPrice: Double,
        productQuantity: Int
    ) {
        this.productName = productName
        this.productPrice = productPrice
        this.productQuantity = productQuantity
    }
}