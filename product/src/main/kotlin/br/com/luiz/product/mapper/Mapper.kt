package br.com.luiz.product.mapper

interface Mapper<T, U> {

    fun map(t: T) : U

}