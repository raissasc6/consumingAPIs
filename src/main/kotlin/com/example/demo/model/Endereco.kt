package com.example.demo.model

import javax.persistence.*


@Entity
@Table(name = "endereco")
data class Endereco(
        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val logradouro: String,
        val bairro:String,
        val cep: String,
        val localidade: String,
        val uf: String,
        val complemento: String

) {


}