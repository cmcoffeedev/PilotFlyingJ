package com.interview.pfj.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.pfj.data.PFJLocation
import com.interview.pfj.repositories.LocationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LocationViewModel"


@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: LocationRepo): ViewModel() {


    private var mLocations = MutableLiveData<List<PFJLocation>>()
    private var mJob: Job? = null

    init {
        getLocationData()
    }

    private fun getLocationData() {
        mJob = viewModelScope.launch(Dispatchers.IO) {
            try {
               val locations =  repository.getAllLocations()
                mLocations.postValue(locations)
            } catch (e: Exception) {
                Log.e(TAG, "getLocationData: ${e.message}")
            }

        }
    }


    fun locations() = mLocations

    override fun onCleared() {
        super.onCleared()
        mJob?.cancel()
    }

}