package SayingApp.repository

import SayingApp.entity.Saying
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.File

object SayingRepository {
    private val sayingMap: MutableMap<Int, Saying> = mutableMapOf()
    private var id: Int = 0

    fun save(author:String, saying:String):Int{
        val saveSaying = Saying(++id, author, saying)
        sayingMap[id] = saveSaying
        saveToFile(saveSaying, id.toString())
        return id
    }
    fun delete(id:Int):Int{
        sayingMap.remove(id)
        deleteFile(id.toString())
        return id
    }
    fun modify(id:Int, author:String, saying:String):Int{
        val modifySaying = Saying(id, author, saying)
        sayingMap[id] = modifySaying
        saveToFile(modifySaying, id.toString())
        return id
    }
    fun findAll(): List<Saying> {
        return sayingMap.values.toList()
    }
    fun check(id:Int):Boolean{
        return sayingMap.containsKey(id)
    }
    private fun saveToFile(saying: Saying, fileName: String){
        val json = Json.encodeToJsonElement(saying)
        File(fileName).writeText(json.toString())
    }
    private fun deleteFile(fileName: String) {
        val file = File(fileName)
        if (file.exists()) {
            file.delete()
        }
    }
}