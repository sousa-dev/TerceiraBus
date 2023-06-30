DAY_DICT = {'weekdays': 'WEEKDAY', 'sabado': 'SATURDAY', 'domingo': 'SUNDAY'} 
ALL_STOPS = []  
id = 0
for type_of_day in ['weekdays', 'sabado', 'domingo']:
    with open(f"kt/paragens_{type_of_day}.kt", 'w') as w:
        with open("resources/paragens_tempos_"+type_of_day, 'r') as f:
            print("Converting paragens_tempos_"+type_of_day+" to kt")
            for line in f:
                stops=[]
                times=[]
                line = line.strip()
                if line == "":
                    continue
                line = line.split(';')
                for paragem in line:
                    if paragem == "":
                        continue
                    paragem_tempo = paragem.split(':')
                    paragem = paragem_tempo[0]
                    if paragem not in ALL_STOPS:
                        ALL_STOPS.append(paragem)
                    tempo = paragem_tempo[1:]
                    tempo = 'h'.join(tempo)
                    stops.append(paragem)
                    times.append(tempo)
                stops = ', '.join(["\""+stop+"\"" for stop in stops]) 
                times = ', '.join(["\""+time+"\"" for time in times])
                w.write(f"loadFromAPI({id}, \"{id}\", listOf({stops}), listOf({times}), '{DAY_DICT[type_of_day]}', null)\n")
                id += 1  
ALL_STOPS = set(ALL_STOPS)
print(ALL_STOPS)
with open("kt/stops.kt", 'w') as w:
    for stop in ALL_STOPS:
        w.write(f"Stop(\"{stop}\", Location(0.0, 0.0))\n")


# fun loadFromAPI(id: Int, route: String, stops: JSONArray, times: JSONArray, type_of_day: String, information: String){
#         var day: TypeOfDay = TypeOfDay.WEEKDAY
#         when (type_of_day) {
#             "WEEKDAY" -> {
#                 day = TypeOfDay.WEEKDAY
#             }
#             "SATURDAY" -> {
#                 day = TypeOfDay.SATURDAY
#             }
#             "SUNDAY" -> {
#                 day = TypeOfDay.SUNDAY
#             }
#         }
        
#         var info: JSONObject? = null
#         if (information != "None") info = JSONObject(information)
#         if (info == null) {
#             info = JSONObject("{'pt': '', 'en': '', 'es': '', 'fr': '', 'de': ''}")
#         }

#         var img: Int? = null
#         if (route.startsWith("1")) img = R.drawable.crp_logo
#         else if (route.startsWith("2")) img = R.drawable.avm_logo
#         else if (route.startsWith("3")) img = R.drawable.varela_logo


#         var stop_times: MutableMap<Stop, List<String>> = mutableMapOf()
#         for (i in 0 until stops.length()) stop_times[getStop(stops.getString(i))] = listOf<String>(times.getString(i))

#         val trip: Route? = img?.let {
#             Route(
#                 route, id.toString(), stop_times, day, it, info?.getString(currentLanguage)
#             )
#         }

#         if (trip != null) {
#             allRoutes.add(trip)
#         }
#     }