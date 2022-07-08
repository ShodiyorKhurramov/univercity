package com.example.univercity.dtos

import com.example.univercity.entities.Univercity

data class UnivercityCreateDto(
    var name:String,
    var address:String,
    var openYear:Int

)

data class UnivercityUpdateDto(
    var name:String?,
    var address:String?,
    var openYear:Int?
)

data class UnivercityResponseDto(
    var id:Long?,
    var name:String?,
    var address:String?,
    var openYear:Int?
) {
    companion object {
        fun toDto(r: Univercity) = r.run {
            UnivercityResponseDto(id,name,address,openYear)
        }
    }
}
