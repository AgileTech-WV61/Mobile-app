package Models.HttpRequest.Users

class SignInResponse {
    var username: String
    var email: String
    var password: String
    var roles: Array<String>
    var token: String

    constructor(
        username: String,
        email: String,
        password: String,
        roles: Array<String>,
        token: String
    ) {
        this.username = username
        this.email = email
        this.password = password
        this.roles = roles
        this.token = token
    }
}