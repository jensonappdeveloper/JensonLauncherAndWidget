package com.example.mylauncher.viewmodel

import android.content.ComponentName
import androidx.lifecycle.*
import androidx.work.*
import androidx.work.multiprocess.RemoteListenableWorker.ARGUMENT_CLASS_NAME
import androidx.work.multiprocess.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME
import androidx.work.multiprocess.RemoteWorkerService
import com.example.mylauncher.data.WeatherCities
import com.example.mylauncher.model.WeatherResponse
import com.example.mylauncher.repository.MainRepository
import com.example.mylauncher.resource.ApiState
import com.example.mylauncher.worker.WeatherWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class WeatherViewmodel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _weatherResponse: MutableLiveData<ApiState<WeatherResponse>> = MutableLiveData()

    val PACKAGE_NAME = "com.example.background.multiprocess"


    val serviceName = RemoteWorkerService::class.java.name
    val componentName = ComponentName(PACKAGE_NAME, serviceName)

    val oneTimeWorkRequest = buildOneTimeWorkRemoteWorkRequest(
        componentName,
        WeatherWorker::class.java
    )
    workManager?.enqueue(oneTimeWorkRequest)


}

    private fun buildOneTimeWorkRemoteWorkRequest(componentName: ComponentName, java: Class<WeatherWorker>) : OneTimeWorkRequest {

        // ARGUMENT_PACKAGE_NAME and ARGUMENT_CLASS_NAME are used to determine the service
        // that a Worker binds to. By specifying these parameters, we can designate the process a
        // Worker runs in.
        val data: Data = Data.Builder()
            .putString(ARGUMENT_PACKAGE_NAME, componentName.packageName)
            .putString(ARGUMENT_CLASS_NAME, componentName.className)
            .build()

        return OneTimeWorkRequest.Builder(listenableWorkerClass)
            .setInputData(data)
            .build()
    }




      private fun getData() = Data.Builder().putInt("CITY_ID", WeatherCities.randomCitiesId()).build()

      // Work using coroutines
      private val coroutinesWork = PeriodicWorkRequestBuilder<WeatherWorker>(15, TimeUnit.MINUTES)
          .setInputData(getData())
          .build()


    private val workManager = WorkManager.getInstance()


      val request = OneTimeWorkRequestBuilder()
          .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
          .build()


    return OneTimeWorkRequest.Builder(ExampleRemoteCoroutineWorker::class.java)
    .setInputData(data)
    .build()

      internal fun fetchTemperature(cityList: Array<String>) {

          cityList.forEach {

          }
          val weatherBuilder = OneTimeWorkRequestBuilder<WeatherWorker>()

          workRequest.enqueue(OneTimeWorkRequest.from(WeatherWorker::class.java))
      }







