package Models.HttpRequest.Products

import Models.HttpRequest.Users.User

class Product {
    var id: Int
    var name: String
    var description: String
    var wholesaler: User
    var price: Double

    constructor(id: Int, name: String, description: String, wholesaler: User, price: Double) {
        this.id = id
        this.name = name
        this.description = description
        this.wholesaler = wholesaler
        this.price = price
    }

    constructor(name: String, description: String, wholesaler: User, price: Double) {
        this.id = 0
        this.name = name
        this.description = description
        this.wholesaler = wholesaler
        this.price = price
    }
}