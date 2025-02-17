package SayingApp.service

import SayingApp.entity.Saying
import SayingApp.repository.SayingRepository

object SayingAppService {

    fun regist(author:String, saying:String):Int {
        return SayingRepository.save(author, saying)
    }
    fun delete(id:Int):Int{
        return SayingRepository.delete(id)
    }
    fun modify(id:Int, author:String, saying:String):Int{
        return SayingRepository.modify(id, author, saying)
    }
    fun list(page:Int):List<Saying>?{
        return SayingRepository.findByPage(page)
    }
    fun check(id:Int):Boolean{
        return SayingRepository.check(id)
    }
    fun build(){
        SayingRepository.build()
    }
    fun search(term:String):List<Saying>{
        return SayingRepository.search(term)
    }
    fun exit(){
        SayingRepository.saveToLastId()
    }
}