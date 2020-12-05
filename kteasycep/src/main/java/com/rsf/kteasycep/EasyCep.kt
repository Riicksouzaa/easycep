package com.rsf.kteasycep

import com.rsf.kteasycep.`interface`.RetriveCepCallback
import com.rsf.kteasycep.model.Cep
import com.rsf.kteasycep.providers.BrazilApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.atomic.AtomicLong

class EasyCep {
    final var obCep: Cep? = null
    fun retrieveCep(cep: String, onResult: (cep: Cep?) -> Unit) {

        GlobalScope.launch {
            BrazilApi().fetchBrazilAPIService().getCep(cep).enqueue(object : Callback<Cep> {
                override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                    when {
                        response.code() == 200 -> {
                            val resultado = response.body()
                            if (resultado != null) {
                                obCep = Cep(
                                    resultado.cep,
                                    resultado.state,
                                    resultado.city,
                                    resultado.neighborhood,
                                    resultado.street
                                )
                                onResult(obCep)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<Cep>, t: Throwable) {
                    obCep = null
                }
            })
        }
    }
}