package com.simulated.data_common.mapper

interface Mapper<E, D> {
    fun mapFrom(entity: E): D
    fun mapTo(domainModel: D): E
}