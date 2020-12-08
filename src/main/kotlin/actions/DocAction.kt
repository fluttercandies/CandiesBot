package actions

import bean.BingSearchResult
import bean.MusicSearchResult
import com.google.gson.Gson
import kotlinx.serialization.json.*
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.data.ServiceMessage
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object DocAction : Action {

    override val noArg: Boolean = false
    override val prefix: List<String> = listOf("/doc", "doc", "文档")

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
                        .get()
                }.build()

        val response = client.newCall(request).execute()

        if (response.code == 200) {
            val body = response.body!!.string();
            var jsonContent = body.replace("/*O_o*/", "")
            jsonContent = jsonContent.replace("google.search.cse.api4049(", "")
            jsonContent = jsonContent.replace("});", "}")
            val json = Json.parseToJsonElement(jsonContent).jsonObject
            val results = json["results"]?.jsonArray
            val result = results?.get(0)?.jsonObject
            if (result != null) {
                val url = result?.get("url")?.jsonPrimitive?.content
                val title = result?.get("titleNoFormatting")?.jsonPrimitive?.content
                val content = result?.get("contentNoFormatting")?.jsonPrimitive?.content
                val msg = "咱帮你\uD83D\uDD0D到了这个\n$title\n$url\n$content"
                event.reply(msg.trim().toString())
            } else
                event.reply("小宝什么也没有\uD83D\uDD0D到")

        }
    }

    private fun makeUrl(keyword: String): HttpUrl {
        return HttpUrl.Builder()
            .scheme("https")
            .host("cse.flutter-io.cn")
            .addPathSegments("cse/element/v1")
            .addQueryParameter("q", keyword)
            .addQueryParameter("num", "1")
            .addQueryParameter("cx", "017471510655331970984:x0bd16320-u")
            .addQueryParameter("cse_tok", "AJvRUv0ohbpy4xwZyjr6TjdQ_l-v:1607422836136")
            .addQueryParameter("callback", "google.search.cse.api4049")
            .build()
    }
}