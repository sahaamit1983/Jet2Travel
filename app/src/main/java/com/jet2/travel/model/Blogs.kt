package com.jet2.travel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Blogs(
    @field:SerializedName("id")
    @field:Expose
    var id: String?,

    @field:SerializedName("createdAt")
    @field:Expose
    var createdAt: String?,

    @field:SerializedName("content")
    @field:Expose
    var content: String?,

    @field:SerializedName("comments")
    @field:Expose
    var comments: Long?,

    @field:SerializedName("likes")
    @field:Expose
    var likes: Long?,

    @field:SerializedName("media")
    @field:Expose
    var media: ArrayList<Media>?,

    @field:SerializedName("user")
    @field:Expose
    var user: ArrayList<User>?
) : Serializable