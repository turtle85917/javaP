package com.github.pikokr.pbot.commands

import com.github.pikokr.pbot.structs.Command
import com.github.pikokr.pbot.structs.CommandContext
import net.dv8tion.jda.api.EmbedBuilder

class Ping : Command() {
    init {
        name = "핑"
        aliases = arrayListOf("ping")
        category = "기본"
    }

    override fun execute(ctx: CommandContext) {
        val embed = EmbedBuilder()
        embed.setTitle("핑")
        embed.addField("게이트웨이 핑", "${ctx.evt.jda.gatewayPing}ms", false)
        ctx.evt.channel.sendMessage(embed.build()).queue()
    }
}