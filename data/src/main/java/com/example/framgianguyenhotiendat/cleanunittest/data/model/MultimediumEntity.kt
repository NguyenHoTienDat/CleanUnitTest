package com.example.framgianguyenhotiendat.cleanunittest.data.model

import com.example.framgianguyenhotiendat.cleanunittest.data.base.ModelEntity
import com.google.gson.annotations.SerializedName

data class MultimediumEntity(
        @SerializedName("url")
        var url: String,
        @SerializedName("format")
        var format: String,
        @SerializedName("height")
        var height: Integer,
        @SerializedName("width")
        var width: Integer,
        @SerializedName("type")
        var type: String,
        @SerializedName("subtype")
        var subtype: String,
        @SerializedName("caption")
        var caption: String,
        @SerializedName("copyright")
        var copyright: String) : ModelEntity()
