package com.jet2.travel.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jet2.travel.R
import com.jet2.travel.model.Blogs
import com.jet2.travel.ui.adapter.RecyclerAdapter
import com.jet2.travel.ui.viewmodel.MainStateEvent
import com.jet2.travel.ui.viewmodel.MainViewModel
import com.jet2.travel.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvent)
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Blogs>> -> {
                    displayProgressBar(false)
                    displayList(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayList(data: List<Blogs>) {
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = RecyclerAdapter(data)
        val dividerItemDecoration = DividerItemDecoration(applicationContext, linearLayoutManager.orientation)
        recycler_view.addItemDecoration(dividerItemDecoration)
    }

    private fun displayError(message: String?) {
        Snackbar.make(progress, message ?: "Unknown Error", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress.visibility = if(isDisplayed) View.VISIBLE else View.INVISIBLE
    }
}