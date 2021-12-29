package dougles.project.newsapimockassignmentiii.data.remote.model

data class ResponseDTO(
	val status: String? = null,
	val totalResults: Int? = null,
	val articles: List<ArticlesDTO?>? = null
)