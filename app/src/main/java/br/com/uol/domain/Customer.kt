package br.com.uol.domain

data class Customer(
    val status: String,
    val profileImage: String? = null,
    val profileLink: String? = null,
    val phone: String? = null,
    val email: String,
    val name: String? = null,
    val id: String
)