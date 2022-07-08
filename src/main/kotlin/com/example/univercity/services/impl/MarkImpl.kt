//package com.example.univercity.services.impl
//
//import com.example.univercity.dtos.GroupCreateDto
//import com.example.univercity.dtos.GroupResponseDto
//import com.example.univercity.dtos.GroupUpdateDto
//import com.example.univercity.entities.Group
//import com.example.univercity.repositories.FacultyRepository
//import com.example.univercity.repositories.GroupRepository
//import com.example.univercity.services.GroupService
//import org.springframework.stereotype.Service
//
//
//@Service
//class MarkImpl(
//    private val markRepository: GroupRepository,
//    private val facultyRepository: FacultyRepository
//) : GroupService {
//
//
//    override fun create(dto: GroupCreateDto) {
//        dto.apply {
//            val faculty = facultyRepository.findById(facultyId).orElseThrow { Exception("Faculty not found by id: $facultyId") }
//            markRepository.save(Group(name, faculty,year))
//        }
//
//    }
//
//    override fun update(id: Long, dto: GroupUpdateDto) {
//        val mark = markRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") }
//        dto.apply {
//            name?.let {
//                mark.name = it
//            }
//
//            facultyId?.let {
//                val faculty = facultyRepository.findById(it).orElseThrow { Exception("Faculty not by id: $id") }
//                mark.faculty = faculty
//            }
//
//            year?.let {
//                mark.year = it
//            }
//        }
//        markRepository.save(mark)
//
//    }
//
//    override fun getAll() = markRepository.findAll().map { GroupResponseDto.toDto(it) }
//    override fun getOne(id: Long) = GroupResponseDto.toDto(
//        markRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") })
//
//
//}