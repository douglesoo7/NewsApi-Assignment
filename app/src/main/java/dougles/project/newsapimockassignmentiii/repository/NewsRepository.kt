package dougles.project.newsapimockassignmentiii.repository

import android.content.Context
import dougles.project.newsapimockassignmentiii.data.local.NewsDatabase
import dougles.project.newsapimockassignmentiii.data.remote.model.ResponseDTO
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity
import dougles.project.newsapimockassignmentiii.data.remote.api.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsRepository(context: Context) {
    private val apiService = Network().getApiService()
    private val newsDao = NewsDatabase.getInstanceOfNewsDatabase(context).getNewsDao()

    suspend fun getDataFromApi() {
        val response = apiService.getAllNews("india", "0a997988c00c4bd3af9aa139bf1ac083")
        if (response.body() != null) {
            storeDataInDatabase(response.body()!!)
        }
    }

    private fun storeDataInDatabase(responseDTO: ResponseDTO) {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.deleteAllDataFromDb()
            val newsList = mutableListOf<NewsEntity>()
            responseDTO.articles?.forEach {
                val news = NewsEntity(
                    it?.title.toString(),
                    it?.description.toString(),
                    it?.urlToImage.toString(),
                    it?.publishedAt.toString(),
                    it?.source?.name.toString()
                )
                newsList.add(news)
            }
            newsDao.insertAll(newsList)
        }
    }

    fun getDataFromDb() = newsDao.getDataFromDb()

}