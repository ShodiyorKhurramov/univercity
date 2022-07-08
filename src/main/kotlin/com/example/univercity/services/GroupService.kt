package com.example.univercity.services

import com.example.univercity.dtos.FacultyCreateDto
import com.example.univercity.dtos.FacultyResponseDto
import com.example.univercity.dtos.FacultyUpdateDto


interface FacultyService {

    fun create(dto: FacultyCreateDto)
    fun update(id:Long,dto: FacultyUpdateDto)
    fun getAll(): List<FacultyResponseDto>
    fun getOne(id: Long): FacultyResponseDto
}