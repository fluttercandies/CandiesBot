package actions.dart

import utils.HTMLParser
import actions.Action
import net.mamoe.mirai.message.GroupMessageEvent
import java.net.URL

object PubAction : Action {

    override val noArg: Boolean = false

    override val prefix: String = "/pub"

    override suspend fun invoke(event: GroupMessageEvent, params: String) {
        val pkgUrl = URL("https://pub.flutter-io.cn/packages?q=$params")
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
            event.reply(s.trim().toString())
        }
    }

    override fun helperText(): String {
        return "/pub 包名"
    }
}