package com.example.univercity.services.impl

import com.example.univercity.dtos.StudentCreateDto
import com.example.univercity.dtos.StudentResponseDto
import com.example.univercity.dtos.StudentUpdateDto
import com.example.univercity.entities.Student
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.repositories.StudentRepository
import com.example.univercity.services.StudentService
import org.springframework.stereotype.Service


@Service
class Studentmpl(
    private val subjectRepository: StudentRepository,
    private val facultyRepository: GroupRepository
) : StudentService {


    override fun create(dto: StudentCreateDto) {
        dto.apply {
            val faculty = facultyRepository.findById(facultyId).orElseThrow { Exception("Group not found by id: $facultyId") }
            subjectRepository.save(Student(name, faculty,year))
        }

    }

    override fun update(id: Long, dto: StudentUpdateDto) {
        val subject = subjectRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") }
        dto.apply {
            name?.let {
                subject.name = it
            }

            facultyId?.let {
                val faculty = facultyRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                subject.faculty = faculty
            }

            year?.let {
                subject.year = it
            }
        }
        subjectRepository.save(subject)

    }

    override fun getAll() = subjectRepository.findAll().map { StudentResponseDto.toDto(it) }
    override fun getOne(id: Long) = StudentResponseDto.toDto(
        subjectRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") })


}