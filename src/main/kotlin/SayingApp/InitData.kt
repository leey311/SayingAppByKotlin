package SayingApp

import SayingApp.repository.SayingRepository
class InitData{
    init {
        for (i in 1..10){
            SayingRepository.save("작가미상", "명언")
            println("데이터 초기화 중... $i/10")
        }
    }
}
