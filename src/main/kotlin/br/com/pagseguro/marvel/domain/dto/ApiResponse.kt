package br.com.pagseguro.marvel.domain.dto

class ApiResponse {
    var message: String? = null
    var body: Any? = null

    constructor(message: String?) {
        this.message = message
    }

    constructor(message: String?, body: Any) {
        this.message = message
        this.body = body
    }
}
