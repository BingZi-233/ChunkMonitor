package online.bingzi.chunk.monitor

import online.bingzi.chunk.monitor.config.ConfigManager
import online.bingzi.chunk.monitor.event.ChunkEventBus
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.info

object ChunkMonitor : Plugin() {

    override fun onEnable() {
        info("plugin.enable")
        // 初始化配置
        ConfigManager.init()
        // 初始化事件总线
        ChunkEventBus.init()
        info("plugin.loaded")
    }

    override fun onDisable() {
        info("plugin.disable")
    }
}