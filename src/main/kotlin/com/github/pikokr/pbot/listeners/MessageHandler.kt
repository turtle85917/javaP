package com.github.pikokr.pbot.listeners

import com.github.pikokr.pbot.commands.*
import com.github.pikokr.pbot.structs.Command
import com.github.pikokr.pbot.structs.CommandContext
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageHandler : ListenerAdapter() {
    override fun onMessageReceived(e: MessageReceivedEvent) {
        if (e.author.isBot) return
        val prefix = "p^"
        if (!e.message.contentRaw.startsWith(prefix)) return
        val args = e.message.contentRaw.substring(prefix.length).split(" ").toTypedArray()
        val command = args[0]
        var cmd: Command? = null
        for (c in commands) {
            if (c.name == command || c.aliases.contains(command)) {
                cmd = c
                break
            }
        }
        if (cmd == null) {
            e.message.channel.sendMessage("명령어를 찾을 수 없어요").queue()
            return
        }
        val ctx = CommandContext(e, args)
        try {
            cmd.execute(ctx)
        } catch (err: Exception) {
            e.message.channel.sendMessage(
                """오류가 발생했어요!
                    오류 내용: ```
                    ${err.message}```""".trimIndent()
            ).queue()
        }
    }

    companion object {
        var commands = arrayOf(
            Help(),
            Ping()
        )
    }
}