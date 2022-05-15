package by.kavalchuk.aliaksandr.github.data.network.model

import com.google.gson.annotations.SerializedName

data class GitList(
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Item>?,
    val total_count: Int
)