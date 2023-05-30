package com.SousaDev.TerceiraBus.data

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.fragments.HomeFragment
import java.lang.Exception

var allRoutes: ArrayList<Route> = arrayListOf()
var stops: ArrayList<Stop> = arrayListOf()
var correspondence: MutableMap<Stop, MutableList<Stop>> = mutableMapOf()

var favorite: MutableList<List<String>> = mutableListOf()
var currentLanguage: String = "pt"
var loaded: Boolean = false
var routeHash: HashMap<String, Route> = hashMapOf()


class Datasource {

    fun load() {
        loadStops()

        loadRoutes()

        //setCorrespondence()
    }

    private fun loadStops(){
        Stop("Hospital", Location(0.0, 0.0))
        Stop("Praça Almeida Garrett", Location(0.0, 0.0))
        Stop("Praça Velha", Location(0.0, 0.0))
        Stop("Jardim", Location(0.0, 0.0))
        Stop("Bailão", Location(0.0, 0.0))
        Stop("Aeroporto", Location(0.0, 0.0))
        Stop("Praia da Vitória", Location(0.0, 0.0))
        Stop("Angra do Heroísmo", Location(0.0, 0.0))
        Stop("Av. Álvaro Martins Homem", Location(0.0, 0.0))
        Stop("Santo Amaro", Location(0.0, 0.0))
        Stop("Largo da Cruz", Location(0.0, 0.0))
        Stop("Feteira - Igreja", Location(0.0, 0.0))
        Stop("Ribeira do Testo", Location(0.0, 0.0))
        Stop("Praça da Vila de São Sebastião", Location(0.0, 0.0))
        Stop("Ribeira Seca", Location(0.0, 0.0))
        Stop("Fonte Bastardo - Império", Location(0.0, 0.0))
        Stop("Cabo da Praia - Igreja", Location(0.0, 0.0))
        Stop("Porto Martins - Igreja", Location(0.0, 0.0))
        Stop("Ladeira Grande - Império", Location(0.0, 0.0))
        Stop("Raminho", Location(0.0, 0.0))
        Stop("Altares - Igreja", Location(0.0, 0.0))
        Stop("Biscoitos", Location(0.0, 0.0))
        Stop("Quatro Ribeiras - Igreja", Location(0.0, 0.0))
        Stop("Agualva - Igreja", Location(0.0, 0.0))
        Stop("Vila Nova - Praça", Location(0.0, 0.0))
        Stop("Lajes - Igreja", Location(0.0, 0.0))
        Stop("Posto 1", Location(0.0, 0.0))
        Stop("Lar de Idosos", Location(0.0, 0.0))
        Stop("Canada da Fontainha", Location(0.0, 0.0))
        Stop("Quatro Canadas", Location(0.0, 0.0))
        Stop("Álamos Bravos", Location(0.0, 0.0))

        Stop("Jardim Duque da Terceira", Location(0.0, 0.0))
        Stop("Alto das Covas", Location(0.0, 0.0))
        Stop("Canada de Belém", Location(0.0, 0.0))
        Stop("Terra Alta", Location(0.0, 0.0))
        Stop("Sao Bartolomeu - Igreja", Location(0.0, 0.0))
        Stop("Sao Bartolomeu - Igreja 2", Location(0.0, 0.0))
        Stop("Cruz das Cinco", Location(0.0, 0.0))
        Stop("Regatos", Location(0.0, 0.0))
        Stop("Portoes de São Pedro", Location(0.0, 0.0))

    }

    private fun loadRoutes(){
        val img: Int = R.drawable.evt_logo
        /* Route 02 */
        var route = "02"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Praça Almeida Garrett") to listOf("06h16", "07h01", "08h01", "09h01", "10h01", "11h01", "12h01", "13h01", "14h01", "15h01", "16h01", "17h01", "18h01", "19h01"),
                        getStop("Av. Álvaro Martins Homem") to listOf("06h20", "07h05", "08h05", "09h04", "10h05", "11h05", "12h05", "13h04", "14h05", "15h04", "16h05", "17h05", "18h05", "19h05"),
                        getStop("Santo Amaro") to listOf("06h25", "07h10", "08h10", "09h08", "10h10", "11h10", "12h10", "13h08", "14h10", "15h08", "16h10", "17h10", "18h10", "19h10"),
                        getStop("Feteira - Igreja") to listOf("06h30", "07h15", "08h15", "09h13", "10h15", "11h15", "12h15", "13h10", "14h15", "15h13", "16h15", "17h15", "18h15", "19h15"),
                        getStop("Ribeira do Testo") to listOf("06h35", "07h20", "08h20", "09h18", "10h20", "11h20", "12h20", "13h12", "14h20", "15h18", "16h20", "17h20", "18h20", "19h20"),
                        getStop("Largo da Cruz") to listOf("---", "---", "---", "---", "---", "---", "---", "13h14", "---", "---", "---", "---", "---", "---"),
                        getStop("Praça da Vila de São Sebastião") to  listOf("06h40", "07h25", "08h25", "09h25", "10h25", "11h25", "12h25", "13h25", "14h25", "15h25", "16h25", "17h25", "18h25", "19h25"),
                        getStop("Ribeira Seca") to listOf("06h42", "07h27", "08h27", "09h27", "10h27", "11h27", "12h27", "13h27", "14h27", "15h27", "16h27", "17h27", "18h27", "19h27"),
                        getStop("Fonte Bastardo - Império") to listOf("06h47", "07h32", "08h32", "09h32", "10h32", "11h32", "12h32", "13h32", "14h32", "15h32", "16h32", "17h32", "18h32", "19h32"),
                        getStop("Cabo da Praia - Igreja") to listOf("06h52", "07h37", "08h37", "---", "10h37", "11h37", "12h37", "13h37", "14h37", "---", "16h37", "17h37", "18h37", "19h37"),
                        getStop("Álamos Bravos") to listOf("---", "---", "---", "09h37", "---", "---", "---", "---", "---", "15h37", "---", "---", "---", "---"),
                        getStop("Praia da Vitória") to listOf("07h05", "07h50", "08h50", "09h50", "10h50", "11h50", "12h50", "13h50", "14h50", "15h50", "16h50", "17h50", "18h50", "19h50"),
                        ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hiv", mapOf(
                        getStop("Praia da Vitória") to listOf("06h00", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Álamos Bravos") to listOf("---", "---", "---", "---", "---", "---", "---", "---", "16h10", "---", "---", "---", "---", "---"),
                        getStop("Cabo da Praia - Igreja") to listOf("06h10", "07h10", "08h10", "09h10", "10h10", "11h10", "12h10", "13h10", "14h05", "15h10", "---", "17h10", "18h10", "19h10"),
                        getStop("Fonte Bastardo - Império") to listOf("06h15", "07h20", "08h20", "09h20", "10h20", "11h20", "12h20", "13h20", "14h15", "15h20", "16h18", "17h20", "18h20", "19h20"),
                        getStop("Ribeira Seca") to listOf("06h20", "07h23", "08h23", "09h23", "10h23", "11h23", "12h23", "13h23", "14h18", "15h23", "16h23", "17h23", "18h23", "19h23"),
                        getStop("Praça da Vila de São Sebastião") to  listOf("06h25", "07h25", "08h25", "09h25", "10h25", "11h25", "12h25", "13h25", "14h25", "15h25", "16h25", "17h25", "18h25", "19h25"),
                        getStop("Largo da Cruz") to listOf("06h32", "---", "---", "---", "---", "---", "---", "---", "14h29", "---", "---", "---", "---", "---"),
                        getStop("Ribeira do Testo") to listOf("06h40", "07h30", "08h30", "09h30", "10h30", "11h30", "12h30", "13h30", "14h37", "15h30", "16h30", "17h30", "18h30", "19h30"),
                        getStop("Feteira - Igreja") to listOf("06h42", "07h35", "08h35", "09h35", "10h35", "11h35", "12h35", "13h35", "14h42", "15h35", "16h35", "17h35", "18h35", "19h35"),
                        getStop("Ladeira Grande - Império") to listOf("06h45", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---"),
                        getStop("Santo Amaro") to listOf("06h47", "07h40", "08h40", "09h40", "10h40", "11h40", "12h40", "13h40", "14h45", "15h40", "16h42", "17h40", "18h40", "19h40"),
                        getStop("Praça Velha") to listOf("06h55", "07h50", "08h50", "09h50", "10h50", "11h50", "12h50", "13h50", "14h50", "15h50", "16h50", "17h50", "18h50", "19h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hsi", mapOf(
                        getStop("Praça Velha") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Praça Almeida Garrett") to listOf("06h16", "07h01", "08h01", "09h01", "10h01", "11h01", "12h01", "13h01", "14h01", "15h01", "16h01", "17h01", "18h01", "19h01"),
                        getStop("Av. Álvaro Martins Homem") to listOf("06h20", "07h05", "08h05", "09h04", "10h05", "11h05", "12h05", "13h04", "14h05", "15h04", "16h05", "17h05", "18h05", "19h05"),
                        getStop("Santo Amaro") to listOf("06h25", "07h10", "08h10", "09h08", "10h10", "11h10", "12h08", "13h10", "14h10", "15h08", "16h10", "17h10", "18h10", "19h08"),
                        getStop("Feteira - Igreja") to listOf("06h30", "07h15", "08h15", "09h10", "10h15", "11h15", "12h10", "13h15", "14h15", "15h13", "16h15", "17h15", "18h15", "19h10"),
                        getStop("Ribeira do Testo") to listOf("06h35", "07h20", "08h20", "09h12", "10h20", "11h20", "12h12", "13h20", "14h20", "15h18", "16h20", "17h20", "18h20", "19h12"),
                        getStop("Largo da Cruz") to listOf("---", "---", "---", "09h14", "---", "---", "12h14", "---", "---", "---", "---", "---", "---", "19h14"),
                        getStop("Praça da Vila de São Sebastião") to  listOf("06h40", "07h25", "08h25", "09h25", "10h25", "11h25", "12h25", "13h25", "14h25", "15h25", "16h25", "17h25", "18h25", "19h25"),
                        getStop("Ribeira Seca") to listOf("06h42", "07h27", "08h27", "09h27", "10h27", "11h27", "12h27", "13h27", "14h27", "15h27", "16h27", "17h27", "18h27", "19h27"),
                        getStop("Fonte Bastardo - Império") to listOf("06h47", "07h32", "08h32", "09h32", "10h32", "11h32", "12h32", "13h32", "14h32", "15h32", "16h32", "17h32", "18h32", "19h32"),
                        getStop("Cabo da Praia - Igreja") to listOf("06h52", "07h37", "08h37", "09h37", "10h37", "11h37", "12h37", "13h37", "14h37", "---", "16h37", "17h37", "18h37", "19h37"),
                        getStop("Praia da Vitória") to listOf("07h05", "07h50", "08h50", "09h50", "10h50", "11h50", "12h50", "13h50", "14h50", "15h50", "16h50", "17h50", "18h50", "19h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hsiv", mapOf(
                        getStop("Praia da Vitória") to listOf("06h00", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00"),
                        getStop("Cabo da Praia - Igreja") to listOf("06h10", "07h05", "08h05", "09h05", "10h10", "11h10", "12h05", "13h10", "14h10", "15h10", "---", "17h10", "18h10"),
                        getStop("Fonte Bastardo - Império") to listOf("06h15", "07h15", "08h15", "09h15", "10h20", "11h20", "12h15", "13h20", "14h20", "15h20", "16h18", "17h20", "18h20"),
                        getStop("Ribeira Seca") to listOf("06h20", "07h18", "08h18", "09h18", "10h23", "11h23", "12h18", "13h23", "14h23", "15h23", "16h23", "17h23", "18h23"),
                        getStop("Praça da Vila de São Sebastião") to  listOf("06h25", "07h25", "08h25", "09h25", "10h25", "11h25", "12h25", "13h25", "14h25", "15h25", "16h25", "17h25", "18h25"),
                        getStop("Largo da Cruz") to listOf("06h32", "07h29", "08h29", "09h29", "---", "---", "12h29", "---", "---", "---", "---", "---", "---"),
                        getStop("Ribeira do Testo") to listOf("06h40", "07h37", "08h37", "09h37", "10h30", "11h30", "12h37", "13h30", "14h30", "15h30", "16h30", "17h30", "18h30"),
                        getStop("Feteira - Igreja") to listOf("06h42", "07h42", "08h42", "09h42", "10h35", "11h35", "12h42", "13h35", "14h35", "15h35", "16h35", "17h35", "18h35"),
                        getStop("Ladeira Grande - Império") to listOf("06h45", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---"),
                        getStop("Santo Amaro") to listOf("06h47", "07h45", "08h45", "09h45", "10h40", "11h40", "12h45", "13h40", "14h40", "15h40", "16h42", "17h40", "18h40"),
                        getStop("Praça Velha") to listOf("06h55", "07h50", "08h50", "09h50", "10h50", "11h50", "12h50", "13h50", "14h50", "15h50", "16h50", "17h50", "18h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hsi", mapOf(
                        getStop("Praça Velha") to listOf("09h00", "11h00", "13h00", "15h00", "17h00", "19h00"),
                        getStop("Praça Almeida Garrett") to listOf("09h01", "11h01", "13h01", "15h01", "17h01", "19h01"),
                        getStop("Av. Álvaro Martins Homem") to listOf("09h04", "11h04", "13h04", "15h04", "17h04", "19h05"),
                        getStop("Santo Amaro") to listOf("09h08", "11h08", "13h08", "15h08", "17h08", "19h10"),
                        getStop("Feteira - Igreja") to listOf("09h10", "11h13", "13h10", "15h10", "17h12", "19h15"),
                        getStop("Ribeira do Testo") to listOf("09h12", "11h18", "13h12", "15h18", "17h18", "19h20"),
                        getStop("Largo da Cruz") to listOf("09h14", "---", "13h14", "---", "17h14", "---"),
                        getStop("Praça da Vila de São Sebastião") to listOf("09h25", "11h25", "13h25", "15h25", "17h25", "19h25"),
                        getStop("Ribeira Seca") to listOf("09h27", "11h27", "13h27", "15h27", "17h27", "19h27"),
                        getStop("Fonte Bastardo - Império") to listOf("09h32", "11h32", "13h32", "15h32", "17h32", "19h32"),
                        getStop("Porto Martins - Igreja") to listOf("---", "11h35", "---", "15h35", "---", "---"),
                        getStop("Cabo da Praia - Igreja") to listOf("09h37", "11h45", "13h37", "15h37", "17h37", "19h37"),
                        getStop("Praia da Vitória") to listOf("09h50", "11h55", "13h50", "15h50", "17h50", "19h50"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route, route+"hsiv", mapOf(
                        getStop("Praia da Vitória") to listOf("08h00", "10h00", "12h00", "14h00", "16h00", "18h00"),
                        getStop("Cabo da Praia - Igreja") to listOf("08h05", "10h05", "12h05", "14h05", "16h05", "18h05"),
                        getStop("Porto Martins - Igreja") to listOf("08h10", "---", "12h10", "---", "16h10", "---"),
                        getStop("Fonte Bastardo - Império") to listOf("08h13", "10h15", "12h13", "14h15", "16h13", "18h15"),
                        getStop("Ribeira Seca") to listOf("08h18", "10h18", "12h18", "14h18", "16h18", "18h18"),
                        getStop("Praça da Vila de São Sebastião") to listOf("08h25", "10h25", "12h25", "14h25", "16h25", "18h25"),
                        getStop("Largo da Cruz") to listOf("---", "10h29", "---", "14h29", "---", "18h29"),
                        getStop("Ribeira do Testo") to listOf("08h30", "10h37", "12h30", "14h37", "16h30", "18h37"),
                        getStop("Feteira - Igreja") to listOf("08h35", "10h42", "12h35", "14h42", "16h35", "18h42"),
                        getStop("Santo Amaro") to listOf("08h42", "10h45", "12h42", "14h45", "16h42", "18h45"),
                        getStop("Praça Velha") to listOf("08h50", "10h50", "12h50", "14h50", "16h50", "18h50"),
                    ), TypeOfDay.SUNDAY, img),
            )

        )

        /* Route 03 */
        route = "03"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Raminho") to listOf("06h30", "---", "09h30", "11h45", "15h00", "17h00", "19h00"),
                        getStop("Altares - Igreja") to listOf("06h37", "---", "---", "---", "---", "---","---"),
                        getStop("Biscoitos") to listOf("06h45", "---", "---", "---", "---", "---", "---"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("06h50", "---", "09h35", "11h50", "15h05", "17h05", "19h05"),
                        getStop("Agualva - Igreja") to listOf("07h00", "08h15", "09h48", "12h03", "15h18", "17h18", "19h18"),
                        getStop("Vila Nova - Praça") to listOf("07h05", "08h20", "09h58", "12h13", "15h28", "17h28", "19h28"),
                        getStop("Lajes - Igreja") to listOf("07h12", "08h25", "10h08", "12h23", "15h38", "17h38", "19h38"),
                        getStop("Aeroporto") to  listOf("07h20", "08h30", "10h10", "12h25", "15h40", "17h40", "19h40"),
                        getStop("Posto 1") to listOf("07h25", "08h40", "10h20", "12h35", "15h50", "17h50", "19h50"),
                        getStop("Praia da Vitória") to listOf("07h30", "08h45", "10h30", "12h45", "16h00", "18h00", "20h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hiv", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "14h00", "16h00", "18h00", "20h00"),
                        getStop("Posto 1") to listOf("07h57", "10h37", "14h07", "16h07", "18h07", "20h07"),
                        getStop("Aeroporto") to  listOf("08h00", "10h40", "14h10", "16h10", "18h10", "20h10"),
                        getStop("Lajes - Igreja") to listOf("08h05", "10h45", "14h15", "16h15", "18h15", "20h15"),
                        getStop("Vila Nova - Praça") to listOf("08h15", "10h55", "14h25", "16h25", "18h25", "20h25"),
                        getStop("Agualva - Igreja") to listOf("08h25", "11h05", "14h35", "16h35", "18h35", "20h35"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("08h40", "11h20", "14h50", "16h50", "18h50", "20h50"),
                        getStop("Biscoitos") to listOf("08h50", "11h30", "15h00", "17h00", "19h00", "21h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hs", mapOf(
                        getStop("Raminho") to listOf("06h30", "---", "09h30", "11h45", "15h00", "17h00"),
                        getStop("Altares - Igreja") to listOf("06h37", "---", "---", "---", "---", "---"),
                        getStop("Biscoitos") to listOf("06h45", "---", "---", "---", "---", "---"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("06h50", "---", "09h35", "11h50", "15h05", "17h05"),
                        getStop("Agualva - Igreja") to listOf("07h00", "08h15", "09h48", "12h03", "15h18", "17h18"),
                        getStop("Vila Nova - Praça") to listOf("07h05", "08h20", "09h58", "12h13", "15h28", "17h28"),
                        getStop("Lajes - Igreja") to listOf("07h12", "08h25", "10h08", "12h23", "15h38", "17h38"),
                        getStop("Aeroporto") to  listOf("07h20", "08h30", "10h10", "12h25", "15h40", "17h40"),
                        getStop("Posto 1") to listOf("07h25", "08h40", "10h20", "12h35", "15h50", "17h50"),
                        getStop("Praia da Vitória") to listOf("07h30", "08h45", "10h30", "12h45", "16h00", "18h00"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hsv", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "14h00", "16h00", "18h00"),
                        getStop("Posto 1") to listOf("07h57", "10h37", "14h07", "16h07", "18h07"),
                        getStop("Aeroporto") to  listOf("08h00", "10h40", "14h10", "16h10", "18h10"),
                        getStop("Lajes - Igreja") to listOf("08h05", "10h45", "14h15", "16h15", "18h15"),
                        getStop("Vila Nova - Praça") to listOf("08h15", "10h55", "14h25", "16h25", "18h25"),
                        getStop("Agualva - Igreja") to listOf("08h25", "11h05", "14h35", "16h35", "18h35"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("08h40", "11h20", "14h50", "16h50", "18h50"),
                        getStop("Biscoitos") to listOf("08h50", "11h30", "15h00", "17h00", "19h00"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hd", mapOf(
                        getStop("Biscoitos") to listOf("09h00", "14h00", "17h00"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("09h05", "14h05", "17h05"),
                        getStop("Agualva - Igreja") to listOf("09h18", "14h18", "17h18"),
                        getStop("Vila Nova - Praça") to listOf("09h28", "14h28", "17h28"),
                        getStop("Lajes - Igreja") to listOf("09h38", "14h38", "17h38"),
                        getStop("Aeroporto") to listOf("09h40", "14h40", "17h40"),
                        getStop("Posto 1") to listOf("09h50", "14h50", "17h50"),
                        getStop("Praia da Vitória") to listOf("10h00", "15h00", "18h00"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route, route+"hdv", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00", "16h00", "18h00"),
                        getStop("Posto 1") to listOf("12h07", "16h07", "18h07"),
                        getStop("Aeroporto") to  listOf("12h10", "16h10", "18h10"),
                        getStop("Lajes - Igreja") to listOf("12h15", "16h15", "18h15"),
                        getStop("Vila Nova - Praça") to listOf("12h25", "16h25", "18h25"),
                        getStop("Agualva - Igreja") to listOf("12h35", "16h35", "18h35"),
                        getStop("Quatro Ribeiras - Igreja") to listOf("12h50", "16h50", "18h50"),
                        getStop("Biscoitos") to listOf( "13h00", "17h00", "19h00"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 05 */
        route = "05"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("15h00", "17h00"),
                        getStop("Praça Almeida Garrett") to listOf("15h01", "17h01"),
                        getStop("Lar de Idosos") to listOf("15h04", "17h04"),
                        getStop("Hospital") to listOf("15h10", "17h10"),
                        getStop("Canada da Fontainha") to listOf("15h21", "17h21"),
                        getStop("Quatro Canadas") to listOf("15h26", "17h26"),
                        getStop("Agualva - Igreja") to listOf("15h29", "17h29"),
                        getStop("Vila Nova - Praça") to listOf("15h34", "17h34"),
                        getStop("Aeroporto") to listOf("15h40", "17h40"),
                        getStop("Posto 1") to listOf("15h55", "17h55"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"shi", mapOf(
                        getStop("Praça Velha") to listOf("18h30"),
                        getStop("Praça Almeida Garrett") to listOf("18h31"),
                        getStop("Lar de Idosos") to listOf("18h34"),
                        getStop("Quatro Canadas") to listOf("18h51"),
                        getStop("Canada da Fontainha") to listOf("18h54"),
                        getStop("Agualva - Igreja") to listOf("18h59"),
                        getStop("Vila Nova - Praça") to listOf("19h04"),
                        getStop("Aeroporto") to listOf("19h10"),
                        getStop("Posto 1") to listOf("19h15"),
                        getStop("Praia da Vitória") to listOf("19h25"),
                        ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hiv", mapOf(
                        getStop("Posto 1") to listOf("06h45", "08h00"),
                        getStop("Aeroporto") to listOf("06h45", "08h00"),
                        getStop("Vila Nova - Praça") to listOf("06h48", "08h03"),
                        getStop("Agualva - Igreja") to listOf("06h58", "08h13"),
                        getStop("Quatro Canadas") to listOf("07h08", "08h23"),
                        getStop("Canada da Fontainha") to listOf("07h25", "08h40"),
                        getStop("Praça Velha") to listOf("07h35", "08h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hivp", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00"),
                        getStop("Posto 1") to listOf("12h05"),
                        getStop("Aeroporto") to listOf("12h10"),
                        getStop("Vila Nova - Praça") to listOf("12h18"),
                        getStop("Agualva - Igreja") to listOf("12h28"),
                        getStop("Quatro Canadas") to listOf("12h38"),
                        getStop("Canada da Fontainha") to listOf("12h50"),
                        getStop("Praça Velha") to listOf("13h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"siv", mapOf(
                        getStop("Posto 1") to listOf("06h45", "08h00"),
                        getStop("Aeroporto") to listOf("06h45", "08h00"),
                        getStop("Vila Nova - Praça") to listOf("06h48", "08h03"),
                        getStop("Agualva - Igreja") to listOf("06h58", "08h13"),
                        getStop("Quatro Canadas") to listOf("07h08", "08h23"),
                        getStop("Canada da Fontainha") to listOf("07h25", "08h40"),
                        getStop("Praça Velha") to listOf("07h35", "08h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"sivp", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00"),
                        getStop("Posto 1") to listOf("12h05"),
                        getStop("Aeroporto") to listOf("12h10"),
                        getStop("Vila Nova - Praça") to listOf("12h18"),
                        getStop("Agualva - Igreja") to listOf("12h28"),
                        getStop("Quatro Canadas") to listOf("12h38"),
                        getStop("Canada da Fontainha") to listOf("12h50"),
                        getStop("Praça Velha") to listOf("13h00"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"si", mapOf(
                        getStop("Praça Velha") to listOf("15h00"),
                        getStop("Praça Almeida Garrett") to listOf("15h01"),
                        getStop("Lar de Idosos") to listOf("15h04"),
                        getStop("Hospital") to listOf("15h10"),
                        getStop("Canada da Fontainha") to listOf("15h21"),
                        getStop("Quatro Canadas") to listOf("15h26"),
                        getStop("Agualva - Igreja") to listOf("15h29"),
                        getStop("Vila Nova - Praça") to listOf("15h34"),
                        getStop("Aeroporto") to listOf("15h40"),
                        getStop("Posto 1") to listOf("15h55"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 06 */
        route = "06"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Regatos") to listOf("09h35", "16h35"),
                        getStop("Sao Bartolomeu - Igreja 2") to listOf("09h38", "16h38"),
                        getStop("Terra Alta") to listOf("09h41", "16h41"),
                        getStop("Canada de Belém") to listOf("09h49", "16h49"),
                        getStop("Praça Velha") to listOf("09h57", "16h57"),
                        getStop("Praça Almeida Garrett") to listOf("09h58", "16h58"),
                        getStop("Lar de Idosos") to listOf("10h01", "17h01"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"xhi", mapOf(
                        getStop("Cruz das Cinco") to listOf("08h25", "10h45", "12h35", "18h45"),
                        getStop("Sao Bartolomeu - Igreja") to listOf("08h28", "10h48", "12h38", "18h48"),
                        getStop("Terra Alta") to listOf("08h33", "10h53", "12h43", "18h53"),
                        getStop("Canada de Belém") to listOf("08h38", "10h58", "12h48", "18h58"),
                        getStop("Praça Velha") to listOf("08h47", "11h07", "12h57", "19h07"),
                        getStop("Praça Almeida Garrett") to listOf("08h48", "11h08", "12h58", "19h08"),
                        getStop("Lar de Idosos") to listOf("08h51", "11h11", "13h01", "19h11"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"lhi", mapOf(
                        getStop("Regatos") to listOf("17h40"),
                        getStop("Cruz das Cinco") to listOf("17h43"),
                        getStop("Sao Bartolomeu - Igreja") to listOf("17h47"),
                        getStop("Terra Alta") to listOf("17h50"),
                        getStop("Canada de Belém") to listOf("17h53"),
                        getStop("Praça Velha") to listOf("18h02"),
                        getStop("Praça Almeida Garrett") to listOf("18h03"),
                        getStop("Lar de Idosos") to listOf("18h06"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hiv", mapOf(
                        getStop("Lar de Idosos") to listOf("07h55", "09h00", "13h10", "16h00", "18h15"),
                        getStop("Jardim Duque da Terceira") to listOf("08h01", "09h06", "13h16", "16h06", "18h21"),
                        getStop("Alto das Covas") to listOf("08h02", "09h07", "13h17", "16h07", "18h22"),
                        getStop("Portoes de São Pedro") to listOf("08h03", "09h08", "13h18", "16h08", "18h23"),
                        getStop("Canada de Belém") to listOf("08h16", "09h21", "13h31", "16h21", "18h36"),
                        getStop("Terra Alta") to listOf("08h20", "09h25", "13h35", "16h25", "18h40"),
                        getStop("Sao Bartolomeu - Igreja") to listOf("08h23", "09h28", "13h38", "16h28", "18h43"),
                        getStop("Regatos") to listOf("08h26", "09h31", "13h41", "16h31", "18h46"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hivs", mapOf(
                        getStop("Lar de Idosos") to listOf("10h10", "12h00", "17h05", "19h15"),
                        getStop("Jardim Duque da Terceira") to listOf("10h16", "12h06", "17h11", "19h21"),
                        getStop("Alto das Covas") to listOf("10h17", "12h07", "17h12", "19h22"),
                        getStop("Canada de Belém") to listOf("10h30", "12h20", "17h25", "19h35"),
                        getStop("Terra Alta") to listOf("10h34", "12h24", "17h29", "19h39"),
                        getStop("Sao Bartolomeu - Igreja") to listOf("10h36", "12h26", "17h31", "19h41"),
                        getStop("Cruz das Cinco") to listOf("10h37", "12h27", "17h32", "19h42"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hhi", mapOf(
                        getStop("Cruz das Cinco") to listOf("07h20"),
                        getStop("Sao Bartolomeu - Igreja") to listOf("07h23"),
                        getStop("Regatos") to listOf("07h26"),
                        getStop("Sao Bartolomeu - Igreja 2") to listOf("07h29"),
                        getStop("Terra Alta") to listOf("07h32"),
                        getStop("Canada de Belém") to listOf("07h36"),
                        getStop("Praça Velha") to listOf("07h42"),
                        getStop("Praça Almeida Garrett") to listOf("07h43"),
                        getStop("Lar de Idosos") to listOf("07h46"),
                    ), TypeOfDay.WEEKDAY, img),
            ))
    }

    /*private fun loadStops() {
          Stop("Hospital", Location(0.0, 0.0))
          Stop("Praça Velha", Location(0.0, 0.0))
          Stop("Jardim", Location(0.0, 0.0))
          Stop("Bailão", Location(0.0, 0.0))
          Stop("Aeroporto", Location(0.0, 0.0))
          Stop("Praia da Vitória", Location(0.0, 0.0))
          Stop("Angra do Heroísmo", Location(0.0, 0.0))
          Stop("Biscoitos", Location(0.0, 0.0))
          Stop("Serreta", Location(0.0, 0.0))
          Stop("Raminho", Location(0.0, 0.0))
          Stop("Juncal", Location(0.0, 0.0))
          Stop("Agualva", Location(0.0, 0.0))
          Stop("Cruz", Location(0.0, 0.0))
          Stop("Porto Judeu", Location(0.0, 0.0))
          Stop("Porto Martins", Location(0.0, 0.0))
          Stop("São Brás", Location(0.0, 0.0))
          Stop("São Mateus", Location(0.0, 0.0))
          Stop("Ribeirinha", Location(0.0, 0.0))
          Stop("Silveira", Location(0.0, 0.0))
          Stop("Terra Chã", Location(0.0, 0.0))
          Stop("Posto Santo", Location(0.0, 0.0))
          Stop("Vinha Brava", Location(0.0, 0.0))
          Stop("Bairro da Terra Chã", Location(0.0, 0.0))
          Stop("Zona Industrial", Location(0.0, 0.0))
          Stop("Praça De Toiros", Location(0.0, 0.0))
          Stop("Corpo Santo", Location(0.0, 0.0))
          Stop("Lages", Location(0.0, 0.0))
          Stop("Azória", Location(0.0, 0.0))
          Stop("Vale Farto", Location(0.0, 0.0))
          Stop("Casa da Ribeira", Location(0.0, 0.0))

          Stop("Refugo", Location(0.0, 0.0))
          Stop("Largo da Cruz", Location(0.0, 0.0))
          Stop("Feteira", Location(0.0, 0.0))
          Stop("Serretinha", Location(0.0, 0.0))
          Stop("Ladeira Grande", Location(0.0, 0.0))
          Stop("Ribeira Seca", Location(0.0, 0.0))
          Stop("Serretinha", Location(0.0, 0.0))
          Stop("Quatro Canadas", Location(0.0, 0.0))
          Stop("Serretinha", Location(0.0, 0.0))
          Stop("Rua dos Lourais", Location(0.0, 0.0))
          Stop("Ribeira dos Pães", Location(0.0, 0.0))
          Stop("Fundões", Location(0.0, 0.0))
          Stop("Rua das Covas", Location(0.0, 0.0))
          Stop("Fontinha", Location(0.0, 0.0))
          Stop("Fontinhas", Location(0.0, 0.0))
          Stop("Altares", Location(0.0, 0.0))
          Stop("Queimada - Casa da Junta", Location(0.0, 0.0))
          Stop("Pico Gordo - Entrocamento", Location(0.0, 0.0))
          Stop("Pico da Bagacina", Location(0.0, 0.0))
          Stop("Mata - Veredas", Location(0.0, 0.0))


      }*/
    /*private fun loadRoutes(){
        val img: Int = R.drawable.evt_logo
        /* Route 5 */
        var route = "5"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("15h00"),
                        getStop("Hospital") to listOf("15h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("15h00"),
                        getStop("Hospital") to listOf("15h10"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Aeroporto") to listOf("06h50", "08h05", "12h10"),
                        getStop("Angra do Heroísmo") to listOf("07h40", "08h50", "12h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hva", mapOf(
                        getStop("Aeroporto") to listOf("06h50", "08h05", "12h10"),
                        getStop("Angra do Heroísmo") to listOf("07h40", "08h50", "12h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hsv", mapOf(
                        getStop("Angra do Heroísmo") to listOf("15h00", "17h00", "18h30"),
                        getStop("Aeroporto") to listOf("15h40", "17h40", "19h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hdv", mapOf(
                        getStop("Angra do Heroísmo") to listOf("15h00"),
                        getStop("Aeroporto") to listOf("15h40"),
                    ), TypeOfDay.SATURDAY, img),
            ))
        /* Route 146 */
        route = "146"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("07h05", "08h05", "09h05", "12h05", "13h05", "17h05", "18h05"),
                        getStop("Hospital") to listOf("07h15", "08h15", "09h15", "12h15", "13h15", "17h15", "18h15"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("09h45", "12h45", "13h45", "16h45", "17h45", "18h45"),
                        getStop("Jardim") to listOf("09h51", "12h51", "13h51", "16h51", "17h51", "18h51"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("08h05", "09h05", "12h05", "13h05"),
                        getStop("Hospital") to listOf("08h15", "09h15", "12h15", "13h15"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Hospital") to listOf("08h30", "09h45", "12h30", "13h45"),
                        getStop("Jardim") to listOf("08h36", "09h51", "12h36", "13h51"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 145 */
        route = "145"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("07h20", "08h20", "09h25", "12h20", "13h20", "14h20", "16h35", "18h20", "19h20", "20h20"),
                        getStop("Hospital") to listOf("07h28", "08h28", "09h33", "12h28", "13h28", "14h28", "16h43", "18h28", "19h28", "20h28"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("07h32", "11h32", "12h32", "13h32", "15h47", "17h02", "18h32", "19h32"),
                        getStop("Jardim") to listOf("07h38", "11h38", "12h38", "13h38", "15h53", "17h08", "18h38", "19h38"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("07h20", "08h20", "09h25", "12h20", "13h20", "14h20", "16h35", "18h05", "19h20"),
                        getStop("Hospital") to listOf("07h28", "08h28", "09h33", "12h28", "13h28", "14h28", "16h50", "18h13", "19h35"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Hospital") to listOf("06h30", "07h32", "08h37", "11h30", "12h32", "13h32", "15h47", "17h02", "18h32"),
                        getStop("Jardim") to listOf("06h36", "07h38", "08h43", "11h36", "12h38", "13h38", "15h53", "17h08", "18h38"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hid", mapOf(
                        getStop("Praça Velha") to listOf("08h50", "10h50", "13h50", "14h50", "17h50", "18h50"),
                        getStop("Hospital") to listOf("08h58", "11h00", "13h58", "15h00", "17h58", "19h00"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route, route+"hvd", mapOf(
                        getStop("Hospital") to listOf("08h02", "10h02", "13h02", "14h02", "17h02", "18h02"),
                        getStop("Jardim") to listOf("08h08", "10h08", "13h08", "14h08", "17h08", "18h08"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 143 */
        route = "143"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("07h44", "08h44", "09h44", "12h49", "13h49", "16h49", "17h49", "18h49"),
                        getStop("Hospital") to listOf("07h55", "09h00", "09h50", "12h55", "13h55", "16h55", "17h55", "18h55"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("07h00", "08h00", "09h00", "12h00", "13h00", "16h00", "17h00", "18h00"),
                        getStop("Jardim") to listOf("07h06", "08h06", "09h06", "12h06", "13h06", "16h10", "17h06", "18h06"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("08h44", "09h44", "12h49", "13h49", "16h49"),
                        getStop("Hospital") to listOf("08h50", "09h50", "12h55", "13h55", "16h55"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Hospital") to listOf("08h00", "09h00", "12h00", "13h00", "16h00"),
                        getStop("Jardim") to listOf("08h06", "09h06", "12h06", "13h06", "16h06"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 144 */
        route = "144"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("11h20", "15h40"),
                        getStop("Hospital") to listOf("11h26", "15h46"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("10h30", "14h45"),
                        getStop("Jardim") to listOf("10h36", "14h51"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("11h20"),
                        getStop("Hospital") to listOf("11h26"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Hospital") to listOf("10h30"),
                        getStop("Jardim") to listOf("10h36"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 146 */
        route = "146"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("07h05", "08h05", "09h05", "12h05", "13h05", "17h05", "18h05"),
                        getStop("Hospital") to listOf("07h15", "08h15", "09h15", "12h15", "13h15", "17h15", "18h15"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("09h45", "12h45", "13h45", "16h45", "17h45", "18h45"),
                        getStop("Jardim") to listOf("09h51", "12h51", "13h51", "16h51", "17h51", "18h51"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praça Velha") to listOf("08h05", "09h05", "12h05", "13h05"),
                        getStop("Hospital") to listOf("08h15", "09h15", "12h15", "13h15"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Hospital") to listOf("08h30", "09h45", "12h30", "13h45"),
                        getStop("Jardim") to listOf("08h36", "09h51", "12h36", "13h51"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 148 */
        route = "148"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praça Velha") to listOf("07h55", "---", "08h55", "---", "09h55", "---", "10h55", "---", "11h55", "---", "12h55", "---", "13h55", "---", "14h55", "---", "15h55", "---", "16h55", "---", "17h55", "---"),
                        getStop("Jardim") to listOf("---", "08h30", "---", "09h30", "---", "10h30", "---", "11h30", "---", "12h30", "---", "13h30", "---", "14h30", "---", "15h30", "---", "16h30", "---", "17h30", "---", "18h30"),
                        getStop("Hospital") to listOf("08h10", "08h40", "09h10", "09h40", "10h10", "10h40", "11h10", "11h40", "12h10", "12h40", "13h10", "13h40", "14h10", "14h40","15h10", "15h40", "16h10", "16h40", "17h10", "17h40", "18h10", "18h40"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Hospital") to listOf("08h10", "08h40", "09h10", "09h40", "10h10", "10h40", "11h10", "11h40", "12h10", "12h40", "13h10", "13h40", "14h10", "14h40", "15h10", "15h40", "16h10", "16h40", "17h10", "17h40", "18h10", "18h40"),
                        getStop("Jardim") to listOf("08h30", "---", "09h30", "---", "10h30", "---", "11h30", "---", "12h30", "---", "13h30", "---", "14h30", "---", "15h30", "---", "16h30", "---", "17h30", "---", "18h30", "---"),
                        getStop("Bailão") to listOf("---", "08h50", "---", "09h50", "---", "10h50", "---", "11h50", "---", "12h50", "---", "13h50", "---", "14h50", "---", "15h50", "---", "16h50", "---", "17h50", "---", "18h50"),
                        ), TypeOfDay.WEEKDAY, img),
            )
        )

        /* Route 7 */
        route = "7"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Refugo") to listOf("07h15", "08h20", "---", "12h25", "---", "17h30"),
                        getStop("Largo da Cruz") to listOf("07h20", "08h25", "09h30", "12h30", "16h30", "17h35"),
                        getStop("Feteira") to listOf("07h35", "08h40", "09h45", "---", "---", "---"),
                        getStop("Serretinha") to listOf("---", "---", "---", "12h38", "16h38", "17h43"),
                        getStop("Ladeira Grande") to listOf("07h38", "08h43", "09h48", "12h43", "16h43", "17h48"),
                        getStop("Angra do Heroísmo") to listOf("07h50", "08h55", "10h00", "12h55", "16h55", "18h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotev", mapOf(
                        getStop("Angra do Heroísmo") to listOf("07h50", "09h00", "11h50", "16h00", "17h00", "18h00"),
                        getStop("Ladeira Grande") to listOf("08h02", "09h12", "12h02", "16h12", "17h12", "18h12"),
                        getStop("Serretinha") to listOf("08h07", "09h17", "---", "---", "17h17", "---"),
                        getStop("Feteira") to listOf("---", "---", "12h05", "16h15", "---", "18h15"),
                        getStop("Largo da Cruz") to listOf("08h15", "09h25", "12h20", "16h30", "17h25", "18h30"),
                        getStop("Refugo") to listOf("08h20", "---", "12h25", "---", "17h30", "18h35"),
                ), TypeOfDay.WEEKDAY, img),
            )
        )
        /* Route 9 */
        route = "9"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route+"C", route+"C"+"rote", mapOf(
                        getStop("Quatro Canadas") to listOf("07h10", "08h20", "12h50", "15h30"),
                        getStop("Rua dos Lourais") to listOf("07h15", "08h25", "12h55", "15h35"),
                        getStop("Ribeira dos Pães") to listOf("07h18", "08h28", "12h58", "15h38"),
                        getStop("Fundões") to listOf("07h20", "08h30", "13h00", "15h40"),
                        getStop("Lages") to listOf("07h25", "08h35", "13h05", "15h45"),
                        getStop("Quatro Canadas") to listOf("---", "---", "13h15", "15h55"),
                        getStop("Rua das Covas") to listOf("07h30", "08h40", "13h20", "16h00"),
                        getStop("Fontinhas") to listOf("07h35", "08h45", "13h25", "16h05"),
                        getStop("Praia da Vitória") to listOf("07h45", "08h55", "13h35", "16h15"),
                        ), TypeOfDay.WEEKDAY, img),
                Route(
                    route+"C", route+"C"+"rotes", mapOf(
                        getStop("Quatro Canadas") to listOf("07h10", "08h20", "12h50", "15h30"),
                        getStop("Rua dos Lourais") to listOf("07h15", "08h25", "12h55", "15h35"),
                        getStop("Ribeira dos Pães") to listOf("07h18", "08h28", "12h58", "15h38"),
                        getStop("Fundões") to listOf("07h20", "08h30", "13h00", "15h40"),
                        getStop("Lages") to listOf("07h25", "08h35", "13h05", "15h45"),
                        getStop("Quatro Canadas") to listOf("---", "---", "13h15", "15h55"),
                        getStop("Rua das Covas") to listOf("07h30", "08h40", "13h20", "16h00"),
                        getStop("Fontinhas") to listOf("07h35", "08h45", "13h25", "16h05"),
                        getStop("Praia da Vitória") to listOf("07h45", "08h55", "13h35", "16h15"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route+"F", route+"F"+"rotes", mapOf(
                        getStop("Quatro Canadas") to listOf("08h30", "11h00"),
                        getStop("Rua das Covas") to listOf("08h40", "11h10"),
                        getStop("Fontinhas") to listOf("08h45", "11h15"),
                        getStop("Praia da Vitória") to listOf("08h55", "11h25"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route+"B", route+"B"+"rotes", mapOf(
                        getStop("Fontinha") to listOf("17h50"),
                        getStop("Fontinhas") to listOf("17h55"),
                        getStop("Praia da Vitória") to listOf("18h05"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route+"C", route+"C"+"rotev", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50"),
                        getStop("Fontinhas") to listOf("08h00"),
                        getStop("Rua das Covas") to listOf("08h05"),
                        getStop("Quatro Canadas") to listOf("08h15"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route+"C", route+"C"+"rotesv", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50"),
                        getStop("Fontinhas") to listOf("08h00"),
                        getStop("Rua das Covas") to listOf("08h05"),
                        getStop("Quatro Canadas") to listOf("08h15"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route+"A", route+"A"+"rotev", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00", "15h00"),
                        getStop("Fontinhas") to listOf("12h10", "15h10"),
                        getStop("Rua das Covas") to listOf("12h15", "15h15"),
                        getStop("Quatro Canadas") to listOf("12h25", "15h25"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route+"A", route+"A"+"rotesv", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00", "15h00"),
                        getStop("Fontinhas") to listOf("12h10", "15h10"),
                        getStop("Rua das Covas") to listOf("12h15", "15h15"),
                        getStop("Quatro Canadas") to listOf("12h25", "15h25"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route+"A", route+"A"+"rotedv", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00", "15h00"),
                        getStop("Fontinhas") to listOf("12h10", "15h10"),
                        getStop("Rua das Covas") to listOf("12h15", "15h15"),
                        getStop("Quatro Canadas") to listOf("12h25", "15h25"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route+"B", route+"B"+"rotev", mapOf(
                        getStop("Praia da Vitória") to listOf("17h30", "18h10"),
                        getStop("Fontinhas") to listOf("17h40", "18h20"),
                        getStop("Fontinha") to listOf("17h45", "---"),
                        getStop("Rua das Covas") to listOf("---", "18h25"),
                        getStop("Quatro Canadas") to listOf("---", "18h35"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route+"F", route+"F"+"rotedv", mapOf(
                        getStop("Praia da Vitória") to listOf("18h00"),
                        getStop("Fontinhas") to listOf("18h10"),
                        getStop("Rua das Covas") to listOf("18h15"),
                        getStop("Quatro Canadas") to listOf("18h25"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route+"E", route+"E"+"rotedv", mapOf(
                        getStop("Praia da Vitória") to listOf("18h20"),
                        getStop("Fontinhas") to listOf("18h30"),
                        getStop("Rua das Covas") to listOf("18h35"),
                        getStop("Quatro Canadas") to listOf("18h45"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route+"D", route+"D"+"rotedv", mapOf(
                        getStop("Praia da Vitória") to listOf("15h00"),
                        getStop("Fontinhas") to listOf("15h10"),
                        getStop("Rua das Covas") to listOf("15h15"),
                        getStop("Quatro Canadas") to listOf("15h25"),
                    ), TypeOfDay.WEEKDAY, img, info = Functions().onlyWednesday(currentLanguage)),
            )
        )
        /* Route 11 */
        route = "11"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Biscoitos") to listOf("09h00"),
                        getStop("Altares") to listOf("09h15"),
                        getStop("Queimada - Casa da Junta") to listOf("09h25"),
                        getStop("Pico Gordo - Entrocamento") to listOf("09h30"),
                        getStop("Pico da Bagacina") to listOf("09h35"),
                        getStop("Mata - Veredas") to listOf("09h40"),
                        getStop("Angra do Heroísmo") to listOf("09h55"),
                        ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotev", mapOf(
                        getStop("Angra do Heroísmo") to listOf("16h00"),
                        getStop("Mata - Veredas") to listOf("16h15"),
                        getStop("Pico da Bagacina") to listOf("16h20"),
                        getStop("Pico Gordo - Entrocamento") to listOf("16h25"),
                        getStop("Queimada - Casa da Junta") to listOf("16h30"),
                        getStop("Altares") to listOf("16h40"),
                        getStop("Biscoitos") to listOf("16h55"),
                    ), TypeOfDay.WEEKDAY, img),
            )
        )
        /* Route 3 */
        route = "3"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hv", mapOf(
                        getStop("Aeroporto") to listOf("07h20", "08h35", "10h05", "12h20", "15h35", "17h35", "19h35"),
                        getStop("Praia da Vitória") to listOf("07h30", "08h45", "10h15", "12h30", "15h45", "17h45", "19h45"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Aeroporto") to listOf("07h20", "08h35", "10h05", "12h20", "15h35", "15h40", "17h35"),
                        getStop("Praia da Vitória") to listOf("07h40", "08h45", "10h15", "12h30", "15h45", "15h50", "17h45"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvd", mapOf(
                        getStop("Aeroporto") to listOf("09h35", "14h35", "17h35"),
                        getStop("Praia da Vitória") to listOf("09h45", "14h45", "17h45"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "12h00", "14h00", "16h00", "18h00", "20h00"),
                        getStop("Aeroporto") to listOf("08h00", "10h40", "12h10", "14h10", "16h10", "18h10", "20h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "12h00", "14h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("08h00", "10h40", "12h10", "14h10", "16h10", "18h10"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hid", mapOf(
                        getStop("Praia da Vitória") to listOf("12h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("12h10", "16h10", "18h10"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 151 */
        route = "151"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hi", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h40", "08h40", "09h40", "11h40", "12h40", "13h40", "15h40", "16h40", "17h50", "18h35", "19h40"),
                        getStop("Praia da Vitória") to listOf("06h50", "07h50", "08h50", "09h50", "11h50", "12h50", "13h50", "15h50", "16h50", "18h00", "18h45", "19h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h40", "08h40", "09h40", "11h40", "12h40", "13h40", "15h40", "17h50", "19h40"),
                        getStop("Praia da Vitória") to listOf("06h50", "07h50", "08h50", "09h50", "11h50", "12h50", "13h50", "15h50", "18h00", "19h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hv", mapOf(
                        getStop("Aeroporto") to listOf("08h10", "10h40", "12h40", "15h40", "18h40"),
                        getStop("Praia da Vitória") to listOf("08h30", "11h00", "12h50", "15h50", "18h50"),
                    ), TypeOfDay.SUNDAY, img),
                Route(
                    route, route+"hi", mapOf(
                        getStop("Praia da Vitória") to listOf("08h00", "09h00", "11h00", "12h00", "13h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Aeroporto") to listOf("08h10", "09h10", "11h10", "12h10", "13h10", "15h10", "16h10", "17h10", "18h10", "19h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Praia da Vitória") to listOf("07h00", "08h00", "09h00", "11h00", "12h00", "13h00", "15h00", "17h00", "19h00"),
                        getStop("Aeroporto") to listOf("07h10", "08h10", "09h10", "11h10", "12h10", "13h10", "15h10", "17h10", "19h10"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hid", mapOf(
                        getStop("Praia da Vitória") to listOf("08h00", "10h30", "15h00"),
                        getStop("Aeroporto") to listOf("08h10", "10h40", "15h40"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 2 */
        route = "2"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hv", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h20", "07h40", "08h35", "08h40", "09h40", "10h05", "11h40", "12h20", "12h40", "13h40", "15h35", "15h40", "16h40", "17h35", "17h50", "18h40"),
                        getStop("Praia da Vitória") to listOf("07h00", "08h00", "08h00", "09h00", "09h00", "10h00", "11h00", "12h00", "13h00", "13h00", "14h00", "16h00", "16h00", "17h00", "18h00", "18h00", "19h00"),
                        getStop("Angra do Heroísmo") to listOf("07h50", "08h50", "08h50", "09h50", "09h50", "10h50", "11h50", "12h50", "13h50", "13h50", "14h50", "16h50", "16h50", "17h50", "18h50", "18h50", "19h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h20", "07h40", "08h35", "08h40", "09h40", "10h05", "11h40", "12h20", "12h40", "13h40", "15h35", "15h40", "16h40", "17h35", "17h50"),
                        getStop("Praia da Vitória") to listOf("07h00", "08h00", "08h00", "09h00", "09h00", "10h00", "11h00", "12h00", "13h00", "13h00", "14h00", "16h00", "16h00", "17h00", "18h00", "18h00"),
                        getStop("Angra do Heroísmo") to listOf("07h50", "08h50", "08h50", "09h50", "09h50", "10h50", "11h50", "12h50", "13h50", "13h50", "14h50", "16h50", "16h50", "17h50", "18h50", "18h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvd", mapOf(
                        getStop("Aeroporto") to listOf("08h40", "09h35", "10h40", "12h40", "14h35", "15h40", "17h35"),
                        getStop("Praia da Vitória") to listOf("10h00", "10h00", "12h00", "14h00", "16h00", "16h00", "18h00"),
                        getStop("Angra do Heroísmo") to listOf("10h50", "10h50", "12h50", "14h50", "16h50", "16h50", "18h50"),
                    ), TypeOfDay.SUNDAY, img),

                Route(
                    route, route+"hvx", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Praia da Vitória") to listOf("07h00", "07h50", "09h00", "10h30", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h15", "20h00"),
                        getStop("Aeroporto") to listOf("07h10", "08h00", "09h10", "10h40", "11h10", "12h10", "13h10", "14h10", "15h10", "16h10", "17h10", "18h10", "19h25", "20h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"his", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "15h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("07h00", "07h50", "09h00", "10h30", "11h00", "12h00", "13h00", "14h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("07h10", "08h00", "09h10", "10h40", "11h10", "12h10", "13h10", "14h10", "16h10", "18h10"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hid", mapOf(
                        getStop("Angra do Heroísmo") to listOf("09h00", "11h00", "13h00", "15h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("10h30", "12h00", "15h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("10h40", "12h10", "15h40", "16h10", "18h10"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 2 */
        route = "2"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hvx", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h20", "07h40", "08h35", "08h40", "09h40", "10h05", "11h40", "12h20", "12h40", "13h40", "15h35", "15h40", "16h40", "17h35", "17h50", "18h40"),
                        getStop("Praia da Vitória") to listOf("07h00", "08h00", "08h00", "09h00", "09h00", "10h00", "11h00", "12h00", "13h00", "13h00", "14h00", "16h00", "16h00", "17h00", "18h00", "18h00", "19h00"),
                        getStop("Angra do Heroísmo") to listOf("07h50", "08h50", "08h50", "09h50", "09h50", "10h50", "11h50", "12h50", "13h50", "13h50", "14h50", "16h50", "16h50", "17h50", "18h50", "18h50", "19h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hvsx", mapOf(
                        getStop("Aeroporto") to listOf("06h40", "07h20", "07h40", "08h35", "08h40", "09h40", "10h05", "11h40", "12h20", "12h40", "13h40", "15h35", "15h40", "16h40", "17h35", "17h50"),
                        getStop("Praia da Vitória") to listOf("07h00", "08h00", "08h00", "09h00", "09h00", "10h00", "11h00", "12h00", "13h00", "13h00", "14h00", "16h00", "16h00", "17h00", "18h00", "18h00"),
                        getStop("Angra do Heroísmo") to listOf("07h50", "08h50", "08h50", "09h50", "09h50", "10h50", "11h50", "12h50", "13h50", "13h50", "14h50", "16h50", "16h50", "17h50", "18h50", "18h50"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvdx", mapOf(
                        getStop("Aeroporto") to listOf("08h40", "09h35", "10h40", "12h40", "14h35", "15h40", "17h35"),
                        getStop("Praia da Vitória") to listOf("10h00", "10h00", "12h00", "14h00", "16h00", "16h00", "18h00"),
                        getStop("Angra do Heroísmo") to listOf("10h50", "10h50", "12h50", "14h50", "16h50", "16h50", "18h50"),
                    ), TypeOfDay.SUNDAY, img),

                Route(
                    route, route+"hvxx", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Praia da Vitória") to listOf("07h00", "07h50", "09h00", "10h30", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00", "18h00", "19h15", "20h00"),
                        getStop("Aeroporto") to listOf("07h10", "08h00", "09h10", "10h40", "11h10", "12h10", "13h10", "14h10", "15h10", "16h10", "17h10", "18h10", "19h25", "20h10"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hisx", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00", "15h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("07h00", "07h50", "09h00", "10h30", "11h00", "12h00", "13h00", "14h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("07h10", "08h00", "09h10", "10h40", "11h10", "12h10", "13h10", "14h10", "16h10", "18h10"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hidx", mapOf(
                        getStop("Angra do Heroísmo") to listOf("09h00", "11h00", "13h00", "15h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("10h30", "12h00", "15h00", "16h00", "18h00"),
                        getStop("Aeroporto") to listOf("10h40", "12h10", "15h40", "16h10", "18h10"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* ******************************************* */

        /* Route 1 */
        route = "1"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"hv", mapOf(
                        getStop("Biscoitos") to listOf("06h20", "07h20", "09h30", "13h00", "14h30", "17h00", "17h30", "---"),
                        getStop("Angra do Heroísmo") to listOf("07h45", "10h30", "---", "13h00", "16h00", "17h00", "18h00", "19h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"hvs", mapOf(
                        getStop("Biscoitos") to listOf("06h20", "07h20", "09h30", "13h00", "---", "17h30", "---"),
                        getStop("Angra do Heroísmo") to listOf("07h45", "10h30", "13h00", "16h00", "---", "---", "19h00"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"hvd", mapOf(
                        getStop("Biscoitos") to listOf("---", "10h30", "13h30", "17h30", "---"),
                        getStop("Angra do Heroísmo") to listOf("---", "---", "12h00", "16h00", "19h00"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
        /* Route 2 */
        route = "2"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00","14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                        getStop("Praia da Vitória") to listOf("06h00", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00","14h00", "15h00", "16h00", "17h00", "18h00", "19h00"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotes", mapOf(
                        getStop("Angra do Heroísmo") to listOf("06h15", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00","---", "15h00", "---", "17h00", "---", "19h00"),
                        getStop("Praia da Vitória") to listOf("06h00", "07h00", "08h00", "09h00", "10h00", "11h00", "12h00", "13h00","14h00", "---", "16h00", "---", "18h00", "---"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"roted", mapOf(
                        getStop("Angra do Heroísmo") to listOf("---", "09h00", "---", "11h00", "---", "13h00","---", "15h00", "---", "17h00", "---", "19h00"),
                        getStop("Praia da Vitória") to listOf("08h00", "---", "10h00", "---", "12h00", "---","14h00", "---", "16h00", "---", "18h00", "---"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 3 */
        route = "3"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Biscoitos") to listOf("06h45", "08h15", "09h30", "11h45", "15h00", "17h00", "19h00"),
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "14h00", "16h00", "18h00", "20h00", "---"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotes", mapOf(
                        getStop("Biscoitos") to listOf("06h45", "08h15", "09h30", "11h45", "15h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("07h50", "10h30", "14h00", "16h00", "18h00", "---"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"roted", mapOf(
                        getStop("Biscoitos") to listOf("09h00", "---", "14h00", "17h00"),
                        getStop("Praia da Vitória") to listOf("---", "12h00", "16h00", "18h00"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 6 */
        route = "6"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Cruz") to listOf("07h20", "08h25", "09h35", "10h45", "---", "12h35", "13h45", "16h35", "---", "17h40", "18h45"),
                        getStop("Angra do Heroísmo") to listOf("07h55", "09h00", "10h10", "---", "12h00", "13h10", "16h00", "17h05", "18h15", "---", "19h15"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotes", mapOf(
                        getStop("Cruz") to listOf("07h20", "08h25", "09h35", "10h45", "---", "12h35", "13h45", "17h35", "---", "---", "18h30"),
                        getStop("Angra do Heroísmo") to listOf("07h55", "09h00", "10h10", "---", "12h00", "13h10", "---", "16h45", "---", "18h00", "---"),
                    ), TypeOfDay.SATURDAY, img),
                Route(
                    route, route+"roted", mapOf(
                        getStop("Cruz") to listOf("---", "08h20", "---", "10h30", "---", "14h30", "---", "17h30", "---", "18h30"),
                        getStop("Angra do Heroísmo") to listOf("07h45", "---", "10h00", "---", "14h00", "---", "17h00", "---", "18h00", "---"),
                    ), TypeOfDay.SUNDAY, img),
            )
        )
        /* Route 8 */
        route = "8"
        allRoutes.addAll(
            arrayListOf(
                Route(
                    route, route+"rote", mapOf(
                        getStop("Praia da Vitória") to listOf("06h50", "07h50", "12h50", "14h50", "16h50", "18h20"),
                        getStop("Ribeira Seca") to listOf("07h15", "08h35", "13h30", "15h30", "17h30", "18h50"),
                    ), TypeOfDay.WEEKDAY, img),
                Route(
                    route, route+"rotes", mapOf(
                        getStop("Praia da Vitória") to listOf("07h50", "12h50", "16h50"),
                        getStop("Ribeira Seca") to listOf("08h35", "13h30", "17h30"),
                    ), TypeOfDay.SATURDAY, img),
            )
        )
    }*/

    private fun setCorrespondence() {
        for (stop in stops) {
            correspondence[stop] = mutableListOf()
            for (route in allRoutes) {
                if (stop in route.stops.keys) {
                    correspondence[stop]?.addAll(route.stops.keys)
                }
            }
        }
    }

    fun getStops(): ArrayList<Stop> {
        return stops
    }

    fun addStop(stop: Stop) {
        stops.add(stop)
    }

    fun getAllRoutes(): ArrayList<Route> {
        return allRoutes
    }

    fun getCorrespondence(stop: String): MutableList<Stop>? {
        return correspondence[getStop(stop)]
    }

    fun getStop(stop: String): Stop {
        for (busStop in stops)
            if (busStop.name.uppercase() == stop.uppercase())
                return busStop
        Log.d("ERROR", "Error finding: $stop")
        return Stop("null", Location(0.0, 0.0))
    }

    fun getAllTimes(
        id: String?,
        origin: String?,
        destination: String?,
        day: TypeOfDay
    ): Map<Stop, List<String>>? {
        try {
            //Log.d("ERROR", id.toString())
            val route: Route? = routeHash[id]
            return route?.stops
        }
        catch(e: Exception) {
            return mapOf()
        }
        return mapOf()
    }

    fun getTimeIdx(
        route_id: String?,
        timeToFind: String?,
        origin: String?,
        destination: String?
    ): Int {
        val route = getRouteHash()[route_id]
        if (route != null) {
            for (stop in route.stops) {
                if (stop.key.name == destination)
                    break
                else if ((stop.key.name == origin) and (destination?.let { getStop(it) } in route.stops.keys)) {
                    val ret = route.getTimeIdx(stop.value, timeToFind)
                    if (ret >= 0) return ret
                }
            }
        }
        return -1
    }

    fun addRouteToHash(id: String, route: Route){
        routeHash[id] = route
    }
    fun getRouteHash(): HashMap<String, Route> {
        return routeHash
    }

    fun getAllStopTimes(
        route_id: String?,
        timeToFind: String?,
        origin: String?,
        destination: String?,
        day: TypeOfDay = TypeOfDay.WEEKDAY
    ): Map<String, String> {
        var map: MutableMap<String, String> = mutableMapOf()
        try{
            val idx = getTimeIdx(route_id, timeToFind, origin, destination)
            val route = getRouteHash()[route_id]
            for (i in route?.stops?.keys?.indices!!) {
                Log.d("debug", route.stops.toString())
                val times: List<String>? = route.stops[getStop(route.stops.keys.toList()[i].toString())]
                if (times != null) {
                    map[route.stops.keys.toList()[i].toString()] = times[idx]
                }
            }
            return map
        }
        catch(e: Exception) {
            return mapOf("ERROR" to "ERROR")
        }
        return map
    }

    fun getFavorite(): MutableList<List<String>> {
        return favorite
    }

    fun addFavorite(origin: String?, destination: String?) {
        if (listOf(origin, destination) !in favorite) {
            favorite.add(listOf(origin, destination) as List<String>)
        }
    }

    fun removeFavorite(toRemove: List<String>) {
        favorite.remove(toRemove)
    }

    fun loadFavorite(fav: MutableList<List<String>>) {
        favorite = fav
    }

    fun getCurrentLang(): String {
        return currentLanguage
    }

    fun changeCurrentLang(lang: String) {
        currentLanguage = lang
    }

    fun getLoaded(): Boolean {
        return loaded
    }

    fun loaded() {
        loaded = true
    }

    fun hasInfo(id: String?, origin: String?, destination: String?, typeOfDay: TypeOfDay): String? {
        for (route in allRoutes)
            if ((route.id == id) and (route.getStopIdx(origin?.let { getStop(it) }) < route.getStopIdx(destination?.let { getStop(it) }))and (route.day == typeOfDay))
                return route.info
        return null
    }
}