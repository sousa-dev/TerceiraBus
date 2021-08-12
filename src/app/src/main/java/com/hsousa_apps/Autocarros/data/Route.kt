package com.hsousa_apps.Autocarros.data

class Route constructor(val id: String, val stops: Map<Stop, List<String>>, val day: TypeOfDay, val company: Int) {
    private var allStops: List<Stop> = stops.keys.toList()
    private var origin: Stop? = allStops[0]
    private var destination: Stop? = allStops[allStops.size - 1]

    fun getStopTime(stop: Stop?, position: Int): String? {
        return stops[stop]?.get(position)
    }

    fun getTimeIdx(times: List<String>, time: String?): Int {
        for (i in times.indices)
            if (times[i] == time) return i
        return -1
    }

    fun getStopIdx(stop: Stop?): Int {
        var i : Int = 0
        for (st in stops.keys)
            if (st == stop) return i
            else i++
        return -1
    }

    fun getOrigin(): Stop? {
        return origin
    }

    fun getDestination(): Stop? {
        return destination
    }

    fun getNStops(stop: Stop?): Int? {
        return stops[stop]?.size
    }
}