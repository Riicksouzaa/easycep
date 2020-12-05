package com.rsf.kteasycep.`interface`

import com.rsf.kteasycep.model.Cep

interface RetriveCepCallback {
    fun onCep(cep:Cep)
    fun onCepFailed()
}