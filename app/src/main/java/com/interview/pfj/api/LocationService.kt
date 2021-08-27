package com.interview.pfj.api

import com.interview.pfj.data.PFJLocation
import com.interview.pfj.utils.PFJConstants
import retrofit2.http.GET

interface LocationService {
    @GET(PFJConstants.LOCATIONS)
    suspend fun getLocations():List<PFJLocation>
}