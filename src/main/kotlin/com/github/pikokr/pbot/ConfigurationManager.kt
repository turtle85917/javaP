package com.github.pikokr.pbot

import java.io.File
import java.util.*

class ConfigurationManager : Properties() {
    init {
        load(File("config.properties").inputStream())
    }
}
