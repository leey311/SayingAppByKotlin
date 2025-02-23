package SayingApp.controller

import SayingApp.entity.Saying
import SayingApp.service.SayingAppService

class SayingAppController {
    private val sayingAppService = SayingAppService()

    fun registSaying(){
        val registId = sayingAppService.regist(input("작가"), input("명언"))
        println("${registId}번 명언을 등록했습니다.")
    }
    fun deleteSaying(){
        try {
            val id = input("번호").toInt()
            if (sayingAppService.check(id)){
                val deleteId = sayingAppService.delete(id)
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
            if (sayingAppService.check(id)){
                val modifyId = sayingAppService.modify(id, input("작가"), input("명언"))
                println("$modifyId 번 명언을 수정했습니다.")
            }else println("$id 번 명언은 존재하지 않습니다.")
        }catch (e:NumberFormatException){
            println("잘못된 형식입니다 다시 시도해주세요")
            modifySaying()
        }
    }
    fun showSayingByPaging(){
        val list = sayingAppService.list(input("페이지").toInt())?.reversed()
        if (list == null) {
            println("존재하지 않는 페이지입니다.")
        }else customizing(list)
    }
    fun buildSayingAll(){
        sayingAppService.build()
    }
    fun searchSaying(){
        val findList = sayingAppService.search(input("검색어"))
        customizing(findList)
    }
    fun exitSayingApp(){
        sayingAppService.exit()
    }
    private fun input(input: String):String{
        print("$input) ")
        val userInput = readln()
        return userInput.ifBlank { "1" }
    }
    private fun customizing(list: List<Saying>){
        if(list.isEmpty()){
            println("조회할 명언이 존재하지 않습니다.")
        }else{
            for ((id, author, saying) in list){
                println("$id / $author / $saying")
            }
        }
    }
}