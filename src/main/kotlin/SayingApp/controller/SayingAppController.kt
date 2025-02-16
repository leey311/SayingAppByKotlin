package SayingApp.controller

import SayingApp.entity.Saying
import SayingApp.service.SayingAppService

object SayingAppController {

    fun registSaying(){
        val registId = SayingAppService.regist(input("작가"), input("명언"))
        println("${registId}번 명언을 등록했습니다.")
    }
    fun deleteSaying(){
        try {
            val id = input("번호").toInt()
            if (SayingAppService.check(id)){
                val deleteId = SayingAppService.delete(id)
                println("$deleteId 번 명언을 삭제했습니다.")
            }else println("$id 번 명언은 존재하지 않습니다.")
        }catch (e:NumberFormatException){
            println("잘못된 형식입니다 다시 시도해주세요")
            deleteSaying()
        }
    }
    fun modifySaying(){
        try {
            val id = input("번호").toInt()
            if (SayingAppService.check(id)){
                val modifyId = SayingAppService.modify(id, input("작가"), input("명언"))
                println("$modifyId 번 명언을 수정했습니다.")
            }else println("$id 번 명언은 존재하지 않습니다.")
        }catch (e:NumberFormatException){
            println("잘못된 형식입니다 다시 시도해주세요")
            modifySaying()
        }
    }
    fun showSayingByPaging(){
        val list = SayingAppService.list().reversed()
        customizing(list)
    }
    fun buildSayingAll(){
        SayingAppService.build()
    }
    fun searchSaying(){
        val findList = SayingAppService.search(input("검색어"))
        customizing(findList)
    }
    private fun input(input: String):String{
        print("$input) ")
        return readln()
    }private fun customizing(list: List<Saying>){
        if(list.isEmpty()){
            println("조회할 명언이 존재하지 않습니다.")
        }else{
            for ((id, author, saying) in list){
                println("$id / $author / $saying")
            }
        }
    }
}