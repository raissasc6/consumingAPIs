package com.example.demo.repository

import com.example.demo.model.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EnderecoRepository : JpaRepository<Endereco, Long>{

    fun findByCep(cep: String): Optional<Endereco>;

}