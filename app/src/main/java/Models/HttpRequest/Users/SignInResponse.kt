package Models.HttpRequest.Users

class SignInResponse {
    var id: Int
    var username: String
    var email: String
    var password: String
    var roles: Array<String>
    var token: String

    constructor(
        id: Int,
        username: String,
        email: String,
        password: String,
        roles: Array<String>,
        token: String
    ) {
        this.id = id
        this.username = username
        this.email = email
        this.password = password
        this.roles = roles
        this.token = token
    }
}