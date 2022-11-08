package Models.HttpRequest.Users

class User {
    var id: Int
    var username: String
    var email: String
    var password: String
    var roles: Array<String>

    constructor(id: Int, username: String, email: String, password: String, roles: Array<String>) {
        this.id = id
        this.username = username
        this.email = email
        this.password = password
        this.roles = roles
    }

    constructor(id: Int) {
        this.id = id
        this.username = "username"
        this.email = "email"
        this.password = "password"
        this.roles = emptyArray()
    }
}