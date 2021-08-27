package com.interview.pfj.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.interview.pfj.api.LocationService
import com.interview.pfj.repositories.LocationRepo
import com.interview.pfj.testutility.CoroutineTestRule
import com.interview.pfj.testutility.MockFileReader
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import retrofit2.Retrofit

@RunWith(AndroidJUnit4::class)
class PFJAPITest {

    private lateinit var mLocationRepo: LocationRepo


    private val mMockWebServer = MockWebServer()


    private val contentType =  "application/json".toMediaType()

    private val json = Json { coerceInputValues = true }

    private val mApi = Retrofit.Builder()
        .baseUrl(mMockWebServer.url("/"))
        .addConverterFactory(json.asConverterFactory(contentType)).build().create(LocationService::class.java)



    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRules = CoroutineTestRule()


    @Before
    fun setup() {
        mLocationRepo = LocationRepo(mApi)
    }

    @After
    fun cleanUp() {
        mMockWebServer.shutdown()
    }


    @ExperimentalCoroutinesApi
    @Test
    fun testSuccessfulRepositoryResponse()  {
        mMockWebServer.apply {
            enqueue(MockResponse().setBody(MockFileReader("locations.json").getFakeJsonResponse()))
        }

        val response = runBlocking{ mLocationRepo.getAllLocations()}

        Assert.assertNotNull(response)
        Assert.assertEquals(response.size, 345 )

    }


    @ExperimentalCoroutinesApi
    @Test
    fun testTenLocations()  {
        mMockWebServer.apply {
            enqueue(MockResponse().setBody(MockFileReader("locations_10.json").getFakeJsonResponse()))
        }

        val response = runBlocking{ mLocationRepo.getAllLocations()}

        print(response.size)
        Assert.assertNotNull(response)
        Assert.assertEquals(response.size, 10 )

    }




}