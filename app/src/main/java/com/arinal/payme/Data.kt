package com.arinal.payme

import java.io.Serializable

data class Data (
    val serviceName: String,
    val serviceImage: Int,
    val account: String,
    val name: String,
    val qr: Int,
    val appName: String
):Serializable