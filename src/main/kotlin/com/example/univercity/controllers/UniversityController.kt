package com.example.univercity.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("univercity")
class UnivercityController(


) {

    @PostMapping("create")
    fun create(@RequestBody dto: CompanyCreateDto) = companyService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: CompanyUpdateDto) = companyService.update(id, dto)

    @GetMapping
    fun getAll() = companyService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = companyService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = companyService.delete(id)
}