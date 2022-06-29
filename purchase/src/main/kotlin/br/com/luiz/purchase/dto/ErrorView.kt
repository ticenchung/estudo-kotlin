package br.com.luiz.purchase.dto

import java.time.LocalDateTime

class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)