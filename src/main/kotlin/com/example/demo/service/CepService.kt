package com.example.demo.service

import com.example.demo.model.Endereco
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "cep", url = "https://viacep.com.br/ws")
interface CepService {

    @GetMapping(value = ["/{cep}/json/"])
    fun getCep(@PathVariable cep: String): Endereco

}