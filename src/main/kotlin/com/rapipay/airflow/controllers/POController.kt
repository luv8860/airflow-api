package com.rapipay.airflow.controllers

import com.rapipay.airflow.models.User
import com.rapipay.airflow.models.UserDetails
import com.rapipay.airflow.repository.BankServiceRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@CrossOrigin(origins =["*"])
@RestController
class POController(@Autowired var bankServiceRepo: BankServiceRepo) {

    @PostMapping("/createUser")
    fun createUser(@RequestBody userDetails: UserDetails): User {
        println("here 1")
        var user = User()
        user.id = userDetails.id
        user.name = userDetails.name
        this.bankServiceRepo.save(user).subscribe()
        return user
    }

    @GetMapping("activate/{id}")
    fun activateUser(@PathVariable("id") id: String): Mono<User> {
        println("here 2")
        return Mono.just(id)
            .flatMap {
                this.bankServiceRepo.findById(it)
            }.flatMap {
                it.isActive = "yes"
                this.bankServiceRepo.save(it).subscribe()
                Mono.just(it)
            }
    }
    @GetMapping("send/{id}")
    fun sendNotification(@PathVariable("id") id: String):Mono<User> {
        println("here 3")
        return Mono.just(id)
            .flatMap {
                this.bankServiceRepo.findById(it)
            }.flatMap {
                it.sendNotification  = "yes"
                this.bankServiceRepo.save(it).subscribe()
                Mono.just(it)
            }
    }
}