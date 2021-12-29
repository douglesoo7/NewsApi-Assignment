package dougles.project.newsapimockassignmentiii.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dougles.project.newsapimockassignmentiii.R
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity
import dougles.project.newsapimockassignmentiii.repository.NewsRepository
import dougles.project.newsapimockassignmentiii.ui.adaptersandviewholders.NewsAdapter
import dougles.project.newsapimockassignmentiii.ui.adaptersandviewholders.NewsItemClickListener
import dougles.project.newsapimockassignmentiii.viewmodel.NewsViewModel
import dougles.project.newsapimockassignmentiii.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClickListener {

    private lateinit var mNewsAdapter: NewsAdapter
    private lateinit var mNewsViewModel: NewsViewModel
    lateinit var mNewsRepository: NewsRepository
    var newsList = mutableListOf<NewsEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNewsRepository = NewsRepository(this)

        val newsViewModelFactory = NewsViewModelFactory(mNewsRepository)

        mNewsViewModel =
            ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)

        if (isInternetActive()) {
            mNewsViewModel.getDataFromApi()
        }

        mNewsViewModel.getDataFromDb().observe(this, Observer {
            newsList = it as MutableList<NewsEntity>
            setRecyclerView()
        })


        refreshLayout.setOnRefreshListener {
            progressBar.visibility = View.VISIBLE
            if (isInternetActive()) {
                mNewsViewModel.getDataFromApi()
                refreshLayout.isRefreshing = false
                Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show()
                mNewsAdapter.notifyDataSetChanged()

            }
            progressBar.visibility = View.GONE
        }
    }

    private fun setRecyclerView() {
        mNewsAdapter = NewsAdapter(newsList, this)
        recyclerView.adapter = mNewsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private fun isInternetActive(): Boolean {

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)?.state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)?.state == NetworkInfo.State.CONNECTED
    }

    override fun newsItemClicked(news: NewsEntity) {
        val intent = Intent(this, NewsDetailsActivity::class.java)
        intent.putExtra("headline", news.headLine)
        intent.putExtra("description", news.description)
        intent.putExtra("imageUrl", news.imageUrl)
        intent.putExtra("source", news.source)
        intent.putExtra("published", news.date)
        startActivity(intent)
    }
}