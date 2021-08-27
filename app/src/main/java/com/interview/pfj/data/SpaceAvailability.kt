package com.interview.pfj.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceAvailability(
    @SerialName("LocationID")
    val locationId: Int,
    @SerialName("ItemID")
    val itemId: Int,
    @SerialName("Description")
    val description: String,
    @SerialName("Total")
    val total: Int,
    @SerialName("Booked")
    val booked: Int,
    @SerialName("Available")
    val available: Int,
    @SerialName("Price")
    val price: Int,
)
