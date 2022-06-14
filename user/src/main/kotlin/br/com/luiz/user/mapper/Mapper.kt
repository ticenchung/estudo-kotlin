package br.com.luiz.user.mapper

interface Mapper<T, U> {

    fun map(t: T) : U

}