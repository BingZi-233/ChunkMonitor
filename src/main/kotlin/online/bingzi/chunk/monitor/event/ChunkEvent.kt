package online.bingzi.chunk.monitor.event

import org.bukkit.Chunk

sealed class ChunkEvent {
    data class Load(val chunk: Chunk) : ChunkEvent()
    data class Unload(val chunk: Chunk) : ChunkEvent()
    data class EntityCount(val chunk: Chunk, val count: Int) : ChunkEvent()
    data class BlockUpdate(val chunk: Chunk, val updates: Int) : ChunkEvent()
    data class RedstoneUpdate(val chunk: Chunk, val updates: Int) : ChunkEvent()
} 