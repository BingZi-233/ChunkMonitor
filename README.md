# ChunkMonitor

一个基于TabooLib的Minecraft区块监控插件，用于实时监控和分析区块性能。

## 功能特性

- 区块实体数量监控
- 区块更新事件监控
- 红石更新监控
- 可配置的警告阈值
- 多世界支持
- 实时性能分析

## 系统要求

- Minecraft: 1.8+
- Java: JDK 1.8+
- [TabooLib](https://github.com/TabooLib/taboolib): 6.2.3+

## 安装

1. 下载最新版本的插件
2. 将插件放入服务器的plugins文件夹
3. 重启服务器或重载插件

## 命令

- `/chunkmonitor` 或 `/cm` - 主命令
- `/cm reload` - 重载配置
- `/cm debug` - 切换调试模式

## 配置

```yaml
# 调试模式
debug: false

# 检查间隔（秒）
interval: 30

# 监控的世界列表
worlds:
  - world
  - world_nether
  - world_the_end

# 监控设置
settings:
  # 实体数量警告阈值
  maxEntityWarning: 50
  # 方块更新警告阈值
  maxBlockUpdateWarning: 100
  # 红石更新警告阈值
  maxRedstoneUpdateWarning: 20
```

## 权限

- `chunkmonitor.admin` - 管理员权限
- `chunkmonitor.reload` - 重载配置权限
- `chunkmonitor.debug` - 调试模式权限

## 开发者

- BingZi-233

## 许可证

本项目采用 [CC0-1.0 License](https://creativecommons.org/publicdomain/zero/1.0/) - 详见 [LICENSE](LICENSE) 文件。

```
./gradlew build
```

## 构建开发版本

开发版本包含 TabooLib 本体, 用于开发者使用, 但不可运行。

```
./gradlew taboolibBuildApi -PDeleteCode
```

> 参数 -PDeleteCode 表示移除所有逻辑代码以减少体积。