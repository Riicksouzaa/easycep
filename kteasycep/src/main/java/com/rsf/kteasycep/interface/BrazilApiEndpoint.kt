package com.rsf.kteasycep.`interface`

import com.rsf.kteasycep.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BrazilApiEndpoint {
    @GET("v1/{cep}")
    fun getCep(@Path("cep") cep: String): Call<Cep>
}