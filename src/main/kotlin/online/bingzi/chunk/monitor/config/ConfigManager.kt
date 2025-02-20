package online.bingzi.chunk.monitor.config

import taboolib.common.platform.function.console
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.platform.util.sendLang

object ConfigManager {

    @Config("config.yml", autoReload = true)
    private lateinit var config: Configuration
        private set

    private val mainConfig by lazy {
        createDefault()
        val section = config.getConfigurationSection("main") ?: run {
            console().sendLang("configCorrupted")
            Configuration.empty()
        }
        MainConfig.deserialize(section).also {
            if (it.debug) {
                console().sendLang("configDebugEnabled")
            }
        }
    }

    fun init() {
        // 触发lazy加载
        getMainConfig()
        console().sendLang("configLoaded")
    }

    private fun createDefault() {
        if (!config.contains("main")) {
            config["main.debug"] = false
            config["main.interval"] = 30
            config["main.worlds"] = listOf("world")
            config["main.settings.maxEntityWarning"] = 50
            config["main.settings.maxBlockUpdateWarning"] = 100
            config["main.settings.maxRedstoneUpdateWarning"] = 20
            config.saveToFile()
        }
    }

    fun reload() {
        config.reload()
    }

    fun getMainConfig(): MainConfig = mainConfig
} 