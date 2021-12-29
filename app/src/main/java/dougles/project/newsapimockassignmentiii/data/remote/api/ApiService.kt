package dougles.project.newsapimockassignmentiii.data.remote.api

import dougles.project.newsapimockassignmentiii.data.remote.model.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getAllNews(
        @Query("q") q:String,
        @Query("apiKey") apiKey: String
    ):Response<ResponseDTO>

}
