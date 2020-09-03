package actions

import net.mamoe.mirai.message.GroupMessageEvent

object HelpAction : Action {
    override val noArg: Boolean = true

    override val prefix: List<String> = listOf("/help")

    val actions = ArrayList<Action>()

    fun registerAction(action: Action) {
        actions.add(action)
    }

    override suspend fun invoke(event: GroupMessageEvent, params: String) {
        event.reply(helperText())
    }

    override fun helperText(): String {
        val sb = StringBuilder()
        sb.appendln("以下为本机器人使用帮助")
        sb.appendln("/help 显示本帮助")
        for (action in actions) {
            if (action != this) {
                sb.appendln(action.helperText())
            }
        }
        return sb.toString().trim()
    }
}
