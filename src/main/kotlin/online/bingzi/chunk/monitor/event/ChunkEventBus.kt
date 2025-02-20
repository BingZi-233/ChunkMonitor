package online.bingzi.chunk.monitor.event

import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.info
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

object ChunkEventBus {
    
    private val listeners = ConcurrentHashMap<Class<*>, MutableList<(Any) -> Unit>>()
    
    fun init() {
        info("事件总线初始化完成!")
    }
    
    fun <T : Any> register(type: KClass<T>, handler: (T) -> Unit) {
        listeners.computeIfAbsent(type.java) { mutableListOf() }.add { event ->
            @Suppress("UNCHECKED_CAST")
            handler(event as T)
        }
    }
    
    fun <T : Any> unregister(type: KClass<T>, handler: (T) -> Unit) {
        listeners[type.java]?.remove(handler)
    }
    
    fun publish(event: Any) {
        listeners[event.javaClass]?.forEach { handler ->
            handler(event)
        }
    }
    
    @SubscribeEvent
    fun onChunkLoad(event: org.bukkit.event.world.ChunkLoadEvent) {
        if (event.isNewChunk) {
            publish(ChunkEvent.Load(event.chunk))
        }
    }
} 