package dougles.project.newsapimockassignmentiii.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import dougles.project.newsapimockassignmentiii.R
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.activity_news_details.view.*

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        setData()

    }


    private fun setData() {
        val headLine = intent.getStringExtra("headline")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")
        val source = intent.getStringExtra("source")
        val published = intent.getStringExtra("published")

        tvHeadline.text = headLine
        tvDescription.text = description
        tvPublishedAt.text = published
        Glide.with(this).load(imageUrl).into(ivImage)
        tvSource.text = source
    }
}