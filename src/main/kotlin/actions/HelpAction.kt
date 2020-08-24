package actions

import net.mamoe.mirai.message.GroupMessageEvent

object HelpAction : Action {

    override val prefix = "/help"

    val actions = ArrayList<Action>()

    fun registerAction(action: Action) {
        actions.add(action)
    }

    override suspend fun invoke(event: GroupMessageEvent, params: String) {
        event.reply(helperText())
    }

    override fun helperText(): String {
        val sb = StringBuilder()

        sb.appendln("/help 显示本帮助")
        for (action in actions) {
            if (action != this) {
                sb.appendln(action.helperText())
            }
        }

        return sb.toString().trim()
    }
}
