package br.com.luiz.zipcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZipcodeApplication

fun main(args: Array<String>) {
	runApplication<ZipcodeApplication>(*args)
}
