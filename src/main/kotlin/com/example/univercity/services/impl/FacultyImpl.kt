package com.example.univercity.services.impl

import com.example.univercity.dtos.UniversityCreateDto
import com.example.univercity.dtos.UniversityResponseDto
import com.example.univercity.dtos.UniversityUpdateDto
import com.example.univercity.entities.University
import com.example.univercity.repositories.UniversityRepository
import com.example.univercity.services.UniversityService
import org.springframework.stereotype.Service


@Service
class UniversityImpl(
    private val universityRepository: UniversityRepository
) : UniversityService {


    override fun create(dto: UniversityCreateDto) {
        dto.apply { universityRepository.save(University(name, address, openYear)) }

    }

    override fun update(id: Long, dto: UniversityUpdateDto) {
        val university = universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") }
        dto.apply {
            name?.let {
                university.name = it
            }
            address?.let {
                university.address = it
            }
            openYear?.let {
                university.openYear = it
            }

        }
        universityRepository.save(university)

    }

    override fun getAll() = universityRepository.findAll().map { UniversityResponseDto.toDto(it) }
    override fun getOne(id: Long) = UniversityResponseDto.toDto(
        universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") })


    override fun delete(id: Long) = universityRepository.deleteById(id)

}