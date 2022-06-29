package br.com.luiz.purchase.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}