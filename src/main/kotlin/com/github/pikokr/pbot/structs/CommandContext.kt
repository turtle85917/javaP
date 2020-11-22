package com.github.pikokr.pbot.structs

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class CommandContext(val evt: MessageReceivedEvent, val args: Array<String>)