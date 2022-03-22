package com.rapipay.airflow.repository

import com.rapipay.airflow.models.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BankServiceRepo : ReactiveMongoRepository<User, String>
