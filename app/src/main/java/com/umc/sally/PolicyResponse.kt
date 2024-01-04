package com.umc.sally

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class PolicyResponse(
    @SerializedName("code") val code : Int,
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : List<Data>

) {
    data class Data(
        @SerializedName("title") val title : String,
        @SerializedName("book_image_url") val book_image_url : String,
        @SerializedName("author") val author : String,
        @SerializedName("publisher") val publisher : String,
        @SerializedName("description") val description : String

    )
}
