package dougles.project.newsapimockassignmentiii.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dougles.project.newsapimockassignmentiii.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository):ViewModel() {

    fun getDataFromApi(){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getDataFromApi()
        }
    }

    fun getDataFromDb() = newsRepository.getDataFromDb()

}