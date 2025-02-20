package online.bingzi.chunk.monitor.config

import taboolib.library.configuration.ConfigurationSection

data class MainConfig(
    val debug: Boolean = false,
    val interval: Int = 30,
    val worlds: List<String> = listOf("world"),
    val settings: Settings = Settings()
) {
    data class Settings(
        val maxEntityWarning: Int = 50,
        val maxBlockUpdateWarning: Int = 100,
        val maxRedstoneUpdateWarning: Int = 20
    )
    
    companion object {
        fun deserialize(section: ConfigurationSection): MainConfig {
            return MainConfig(
                debug = section.getBoolean("debug", false),
                interval = section.getInt("interval", 30),
                worlds = section.getStringList("worlds").ifEmpty { listOf("world") },
                settings = Settings(
                    maxEntityWarning = section.getInt("settings.maxEntityWarning", 50),
                    maxBlockUpdateWarning = section.getInt("settings.maxBlockUpdateWarning", 100),
                    maxRedstoneUpdateWarning = section.getInt("settings.maxRedstoneUpdateWarning", 20)
                )
            )
        }
    }
}