package br.com.pagseguro.marvel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarvelApplication

fun main(args: Array<String>) {
	runApplication<MarvelApplication>(*args)
}
