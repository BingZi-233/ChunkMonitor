package online.bingzi.chunk.monitor.module

import online.bingzi.chunk.monitor.config.ConfigManager
import online.bingzi.chunk.monitor.event.ChunkEventBus
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.module.lang.sendInfo

object CoreModule : Plugin() {
    
    override fun onEnable() {
        console().sendInfo("pluginEnable")
        // 初始化配置
        ConfigManager.init()
        // 初始化事件总线
        ChunkEventBus.init()
        console().sendInfo("pluginLoaded")
    }
    
    override fun onDisable() {
        console().sendInfo("pluginDisable")
    }
} 