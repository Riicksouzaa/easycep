package com.rsf.kteasycep.providers

import com.rsf.kteasycep.`interface`.BrazilApiEndpoint
import com.rsf.kteasycep.util.Network

class BrazilApi {

    private val url = "https://brasilapi.com.br/api/cep/"

    fun fetchBrazilAPIService(): BrazilApiEndpoint {
        return Network.getRetrofitInstance(url).create(BrazilApiEndpoint::class.java)
    }
}