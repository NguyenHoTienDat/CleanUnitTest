package com.example.framgianguyenhotiendat.cleanunittest.base

import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToDomain(item: MI): M

    fun mapToPresentation(model: M): MI

    fun mapListToDomain(items: List<MI>): List<M>

    fun mapListToPresentation(models: List<M>): List<MI>
}
