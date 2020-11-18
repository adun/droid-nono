package com.example.golfcoursesinamap

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer


class GolfCourseMarkerClusterRenderer(
    context: Context?,
    map: GoogleMap?,
    clusterManager: ClusterManager<GolfCourseItem>?
) : DefaultClusterRenderer<GolfCourseItem>(context, map, clusterManager) {

    override fun onBeforeClusterItemRendered(item: GolfCourseItem, markerOptions: MarkerOptions) { // 5
        val icon = BitmapDescriptorFactory.defaultMarker(
            MapsActivity.courseTypes.getOrDefault(item.getGolfCourseType(), BitmapDescriptorFactory.HUE_RED)
        )
        markerOptions.icon(icon)
        markerOptions.title(item.getTitle())
        markerOptions
    }

    override fun onClusterItemRendered(clusterItem: GolfCourseItem, marker: Marker) {
        super.onClusterItemRendered(clusterItem, marker)
        marker.tag = clusterItem.getGolfCourseDetails()
    }
}
