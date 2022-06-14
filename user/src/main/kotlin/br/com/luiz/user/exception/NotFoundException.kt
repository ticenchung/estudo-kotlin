package br.com.luiz.user.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}