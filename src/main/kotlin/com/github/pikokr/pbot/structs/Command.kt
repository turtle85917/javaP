package com.github.pikokr.pbot.structs

open class Command {
    var name = ""
    var aliases = ArrayList<String>()
    var category = "default"

    open fun execute(ctx: CommandContext) {
    }
}