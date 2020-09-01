package actions

import bean.BingSearchResult
import bingKey
import com.google.gson.Gson
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object BingAction : Action {
    override val noArg: Boolean = false

    override val prefix: String = "/bing"

    override suspend fun invoke(event: GroupMessageEvent, params: String) {
        if (params.isBlank()) {
            event.reply("不加参数是坏文明！")
            return
        }
        val client = OkHttpClient.Builder()
            .build()
        val request =
            Request.Builder()
                .apply {
                    url(makeUrl(params.trim()))
                        .addHeader("Ocp-Apim-Subscription-Key", bingKey!!)
                        .get()
                }.build()

        val response = client.newCall(request).execute()
        if (response.code == 200) {
            val body = response.body!!.string();
            val json = Gson().fromJson(body, BingSearchResult::class.java)
            val result = json.webPages.value[0]
            val msg = "咱帮你🔍到了这个\n${result.name}\n${result.snippet}\n${result.url}"
            event.reply(msg)
        }

    }

    private fun makeUrl(keyword: String): HttpUrl {
        return HttpUrl.Builder()
            .scheme("https")
            .host("api.cognitive.microsoft.com")
            .addPathSegments("bing/v7.0/search")
            .addQueryParameter("q", keyword)
            .addQueryParameter("count", "1")
            .addQueryParameter("mkt", "zh-CN")
            .build()
    }

    override fun helperText(): String {
        return "/bing 关键词"
    }
}