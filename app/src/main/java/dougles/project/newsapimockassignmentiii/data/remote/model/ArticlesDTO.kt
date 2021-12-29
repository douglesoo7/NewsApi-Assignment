package dougles.project.newsapimockassignmentiii.data.remote.model

data class ArticlesDTO(
    val source: SourceDTO? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
)