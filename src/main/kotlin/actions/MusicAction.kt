package actions

import bean.MusicSearchResult
import com.google.gson.Gson
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.data.ServiceMessage
import okhttp3.OkHttpClient
import okhttp3.Request

object MusicAction : Action {

    override val noArg: Boolean = false
    override val prefix: String = "/music"

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
                    url("http://inuyasha.love:8001/search?keywords=$params&limit=1&type=1")
                        .get()
                }.build()

        val response = client.newCall(request).execute()
        if (response.code == 200) {
            val body = response.body!!.string();
            val json = Gson().fromJson(body, MusicSearchResult::class.java)
            if (json.result.songs.size >= 1) {
                val id = json.result.songs[0].id.toString()
                var name = json.result.songs[0].name
                if (name.length > 7)
                    name = name.substring(0, 7) + "..."
                val url = "https://music.163.com/song/$id"
                val cover = ""
                var artist = "";
                json.result.songs[0].artists.map {
                    if (it == json.result.songs[0].artists.last())
                        artist += it.name
                    else
                        artist = artist + it.name + "/"
                }
                if (artist.length > 7)
                    artist = artist.substring(0, 7) + "..."

                val msg = "《$name》\n$artist\n$url"
                event.reply(msg)
//                    val xml =
//                        """ <?xml version='1.0' encoding='UTF-8'?><msg serviceID="60" templateID="1" action="web" brief="[分享] $name" url="$url"><item layout="2"><audio cover="$cover" src="" /><title>$name</title><summary>$artist</summary></item><source url="$url" /></msg> """.trimIndent()
//
//                    val xml =
//                        """ <?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID="60" templateID="1" action="web" brief="[分享] 夜奏花" sourceMsgId="0" url="https://i.y.qq.com/v8/playsong.html?_wv=1&amp;songid=217551140&amp;souce=qqshare&amp;source=qqshare&amp;ADTAG=qqshare" flag="0" adverSign="0" multiMsgFlag="0"><item layout="2"><audio cover="http://imgcache.qq.com/music/photo/album_500/70/500_albumpic_4690970_0.jpg" src="" /><title>夜奏花</title><summary>YURiKA</summary></item><source name="QQ音乐" icon="https://i.gtimg.cn/open/app_icon/01/07/98/56/1101079856_100_m.png" url="http://web.p.qq.com/qqmpmobile/aio/app.html?id=1101079856" action="app" a_actionData="com.tencent.qqmusic" i_actionData="tencent1101079856://" appid="1101079856" /></msg> """
//                    event.reply(
//                        ServiceMessage(
//                            60,
//                            xml
//                        )
//                    )
            }
        }
    }

    override fun helperText(): String {
        return "/music 关键词"
    }
}