package br.com.luiz.zipcode.service

import br.com.luiz.zipcode.dto.ZipCodeView
import org.springframework.stereotype.Service

@Service
class ZipCodeService {

    fun generate(): ZipCodeView = ZipCodeView((0..99999).random().toString() + "-" + (0..999).random().toString())

}