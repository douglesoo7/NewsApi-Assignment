package dougles.project.newsapimockassignmentiii.ui.adaptersandviewholders

import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity

interface NewsItemClickListener {
    fun newsItemClicked(news:NewsEntity)
}