package dougles.project.newsapimockassignmentiii.ui.adaptersandviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dougles.project.newsapimockassignmentiii.R
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity

class NewsAdapter(
    private val newsList: List<NewsEntity>,
    private val newsItemClickListener: NewsItemClickListener
) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.headline_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.setData(news)
        holder.itemView.setOnClickListener {
            newsItemClickListener.newsItemClicked(news)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}