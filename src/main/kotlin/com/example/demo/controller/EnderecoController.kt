package com.example.demo.controller

import com.example.demo.model.Endereco
import com.example.demo.repository.EnderecoRepository
import com.example.demo.service.EnderecoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

@RestController
@RequestMapping("/enderecos")
class EnderecoController {

    @Autowired
    lateinit var service: EnderecoService

    @GetMapping
    fun getAll(): ResponseEntity<List<Endereco>>{ return ResponseEntity.ok(service.getAll())}

    @GetMapping("/{cep}")
    fun getEndereco(@PathVariable("cep") cep: String, @RequestHeader serviceType: String): ResponseEntity<Endereco> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEndereco(cep, serviceType))
    }

}