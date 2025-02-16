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
        saveToLastId(id.toString())
        return id
    }
    fun delete(id:Int):Int{
        sayingMap.remove(id)
        deleteFromFile(id.toString())
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
    fun build(){
        val json = Json.encodeToJsonElement(findAll())
        File("db/build").writeText(json.toString())
    }
    fun search(term:String):List<Saying>{
        val findList = mutableListOf<Saying>()
        for(i in findAll()){
            if (i.saying.contains(term)|| i.author.contains(term)){
                findList.add(i)
            }
        }
        return findList
    }
    private fun saveToFile(saying: Saying, fileName: String){
        val json = Json.encodeToJsonElement(saying)
        File("db/$fileName").writeText(json.toString())
    }
    private fun saveToLastId(id:String){
        File("db/lastId").writeText(id)
    }
    private fun deleteFromFile(fileName: String) {
        val file = File("db/$fileName")
        if (file.exists()) file.delete()
    }
}