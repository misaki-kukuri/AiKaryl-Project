package com.MisakiKukuri.AiKarylProject.yiyan

import com.MisakiKukuri.AiKarylProject.PluginMain
import net.mamoe.mirai.console.plugins.withDefaultWriteSave
import java.net.URL

class yiyanMain()
{
    val config = PluginMain.loadConfig("yiyansetting.yml")
    val yiyan_Trigger by config.withDefaultWriteSave { "一言" }

    private val Url = "http://api.00mm.cc/%E4%B8%80%E8%A8%80/%E7%A4%BE%E4%BC%9A%E8%AF%AD%E5%BD%95"
    val groupsAllowNormal by lazy {
        config.setIfAbsent("Allow_Normal_Image_Groups", listOf<Long>())
        config.getLongList("Allow_Normal_Image_Groups").toMutableList()
    }

    init {

    }

    fun execute(): String{
        val jsonStr = URL(Url).readText()
        //val jsonList = Gson().fromJson(jsonStr,yiyanUrlResult::class.java)
        //return jsonList.data;
        val jsonStr1 = jsonStr.replace('"',' ',ignoreCase = true)
            .replace('{',' ',ignoreCase = true)
            .replace('}',' ',ignoreCase = true)
            .split(',')
        val jsonStr2 = jsonStr1[1]
        val jsonStr3 = jsonStr2.split(':')
        return jsonStr3[1]
    }
}

data class yiyanUrlResult(val ret:String, val data:String, val msg:String)