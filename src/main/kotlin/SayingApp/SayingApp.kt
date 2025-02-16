package SayingApp

import SayingApp.controller.SayingAppController
import SayingApp.repository.SayingRepository

fun main(){
    //샘플 데이터
    for (i in 1..10){
        SayingRepository.save("작가미상", "명언")
    }
    println("===명언 앱===")
    while (true){
        print("1. 등록 ㅣ 2. 삭제 ㅣ 3. 수정 ㅣ 4. 목록 ㅣ 5. 빌드 ㅣ 6. 검색 ㅣ 종료) ")
        val start = readlnOrNull()
        when(start){
            "1" -> SayingAppController.registSaying()
            "2" -> SayingAppController.deleteSaying()
            "3" -> SayingAppController.modifySaying()
            "4" -> SayingAppController.showSayingByPaging()
            "5" -> SayingAppController.buildSayingAll()
            "6" -> SayingAppController.searchSaying()
            else -> break
        }
    }
}