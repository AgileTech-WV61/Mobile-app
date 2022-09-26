package Models.HttpRequest.Products

import java.util.*

class Product {
    var id: Int
    var name: String
    var description: String
    var wholesaler: Objects
    var price: Double

    constructor(id: Int, name: String, description: String, wholesaler: Objects, price: Double) {
        this.id = id
        this.name = name
        this.description = description
        this.wholesaler = wholesaler
        this.price = price
    }
}