package com.example.univercity.services

import com.example.univercity.dtos.GroupCreateDto
import com.example.univercity.dtos.GroupResponseDto
import com.example.univercity.dtos.GroupUpdateDto


interface GroupService {

    fun create(dto: GroupCreateDto)
    fun update(id:Long,dto: GroupUpdateDto)
    fun getAll(): List<GroupResponseDto>
    fun getOne(id: Long): GroupResponseDto
}