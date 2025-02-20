package online.bingzi.chunk.monitor.command

import online.bingzi.chunk.monitor.config.ConfigManager
import org.bukkit.command.CommandSender
import taboolib.common.platform.command.*
import taboolib.platform.util.sendLang

@CommandHeader(
    name = "chunkmonitor",
    aliases = ["cm"],
    permission = "chunkmonitor.admin",
    permissionDefault = PermissionDefault.OP,
    description = "ChunkMonitor 管理命令"
)
object ChunkCommand {

    @CommandBody
    val main = mainCommand {
        execute<CommandSender> { sender, _, _ ->
            sender.sendLang("commandHelpHeader")
            sender.sendLang("commandHelpReload")
            sender.sendLang("commandHelpFooter")
        }
    }

    @CommandBody
    val reload = subCommand {
        execute<CommandSender> { sender, _, _ ->
            ConfigManager.reload()
            sender.sendLang("commandReloadSuccess")
        }
    }
} 