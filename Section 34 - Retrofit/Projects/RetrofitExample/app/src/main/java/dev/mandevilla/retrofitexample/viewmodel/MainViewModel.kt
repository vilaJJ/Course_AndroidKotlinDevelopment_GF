package dev.mandevilla.retrofitexample.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import dev.mandevilla.retrofitexample.client.JsonPlaceHolderClient
import dev.mandevilla.retrofitexample.model.CommentEntity
import dev.mandevilla.retrofitexample.model.PostEntity
import dev.mandevilla.retrofitexample.service.CommentService
import dev.mandevilla.retrofitexample.service.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val application: Application) : AndroidViewModel(application) {
    private val commentService = JsonPlaceHolderClient.createService(CommentService::class.java)
    private val postService = JsonPlaceHolderClient.createService(PostService::class.java)

    fun getData() {
        with(postService.getList()) {
            enqueue(object : Callback<List<PostEntity>> {
                override fun onResponse(
                    call: Call<List<PostEntity>>,
                    response: Response<List<PostEntity>>
                ) {
                    val result = response.body()
                    val listCount = result?.count() ?: 0

                    showToast("$listCount post(s)")
                }

                override fun onFailure(call: Call<List<PostEntity>>, ex: Throwable) {
                    showToast(ex.message ?: "Error")
                }
            })
        }

        with(commentService.getList()) {
            enqueue(object : Callback<List<CommentEntity>> {
                override fun onResponse(
                    call: Call<List<CommentEntity>>,
                    response: Response<List<CommentEntity>>
                ) {
                    val result = response.body()
                    val listCount = result?.count() ?: 0

                    showToast("$listCount comment(s)")
                }

                override fun onFailure(call: Call<List<CommentEntity>>, ex: Throwable) {
                    showToast(ex.message ?: "Error")
                }

            })
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }
}