package com.example.demo.service

import com.example.demo.model.Endereco
import com.example.demo.repository.EnderecoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.client.getForObject
import java.lang.IllegalArgumentException


@Service
class EnderecoService {
    @Autowired
    lateinit var repository: EnderecoRepository
    lateinit var endereco: Endereco
    @Autowired
    lateinit var cepService: CepService

    fun  create(endereco: Endereco): Endereco {
        return repository.save(endereco);
    }

    fun getAll(): List<Endereco>{
        return repository.findAll();
    }

    fun getEndereco(cep: String, service: String): Endereco {
        if(repository.findByCep(cep).isPresent){
            return repository.findByCep(cep).get();
        }else{
            when(service){
                "RestTemplate" -> return getRestTemplate(cep);
                "Feign" -> return getCepFeign(cep);
                else -> throw IllegalArgumentException("Servico não encontrado")
            }
        }
    }

    fun getRestTemplate(cep: String): Endereco {
        val restTemplate = RestTemplate()
        val viaCepUrl = "https://viacep.com.br/ws/$cep/json/"
        endereco = restTemplate.getForObject<Endereco>("$viaCepUrl");
        create(endereco);
        return endereco;
    }

    fun getCepFeign(cep: String): Endereco {
        return create(cepService.getCep(cep));
    }


}