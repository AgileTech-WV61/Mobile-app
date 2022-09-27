package Models.HttpRequest.Users

class User {
    var username: String
    var email: String
    var password: String
    var roles: Array<String>

    constructor(username: String, email: String, password: String, roles: Array<String>) {
        this.username = username
        this.email = email
        this.password = password
        this.roles = roles
    }
}