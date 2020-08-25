package actions

import bean.BingSearchResult
import bingKey
import com.google.gson.Gson
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import okhttp3.OkHttpClient
import okhttp3.Request

object BingAction : Action {
    override val noArg: Boolean = false

    override val prefix: String = "/bing"

    override suspend fun invoke(event: GroupMessageEvent, params: String) {
        val client = OkHttpClient.Builder()
            .build()
        val request =
            Request.Builder()
                .apply {
                    url("https://api.cognitive.microsoft.com/bing/v7.0/search?q=$params&count=1&mkt=zh-CN")
                        .addHeader("Ocp-Apim-Subscription-Key", bingKey!!)
                        .get()
                }.build()
        try {
            val response = client.newCall(request).execute()
            if (response.code == 200) {
                val body = response.body!!.string();
                val json = Gson().fromJson(body, BingSearchResult::class.java)
                val result = json.webPages.value[0]
                val msg = "咱帮你🔍到了这个\n${result.name}\n${result.snippet}\n${result.url}"
                event.reply(msg)
            } else
                event.reply("什么东西坏掉了,大概是bing吧...不可能是咱!")
        } catch (e: Exception) {
            event.reply("什么东西坏掉了,大概是bing吧...不可能是咱!")
        }

    }

    override fun helperText(): String {
        return "/bing 关键词"
    }
}