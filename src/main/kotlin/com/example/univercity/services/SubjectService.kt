package com.example.univercity.services

import com.example.univercity.dtos.JournalCreateDto
import com.example.univercity.dtos.JournalResponseDto
import com.example.univercity.dtos.JournalUpdateDto


interface JournalService {

    fun create(dto: JournalCreateDto)
    fun update(id:Long,dto: JournalUpdateDto)
    fun getAll(): List<JournalResponseDto>
    fun getOne(id: Long): JournalResponseDto
}