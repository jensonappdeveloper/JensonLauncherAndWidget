package com.example.mylauncher.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class WeatherWorker  constructor(appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {
    val MY_KEY_DATA_FROM_WORKER = "MY_KEY_DATA_FROM_WORKER"

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val d = async {
                    delay(1000)
                    "hello"
                }
                val value = d.await()

                //val data: WeatherResponse = getWeatherData()
                checkfunction()
                Result.success()
            } catch (e: Exception) {
                Log.d("MyWorker", "exception in doWork ${e.message}")
                Result.failure()
            }
        }
    }

    private fun checkfunction() {

        /*viewModelScope.launch {
            withContext(dispatcherProvider.heavyTasks) {
                val multipleIds = listOf(1, 2, 3, 4, 5, ..)
                val content = arrayListOf<CustomObj>()

                coroutineScope {
                    multipleIds.forEach { id ->
                        launch { // this will allow us to run multiple tasks in parallel
                            val apiResponse = api.get(id)
                            if (apiResponse.isSuccessful()) {
                                content.find { it.id == id }.enable = true
                            }
                        }
                    }
                }  // coroutineScope block will wait here until all child tasks are completed

                liveData.postValue(content)
            }
        }*/
    }

    private suspend fun getWeatherData() {
       /* CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit().create(ApiService::class.java).getFactsByNumber("dogs?number=$number")
            val the_facts = call.body()

            runOnUiThread {
                if(call.isSuccessful){
                    val factsData = the_facts?.fact ?: emptyList()
                    facts.clear()
                    facts.addAll(factsData)
                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(binding.btnGo.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }*/

    }



}