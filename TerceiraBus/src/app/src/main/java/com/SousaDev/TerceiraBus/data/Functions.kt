package com.SousaDev.TerceiraBus.data

import android.util.Log


class Functions {

    fun getOptions(origin: String, destination: String, TypeOfDay: TypeOfDay = com.SousaDev.TerceiraBus.data.TypeOfDay.WEEKDAY): ArrayList<Route>{
        val ret: MutableList<Route> = mutableListOf()
        val originStop: Stop = Datasource().getStop(origin)
        val destinationStop: Stop = Datasource().getStop(destination)
        for (route in Datasource().getAllRoutes())
            if(route.stops.containsKey(originStop) and route.stops.containsKey(destinationStop) and (route.getStopIdx(originStop) < route.getStopIdx(destinationStop)) and (route.day == TypeOfDay))
                ret.add(route)
        return ret as ArrayList<Route>
    }

    fun removeFav(lang: String): String {
        if (lang == "pt")
            return "Rota Removida dos Favoritos!"
        else if (lang == "de")
            return "Route aus Favoriten entfernt!"
        else if (lang == "fr")
            return "Itinéraire supprimé des favoris!"
        else if (lang == "es")
            return "¡Ruta eliminada de favoritos!"
        return "Route Removed from Favorites!"
    }

    fun onlyWednesday(lang: String): String {
        if (lang == "pt")
            return "Só à Quarta em Período Escolar"
        else if (lang == "de")
            return "Nur mittwochs in der Schulzeit"
        else if (lang == "fr")
            return "Uniquement le mercredi en période scolaire"
        else if (lang == "es")
            return "Solo los miércoles en horario escolar"
        return "Only on Wednesdays in School Time"
    }

    fun getStopRoutes(stop: String): ArrayList<Route>{
        val ret: MutableList<Route> = mutableListOf()
        val getStop: Stop = Datasource().getStop(stop)
        for (route in Datasource().getAllRoutes())
           if (route.stops.containsKey(getStop)) ret.add(route)
        return ret as ArrayList<Route>
    }
}
