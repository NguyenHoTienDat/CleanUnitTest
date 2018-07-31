package com.example.framgianguyenhotiendat.cleanunittest.data.base

import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Model

interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME

    fun mapListToDomain(entities: List<ME>): List<M>

    fun mapListToEntity(models: List<M>): List<ME>
}
