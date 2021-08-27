package com.interview.pfj.repositories

import com.interview.pfj.api.LocationService
import com.interview.pfj.data.PFJLocation
import javax.inject.Inject

class LocationRepo @Inject constructor(private val service: LocationService) {

    suspend fun getAllLocations(): List<PFJLocation> {
        return service.getLocations()
    }

}