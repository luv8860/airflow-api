package com.rapipay.airflow.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user_data")
data class User(
    @Id
    var id:String?= null,
    var name:String?= null,
    var isActive:String?="no",
    var sendNotification:String?="no"
)