package com.jet2.travel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Media(
    @field:SerializedName("id")
    @field:Expose
    var id: String?,

    @field:SerializedName("blogId")
    @field:Expose
    var blogId: String?,

    @field:SerializedName("createdAt")
    @field:Expose
    var createdAt: String?,

    @field:SerializedName("image")
    @field:Expose
    var image: String?,

    @field:SerializedName("title")
    @field:Expose
    var title: String?,

    @field:SerializedName("url")
    @field:Expose
    var url: String?

) : Serializable