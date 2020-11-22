package com.github.pikokr.pbot

import com.github.pikokr.pbot.listeners.MessageHandler
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder

val config = ConfigurationManager()

fun main() {
    val manager = DefaultShardManagerBuilder.createDefault(config["TOKEN"] as String?).build()
    manager.addEventListener(object : ListenerAdapter() {
        override fun onReady(e: ReadyEvent) {
            println("LOGIN: " + e.jda.selfUser.asTag)
        }
    })
    manager.addEventListener(MessageHandler())
}