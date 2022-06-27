package br.com.luiz.user.exception

import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class FeignExceptionDecoder : ErrorDecoder {

    override fun decode(methodKey: String?, response: Response?): Exception = Exception(response!!.reason())

}