package com.MisakiKukuri.AiKarylProject

import com.MisakiKukuri.AiKarylProject.yiyan.yiyanMain
import kotlinx.coroutines.launch
import net.mamoe.mirai.console.command.ContactCommandSender
import net.mamoe.mirai.console.command.registerCommand
import net.mamoe.mirai.console.plugins.Config
import net.mamoe.mirai.console.plugins.PluginBase
import net.mamoe.mirai.console.plugins.withDefaultWriteSave
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.event.subscribeGroupMessages


object PluginMain : PluginBase() {

    lateinit var yiyanInstance:yiyanMain

    override fun onLoad() {
    }

    override fun onEnable() {
        yiyanInstance = yiyanMain()

        subscribeGroupMessages {
            (contains(yiyanInstance.yiyan_Trigger)) {

                    launch {
                        subject.sendMessage(yiyanInstance.execute())

                }
            }
        }
        logger.info("一言模块已加载")
    }

    override fun onDisable() {
        super.onDisable()

        yiyanInstance.config.save()
    }
}