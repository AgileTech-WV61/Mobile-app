package Models.HttpRequest.Users

import java.util.*

class UserGet {
    var username: String
    var email: String
    var password: String
    var roles: Array<Objects>

    constructor(username: String, email: String, password: String, roles: Array<Objects>) {
        this.username = username
        this.email = email
        this.password = password
        this.roles = roles
    }
}