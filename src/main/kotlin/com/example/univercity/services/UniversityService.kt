package com.example.univercity.services

import com.example.univercity.dtos.UnivercityCreateDto
import com.example.univercity.dtos.UnivercityResponseDto
import com.example.univercity.dtos.UnivercityUpdateDto

interface UnivercityService {

    fun create(dto: UnivercityCreateDto)
    fun update(companyId:Long,dto: UnivercityUpdateDto)
    fun getAll(): List<UnivercityResponseDto>
    fun getOne(id: Long): UnivercityResponseDto
    fun delete(id: Long)
}