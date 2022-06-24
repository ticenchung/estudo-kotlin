package br.com.luiz.user.exception

class AuthenticationException(override val message : String, val errorCode : String) : Exception()