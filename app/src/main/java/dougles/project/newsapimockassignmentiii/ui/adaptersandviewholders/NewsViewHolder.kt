package dougles.project.newsapimockassignmentiii.ui.adaptersandviewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.headline_layout.view.*

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(news: NewsEntity) {
        itemView.apply {
            Glide.with(context).load(news.imageUrl).into(ivHeadLineImage)
            tvHeadline.text = news.headLine
            tvSource.text = news.source
            tvPublishedAt.text = news.date
        }
    }

}
