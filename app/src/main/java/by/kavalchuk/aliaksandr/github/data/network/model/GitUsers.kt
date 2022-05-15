package by.kavalchuk.aliaksandr.github.data.network.model

import com.google.gson.annotations.SerializedName

data class GitUsers(
    @SerializedName("avatar_url")
    val avatar_url: String?,
    val bio: Any,
    val blog: String,
    val company: Any,
    val created_at: String,
    @SerializedName("email")
    val email: Any?,
    val events_url: String,
    @SerializedName("followers")
    val followers: Int?,
    val followers_url: String,
    @SerializedName("following")
    val following: Int?,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Any,
    val html_url: String,
    val id: Int,
    val location: Any,
    @SerializedName("login")
    val login: String?,
    @SerializedName("name")
    val name: String?,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val twitter_username: Any,
    val type: String,
    val updated_at: String,
    val url: String
)