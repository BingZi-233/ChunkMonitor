package online.bingzi.chunkmonitor

import taboolib.common.platform.Plugin
import taboolib.common.platform.function.info

object ChunkMonitor : Plugin() {

    override fun onEnable() {
        info("Successfully running ChunkMonitor!")
    }
}