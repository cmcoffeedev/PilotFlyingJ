package com.interview.pfj.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PFJLocation(
    @SerialName("StoreNo")
    val storeNum: Int,
    @SerialName("StoreName")
    val storeName: String,
    @SerialName("City")
    val city: String,
    @SerialName("State")
    val state: String,
    @SerialName("Address")
    val address: String,
    @SerialName("AddressTwo")
    val addressTwo: String? = "",
    @SerialName("ZipCode")
    val zipCode: String,
    @SerialName("Country")
    val country: String,
    @SerialName("Interstate")
    val interstate: String,
    @SerialName("StoreFrontBrand")
    val storeFrontBrand: String? = "",
    @SerialName("Phone")
    val phone: String,
    @SerialName("Area")
    val area: String? = "",
    @SerialName("StoreType")
    val storeType: String? = "",
    @SerialName("Latitude")
    val latitude: Double,
    @SerialName("Longitude")
    val longitude: Double,
    @SerialName("SpaceAvailability")
    val spaceAvailability: List<SpaceAvailability>,
)
