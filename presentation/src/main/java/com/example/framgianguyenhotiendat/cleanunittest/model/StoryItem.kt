package com.example.framgianguyenhotiendat.cleanunittest.model

import com.example.framgianguyenhotiendat.cleanunittest.base.ItemMapper
import com.example.framgianguyenhotiendat.cleanunittest.base.ModelItem
import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Story
import javax.inject.Inject

data class StoryItem(val name: String) : ModelItem()

class StoryItemMapper @Inject constructor() : ItemMapper<Story, StoryItem> {

    override fun mapToDomain(item: StoryItem): Story = Story(name = item.name)

    override fun mapToPresentation(model: Story): StoryItem = StoryItem(model.name)

    override fun mapListToDomain(items: List<StoryItem>): List<Story> {
        val result = mutableListOf<Story>()
        for (storyItem: StoryItem in items) {
            result.add(mapToDomain(storyItem))
        }
        return result
    }

    override fun mapListToPresentation(models: List<Story>): List<StoryItem> {
        val result = mutableListOf<StoryItem>()
        for (story: Story in models) {
            result.add(mapToPresentation(story))
        }
        return result
    }

}