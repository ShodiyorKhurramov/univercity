package com.example.univercity.services.impl

import com.example.univercity.dtos.UnivercityCreateDto
import com.example.univercity.dtos.UnivercityResponseDto
import com.example.univercity.dtos.UnivercityUpdateDto
import com.example.univercity.entities.Univercity
import com.example.univercity.repositories.UnivercityRepository
import com.example.univercity.services.UnivercityService

class UnivercityImpl(
    private val univercityRepository: UnivercityRepository
):UnivercityService {



    override fun create(dto: UnivercityCreateDto) {
       dto.apply { univercityRepository.save(Univercity(name,address,openYear)) }

    }

    override fun update(id: Long, dto: UnivercityUpdateDto) {
        val university = univercityRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") }
        dto.apply {
            name?.let {
                university.name = it
            }

        }
        univercityRepository.save(university)

    }

    override fun getAll(): List<UnivercityResponseDto> {

    }

    override fun getOne(id: Long): UnivercityResponseDto {

    }

    override fun delete(id: Long) {

    }

}