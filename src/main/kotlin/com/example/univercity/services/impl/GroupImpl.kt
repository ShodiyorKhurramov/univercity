package com.example.univercity.services.impl

import com.example.univercity.dtos.FacultyCreateDto
import com.example.univercity.dtos.FacultyResponseDto
import com.example.univercity.dtos.FacultyUpdateDto
import com.example.univercity.entities.Faculty
import com.example.univercity.repositories.FacultyRepository
import com.example.univercity.repositories.UniversityRepository
import com.example.univercity.services.FacultyService
import org.springframework.stereotype.Service


@Service
class FacultyImpl(
    private val facultyRepository: FacultyRepository,
    private val universityRepository: UniversityRepository
) : FacultyService {


    override fun create(dto: FacultyCreateDto) {
        dto.apply {
            val university = universityRepository.findById(universityId)
                .orElseThrow { Exception("Region not found by id: $universityId") }
            facultyRepository.save(Faculty(name, university))
        }

    }

    override fun update(id: Long, dto: FacultyUpdateDto) {
        val faculty = facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") }
        dto.apply {
            name?.let {
                faculty.name = it
            }

            universityId?.let {
                val university = universityRepository.findById(it).orElseThrow { Exception("District not by id: $id") }
                faculty.university = university
            }
        }
        facultyRepository.save(faculty)

    }

    override fun getAll() = facultyRepository.findAll().map { FacultyResponseDto.toDto(it) }
    override fun getOne(id: Long) = FacultyResponseDto.toDto(
        facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") })


}