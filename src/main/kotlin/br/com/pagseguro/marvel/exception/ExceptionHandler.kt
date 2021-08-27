package br.com.pagseguro.marvel.exception

import br.com.pagseguro.marvel.domain.dto.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BusinessException::class)
    fun handleException(ex: BusinessException): ResponseEntity<*>? {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse(ex.message))
    }
}