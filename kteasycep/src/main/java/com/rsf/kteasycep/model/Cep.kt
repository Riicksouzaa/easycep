package com.rsf.kteasycep.model

import com.google.gson.annotations.SerializedName

data class Cep(
    @SerializedName("cep")
    var cep: String,
    @SerializedName("state")
    var state: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("neighborhood")
    var neighborhood: String,
    @SerializedName("street")
    var street: String
)
