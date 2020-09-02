package actions

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import net.mamoe.mirai.message.GroupMessageEvent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import transAppId
import transKey
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object TransAction : Action {
    override val noArg: Boolean = false
    override val prefix: List<String> = listOf("/trans", "trans", "translate", "翻译")

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
                    url(TransAction.makeUrl(params.trim()))
                        .get()
                }.build()
        val response = client.newCall(request).execute()
        if (response.code == 200) {
            val body = response.body!!.string();
            val jsonObject = Json.parseToJsonElement(body).jsonObject
            val result = jsonObject["trans_result"]?.jsonArray?.get(0)?.jsonObject?.get("dst")?.jsonPrimitive?.content
            if (!result.isNullOrBlank()) {
                event.reply(result)
            }
        }
    }

    private fun makeUrl(keyword: String): HttpUrl {
        val salt = (0..100).random()
        val sign = encryption("$transAppId$keyword$salt$transKey")
        return HttpUrl.Builder()
            .scheme("https")
            .host("fanyi-api.baidu.com")
            .addPathSegments("api/trans/vip/translate")
            .addQueryParameter("q", keyword)
            .addQueryParameter("from", "auto")
            .addQueryParameter("to", "zh")
            .addQueryParameter("appid", transAppId)
            .addQueryParameter("salt", salt.toString())
            .addQueryParameter("sign", sign)
            .build()
    }

    private fun encryption(str: String): String? {
        var re_md5 = String()
        try {
            val md = MessageDigest.getInstance("MD5")
            md.update(str.toByteArray())
            val b = md.digest()
            var i: Int
            val buf = StringBuffer("")
            for (offset in b.indices) {
                i = b[offset].toInt()
                if (i < 0) i += 256
                if (i < 16) buf.append("0")
                buf.append(Integer.toHexString(i))
            }
            re_md5 = buf.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return re_md5.toLowerCase()
    }
}