package SayingApp

import SayingApp.controller.SayingAppController

fun main(){
    println("===명언 앱===")
    while (true){
        print("1. 등록 ㅣ 2. 삭제 ㅣ 3. 수정 ㅣ 4. 목록 ㅣ 종료) ")
        val start = readlnOrNull()
        when(start){
            "1" -> SayingAppController.registSaying()
            "2" -> SayingAppController.deleteSaying()
            "3" -> SayingAppController.modifySaying()
            "4" -> SayingAppController.showSayingAll()
            else -> break
        }
    }
}