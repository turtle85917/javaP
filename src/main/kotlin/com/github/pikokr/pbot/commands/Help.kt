package com.github.pikokr.pbot.commands

import com.github.pikokr.pbot.listeners.MessageHandler
import com.github.pikokr.pbot.structs.Command
import com.github.pikokr.pbot.structs.CommandContext
import net.dv8tion.jda.api.EmbedBuilder

class Help : Command() {
    override fun execute(ctx: CommandContext) {
        val builder = EmbedBuilder()
        builder.setTitle("도움말!")
        builder.setColor(0x98E081)
        val categories = HashSet(MessageHandler.commands.map { it.category })
        categories.forEach { category ->
            builder.addField(category,
                MessageHandler.commands.filter { it.category == category }.joinToString(", ") { "`${it.name}`" }, false)
        }
        ctx.evt.channel.sendMessage(builder.build()).queue()
    }

    init {
        name = "도움말"
        val aliases = ArrayList<String>()
        aliases.add("help")
        aliases.add("도움")
        this.aliases = aliases
        category = "기본"
    }
}