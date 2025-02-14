package SayingApp.repository

import SayingApp.entity.Saying

object SayingRepository {
    private val sayingMap: MutableMap<Int, Saying> = mutableMapOf()
    private var id: Int = 0

    fun save(author:String, saying:String):Int{
        val saying = Saying(++id, author, saying)
        sayingMap[id] = saying
        return id
    }
    fun delete(id:Int):Int{
        sayingMap.remove(id)
        return id
    }
    fun modify(id:Int, author:String, saying:String):Int{
        sayingMap[id] = Saying(id, author, saying)
        return id
    }
    fun findAll(): List<Saying> {
        return sayingMap.values.toList()
    }
    fun check(id:Int):Boolean{
        return sayingMap.containsKey(id)
    }
}