package SayingApp

import SayingApp.controller.SayingAppController

fun main(){
    val sayingAppController = SayingAppController()
    println("===명언 앱===")
    InitData()

    while (true){
        print("1. 등록 ㅣ 2. 삭제 ㅣ 3. 수정 ㅣ 4. 목록 ㅣ 5. 빌드 ㅣ 6. 검색 ㅣ 종료) ")
        val start = readlnOrNull()
        when(start){
            "1" -> {
                sayingAppController.registSaying()
            }
            "2" -> {
                sayingAppController.deleteSaying()
            }
            "3" -> {
                sayingAppController.modifySaying()
            }
            "4" -> {
                sayingAppController.showSayingByPaging()
            }
            "5" -> {
                sayingAppController.buildSayingAll()
            }
            "6" -> {
                sayingAppController.searchSaying()
            }
            else -> {
                sayingAppController.exitSayingApp()
                break
            }
        }
    }
}