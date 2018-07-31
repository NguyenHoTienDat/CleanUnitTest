package com.example.framgianguyenhotiendat.cleanunittest.data.model

import com.example.framgianguyenhotiendat.cleanunittest.data.base.EntityMapper
import com.example.framgianguyenhotiendat.cleanunittest.data.base.ModelEntity
import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Story
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class StoryEntity(
        @SerializedName("section")
        var section: String = "",
        @SerializedName("subsection")
        var subsection: String = "",
        @SerializedName("title")
        var title: String = "",
        @SerializedName("abstract")
        var _abstract: String = "",
        @SerializedName("url")
        var url: String = "",
        @SerializedName("byline")
        var byline: String = "",
        @SerializedName("item_type")
        var itemType: String = "",
        @SerializedName("updated_date")
        var updatedDate: String = "",
        @SerializedName("created_date")
        var createdDate: String = "",
        @SerializedName("published_date")
        var publishedDate: String = "",
        @SerializedName("material_type_facet")
        var materialTypeFacet: String = "",
        @SerializedName("kicker")
        var kicker: String = "",
        @SerializedName("des_facet")
        var desFacet: List<String> = mutableListOf(),
        @SerializedName("org_facet")
        var orgFacet: List<String> = mutableListOf(),
        @SerializedName("multimedia")
        var multimedia: List<MultimediumEntity> = mutableListOf(),
        @SerializedName("short_url")
        var shortUrl: String = ""
) : ModelEntity()

class StoryEntityMapper @Inject constructor() : EntityMapper<Story, StoryEntity> {

    override fun mapListToDomain(entities: List<StoryEntity>): List<Story> {
        val result = mutableListOf<Story>()
        for (storyEntity: StoryEntity in entities) {
            result.add(mapToDomain(storyEntity))
        }
        return result
    }

    override fun mapListToEntity(models: List<Story>): List<StoryEntity> {
        val result = mutableListOf<StoryEntity>()
        for (story: Story in models) {
            result.add(mapToEntity(story))
        }
        return result
    }

    override fun mapToDomain(entity: StoryEntity): Story = Story(name = entity.title)

    override fun mapToEntity(model: Story): StoryEntity = StoryEntity(title = model.name)
}
