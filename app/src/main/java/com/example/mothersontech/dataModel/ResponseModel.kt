package com.example.mothersontech.dataModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseModel(

    @SerializedName("albumId") var albumId: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("thumbnailUrl") var thumbnailUrl: String? = null

) : Serializable