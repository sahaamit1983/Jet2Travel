package com.jet2.travel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @field:SerializedName("id")
    @field:Expose
    var id: String?,

    @field:SerializedName("blogId")
    @field:Expose
    var blogId: String?,

    @field:SerializedName("createdAt")
    @field:Expose
    var createdAt: String?,

    @field:SerializedName("name")
    @field:Expose
    var name: String?,

    @field:SerializedName("avatar")
    @field:Expose
    var avatar: String?,

    @field:SerializedName("lastname")
    @field:Expose
    var lastname: String?,

    @field:SerializedName("city")
    @field:Expose
    var city: String?,

    @field:SerializedName("designation")
    @field:Expose
    var designation: String?,

    @field:SerializedName("about")
    @field:Expose
    var about: String?
) : Serializable