package com.example.univercity.services

import com.example.univercity.dtos.UniversityCreateDto
import com.example.univercity.dtos.UniversityResponseDto
import com.example.univercity.dtos.UniversityUpdateDto
import org.springframework.stereotype.Service


interface UniversityService {

    fun create(dto: UniversityCreateDto)
    fun update(id:Long,dto: UniversityUpdateDto)
    fun getAll(): List<UniversityResponseDto>
    fun getOne(id: Long): UniversityResponseDto
    fun delete(id: Long)
}