package com.example.framgianguyenhotiendat.cleanunittest.data.remote.response

import com.example.framgianguyenhotiendat.cleanunittest.data.base.ModelEntity
import com.google.gson.annotations.SerializedName

class WrapperResponse<RE : ModelEntity>(
        @SerializedName("status") val status: String,
        @SerializedName("copyright") val copyright: String,
        @SerializedName("last_updated") val lastUpdate: String,
        @SerializedName("num_results") val numResults: String,
        @SerializedName("results") val results: List<RE>)
