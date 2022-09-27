package Models.HttpRequest.Users

class SignInRequest {
    var username: String
    var password: String

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }
}