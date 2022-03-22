package com.rapipay.airflow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AirflowApplication

fun main(args: Array<String>) {
	runApplication<AirflowApplication>(*args)
}
