package com.example.golfcoursesinamap

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem


class GolfCourseItem(
    lat: Double,
    lng: Double,
    title: String,
    snippet: String,
    golfCourseType: String,
    address: String,
    phone: String,
    email: String,
    webUrl: String
) : ClusterItem {

    private val position: LatLng
    private val title: String
    private val snippet: String
    private val golfCourseType: String
    private val address: String
    private val phone: String
    private val email: String
    private val webUrl: String

    override fun getPosition(): LatLng {
        return position
    }

    override fun getTitle(): String? {
        return title
    }

    override fun getSnippet(): String? {
        return snippet
    }

    fun getGolfCourseType(): String {
        return golfCourseType
    }

    fun getGolfCourseDetails(): List<String> {
        return listOf(address, phone, email, webUrl)
    }

    init {
        position = LatLng(lat, lng)
        this.title = title
        this.snippet = snippet
        this.golfCourseType = golfCourseType
        this.address = address
        this.phone = phone
        this.email = email
        this.webUrl = webUrl
    }
}
