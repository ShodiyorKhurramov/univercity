package com.example.univercity.services.impl

import com.example.univercity.dtos.JournalCreateDto
import com.example.univercity.dtos.JournalResponseDto
import com.example.univercity.dtos.JournalUpdateDto
import com.example.univercity.entities.Journal
import com.example.univercity.repositories.FacultyRepository
import com.example.univercity.repositories.JournalRepository
import com.example.univercity.services.JournalService
import org.springframework.stereotype.Service


@Service
class JournalImpl(
    private val journalRepository: JournalRepository,
    private val facultyRepository: FacultyRepository
) : JournalService {


    override fun create(dto: JournalCreateDto) {
        dto.apply {
            val faculty = facultyRepository.findById(facultyId).orElseThrow { Exception("Faculty not found by id: $facultyId") }
            journalRepository.save(Journal(name, faculty,year))
        }

    }

    override fun update(id: Long, dto: JournalUpdateDto) {
        val journal = journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") }
        dto.apply {
            name?.let {
                journal.name = it
            }

            facultyId?.let {
                val faculty = facultyRepository.findById(it).orElseThrow { Exception("Faculty not by id: $id") }
                journal.faculty = faculty
            }

            year?.let {
                journal.year = it
            }
        }
        journalRepository.save(journal)

    }

    override fun getAll() = journalRepository.findAll().map { JournalResponseDto.toDto(it) }
    override fun getOne(id: Long) = JournalResponseDto.toDto(
        journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") })


}