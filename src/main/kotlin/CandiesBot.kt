import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.event.*
import net.mamoe.mirai.join
import net.mamoe.mirai.message.data.content
import java.net.URL


const val cmd = "命令：\n" + "/help\n" + "/pub 包名"

suspend fun main() {
    val bot = Bot( // JVM 下也可以不写 `QQAndroid.` 引用顶层函数
        123,
        ""
    ) {
        // 覆盖默认的配置
        fileBasedDeviceInfo("device.json") // 使用 "device.json" 保存设备信息
        // networkLoggerSupplier = { SilentLogger } // 禁用网络层输出
    }.alsoLogin()
    bot.messageDSL()
    bot.join()//等到直到断开连接
}

/**
 * 使用 dsl 监听消息事件
 *
 * @see subscribeFriendMessages
 * @see subscribeMessages
 * @see subscribeGroupMessages
 * @see subscribeTempMessages
 *
 * @see MessageSubscribersBuilder
 */
fun Bot.messageDSL() {
    subscribeGroupMessages {
        startsWith("/pub ") {
            val pkgUrl = URL("https://pub.flutter-io.cn/packages?q=" + message.content.substringAfter("/pub "))
            val html = pkgUrl.readText()
            val packages = HTMLParser.getElementsByClass(html, "packages-item")
            if (packages.size > 0) {
                val p = packages.first();

                val name = HTMLParser.getElementsByClass(p.html(), "packages-title")[0].child(0).text()

                val link =
                    "https://pub.flutter-io.cn" + HTMLParser.getElementsByClass(p.html(), "packages-title")[0].child(0)
                        .attr("href")

                val scoreHtml = HTMLParser.getElementsByClass(p.html(), "packages-scores")[0]
                val scores = HTMLParser.getElementsByClass(scoreHtml.html(), "packages-score-value-number")

                val description = HTMLParser.getElementsByClass(p.html(), "packages-description").text()

                val version = HTMLParser.getElementsByClass(p.html(), "packages-metadata-block")[0].child(0).text()

                val time = HTMLParser.getElementsByClass(p.html(), "packages-metadata-block")[0].child(1).text()

                val platforms = HTMLParser.getElementsByClass(p.html(), "-pub-tag-badge")

                val s = StringBuilder()
                s.appendln("包名 ：$name")
                s.appendln("链接 ：$link")
                s.appendln("喜欢 ：${scores[0].text()}")
                s.appendln("Pub Point ：${scores[1].text()}/110")
                s.appendln("流行度 ：${scores[2].text()}")
                s.appendln("描述 ：$description")
                s.appendln("版本 ：$version")
                s.appendln("时间 ：$time")
                platforms.map {
                    val main = HTMLParser.getElementsByClass(it.html(), "tag-badge-main")
                    val sub = HTMLParser.getElementsByClass(it.html(), "tag-badge-sub")
                    s.appendln("${main[0].text()} ：${sub.text()}")
                }
                reply(s.toString())
            }
        }
        "/help" reply cmd
    }
}
