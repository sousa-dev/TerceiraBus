package com.SousaDev.TerceiraBus.data

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.SousaDev.TerceiraBus.R
import com.SousaDev.TerceiraBus.fragments.HomeFragment
import org.json.JSONArray
import org.json.JSONObject
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
        Stop("Casa da Ribeira - Igreja", Location(0.0, 0.0))
        Stop("Largo S. Bento", Location(0.0, 0.0))
        Stop("Ponta Negra", Location(0.0, 0.0))
        Stop("Hospital", Location(0.0, 0.0))
        Stop("Jardim Duque da Terceira", Location(0.0, 0.0))
        Stop("Bairro - Império", Location(0.0, 0.0))
        Stop("Quinta da Vargem", Location(0.0, 0.0))
        Stop("Canada do Célis", Location(0.0, 0.0))
        Stop("Ribeirinha (Serra)", Location(0.0, 0.0))
        Stop("Largo do Terreiro", Location(0.0, 0.0))
        Stop("Praça Velha - Sub-Urbanas", Location(0.0, 0.0))
        Stop("Ribeira do Testo", Location(0.0, 0.0))
        Stop("Serretinha", Location(0.0, 0.0))
        Stop("Cabo da Praia", Location(0.0, 0.0))
        Stop("Regatos", Location(0.0, 0.0))
        Stop("Fontinha", Location(0.0, 0.0))
        Stop("Boa Hora", Location(0.0, 0.0))
        Stop("Praça de Toiros", Location(0.0, 0.0))
        Stop("Refugo", Location(0.0, 0.0))
        Stop("Praça Almeida Garrett", Location(0.0, 0.0))
        Stop("Fonte da Faneca", Location(0.0, 0.0))
        Stop("Salto", Location(0.0, 0.0))
        Stop("Atalaia", Location(0.0, 0.0))
        Stop("Av. Álvaro Martins Homem", Location(0.0, 0.0))
        Stop("Cinco Ribeiras", Location(0.0, 0.0))
        Stop("Canada da Fontaínha", Location(0.0, 0.0))
        Stop("Alto das Covas - Escola", Location(0.0, 0.0))
        Stop("Raminho", Location(0.0, 0.0))
        Stop("Fanal", Location(0.0, 0.0))
        Stop("Serreta (Estalagem)", Location(0.0, 0.0))
        Stop("Praça Velha - Urbanas", Location(0.0, 0.0))
        Stop("Cruz das Cinco", Location(0.0, 0.0))
        Stop("São Bartolomeu (Igreja)", Location(0.0, 0.0))
        Stop("Biscoitos", Location(0.0, 0.0))
        Stop("Posto 1", Location(0.0, 0.0))
        Stop("Ribeirinha - Caminho Novo", Location(0.0, 0.0))
        Stop("Vila Nova - Praça", Location(0.0, 0.0))
        Stop("Biscoitos - Caparica", Location(0.0, 0.0))
        Stop("Lajes - Igreja", Location(0.0, 0.0))
        Stop("Fonte Bastardo - Império", Location(0.0, 0.0))
        Stop("Álamos Bravos", Location(0.0, 0.0))
        Stop("Cruz Dourada", Location(0.0, 0.0))
        Stop("Grota do Medo", Location(0.0, 0.0))
        Stop("Guarita", Location(0.0, 0.0))
        Stop("Base Aérea 4", Location(0.0, 0.0))
        Stop("Portões de S. Pedro", Location(0.0, 0.0))
        Stop("Quinta da Pata", Location(0.0, 0.0))
        Stop("S. João Deus - Largo", Location(0.0, 0.0))
        Stop("Ribeira dos Pães", Location(0.0, 0.0))
        Stop("Reguinho", Location(0.0, 0.0))
        Stop("Grota do Vale", Location(0.0, 0.0))
        Stop("Quatro Canadas", Location(0.0, 0.0))
        Stop("Ribeirinha", Location(0.0, 0.0))
        Stop("Quatro Ribeiras - Igreja", Location(0.0, 0.0))
        Stop("Cerrado do bailão - Fim", Location(0.0, 0.0))
        Stop("Altares - Igreja", Location(0.0, 0.0))
        Stop("Zona Industrial", Location(0.0, 0.0))
        Stop("Carreirinha", Location(0.0, 0.0))
        Stop("R. Dr. Henrique Bráz", Location(0.0, 0.0))
        Stop("Praça Almeida Garrett - Tribunal", Location(0.0, 0.0))
        Stop("Lar de Idosos", Location(0.0, 0.0))
        Stop("Estrela", Location(0.0, 0.0))
        Stop("Canada Nova de Sta. Luzia", Location(0.0, 0.0))
        Stop("Alto das Covas", Location(0.0, 0.0))
        Stop("Terreiro", Location(0.0, 0.0))
        Stop("Azória", Location(0.0, 0.0))
        Stop("Doze Ribeiras", Location(0.0, 0.0))
        Stop("Posto Santo - Igreja", Location(0.0, 0.0))
        Stop("Ladeira Grande - Império", Location(0.0, 0.0))
        Stop("Bairro - Forte", Location(0.0, 0.0))
        Stop("Praça de Toiros - Estacionamento", Location(0.0, 0.0))
        Stop("Biscoitos - Igreja Velha", Location(0.0, 0.0))
        Stop("Canada de Belém", Location(0.0, 0.0))
        Stop("Canada das Covas (Chafariz) 2", Location(0.0, 0.0))
        Stop("Pesqueiro", Location(0.0, 0.0))
        Stop("Pico Gordo - Entroncamento", Location(0.0, 0.0))
        Stop("Canada das Covas (Chafariz)", Location(0.0, 0.0))
        Stop("Pico Redondo", Location(0.0, 0.0))
        Stop("Porto Martins - Igreja", Location(0.0, 0.0))
        Stop("Serreta", Location(0.0, 0.0))
        Stop("Canada Capitão Mor", Location(0.0, 0.0))
        Stop("2 Caminhos", Location(0.0, 0.0))
        Stop("Porto das Pipas", Location(0.0, 0.0))
        Stop("Ribeira Seca", Location(0.0, 0.0))
        Stop("Cabo da Praia - Igreja", Location(0.0, 0.0))
        Stop("Fontinhas", Location(0.0, 0.0))
        Stop("Tomás de Borba", Location(0.0, 0.0))
        Stop("Praça Velha - Inter-Urbanas", Location(0.0, 0.0))
        Stop("Bairro do Lameirinho (Entrada)", Location(0.0, 0.0))
        Stop("Cruz das Cinco", Location(0.0, 0.0))
        Stop("Agualva - Igreja", Location(0.0, 0.0))
        Stop("Praça da Vila de São Sebastião", Location(0.0, 0.0))
        Stop("Vinha Brava", Location(0.0, 0.0))
        Stop("Bairro Novo", Location(0.0, 0.0))
        Stop("Silveira", Location(0.0, 0.0))
        Stop("Terra Alta", Location(0.0, 0.0))
        Stop("Santo Amaro", Location(0.0, 0.0))
        Stop("Mata - Veredas", Location(0.0, 0.0))
        Stop("Serra Santiago", Location(0.0, 0.0))
        Stop("Pico Bagacina", Location(0.0, 0.0))
        Stop("Pico Celeiro", Location(0.0, 0.0))
        Stop("Rua do Ramo Grande", Location(0.0, 0.0))
        Stop("São Bartolomeu - Igreja", Location(0.0, 0.0))
        Stop("Largo da Silveira", Location(0.0, 0.0))
        Stop("Rosário", Location(0.0, 0.0))
        Stop("Lourais", Location(0.0, 0.0))
        Stop("Cerrado do bailão", Location(0.0, 0.0))
        Stop("Praia da Vitória", Location(0.0, 0.0))
        Stop("Silveira 2", Location(0.0, 0.0))
        Stop("Cnd. Cinco Reis", Location(0.0, 0.0))
        Stop("Aeroporto", Location(0.0, 0.0))
        Stop("Escola Tomás de Borba", Location(0.0, 0.0))
        Stop("Terra Chã - Igreja", Location(0.0, 0.0))
        Stop("Rua dos Fundões", Location(0.0, 0.0))
        Stop("Santa Bárbara", Location(0.0, 0.0))
        Stop("Praça Velha - Interparques", Location(0.0, 0.0))
        Stop("S. Bartolomeu (Igreja) 2", Location(0.0, 0.0))
        Stop("Largo da Cruz", Location(0.0, 0.0))
        Stop("Feteira - Igreja", Location(0.0, 0.0))
    }
    fun loadWeekdays(){
        /* WEEKDAYS */
        loadFromAPI(0, "0", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("06h15", "06h16", "06h20", "06h25", "06h30", "06h35", "06h40", "06h42", "06h47", "06h52", "07h05"), "WEEKDAY", "")
        loadFromAPI(1, "1", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("07h00", "07h01", "07h05", "07h10", "07h15", "07h20", "07h25", "07h27", "07h32", "07h37", "07h50"), "WEEKDAY", "")
        loadFromAPI(2, "2", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("08h00", "08h01", "08h05", "08h10", "08h15", "08h20", "08h25", "08h27", "08h32", "08h37", "08h50"), "WEEKDAY", "")
        loadFromAPI(3, "3", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("10h00", "10h01", "10h05", "10h10", "10h15", "10h20", "10h25", "10h27", "10h32", "10h37", "10h50"), "WEEKDAY", "")
        loadFromAPI(4, "4", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("11h00", "11h01", "11h05", "11h10", "11h15", "11h20", "11h25", "11h27", "11h32", "11h37", "11h50"), "WEEKDAY", "")
        loadFromAPI(5, "5", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("12h00", "12h01", "12h05", "12h10", "12h15", "12h20", "12h25", "12h27", "12h32", "12h37", "12h50"), "WEEKDAY", "")
        loadFromAPI(6, "6", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("14h00", "14h01", "14h05", "14h10", "14h15", "14h20", "14h25", "14h27", "14h32", "14h37", "14h50"), "WEEKDAY", "")
        loadFromAPI(7, "7", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("16h00", "16h01", "16h05", "16h10", "16h15", "16h20", "16h25", "16h27", "16h32", "16h37", "16h50"), "WEEKDAY", "")
        loadFromAPI(8, "8", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("17h00", "17h01", "17h05", "17h10", "17h15", "17h20", "17h25", "17h27", "17h32", "17h37", "17h50"), "WEEKDAY", "")
        loadFromAPI(9, "9", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("18h00", "18h01", "18h05", "18h10", "18h15", "18h20", "18h25", "18h27", "18h32", "18h37", "18h50"), "WEEKDAY", "")
        loadFromAPI(10, "10", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("19h00", "19h01", "19h05", "19h10", "19h15", "19h20", "19h25", "19h27", "19h32", "19h37", "19h50"), "WEEKDAY", "")
        loadFromAPI(11, "11", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Álamos Bravos", "Praia da Vitória"), listOf("09h00", "09h01", "09h04", "09h08", "09h13", "09h18", "09h25", "09h27", "09h32", "09h37", "09h50"), "WEEKDAY", "")
        loadFromAPI(12, "12", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Álamos Bravos", "Praia da Vitória"), listOf("15h00", "15h01", "15h04", "15h08", "15h13", "15h18", "15h25", "15h27", "15h32", "15h37", "15h50"), "WEEKDAY", "")
        loadFromAPI(13, "13", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("13h00", "13h01", "13h04", "13h08", "13h10", "13h12", "13h14", "13h25", "13h27", "13h32", "13h37", "13h50"), "WEEKDAY", "")
        loadFromAPI(14, "14", listOf("Praia da Vitória", "Álamos Bravos", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("16h00", "16h10", "16h18", "16h23", "16h25", "16h30", "16h35", "16h42", "16h50"), "WEEKDAY", "")
        loadFromAPI(15, "15", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Ladeira Grande - Império", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("06h00", "06h10", "06h15", "06h20", "06h25", "06h32", "06h40", "06h42", "06h45", "06h47", "06h55"), "WEEKDAY", "")
        loadFromAPI(16, "16", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("14h00", "14h05", "14h15", "14h18", "14h25", "14h29", "14h37", "14h42", "14h45", "14h50"), "WEEKDAY", "")
        loadFromAPI(17, "17", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("07h00", "07h10", "07h20", "07h23", "07h25", "07h30", "07h35", "07h40", "07h50"), "WEEKDAY", "")
        loadFromAPI(18, "18", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("08h00", "08h10", "08h20", "08h23", "08h25", "08h30", "08h35", "08h40", "08h50"), "WEEKDAY", "")
        loadFromAPI(19, "19", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("09h00", "09h10", "09h20", "09h23", "09h25", "09h30", "09h35", "09h40", "09h50"), "WEEKDAY", "")
        loadFromAPI(20, "20", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("10h00", "10h10", "10h20", "10h23", "10h25", "10h30", "10h35", "10h40", "10h50"), "WEEKDAY", "")
        loadFromAPI(21, "21", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("11h00", "11h10", "11h20", "11h23", "11h25", "11h30", "11h35", "11h40", "11h50"), "WEEKDAY", "")
        loadFromAPI(22, "22", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("12h00", "12h10", "12h20", "12h23", "12h25", "12h30", "12h35", "12h40", "12h50"), "WEEKDAY", "")
        loadFromAPI(23, "23", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("13h00", "13h10", "13h20", "13h23", "13h25", "13h30", "13h35", "13h40", "13h50"), "WEEKDAY", "")
        loadFromAPI(24, "24", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("15h00", "15h10", "15h20", "15h23", "15h25", "15h30", "15h35", "15h40", "15h50"), "WEEKDAY", "")
        loadFromAPI(25, "25", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("17h00", "17h10", "17h20", "17h23", "17h25", "17h30", "17h35", "17h40", "17h50"), "WEEKDAY", "")
        loadFromAPI(26, "26", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("18h00", "18h10", "18h20", "18h23", "18h25", "18h30", "18h35", "18h40", "18h50"), "WEEKDAY", "")
        loadFromAPI(27, "27", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("19h00", "19h10", "19h20", "19h23", "19h25", "19h30", "19h35", "19h40", "19h50"), "WEEKDAY", "")
        loadFromAPI(28, "28", listOf("Raminho", "Altares - Igreja", "Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("06h30", "06h37", "06h45", "06h50", "07h00", "07h05", "07h12", "07h20", "07h25", "07h30"), "WEEKDAY", "")
        loadFromAPI(29, "29", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("07h50", "07h57", "08h00", "08h05", "08h15", "08h25", "08h40", "08h50"), "WEEKDAY", "")
        loadFromAPI(30, "30", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("10h30", "10h37", "10h40", "10h45", "10h55", "11h05", "11h20", "11h30"), "WEEKDAY", "")
        loadFromAPI(31, "31", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("14h00", "14h07", "14h10", "14h15", "14h25", "14h35", "14h50", "15h00"), "WEEKDAY", "")
        loadFromAPI(32, "32", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("16h00", "16h07", "16h10", "16h15", "16h25", "16h35", "16h50", "17h00"), "WEEKDAY", "")
        loadFromAPI(33, "33", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("18h00", "18h07", "18h10", "18h15", "18h25", "18h35", "18h50", "19h00"), "WEEKDAY", "")
        loadFromAPI(34, "34", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("20h00", "20h07", "20h10", "20h15", "20h25", "20h35", "20h50", "21h00"), "WEEKDAY", "")
        loadFromAPI(35, "35", listOf("Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("08h15", "08h20", "08h25", "08h30", "08h40", "08h45"), "WEEKDAY", "")
        loadFromAPI(36, "36", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("09h30", "09h35", "09h48", "09h58", "10h08", "10h10", "10h20", "10h30"), "WEEKDAY", "")
        loadFromAPI(37, "37", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("11h45", "11h50", "12h03", "12h13", "12h23", "12h25", "12h35", "12h45"), "WEEKDAY", "")
        loadFromAPI(38, "38", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("15h00", "15h05", "15h18", "15h28", "15h38", "15h40", "15h50", "16h00"), "WEEKDAY", "")
        loadFromAPI(39, "39", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("17h00", "17h05", "17h18", "17h28", "17h38", "17h40", "17h50", "18h00"), "WEEKDAY", "")
        loadFromAPI(40, "40", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("19h00", "19h05", "19h18", "19h28", "19h38", "19h40", "19h50", "20h00"), "WEEKDAY", "")
        loadFromAPI(41, "41", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Canada da Fontaínha", "Quatro Canadas", "Agualva - Igreja", "Vila Nova - Praça", "Aeroporto", "Posto 1"), listOf("15h00", "15h01", "15h04", "15h10", "15h21", "15h26", "15h29", "15h34", "15h40", "15h55"), "WEEKDAY", "")
        loadFromAPI(42, "42", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Canada da Fontaínha", "Quatro Canadas", "Agualva - Igreja", "Vila Nova - Praça", "Aeroporto", "Posto 1"), listOf("17h00", "17h01", "17h04", "17h10", "17h21", "17h26", "17h29", "17h34", "17h40", "17h55"), "WEEKDAY", "")
        loadFromAPI(43, "43", listOf("Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("06h45", "06h45", "06h48", "06h58", "07h08", "07h25", "07h35"), "WEEKDAY", "")
        loadFromAPI(44, "44", listOf("Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("08h00", "08h00", "08h03", "08h13", "08h23", "08h40", "08h50"), "WEEKDAY", "")
        loadFromAPI(45, "45", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Quatro Canadas", "Canada da Fontaínha", "Agualva - Igreja", "Vila Nova - Praça", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("18h30", "18h31", "18h34", "18h51", "18h54", "18h59", "19h04", "19h10", "19h15", "19h25"), "WEEKDAY", "")
        loadFromAPI(46, "46", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("12h00", "12h05", "12h10", "12h18", "12h28", "12h38", "12h50", "13h00"), "WEEKDAY", "")
        loadFromAPI(47, "47", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("09h35", "09h38", "09h41", "09h49", "09h57", "09h58", "10h01"), "WEEKDAY", "")
        loadFromAPI(48, "48", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("16h35", "16h38", "16h41", "16h49", "16h57", "16h58", "17h01"), "WEEKDAY", "")
        loadFromAPI(49, "49", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("08h25", "08h28", "08h33", "08h38", "08h47", "08h48", "08h51"), "WEEKDAY", "")
        loadFromAPI(50, "50", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("10h45", "10h48", "10h53", "10h58", "11h07", "11h08", "11h11"), "WEEKDAY", "")
        loadFromAPI(51, "51", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("12h35", "12h38", "12h43", "12h48", "12h57", "12h58", "13h01"), "WEEKDAY", "")
        loadFromAPI(52, "52", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("18h45", "18h48", "18h53", "18h58", "19h07", "19h08", "19h11"), "WEEKDAY", "")
        loadFromAPI(53, "53", listOf("Regatos", "Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h40", "17h43", "17h47", "17h50", "17h53", "18h02", "18h03", "18h06"), "WEEKDAY", "")
        loadFromAPI(54, "54", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("07h55", "08h01", "08h02", "08h03", "08h16", "08h20", "08h23", "08h26"), "WEEKDAY", "")
        loadFromAPI(55, "55", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("09h00", "09h06", "09h07", "09h08", "09h21", "09h25", "09h28", "09h31"), "WEEKDAY", "")
        loadFromAPI(56, "56", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("13h10", "13h16", "13h17", "13h18", "13h31", "13h35", "13h38", "13h41"), "WEEKDAY", "")
        loadFromAPI(57, "57", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("16h00", "16h06", "16h07", "16h08", "16h21", "16h25", "16h28", "16h31"), "WEEKDAY", "")
        loadFromAPI(58, "58", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("18h15", "18h21", "18h22", "18h23", "18h36", "18h40", "18h43", "18h46"), "WEEKDAY", "")
        loadFromAPI(59, "59", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("10h10", "10h16", "10h17", "10h30", "10h34", "10h36", "10h37"), "WEEKDAY", "")
        loadFromAPI(60, "60", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("12h00", "12h06", "12h07", "12h20", "12h24", "12h26", "12h27"), "WEEKDAY", "")
        loadFromAPI(61, "61", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("17h05", "17h11", "17h12", "17h25", "17h29", "17h31", "17h32"), "WEEKDAY", "")
        loadFromAPI(62, "62", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("19h15", "19h21", "19h22", "19h35", "19h39", "19h41", "19h42"), "WEEKDAY", "")
        loadFromAPI(63, "63", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("07h20", "07h23", "07h26", "07h29", "07h32", "07h36", "07h42", "07h43", "07h46"), "WEEKDAY", "")
        loadFromAPI(64, "64", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Serretinha", "Largo da Cruz", "Refugo"), listOf("07h50", "07h51", "07h54", "08h02", "08h07", "08h15", "08h20"), "WEEKDAY", "")
        loadFromAPI(65, "65", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Serretinha", "Largo da Cruz", "Refugo"), listOf("17h00", "17h01", "17h04", "17h12", "17h17", "17h25", "17h30"), "WEEKDAY", "")
        loadFromAPI(66, "66", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Serretinha", "Largo da Cruz"), listOf("09h00", "09h01", "09h04", "09h12", "09h17", "09h25"), "WEEKDAY", "")
        loadFromAPI(67, "67", listOf("Refugo", "Largo da Cruz", "Serretinha", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("12h25", "12h30", "12h33", "12h38", "12h50"), "WEEKDAY", "")
        loadFromAPI(68, "68", listOf("Refugo", "Largo da Cruz", "Serretinha", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("17h30", "17h35", "17h38", "17h43", "17h55"), "WEEKDAY", "")
        loadFromAPI(69, "69", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Feteira - Igreja", "Largo da Cruz"), listOf("16h00", "16h01", "16h04", "16h12", "16h15", "16h30"), "WEEKDAY", "")
        loadFromAPI(70, "70", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Feteira - Igreja", "Largo da Cruz", "Refugo"), listOf("11h50", "11h51", "11h54", "12h02", "12h05", "12h20", "12h25"), "WEEKDAY", "")
        loadFromAPI(71, "71", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Ladeira Grande - Império", "Feteira - Igreja", "Largo da Cruz", "Refugo"), listOf("18h00", "18h01", "18h04", "18h12", "18h15", "18h30", "18h35"), "WEEKDAY", "")
        loadFromAPI(72, "72", listOf("Refugo", "Largo da Cruz", "Feteira - Igreja", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("07h15", "07h20", "07h25", "07h28", "07h40"), "WEEKDAY", "")
        loadFromAPI(73, "73", listOf("Refugo", "Largo da Cruz", "Feteira - Igreja", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("08h20", "08h25", "08h30", "08h33", "08h45"), "WEEKDAY", "")
        loadFromAPI(74, "74", listOf("Largo da Cruz", "Feteira - Igreja", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("09h30", "09h40", "09h43", "09h55"), "WEEKDAY", "")
        loadFromAPI(75, "75", listOf("Largo da Cruz", "Serretinha", "Ladeira Grande - Império", "Praça Velha - Sub-Urbanas"), listOf("16h30", "16h38", "16h43", "16h55"), "WEEKDAY", "")
        loadFromAPI(76, "76", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Casa da Ribeira - Igreja", "Praia da Vitória"), listOf("07h15", "07h25", "07h32", "07h40", "07h50"), "WEEKDAY", "")
        loadFromAPI(77, "77", listOf("Fonte Bastardo - Império", "Ponta Negra", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("08h35", "08h47", "08h50", "08h57", "09h05"), "WEEKDAY", "")
        loadFromAPI(78, "78", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("13h30", "13h40", "13h47", "13h55"), "WEEKDAY", "")
        loadFromAPI(79, "79", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("15h30", "15h40", "15h47", "15h55"), "WEEKDAY", "")
        loadFromAPI(80, "80", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("17h30", "17h40", "17h47", "17h55"), "WEEKDAY", "")
        loadFromAPI(81, "81", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("18h50", "19h00", "19h07", "19h15"), "WEEKDAY", "")
        loadFromAPI(82, "82", listOf("Praia da Vitória", "Cabo da Praia", "Ponta Negra", "Porto Martins - Igreja", "Fonte Bastardo - Império"), listOf("07h50", "07h58", "08h05", "08h08", "08h20"), "WEEKDAY", "")
        loadFromAPI(83, "83", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("06h50", "06h58", "07h05", "07h15"), "WEEKDAY", "")
        loadFromAPI(84, "84", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("12h50", "12h58", "13h05", "13h15"), "WEEKDAY", "")
        loadFromAPI(85, "85", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("14h50", "14h58", "15h05", "15h15"), "WEEKDAY", "")
        loadFromAPI(86, "86", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("16h50", "16h58", "17h05", "17h15"), "WEEKDAY", "")
        loadFromAPI(87, "87", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("18h20", "18h28", "18h35", "18h45"), "WEEKDAY", "")
        loadFromAPI(88, "88", listOf("Praia da Vitória", "Fontinhas", "Fontinha"), listOf("17h30", "17h40", "17h45"), "WEEKDAY", "")
        loadFromAPI(89, "89", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("07h50", "08h00", "08h05", "08h15"), "WEEKDAY", "")
        loadFromAPI(90, "90", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("12h00", "12h10", "12h15", "12h25"), "WEEKDAY", "")
        loadFromAPI(91, "91", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("15h00", "15h10", "15h15", "15h25"), "WEEKDAY", "")
        loadFromAPI(92, "92", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("18h10", "18h20", "18h25", "18h35"), "WEEKDAY", "")
        loadFromAPI(93, "93", listOf("Fontinha", "Fontinhas", "Praia da Vitória"), listOf("17h50", "17h55", "18h05"), "WEEKDAY", "")
        loadFromAPI(94, "94", listOf("Quatro Canadas", "Lourais", "Ribeira dos Pães", "Rua dos Fundões", "Lajes - Igreja", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("07h10", "07h15", "07h18", "07h20", "07h25", "07h30", "07h35", "07h45"), "WEEKDAY", "")
        loadFromAPI(95, "95", listOf("Quatro Canadas", "Lourais", "Ribeira dos Pães", "Rua dos Fundões", "Lajes - Igreja", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("08h20", "08h25", "08h28", "08h30", "08h35", "08h40", "08h45", "08h55"), "WEEKDAY", "")
        loadFromAPI(96, "96", listOf("Biscoitos - Caparica", "Biscoitos - Igreja Velha", "Biscoitos", "Altares - Igreja", "Pico Gordo - Entroncamento", "Pico Bagacina", "Mata - Veredas", "Praça Velha - Inter-Urbanas"), listOf("09h00", "09h02", "09h03", "09h10", "09h25", "09h30", "09h35", "09h45"), "WEEKDAY", "")
        loadFromAPI(97, "97", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Mata - Veredas", "Pico Bagacina", "Pico Gordo - Entroncamento", "Altares - Igreja", "Biscoitos - Igreja Velha"), listOf("16h00", "16h01", "16h04", "16h15", "16h20", "16h25", "16h40", "16h50"), "WEEKDAY", "")
        loadFromAPI(98, "98", listOf("Praia da Vitória", "Casa da Ribeira - Igreja"), listOf("13h10", "13h20"), "WEEKDAY", "")
        loadFromAPI(99, "99", listOf("Praia da Vitória", "Casa da Ribeira - Igreja"), listOf("18h00", "18h10"), "WEEKDAY", "")
        loadFromAPI(100, "100", listOf("Praia da Vitória", "Casa da Ribeira - Igreja", "Pico Celeiro"), listOf("08h30", "08h40", "08h45"), "WEEKDAY", "")
        loadFromAPI(101, "101", listOf("Praia da Vitória", "Casa da Ribeira - Igreja", "Pico Celeiro"), listOf("12h00", "12h10", "12h15"), "WEEKDAY", "")
        loadFromAPI(102, "102", listOf("Praia da Vitória", "Casa da Ribeira - Igreja", "Pico Celeiro"), listOf("16h30", "16h40", "16h45"), "WEEKDAY", "")
        loadFromAPI(103, "103", listOf("Cruz Dourada", "Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("08h15", "08h17", "08h19", "08h21", "08h23", "08h25", "08h27", "08h29", "08h35", "08h36", "08h39", "08h42"), "WEEKDAY", "")
        loadFromAPI(104, "104", listOf("Cruz Dourada", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Largo S. Bento", "Salto", "Quinta da Vargem", "Reguinho"), listOf("18h45", "18h49", "18h50", "18h53", "18h57", "19h01", "19h03", "19h05", "19h06", "19h09", "19h10", "19h11", "19h13", "19h16"), "WEEKDAY", "")
        loadFromAPI(105, "105", listOf("Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("15h15", "15h18", "15h20", "15h22", "15h25", "15h28", "15h34", "15h35", "15h38", "15h41"), "WEEKDAY", "")
        loadFromAPI(106, "106", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Cruz Dourada"), listOf("07h45", "07h53", "07h54", "07h56", "07h59", "08h01", "08h03", "08h07", "08h12", "08h17"), "WEEKDAY", "")
        loadFromAPI(107, "107", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor", "Cruz Dourada"), listOf("18h10", "18h20", "18h21", "18h22", "18h25", "18h27", "18h30", "18h35", "18h40", "18h45", "18h48"), "WEEKDAY", "")
        loadFromAPI(108, "108", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Carreirinha", "Guarita", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro"), listOf("14h30", "14h33", "14h34", "14h36", "14h37", "14h38", "14h39", "14h40", "14h43", "14h47", "14h52", "14h57", "15h02"), "WEEKDAY", "")
        loadFromAPI(109, "109", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("06h45", "06h53", "06h54", "06h56", "06h57", "07h01", "07h05", "07h08", "07h11", "07h16"), "WEEKDAY", "")
        loadFromAPI(110, "110", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("09h00", "09h08", "09h09", "09h11", "09h12", "09h16", "09h20", "09h23", "09h26", "09h31"), "WEEKDAY", "")
        loadFromAPI(111, "111", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("12h00", "12h08", "12h09", "12h11", "12h12", "12h16", "12h20", "12h23", "12h26", "12h31"), "WEEKDAY", "")
        loadFromAPI(112, "112", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("13h10", "13h18", "13h19", "13h21", "13h22", "13h26", "13h30", "13h33", "13h36", "13h41"), "WEEKDAY", "")
        loadFromAPI(113, "113", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("16h00", "16h08", "16h09", "16h11", "16h12", "16h16", "16h20", "16h23", "16h26", "16h31"), "WEEKDAY", "")
        loadFromAPI(114, "114", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("17h05", "17h13", "17h14", "17h16", "17h17", "17h21", "17h25", "17h28", "17h31", "17h36"), "WEEKDAY", "")
        loadFromAPI(115, "115", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("07h15", "07h18", "07h21", "07h24", "07h28", "07h30", "07h31", "07h35", "07h36", "07h39", "07h41"), "WEEKDAY", "")
        loadFromAPI(116, "116", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("09h30", "09h33", "09h36", "09h39", "09h43", "09h45", "09h46", "09h50", "09h51", "09h54", "09h56"), "WEEKDAY", "")
        loadFromAPI(117, "117", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("12h35", "12h38", "12h41", "12h44", "12h48", "12h50", "12h51", "12h55", "12h56", "12h59", "13h01"), "WEEKDAY", "")
        loadFromAPI(118, "118", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("13h45", "13h48", "13h51", "13h54", "13h58", "14h00", "14h01", "14h05", "14h06", "14h09", "14h11"), "WEEKDAY", "")
        loadFromAPI(119, "119", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("16h35", "16h38", "16h41", "16h44", "16h48", "16h50", "16h51", "16h55", "16h56", "16h59", "17h01"), "WEEKDAY", "")
        loadFromAPI(120, "120", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("17h40", "17h43", "17h46", "17h49", "17h53", "17h55", "17h56", "18h00", "18h01", "18h04", "18h06"), "WEEKDAY", "")
        loadFromAPI(121, "121", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Guarita"), listOf("10h15", "10h18", "10h21", "10h24", "10h27"), "WEEKDAY", "")
        loadFromAPI(122, "122", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Guarita"), listOf("18h30", "18h33", "18h36", "18h39", "18h42"), "WEEKDAY", "")
        loadFromAPI(123, "123", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("06h15", "06h20", "06h23", "06h27", "06h40", "06h41", "06h42", "06h45", "06h48"), "WEEKDAY", "")
        loadFromAPI(124, "124", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("08h15", "08h20", "08h23", "08h27", "08h40", "08h41", "08h42", "08h45", "08h48"), "WEEKDAY", "")
        loadFromAPI(125, "125", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("09h15", "09h20", "09h23", "09h27", "09h40", "09h41", "09h42", "09h45", "09h48"), "WEEKDAY", "")
        loadFromAPI(126, "126", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("13h30", "13h35", "13h38", "13h42", "13h55", "13h56", "13h57", "14h00", "14h03"), "WEEKDAY", "")
        loadFromAPI(127, "127", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("16h30", "16h35", "16h38", "16h42", "16h55", "16h56", "16h57", "17h00", "17h03"), "WEEKDAY", "")
        loadFromAPI(128, "128", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("17h30", "17h35", "17h38", "17h42", "17h55", "17h56", "17h57", "18h00", "18h03"), "WEEKDAY", "")
        loadFromAPI(129, "129", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada do Célis"), listOf("07h15", "07h20", "07h24", "07h28", "07h36", "07h37", "07h38", "07h41", "07h44", "07h47", "07h49"), "WEEKDAY", "")
        loadFromAPI(130, "130", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada do Célis"), listOf("12h30", "12h35", "12h39", "12h43", "12h51", "12h52", "12h53", "12h56", "12h59", "13h02", "13h04"), "WEEKDAY", "")
        loadFromAPI(131, "131", listOf("Canada de Belém", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("12h00", "12h04", "12h06", "12h09", "12h12", "12h15", "12h16", "12h19", "12h22", "12h25", "12h27", "12h30"), "WEEKDAY", "")
        loadFromAPI(132, "132", listOf("Canada de Belém", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("16h00", "16h04", "16h06", "16h09", "16h12", "16h15", "16h16", "16h19", "16h22", "16h25", "16h27", "16h30"), "WEEKDAY", "")
        loadFromAPI(133, "133", listOf("Canada do Célis", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("07h45", "07h46", "07h49", "07h53", "07h55", "08h00", "08h01", "08h04", "08h07", "08h10", "08h12", "08h15"), "WEEKDAY", "")
        loadFromAPI(134, "134", listOf("Canada do Célis", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("13h00", "13h01", "13h04", "13h08", "13h10", "13h15", "13h16", "13h19", "13h22", "13h25", "13h27", "13h30"), "WEEKDAY", "")
        loadFromAPI(135, "135", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("06h45", "06h49", "06h53", "07h00", "07h01", "07h04", "07h07", "07h10", "07h12", "07h15"), "WEEKDAY", "")
        loadFromAPI(136, "136", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("08h45", "08h49", "08h53", "09h00", "09h01", "09h04", "09h07", "09h10", "09h12", "09h15"), "WEEKDAY", "")
        loadFromAPI(137, "137", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("09h45", "09h49", "09h53", "10h00", "10h01", "10h04", "10h07", "10h10", "10h12", "10h15"), "WEEKDAY", "")
        loadFromAPI(138, "138", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("14h00", "14h04", "14h08", "14h15", "14h16", "14h19", "14h22", "14h25", "14h27", "14h30"), "WEEKDAY", "")
        loadFromAPI(139, "139", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("17h00", "17h04", "17h08", "17h15", "17h16", "17h19", "17h22", "17h25", "17h27", "17h30"), "WEEKDAY", "")
        loadFromAPI(140, "140", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("18h00", "18h04", "18h08", "18h15", "18h16", "18h19", "18h22", "18h25", "18h27", "18h30"), "WEEKDAY", "")
        loadFromAPI(141, "141", listOf("Carreirinha", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada de Belém"), listOf("11h45", "11h47", "11h53", "11h54", "11h55", "11h57", "11h59", "12h01", "12h03"), "WEEKDAY", "")
        loadFromAPI(142, "142", listOf("Carreirinha", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada de Belém"), listOf("15h45", "15h47", "15h53", "15h54", "15h55", "15h57", "15h59", "16h01", "16h03"), "WEEKDAY", "")
        loadFromAPI(143, "143", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("07h15", "07h20", "07h35", "07h36", "07h40"), "WEEKDAY", "")
        loadFromAPI(144, "144", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("08h15", "08h20", "08h35", "08h36", "08h40"), "WEEKDAY", "")
        loadFromAPI(145, "145", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("13h30", "13h35", "13h50", "13h51", "13h55"), "WEEKDAY", "")
        loadFromAPI(146, "146", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("16h30", "16h35", "16h50", "16h51", "16h55"), "WEEKDAY", "")
        loadFromAPI(147, "147", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h30", "17h35", "17h50", "17h51", "17h55"), "WEEKDAY", "")
        loadFromAPI(148, "148", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("18h30", "18h35", "18h50", "18h51", "18h55"), "WEEKDAY", "")
        loadFromAPI(149, "149", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("11h00", "11h20", "11h21", "11h25"), "WEEKDAY", "")
        loadFromAPI(150, "150", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("15h15", "15h35", "15h36", "15h40"), "WEEKDAY", "")
        loadFromAPI(151, "151", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("09h30", "09h55", "09h56", "10h00"), "WEEKDAY", "")
        loadFromAPI(152, "152", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("12h30", "12h55", "12h56", "13h00"), "WEEKDAY", "")
        loadFromAPI(153, "153", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Fonte da Faneca"), listOf("12h00", "12h04", "12h05", "12h06", "12h29"), "WEEKDAY", "")
        loadFromAPI(154, "154", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Fonte da Faneca"), listOf("13h00", "13h04", "13h05", "13h06", "13h29"), "WEEKDAY", "")
        loadFromAPI(155, "155", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Fonte da Faneca"), listOf("16h00", "16h04", "16h05", "16h06", "16h29"), "WEEKDAY", "")
        loadFromAPI(156, "156", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Fonte da Faneca"), listOf("18h00", "18h04", "18h05", "18h06", "18h29"), "WEEKDAY", "")
        loadFromAPI(157, "157", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("06h45", "06h48", "06h49", "06h50", "07h13"), "WEEKDAY", "")
        loadFromAPI(158, "158", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("07h45", "07h48", "07h49", "07h50", "08h13"), "WEEKDAY", "")
        loadFromAPI(159, "159", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("09h00", "09h03", "09h04", "09h05", "09h28"), "WEEKDAY", "")
        loadFromAPI(160, "160", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("17h05", "17h08", "17h09", "17h10", "17h33"), "WEEKDAY", "")
        loadFromAPI(161, "161", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("14h45", "14h48", "14h53", "14h54", "14h55", "15h17"), "WEEKDAY", "")
        loadFromAPI(162, "162", listOf("Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("10h30", "10h34", "10h35", "10h36", "10h58"), "WEEKDAY", "")
        loadFromAPI(163, "163", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("07h00", "07h03", "07h06", "07h08", "07h13", "07h25"), "WEEKDAY", "")
        loadFromAPI(164, "164", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("08h00", "08h03", "08h06", "08h08", "08h13", "08h25"), "WEEKDAY", "")
        loadFromAPI(165, "165", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("09h00", "09h03", "09h06", "09h08", "09h13", "09h25"), "WEEKDAY", "")
        loadFromAPI(166, "166", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("12h00", "12h03", "12h06", "12h08", "12h13", "12h25"), "WEEKDAY", "")
        loadFromAPI(167, "167", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("13h00", "13h03", "13h06", "13h08", "13h13", "13h25"), "WEEKDAY", "")
        loadFromAPI(168, "168", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("16h00", "16h03", "16h06", "16h08", "16h13", "16h25"), "WEEKDAY", "")
        loadFromAPI(169, "169", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("17h00", "17h03", "17h06", "17h08", "17h13", "17h25"), "WEEKDAY", "")
        loadFromAPI(170, "170", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("18h00", "18h03", "18h06", "18h08", "18h13", "18h25"), "WEEKDAY", "")
        loadFromAPI(171, "171", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("07h25", "07h29", "07h34", "07h44", "07h45", "07h49", "07h55"), "WEEKDAY", "")
        loadFromAPI(172, "172", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("08h25", "08h29", "08h34", "08h44", "08h45", "08h49", "08h55"), "WEEKDAY", "")
        loadFromAPI(173, "173", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("09h25", "09h29", "09h34", "09h44", "09h45", "09h49", "09h55"), "WEEKDAY", "")
        loadFromAPI(174, "174", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("12h30", "12h34", "12h39", "12h49", "12h50", "12h54", "13h00"), "WEEKDAY", "")
        loadFromAPI(175, "175", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("13h30", "13h34", "13h39", "13h49", "13h50", "13h54", "14h00"), "WEEKDAY", "")
        loadFromAPI(176, "176", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("16h30", "16h34", "16h39", "16h49", "16h50", "16h54", "17h00"), "WEEKDAY", "")
        loadFromAPI(177, "177", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("17h30", "17h34", "17h39", "17h49", "17h50", "17h54", "18h00"), "WEEKDAY", "")
        loadFromAPI(178, "178", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("18h30", "18h34", "18h39", "18h49", "18h50", "18h54", "19h00"), "WEEKDAY", "")
        loadFromAPI(179, "179", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("14h00", "14h20", "14h21", "14h23", "14h30"), "WEEKDAY", "")
        loadFromAPI(180, "180", listOf("Bairro Novo", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("07h00", "07h20", "07h21", "07h23", "07h30"), "WEEKDAY", "")
        loadFromAPI(181, "181", listOf("Bairro Novo", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("08h00", "08h20", "08h21", "08h23", "08h30"), "WEEKDAY", "")
        loadFromAPI(182, "182", listOf("Bairro Novo", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("18h00", "18h20", "18h21", "18h23", "18h30"), "WEEKDAY", "")
        loadFromAPI(183, "183", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("09h05", "09h25", "09h26", "09h28", "09h33", "09h35"), "WEEKDAY", "")
        loadFromAPI(184, "184", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("12h00", "12h20", "12h21", "12h23", "12h28", "12h30"), "WEEKDAY", "")
        loadFromAPI(185, "185", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("13h00", "13h20", "13h21", "13h23", "13h28", "13h30"), "WEEKDAY", "")
        loadFromAPI(186, "186", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("16h15", "16h35", "16h36", "16h38", "16h43", "16h45"), "WEEKDAY", "")
        loadFromAPI(187, "187", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("19h00", "19h20", "19h21", "19h23", "19h28", "19h30"), "WEEKDAY", "")
        loadFromAPI(188, "188", listOf("Hospital", "Bairro do Lameirinho (Entrada)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("06h30", "06h31", "06h34", "06h40", "06h41", "06h42", "07h02"), "WEEKDAY", "")
        loadFromAPI(189, "189", listOf("Hospital", "Bairro do Lameirinho (Entrada)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("11h30", "11h31", "11h34", "11h40", "11h41", "11h42", "12h02"), "WEEKDAY", "")
        loadFromAPI(190, "190", listOf("Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("13h30", "13h32", "13h39", "13h40", "13h41", "14h01"), "WEEKDAY", "")
        loadFromAPI(191, "191", listOf("Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("19h30", "19h32", "19h39", "19h40", "19h41", "20h01"), "WEEKDAY", "")
        loadFromAPI(192, "192", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("07h30", "07h32", "07h35", "07h38", "07h39", "07h40", "08h00"), "WEEKDAY", "")
        loadFromAPI(193, "193", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("12h30", "12h32", "12h35", "12h38", "12h39", "12h40", "13h00"), "WEEKDAY", "")
        loadFromAPI(194, "194", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("15h45", "15h47", "15h50", "15h53", "15h54", "15h55", "16h15"), "WEEKDAY", "")
        loadFromAPI(195, "195", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("17h00", "17h02", "17h05", "17h08", "17h09", "17h10", "17h30"), "WEEKDAY", "")
        loadFromAPI(196, "196", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("18h30", "18h32", "18h35", "18h38", "18h39", "18h40", "19h00"), "WEEKDAY", "")
        loadFromAPI(197, "197", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("20h00", "20h20", "20h21", "20h23"), "WEEKDAY", "")
        loadFromAPI(198, "198", listOf("Grota do Medo", "Vinha Brava", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("08h35", "08h36", "08h42", "08h46", "08h47", "08h48", "09h06"), "WEEKDAY", "")
        loadFromAPI(199, "199", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Hospital", "Pico Redondo", "Canada da Fontaínha", "Zona Industrial", "Reguinho", "Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("09h00", "09h05", "09h06", "09h08", "09h11", "09h15", "09h26", "09h27", "09h30", "09h38", "09h40", "09h45", "09h54", "09h57", "10h03"), "WEEKDAY", "")
        loadFromAPI(200, "200", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Hospital", "Pico Redondo", "Canada da Fontaínha", "Zona Industrial", "Reguinho", "Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("13h00", "13h05", "13h06", "13h08", "13h11", "13h15", "13h26", "13h27", "13h30", "13h38", "13h40", "13h45", "13h54", "13h57", "14h03"), "WEEKDAY", "")
        loadFromAPI(201, "201", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Hospital", "Pico Redondo", "Canada da Fontaínha", "Zona Industrial", "Reguinho", "Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("17h00", "17h05", "17h06", "17h08", "17h11", "17h15", "17h26", "17h27", "17h30", "17h38", "17h40", "17h45", "17h54", "17h57", "18h03"), "WEEKDAY", "")
        loadFromAPI(202, "202", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Reguinho", "Vinha Brava", "Hospital", "Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("12h00", "12h05", "12h06", "12h08", "12h12", "12h25", "12h27", "12h30", "12h35", "12h40", "12h44", "12h49"), "WEEKDAY", "")
        loadFromAPI(203, "203", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Reguinho", "Vinha Brava", "Hospital", "Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("18h00", "18h05", "18h06", "18h08", "18h12", "18h25", "18h27", "18h30", "18h35", "18h40", "18h44", "18h49"), "WEEKDAY", "")
        loadFromAPI(204, "204", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("07h45", "07h48", "07h49", "07h53", "07h56", "07h58", "08h00", "08h06", "08h10", "08h10"), "WEEKDAY", "")
        loadFromAPI(205, "205", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("08h00", "08h03", "08h04", "08h08", "08h11", "08h13", "08h15", "08h21", "08h25", "08h25"), "WEEKDAY", "")
        loadFromAPI(206, "206", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("08h15", "08h18", "08h19", "08h23", "08h26", "08h28", "08h30", "08h36", "08h40", "08h40"), "WEEKDAY", "")
        loadFromAPI(207, "207", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("08h30", "08h33", "08h34", "08h38", "08h41", "08h43", "08h45", "08h51", "08h55", "08h55"), "WEEKDAY", "")
        loadFromAPI(208, "208", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("08h45", "08h48", "08h49", "08h53", "08h56", "08h58", "09h00", "09h06", "09h10", "09h10"), "WEEKDAY", "")
        loadFromAPI(209, "209", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("09h00", "09h03", "09h04", "09h08", "09h11", "09h13", "09h15", "09h21", "09h25", "09h25"), "WEEKDAY", "")
        loadFromAPI(210, "210", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("09h15", "09h18", "09h19", "09h23", "09h26", "09h28", "09h30", "09h36", "09h40", "09h40"), "WEEKDAY", "")
        loadFromAPI(211, "211", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("09h30", "09h33", "09h34", "09h38", "09h41", "09h43", "09h45", "09h51", "09h55", "09h55"), "WEEKDAY", "")
        loadFromAPI(212, "212", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("09h45", "09h48", "09h49", "09h53", "09h56", "09h58", "10h00", "10h06", "10h10", "10h10"), "WEEKDAY", "")
        loadFromAPI(213, "213", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("10h00", "10h03", "10h04", "10h08", "10h11", "10h13", "10h15", "10h21", "10h25", "10h25"), "WEEKDAY", "")
        loadFromAPI(214, "214", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("10h15", "10h18", "10h19", "10h23", "10h26", "10h28", "10h30", "10h36", "10h40", "10h40"), "WEEKDAY", "")
        loadFromAPI(215, "215", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("10h30", "10h33", "10h34", "10h38", "10h41", "10h43", "10h45", "10h51", "10h55", "10h55"), "WEEKDAY", "")
        loadFromAPI(216, "216", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("10h45", "10h48", "10h49", "10h53", "10h56", "10h58", "11h00", "11h06", "11h10", "11h10"), "WEEKDAY", "")
        loadFromAPI(217, "217", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("11h00", "11h03", "11h04", "11h08", "11h11", "11h13", "11h15", "11h21", "11h25", "11h25"), "WEEKDAY", "")
        loadFromAPI(218, "218", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("11h15", "11h18", "11h19", "11h23", "11h26", "11h28", "11h30", "11h36", "11h40", "11h40"), "WEEKDAY", "")
        loadFromAPI(219, "219", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("11h30", "11h33", "11h34", "11h38", "11h41", "11h43", "11h45", "11h51", "11h55", "11h55"), "WEEKDAY", "")
        loadFromAPI(220, "220", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("11h45", "11h48", "11h49", "11h53", "11h56", "11h58", "12h00", "12h06", "12h10", "12h10"), "WEEKDAY", "")
        loadFromAPI(221, "221", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("12h00", "12h03", "12h04", "12h08", "12h11", "12h13", "12h15", "12h21", "12h25", "12h25"), "WEEKDAY", "")
        loadFromAPI(222, "222", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("12h15", "12h18", "12h19", "12h23", "12h26", "12h28", "12h30", "12h36", "12h40", "12h40"), "WEEKDAY", "")
        loadFromAPI(223, "223", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("12h30", "12h33", "12h34", "12h38", "12h41", "12h43", "12h45", "12h51", "12h55", "12h55"), "WEEKDAY", "")
        loadFromAPI(224, "224", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("12h45", "12h48", "12h49", "12h53", "12h56", "12h58", "13h00", "13h06", "13h10", "13h10"), "WEEKDAY", "")
        loadFromAPI(225, "225", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("13h00", "13h03", "13h04", "13h08", "13h11", "13h13", "13h15", "13h21", "13h25", "13h25"), "WEEKDAY", "")
        loadFromAPI(226, "226", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("13h15", "13h18", "13h19", "13h23", "13h26", "13h28", "13h30", "13h36", "13h40", "13h40"), "WEEKDAY", "")
        loadFromAPI(227, "227", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("13h30", "13h33", "13h34", "13h38", "13h41", "13h43", "13h45", "13h51", "13h55", "13h55"), "WEEKDAY", "")
        loadFromAPI(228, "228", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("13h45", "13h48", "13h49", "13h53", "13h56", "13h58", "14h00", "14h06", "14h10", "14h10"), "WEEKDAY", "")
        loadFromAPI(229, "229", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("14h00", "14h03", "14h04", "14h08", "14h11", "14h13", "14h15", "14h21", "14h25", "14h25"), "WEEKDAY", "")
        loadFromAPI(230, "230", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("14h15", "14h18", "14h19", "14h23", "14h26", "14h28", "14h30", "14h36", "14h40", "14h40"), "WEEKDAY", "")
        loadFromAPI(231, "231", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("14h30", "14h33", "14h34", "14h38", "14h41", "14h43", "14h45", "14h51", "14h55", "14h55"), "WEEKDAY", "")
        loadFromAPI(232, "232", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("14h45", "14h48", "14h49", "14h53", "14h56", "14h58", "15h00", "15h06", "15h10", "15h10"), "WEEKDAY", "")
        loadFromAPI(233, "233", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("15h00", "15h03", "15h04", "15h08", "15h11", "15h13", "15h15", "15h21", "15h25", "15h25"), "WEEKDAY", "")
        loadFromAPI(234, "234", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("15h15", "15h18", "15h19", "15h23", "15h26", "15h28", "15h30", "15h36", "15h40", "15h40"), "WEEKDAY", "")
        loadFromAPI(235, "235", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("15h30", "15h33", "15h34", "15h38", "15h41", "15h43", "15h45", "15h51", "15h55", "15h55"), "WEEKDAY", "")
        loadFromAPI(236, "236", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("15h45", "15h48", "15h49", "15h53", "15h56", "15h58", "16h00", "16h06", "16h10", "16h10"), "WEEKDAY", "")
        loadFromAPI(237, "237", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("16h00", "16h03", "16h04", "16h08", "16h11", "16h13", "16h15", "16h21", "16h25", "16h25"), "WEEKDAY", "")
        loadFromAPI(238, "238", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("16h15", "16h18", "16h19", "16h23", "16h26", "16h28", "16h30", "16h36", "16h40", "16h40"), "WEEKDAY", "")
        loadFromAPI(239, "239", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("16h30", "16h33", "16h34", "16h38", "16h41", "16h43", "16h45", "16h51", "16h55", "16h55"), "WEEKDAY", "")
        loadFromAPI(240, "240", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("16h45", "16h48", "16h49", "16h53", "16h56", "16h58", "17h00", "17h06", "17h10", "17h10"), "WEEKDAY", "")
        loadFromAPI(241, "241", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("17h00", "17h03", "17h04", "17h08", "17h11", "17h13", "17h15", "17h21", "17h25", "17h25"), "WEEKDAY", "")
        loadFromAPI(242, "242", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("17h15", "17h18", "17h19", "17h23", "17h26", "17h28", "17h30", "17h36", "17h40", "17h40"), "WEEKDAY", "")
        loadFromAPI(243, "243", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("17h30", "17h33", "17h34", "17h38", "17h41", "17h43", "17h45", "17h51", "17h55", "17h55"), "WEEKDAY", "")
        loadFromAPI(244, "244", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("17h45", "17h48", "17h49", "17h53", "17h56", "17h58", "18h00", "18h06", "18h10", "18h10"), "WEEKDAY", "")
        loadFromAPI(245, "245", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("18h00", "18h03", "18h04", "18h08", "18h11", "18h13", "18h15", "18h21", "18h25", "18h25"), "WEEKDAY", "")
        loadFromAPI(246, "246", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("18h15", "18h18", "18h19", "18h23", "18h26", "18h28", "18h30", "18h36", "18h40", "18h40"), "WEEKDAY", "")
        loadFromAPI(247, "247", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Portões de S. Pedro", "Fanal", "Cerrado do bailão"), listOf("18h30", "18h33", "18h34", "18h38", "18h41", "18h43", "18h45", "18h51", "18h55", "18h55"), "WEEKDAY", "")
        loadFromAPI(248, "248", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("07h50", "07h50", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53", "07h53"), "WEEKDAY", "")
        loadFromAPI(249, "249", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("08h50", "08h50", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53", "08h53"), "WEEKDAY", "")
        loadFromAPI(250, "250", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("09h50", "09h50", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53", "09h53"), "WEEKDAY", "")
        loadFromAPI(251, "251", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("10h50", "10h50", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53", "10h53"), "WEEKDAY", "")
        loadFromAPI(252, "252", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("11h50", "11h50", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53", "11h53"), "WEEKDAY", "")
        loadFromAPI(253, "253", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("12h50", "12h50", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53", "12h53"), "WEEKDAY", "")
        loadFromAPI(254, "254", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("13h50", "13h50", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53", "13h53"), "WEEKDAY", "")
        loadFromAPI(255, "255", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("14h50", "14h50", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53", "14h53"), "WEEKDAY", "")
        loadFromAPI(256, "256", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("15h50", "15h50", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53", "15h53"), "WEEKDAY", "")
        loadFromAPI(257, "257", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("16h50", "16h50", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53", "16h53"), "WEEKDAY", "")
        loadFromAPI(258, "258", listOf("Cerrado do bailão", "Alto das Covas - Escola", "Praça Velha - Interparques", "Porto das Pipas", "Praça de Toiros", "Hospital", "Largo S. Bento", "Praça de Toiros - Estacionamento", "Praça Almeida Garrett - Tribunal", "Jardim Duque da Terceira", "Hospital", "Alto das Covas - Escola", "Largo da Silveira", "Portões de S. Pedro"), listOf("17h50", "17h50", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53", "17h53"), "WEEKDAY", "")
        loadFromAPI(259, "259", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("06h30", "06h40", "06h45", "07h00"), "WEEKDAY", "")
        loadFromAPI(260, "260", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("11h30", "11h40", "11h45", "12h00"), "WEEKDAY", "")
        loadFromAPI(261, "261", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("12h30", "12h40", "12h45", "13h00"), "WEEKDAY", "")
        loadFromAPI(262, "262", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("13h30", "13h40", "13h45", "14h00"), "WEEKDAY", "")
        loadFromAPI(263, "263", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("16h30", "16h40", "16h45", "17h00"), "WEEKDAY", "")
        loadFromAPI(264, "264", listOf("Quatro Canadas", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("17h40", "17h45", "17h55", "18h00", "18h15"), "WEEKDAY", "")
        loadFromAPI(265, "265", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("09h30", "09h40", "09h45", "10h00"), "WEEKDAY", "")
        loadFromAPI(266, "266", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("18h45", "18h55", "19h00", "19h15"), "WEEKDAY", "")
        loadFromAPI(267, "267", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("19h45", "19h55", "20h00", "20h15"), "WEEKDAY", "")
        loadFromAPI(268, "268", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("07h00", "07h05", "07h10", "07h30"), "WEEKDAY", "")
        loadFromAPI(269, "269", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("09h00", "09h05", "09h10", "09h30"), "WEEKDAY", "")
        loadFromAPI(270, "270", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("11h00", "11h05", "11h10", "11h30"), "WEEKDAY", "")
        loadFromAPI(271, "271", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("12h00", "12h05", "12h10", "12h30"), "WEEKDAY", "")
        loadFromAPI(272, "272", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("13h00", "13h05", "13h10", "13h30"), "WEEKDAY", "")
        loadFromAPI(273, "273", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("15h00", "15h05", "15h10", "15h30"), "WEEKDAY", "")
        loadFromAPI(274, "274", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("18h15", "18h20", "18h25", "18h45"), "WEEKDAY", "")
        loadFromAPI(275, "275", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("19h15", "19h20", "19h25", "19h45"), "WEEKDAY", "")
        loadFromAPI(276, "276", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("08h00", "08h05", "08h10", "08h30"), "WEEKDAY", "")
        loadFromAPI(277, "277", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("16h00", "16h05", "16h10", "16h30"), "WEEKDAY", "")
        loadFromAPI(278, "278", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Quatro Canadas"), listOf("17h00", "17h05", "17h10", "17h30", "17h40"), "WEEKDAY", "")
        loadFromAPI(279, "279", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("07h30", "07h40", "07h45", "08h00"), "WEEKDAY", "")
        loadFromAPI(280, "280", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("08h30", "08h40", "08h45", "09h00"), "WEEKDAY", "")
        loadFromAPI(281, "281", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("13h30", "13h40", "13h45", "14h00"), "WEEKDAY", "")
        loadFromAPI(282, "282", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("12h30", "12h45", "13h00"), "WEEKDAY", "")
        loadFromAPI(283, "283", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("13h30", "13h45", "14h00"), "WEEKDAY", "")
        loadFromAPI(284, "284", listOf("Base Aérea 4", "Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("07h20", "07h30", "07h35", "07h50"), "WEEKDAY", "")
        loadFromAPI(285, "285", listOf("Base Aérea 4", "Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("08h00", "08h10", "08h15", "08h30"), "WEEKDAY", "")
        loadFromAPI(286, "286", listOf("Base Aérea 4", "Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("09h00", "09h10", "09h15", "09h30"), "WEEKDAY", "")
        loadFromAPI(287, "287", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("18h30", "18h45", "19h00"), "WEEKDAY", "")
        loadFromAPI(288, "288", listOf("Praia da Vitória", "Posto 1", "Serra Santiago"), listOf("12h00", "12h15", "12h30"), "WEEKDAY", "")
        loadFromAPI(289, "289", listOf("Praia da Vitória", "Posto 1", "Serra Santiago"), listOf("13h00", "13h15", "13h30"), "WEEKDAY", "")
        loadFromAPI(290, "290", listOf("Praia da Vitória", "Posto 1", "Serra Santiago"), listOf("16h15", "16h30", "16h45"), "WEEKDAY", "")
        loadFromAPI(291, "291", listOf("Praia da Vitória", "Posto 1", "Serra Santiago"), listOf("18h05", "18h20", "18h35"), "WEEKDAY", "")
        loadFromAPI(292, "292", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("07h30", "07h45", "08h00"), "WEEKDAY", "")
        loadFromAPI(293, "293", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("08h30", "08h45", "09h00"), "WEEKDAY", "")
        loadFromAPI(294, "294", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("15h30", "15h45", "16h00"), "WEEKDAY", "")
        loadFromAPI(295, "295", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("16h00", "16h15", "16h30"), "WEEKDAY", "")
        loadFromAPI(296, "296", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("17h00", "17h15", "17h30"), "WEEKDAY", "")
        loadFromAPI(297, "297", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("07h45", "07h49", "07h50", "07h51", "08h05", "08h09", "08h12", "08h17", "08h27", "08h37", "08h42", "08h52", "08h59", "09h09"), "WEEKDAY", "")
        loadFromAPI(298, "298", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("10h30", "10h34", "10h35", "10h36", "10h50", "10h54", "10h57", "11h02", "11h12", "11h22", "11h27", "11h37", "11h44", "11h54"), "WEEKDAY", "")
        loadFromAPI(299, "299", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("13h00", "13h04", "13h05", "13h06", "13h20", "13h24", "13h27", "13h32", "13h42", "13h52", "13h57", "14h07", "14h14", "14h24"), "WEEKDAY", "")
        loadFromAPI(300, "300", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("16h00", "16h04", "16h05", "16h06", "16h20", "16h24", "16h27", "16h32", "16h42", "16h52", "16h57", "17h07", "17h14", "17h24"), "WEEKDAY", "")
        loadFromAPI(301, "301", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("17h00", "17h04", "17h05", "17h06", "17h20", "17h24", "17h27", "17h32", "17h42", "17h52", "17h57", "18h07", "18h14", "18h24"), "WEEKDAY", "")
        loadFromAPI(302, "302", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("18h00", "18h04", "18h05", "18h06", "18h20", "18h24", "18h27", "18h32", "18h42", "18h52", "18h57", "19h07", "19h14", "19h24"), "WEEKDAY", "")
        loadFromAPI(303, "303", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("19h00", "19h04", "19h05", "19h06", "19h20", "19h24", "19h27", "19h32", "19h42", "19h52", "19h57", "20h07", "20h14", "20h24"), "WEEKDAY", "")
        loadFromAPI(304, "304", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("06h20", "06h30", "06h37", "06h48", "06h53", "07h03", "07h13", "07h18", "07h20", "07h25", "07h40", "07h41", "07h45"), "WEEKDAY", "")
        loadFromAPI(305, "305", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("07h20", "07h30", "07h37", "07h48", "07h53", "08h03", "08h13", "08h18", "08h20", "08h25", "08h40", "08h41", "08h45"), "WEEKDAY", "")
        loadFromAPI(306, "306", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("09h30", "09h40", "09h47", "09h58", "10h03", "10h13", "10h23", "10h28", "10h30", "10h35", "10h50", "10h51", "10h55"), "WEEKDAY", "")
        loadFromAPI(307, "307", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("13h00", "13h10", "13h17", "13h28", "13h33", "13h43", "13h53", "13h58", "14h00", "14h05", "14h20", "14h21", "14h25"), "WEEKDAY", "")
        loadFromAPI(308, "308", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("14h30", "14h40", "14h47", "14h58", "15h03", "15h13", "15h23", "15h28", "15h30", "15h35", "15h50", "15h51", "15h55"), "WEEKDAY", "")
    }
    private fun loadRoutes(){
        loadWeekdays()
        
        /* SATURDAY */
        loadFromAPI(309, "309", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("10h00", "10h10", "10h20", "10h23", "10h25", "10h30", "10h35", "10h40", "10h50"), "SATURDAY", "")
        loadFromAPI(310, "310", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("11h00", "11h10", "11h20", "11h23", "11h25", "11h30", "11h35", "11h40", "11h50"), "SATURDAY", "")
        loadFromAPI(311, "311", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("13h00", "13h10", "13h20", "13h23", "13h25", "13h30", "13h35", "13h40", "13h50"), "SATURDAY", "")
        loadFromAPI(312, "312", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("14h00", "14h10", "14h20", "14h23", "14h25", "14h30", "14h35", "14h40", "14h50"), "SATURDAY", "")
        loadFromAPI(313, "313", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("16h00", "16h10", "16h20", "16h23", "16h25", "16h30", "16h35", "16h40", "16h50"), "SATURDAY", "")
        loadFromAPI(314, "314", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("18h00", "18h10", "18h20", "18h23", "18h25", "18h30", "18h35", "18h40", "18h50"), "SATURDAY", "")
        loadFromAPI(315, "315", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("07h00", "07h05", "07h15", "07h18", "07h25", "07h29", "07h37", "07h42", "07h45", "07h50"), "SATURDAY", "")
        loadFromAPI(316, "316", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("08h00", "08h05", "08h15", "08h18", "08h25", "08h29", "08h37", "08h42", "08h45", "08h50"), "SATURDAY", "")
        loadFromAPI(317, "317", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("09h00", "09h05", "09h15", "09h18", "09h25", "09h29", "09h37", "09h42", "09h45", "09h50"), "SATURDAY", "")
        loadFromAPI(318, "318", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("12h00", "12h05", "12h15", "12h18", "12h25", "12h29", "12h37", "12h42", "12h45", "12h50"), "SATURDAY", "")
        loadFromAPI(319, "319", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("09h00", "09h01", "09h04", "09h08", "09h10", "09h12", "09h14", "09h25", "09h27", "09h32", "09h37", "09h50"), "SATURDAY", "")
        loadFromAPI(320, "320", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("12h00", "12h01", "12h04", "12h08", "12h10", "12h12", "12h14", "12h25", "12h27", "12h32", "12h37", "12h50"), "SATURDAY", "")
        loadFromAPI(321, "321", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("19h00", "19h01", "19h04", "19h08", "19h10", "19h12", "19h14", "19h25", "19h27", "19h32", "19h37", "19h50"), "SATURDAY", "")
        loadFromAPI(322, "322", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("06h15", "06h16", "06h20", "06h25", "06h30", "06h35", "06h40", "06h42", "06h47", "06h52", "07h05"), "SATURDAY", "")
        loadFromAPI(323, "323", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("07h00", "07h01", "07h05", "07h10", "07h15", "07h20", "07h25", "07h27", "07h32", "07h37", "07h50"), "SATURDAY", "")
        loadFromAPI(324, "324", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("08h00", "08h01", "08h05", "08h10", "08h15", "08h20", "08h25", "08h27", "08h32", "08h37", "08h50"), "SATURDAY", "")
        loadFromAPI(325, "325", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("10h00", "10h01", "10h05", "10h10", "10h15", "10h20", "10h25", "10h27", "10h32", "10h37", "10h50"), "SATURDAY", "")
        loadFromAPI(326, "326", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("11h00", "11h01", "11h05", "11h10", "11h15", "11h20", "11h25", "11h27", "11h32", "11h37", "11h50"), "SATURDAY", "")
        loadFromAPI(327, "327", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("13h00", "13h01", "13h05", "13h10", "13h15", "13h20", "13h25", "13h27", "13h32", "13h37", "13h50"), "SATURDAY", "")
        loadFromAPI(328, "328", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("15h00", "15h01", "15h05", "15h10", "15h15", "15h20", "15h25", "15h27", "15h32", "15h37", "15h50"), "SATURDAY", "")
        loadFromAPI(329, "329", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("17h00", "17h01", "17h05", "17h10", "17h15", "17h20", "17h25", "17h27", "17h32", "17h37", "17h50"), "SATURDAY", "")
        loadFromAPI(330, "330", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Ladeira Grande - Império", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("06h00", "06h10", "06h15", "06h20", "06h25", "06h32", "06h40", "06h42", "06h45", "06h47", "06h55"), "SATURDAY", "")
        loadFromAPI(331, "331", listOf("Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("08h15", "08h20", "08h25", "08h30", "08h40", "08h45"), "SATURDAY", "")
        loadFromAPI(332, "332", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("07h50", "07h57", "08h00", "08h05", "08h15", "08h25", "08h40", "08h50"), "SATURDAY", "")
        loadFromAPI(333, "333", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("10h30", "10h37", "10h40", "10h45", "10h55", "11h05", "11h20", "11h30"), "SATURDAY", "")
        loadFromAPI(334, "334", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("14h00", "14h07", "14h10", "14h15", "14h25", "14h35", "14h50", "15h00"), "SATURDAY", "")
        loadFromAPI(335, "335", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("16h00", "16h07", "16h10", "16h15", "16h25", "16h35", "16h50", "17h00"), "SATURDAY", "")
        loadFromAPI(336, "336", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("18h00", "18h07", "18h10", "18h15", "18h25", "18h35", "18h50", "19h00"), "SATURDAY", "")
        loadFromAPI(337, "337", listOf("Raminho", "Altares - Igreja", "Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("06h30", "06h37", "06h45", "06h50", "07h00", "07h05", "07h12", "07h20", "07h25", "07h30"), "SATURDAY", "")
        loadFromAPI(338, "338", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("09h30", "09h35", "09h48", "09h58", "10h08", "10h10", "10h20", "10h30"), "SATURDAY", "")
        loadFromAPI(339, "339", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("11h45", "11h50", "12h03", "12h13", "12h23", "12h25", "12h35", "12h45"), "SATURDAY", "")
        loadFromAPI(340, "340", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("15h00", "15h05", "15h18", "15h28", "15h38", "15h40", "15h50", "16h00"), "SATURDAY", "")
        loadFromAPI(341, "341", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("17h00", "17h05", "17h18", "17h28", "17h38", "17h40", "17h50", "18h00"), "SATURDAY", "")
        loadFromAPI(342, "342", listOf("Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Canada da Fontaínha", "Quatro Canadas", "Agualva - Igreja", "Vila Nova - Praça", "Aeroporto", "Posto 1"), listOf("15h00", "15h01", "15h04", "15h10", "15h21", "15h26", "15h29", "15h34", "15h40", "15h55"), "SATURDAY", "")
        loadFromAPI(343, "343", listOf("Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("06h45", "06h45", "06h48", "06h58", "07h08", "07h25", "07h35"), "SATURDAY", "")
        loadFromAPI(344, "344", listOf("Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("08h00", "08h00", "08h03", "08h13", "08h23", "08h40", "08h50"), "SATURDAY", "")
        loadFromAPI(345, "345", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Canadas", "Canada da Fontaínha", "Praça Velha - Sub-Urbanas"), listOf("12h00", "12h05", "12h10", "12h18", "12h28", "12h38", "12h50", "13h00"), "SATURDAY", "")
        loadFromAPI(346, "346", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("08h25", "08h28", "08h33", "08h38", "08h47", "08h48", "08h51"), "SATURDAY", "")
        loadFromAPI(347, "347", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("10h45", "10h48", "10h53", "10h58", "11h07", "11h08", "11h11"), "SATURDAY", "")
        loadFromAPI(348, "348", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("12h35", "12h38", "12h43", "12h48", "12h57", "12h58", "13h01"), "SATURDAY", "")
        loadFromAPI(349, "349", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("18h30", "18h33", "18h38", "18h43", "18h52", "18h53", "18h56"), "SATURDAY", "")
        loadFromAPI(350, "350", listOf("Ribeirinha (Serra)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("16h45", "16h48", "16h53", "16h54", "16h55", "17h08", "17h12", "17h15", "17h18"), "SATURDAY", "")
        loadFromAPI(351, "351", listOf("Ribeirinha - Caminho Novo", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("18h00", "18h03", "18h08", "18h09", "18h10", "18h20", "18h24", "18h27", "18h33"), "SATURDAY", "")
        loadFromAPI(352, "352", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("07h20", "07h23", "07h26", "07h29", "07h32", "07h36", "07h42", "07h43", "07h46"), "SATURDAY", "")
        loadFromAPI(353, "353", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("09h35", "09h38", "09h41", "09h49", "09h57", "09h58", "10h01"), "SATURDAY", "")
        loadFromAPI(354, "354", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("13h45", "13h48", "13h51", "13h59", "14h07", "14h08", "14h11"), "SATURDAY", "")
        loadFromAPI(355, "355", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h15", "17h18", "17h21", "17h29", "17h37", "17h38", "17h41"), "SATURDAY", "")
        loadFromAPI(356, "356", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("07h55", "08h01", "08h02", "08h03", "08h16", "08h20", "08h23", "08h26"), "SATURDAY", "")
        loadFromAPI(357, "357", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("09h00", "09h06", "09h07", "09h08", "09h21", "09h25", "09h28", "09h31"), "SATURDAY", "")
        loadFromAPI(358, "358", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("13h10", "13h16", "13h17", "13h18", "13h31", "13h35", "13h38", "13h41"), "SATURDAY", "")
        loadFromAPI(359, "359", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("10h10", "10h16", "10h17", "10h30", "10h34", "10h36", "10h37"), "SATURDAY", "")
        loadFromAPI(360, "360", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("12h00", "12h06", "12h07", "12h20", "12h24", "12h26", "12h27"), "SATURDAY", "")
        loadFromAPI(361, "361", listOf("Praia da Vitória", "Cabo da Praia", "Ponta Negra", "Porto Martins - Igreja", "Fonte Bastardo - Império"), listOf("07h50", "07h58", "08h05", "08h08", "08h20"), "SATURDAY", "")
        loadFromAPI(362, "362", listOf("Fonte Bastardo - Império", "Ponta Negra", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("08h35", "08h47", "08h50", "08h57", "09h05"), "SATURDAY", "")
        loadFromAPI(363, "363", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("13h30", "13h40", "13h47", "13h55"), "SATURDAY", "")
        loadFromAPI(364, "364", listOf("Ribeira Seca", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("17h30", "17h40", "17h47", "17h55"), "SATURDAY", "")
        loadFromAPI(365, "365", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("12h50", "12h58", "13h05", "13h15"), "SATURDAY", "")
        loadFromAPI(366, "366", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Ribeira Seca"), listOf("16h50", "16h58", "17h05", "17h15"), "SATURDAY", "")
        loadFromAPI(367, "367", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("07h50", "08h00", "08h05", "08h15"), "SATURDAY", "")
        loadFromAPI(368, "368", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("12h00", "12h10", "12h15", "12h25"), "SATURDAY", "")
        loadFromAPI(369, "369", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("15h00", "15h10", "15h15", "15h25"), "SATURDAY", "")
        loadFromAPI(370, "370", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("18h20", "18h30", "18h35", "18h45"), "SATURDAY", "")
        loadFromAPI(371, "371", listOf("Quatro Canadas", "Lourais", "Ribeira dos Pães", "Rua dos Fundões", "Lajes - Igreja", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("07h10", "07h15", "07h18", "07h20", "07h25", "07h30", "07h35", "07h45"), "SATURDAY", "")
        loadFromAPI(372, "372", listOf("Quatro Canadas", "Lourais", "Ribeira dos Pães", "Rua dos Fundões", "Lajes - Igreja", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("08h20", "08h25", "08h28", "08h30", "08h35", "08h40", "08h45", "08h55"), "SATURDAY", "")
        loadFromAPI(373, "373", listOf("Praia da Vitória", "Casa da Ribeira - Igreja", "Pico Celeiro"), listOf("08h30", "08h40", "08h45"), "SATURDAY", "")
        loadFromAPI(374, "374", listOf("Praia da Vitória", "Casa da Ribeira - Igreja", "Pico Celeiro"), listOf("12h00", "12h10", "12h15"), "SATURDAY", "")
        loadFromAPI(375, "375", listOf("Cruz Dourada", "Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("08h15", "08h17", "08h19", "08h21", "08h23", "08h25", "08h27", "08h29", "08h35", "08h36", "08h39", "08h42"), "SATURDAY", "")
        loadFromAPI(376, "376", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Cruz Dourada"), listOf("07h45", "07h53", "07h54", "07h56", "07h59", "08h01", "08h03", "08h07", "08h12", "08h17"), "SATURDAY", "")
        loadFromAPI(377, "377", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("09h00", "09h08", "09h09", "09h11", "09h12", "09h16", "09h20", "09h23", "09h26", "09h31"), "SATURDAY", "")
        loadFromAPI(378, "378", listOf("Carreirinha", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira 2", "Estrela", "Quinta da Pata", "Bairro - Forte", "Terreiro", "Canada Capitão Mor"), listOf("12h00", "12h08", "12h09", "12h11", "12h12", "12h16", "12h20", "12h23", "12h26", "12h31"), "SATURDAY", "")
        loadFromAPI(379, "379", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("09h30", "09h33", "09h36", "09h39", "09h43", "09h45", "09h46", "09h50", "09h51", "09h54", "09h56"), "SATURDAY", "")
        loadFromAPI(380, "380", listOf("Canada Capitão Mor", "Terreiro", "Bairro - Forte", "Quinta da Pata", "Estrela", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Carreirinha"), listOf("12h35", "12h38", "12h41", "12h44", "12h48", "12h50", "12h51", "12h55", "12h56", "12h59", "13h01"), "SATURDAY", "")
        loadFromAPI(381, "381", listOf("Canada de Belém", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("12h00", "12h04", "12h06", "12h09", "12h12", "12h15", "12h16", "12h19", "12h22", "12h25", "12h27", "12h30"), "SATURDAY", "")
        loadFromAPI(382, "382", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("06h45", "06h49", "06h53", "07h00", "07h01", "07h04", "07h07", "07h10", "07h12", "07h15"), "SATURDAY", "")
        loadFromAPI(383, "383", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("08h45", "08h49", "08h53", "09h00", "09h01", "09h04", "09h07", "09h10", "09h12", "09h15"), "SATURDAY", "")
        loadFromAPI(384, "384", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("09h45", "09h49", "09h53", "10h00", "10h01", "10h04", "10h07", "10h10", "10h12", "10h15"), "SATURDAY", "")
        loadFromAPI(385, "385", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("16h15", "16h19", "16h23", "16h30", "16h31", "16h34", "16h37", "16h40", "16h42", "16h45"), "SATURDAY", "")
        loadFromAPI(386, "386", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("06h15", "06h20", "06h23", "06h27", "06h40", "06h41", "06h42", "06h45", "06h48"), "SATURDAY", "")
        loadFromAPI(387, "387", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("08h15", "08h20", "08h23", "08h27", "08h40", "08h41", "08h42", "08h45", "08h48"), "SATURDAY", "")
        loadFromAPI(388, "388", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("09h15", "09h20", "09h23", "09h27", "09h40", "09h41", "09h42", "09h45", "09h48"), "SATURDAY", "")
        loadFromAPI(389, "389", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada do Célis"), listOf("07h15", "07h20", "07h24", "07h28", "07h36", "07h37", "07h38", "07h41", "07h44", "07h47", "07h49"), "SATURDAY", "")
        loadFromAPI(390, "390", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada do Célis"), listOf("12h30", "12h35", "12h39", "12h43", "12h51", "12h52", "12h53", "12h56", "12h59", "13h02", "13h04"), "SATURDAY", "")
        loadFromAPI(391, "391", listOf("Canada do Célis", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("07h45", "07h46", "07h49", "07h53", "07h55", "08h00", "08h01", "08h04", "08h07", "08h10", "08h12", "08h15"), "SATURDAY", "")
        loadFromAPI(392, "392", listOf("Canada do Célis", "Cnd. Cinco Reis", "Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("13h00", "13h01", "13h04", "13h08", "13h10", "13h15", "13h16", "13h19", "13h22", "13h25", "13h27", "13h30"), "SATURDAY", "")
        loadFromAPI(393, "393", listOf("Carreirinha", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Tomás de Borba", "Cnd. Cinco Reis", "Canada de Belém"), listOf("11h45", "11h47", "11h53", "11h54", "11h55", "11h57", "11h59", "12h01", "12h03"), "SATURDAY", "")
        loadFromAPI(394, "394", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("18h30", "18h33", "18h42", "18h46", "18h52", "18h53", "18h56"), "SATURDAY", "")
        loadFromAPI(395, "395", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h15", "17h18", "17h21", "17h25", "17h37", "17h38", "17h41"), "SATURDAY", "")
        loadFromAPI(396, "396", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("11h00", "11h20", "11h21", "11h25"), "SATURDAY", "")
        loadFromAPI(397, "397", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("09h30", "09h55", "09h56", "10h00"), "SATURDAY", "")
        loadFromAPI(398, "398", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("12h30", "12h55", "12h56", "13h00"), "SATURDAY", "")
        loadFromAPI(399, "399", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("07h45", "07h48", "07h49", "07h50", "08h13"), "SATURDAY", "")
        loadFromAPI(400, "400", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("09h00", "09h03", "09h04", "09h05", "09h28"), "SATURDAY", "")
        loadFromAPI(401, "401", listOf("Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Fonte da Faneca"), listOf("12h00", "12h04", "12h05", "12h06", "12h29"), "SATURDAY", "")
        loadFromAPI(402, "402", listOf("Fonte da Faneca", "Terra Chã - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("08h15", "08h20", "08h35", "08h36", "08h40"), "SATURDAY", "")
        loadFromAPI(403, "403", listOf("Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("10h30", "10h34", "10h35", "10h36", "10h58"), "SATURDAY", "")
        loadFromAPI(404, "404", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("08h00", "08h03", "08h06", "08h08", "08h13", "08h25"), "SATURDAY", "")
        loadFromAPI(405, "405", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("09h00", "09h03", "09h06", "09h08", "09h13", "09h25"), "SATURDAY", "")
        loadFromAPI(406, "406", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("12h00", "12h03", "12h06", "12h08", "12h13", "12h25"), "SATURDAY", "")
        loadFromAPI(407, "407", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("13h00", "13h03", "13h06", "13h08", "13h13", "13h25"), "SATURDAY", "")
        loadFromAPI(408, "408", listOf("Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas - Escola", "Canada Nova de Sta. Luzia", "Grota do Medo"), listOf("16h00", "16h03", "16h06", "16h08", "16h13", "16h25"), "SATURDAY", "")
        loadFromAPI(409, "409", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("08h25", "08h29", "08h34", "08h44", "08h45", "08h49", "08h55"), "SATURDAY", "")
        loadFromAPI(410, "410", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("09h25", "09h29", "09h34", "09h44", "09h45", "09h49", "09h55"), "SATURDAY", "")
        loadFromAPI(411, "411", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("12h30", "12h34", "12h39", "12h49", "12h50", "12h54", "13h00"), "SATURDAY", "")
        loadFromAPI(412, "412", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("13h30", "13h34", "13h39", "13h49", "13h50", "13h54", "14h00"), "SATURDAY", "")
        loadFromAPI(413, "413", listOf("Grota do Medo", "Largo do Terreiro", "Posto Santo - Igreja", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital"), listOf("16h30", "16h34", "16h39", "16h49", "16h50", "16h54", "17h00"), "SATURDAY", "")
        loadFromAPI(414, "414", listOf("Hospital", "Bairro do Lameirinho (Entrada)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("06h30", "06h31", "06h34", "06h40", "06h41", "06h42", "07h02"), "SATURDAY", "")
        loadFromAPI(415, "415", listOf("Hospital", "Bairro do Lameirinho (Entrada)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("11h30", "11h31", "11h34", "11h40", "11h41", "11h42", "12h02"), "SATURDAY", "")
        loadFromAPI(416, "416", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("07h00", "07h20", "07h21", "07h23", "07h28", "07h30"), "SATURDAY", "")
        loadFromAPI(417, "417", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("08h00", "08h20", "08h21", "08h23", "08h28", "08h30"), "SATURDAY", "")
        loadFromAPI(418, "418", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("09h05", "09h25", "09h26", "09h28", "09h33", "09h35"), "SATURDAY", "")
        loadFromAPI(419, "419", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("12h00", "12h20", "12h21", "12h23", "12h28", "12h30"), "SATURDAY", "")
        loadFromAPI(420, "420", listOf("Bairro - Império", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Hospital", "Vinha Brava"), listOf("13h00", "13h20", "13h21", "13h23", "13h28", "13h30"), "SATURDAY", "")
        loadFromAPI(421, "421", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("07h30", "07h32", "07h35", "07h38", "07h39", "07h40", "08h00"), "SATURDAY", "")
        loadFromAPI(422, "422", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("08h35", "08h37", "08h40", "08h43", "08h44", "08h45", "09h05"), "SATURDAY", "")
        loadFromAPI(423, "423", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Bairro - Império"), listOf("12h30", "12h32", "12h35", "12h38", "12h39", "12h40", "13h00"), "SATURDAY", "")
        loadFromAPI(424, "424", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("14h00", "14h20", "14h21", "14h25"), "SATURDAY", "")
        loadFromAPI(425, "425", listOf("Fonte da Faneca", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h45", "18h05", "18h06", "18h10"), "SATURDAY", "")
        loadFromAPI(426, "426", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Boa Hora", "Fonte da Faneca"), listOf("13h30", "13h32", "13h33", "13h36", "13h37", "13h38", "13h42", "13h58"), "SATURDAY", "")
        loadFromAPI(427, "427", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Boa Hora", "Fonte da Faneca"), listOf("17h00", "17h02", "17h03", "17h06", "17h07", "17h08", "17h12", "17h28"), "SATURDAY", "")
        loadFromAPI(428, "428", listOf("Rosário", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Reguinho"), listOf("16h15", "16h35", "16h36", "16h40", "16h45"), "SATURDAY", "")
        loadFromAPI(429, "429", listOf("Rosário", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Reguinho"), listOf("19h00", "19h20", "19h21", "19h25", "19h30"), "SATURDAY", "")
        loadFromAPI(430, "430", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Rosário"), listOf("15h45", "15h47", "15h48", "15h51", "15h52", "15h53", "16h16"), "SATURDAY", "")
        loadFromAPI(431, "431", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Rosário"), listOf("18h30", "18h32", "18h33", "18h36", "18h37", "18h38", "19h01"), "SATURDAY", "")
        loadFromAPI(432, "432", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Hospital", "Pico Redondo", "Canada da Fontaínha", "Zona Industrial", "Reguinho", "Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("09h00", "09h05", "09h06", "09h08", "09h11", "09h15", "09h26", "09h27", "09h30", "09h38", "09h40", "09h45", "09h54", "09h57", "10h03"), "SATURDAY", "")
        loadFromAPI(433, "433", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Hospital", "Pico Redondo", "Canada da Fontaínha", "Zona Industrial", "Reguinho", "Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("13h00", "13h05", "13h06", "13h08", "13h11", "13h15", "13h26", "13h27", "13h30", "13h38", "13h40", "13h45", "13h54", "13h57", "14h03"), "SATURDAY", "")
        loadFromAPI(434, "434", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Reguinho", "Vinha Brava", "Hospital", "Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("08h00", "08h05", "08h06", "08h08", "08h12", "08h25", "08h27", "08h30", "08h35", "08h40", "08h44", "08h49"), "SATURDAY", "")
        loadFromAPI(435, "435", listOf("Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "S. João Deus - Largo", "Reguinho", "Vinha Brava", "Hospital", "Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro"), listOf("12h00", "12h05", "12h06", "12h08", "12h12", "12h25", "12h27", "12h30", "12h35", "12h40", "12h44", "12h49"), "SATURDAY", "")
        loadFromAPI(436, "436", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("08h30", "08h33", "08h38", "08h41", "08h43", "08h45", "08h51", "08h56", "09h00"), "SATURDAY", "")
        loadFromAPI(437, "437", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("09h00", "09h03", "09h08", "09h11", "09h13", "09h15", "09h21", "09h26", "09h30"), "SATURDAY", "")
        loadFromAPI(438, "438", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("09h30", "09h33", "09h38", "09h41", "09h43", "09h45", "09h51", "09h56", "10h00"), "SATURDAY", "")
        loadFromAPI(439, "439", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("10h00", "10h03", "10h08", "10h11", "10h13", "10h15", "10h21", "10h26", "10h30"), "SATURDAY", "")
        loadFromAPI(440, "440", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("10h30", "10h33", "10h38", "10h41", "10h43", "10h45", "10h51", "10h56", "11h00"), "SATURDAY", "")
        loadFromAPI(441, "441", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("11h00", "11h03", "11h08", "11h11", "11h13", "11h15", "11h21", "11h26", "11h30"), "SATURDAY", "")
        loadFromAPI(442, "442", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("11h30", "11h33", "11h38", "11h41", "11h43", "11h45", "11h51", "11h56", "12h00"), "SATURDAY", "")
        loadFromAPI(443, "443", listOf("Cerrado do bailão", "Praça Velha - Interparques", "Lar de Idosos", "Av. Álvaro Martins Homem", "Praça de Toiros - Estacionamento", "R. Dr. Henrique Bráz", "Alto das Covas", "Portões de S. Pedro", "Cerrado do bailão - Fim"), listOf("12h00", "12h03", "12h08", "12h11", "12h13", "12h15", "12h21", "12h26", "12h30"), "SATURDAY", "")
        loadFromAPI(444, "444", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("06h30", "06h40", "06h45", "07h00"), "SATURDAY", "")
        loadFromAPI(445, "445", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("11h30", "11h40", "11h45", "12h00"), "SATURDAY", "")
        loadFromAPI(446, "446", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("12h30", "12h40", "12h45", "13h00"), "SATURDAY", "")
        loadFromAPI(447, "447", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("13h30", "13h40", "13h45", "14h00"), "SATURDAY", "")
        loadFromAPI(448, "448", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("17h40", "17h50", "17h55", "18h10"), "SATURDAY", "")
        loadFromAPI(449, "449", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("07h00", "07h05", "07h10", "07h30"), "SATURDAY", "")
        loadFromAPI(450, "450", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("09h00", "09h05", "09h10", "09h30"), "SATURDAY", "")
        loadFromAPI(451, "451", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("11h00", "11h05", "11h10", "11h30"), "SATURDAY", "")
        loadFromAPI(452, "452", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("12h00", "12h05", "12h10", "12h30"), "SATURDAY", "")
        loadFromAPI(453, "453", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("13h00", "13h05", "13h10", "13h30"), "SATURDAY", "")
        loadFromAPI(454, "454", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("15h00", "15h05", "15h10", "15h30"), "SATURDAY", "")
        loadFromAPI(455, "455", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("19h00", "19h05", "19h10", "19h30"), "SATURDAY", "")
        loadFromAPI(456, "456", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("08h00", "08h05", "08h10", "08h30"), "SATURDAY", "")
        loadFromAPI(457, "457", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("17h00", "17h05", "17h10", "17h30"), "SATURDAY", "")
        loadFromAPI(458, "458", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("07h30", "07h40", "07h45", "08h00"), "SATURDAY", "")
        loadFromAPI(459, "459", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("08h30", "08h40", "08h45", "09h00"), "SATURDAY", "")
        loadFromAPI(460, "460", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("09h30", "09h40", "09h45", "10h00"), "SATURDAY", "")
        loadFromAPI(461, "461", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("19h30", "19h40", "19h45", "20h00"), "SATURDAY", "")
        loadFromAPI(462, "462", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1"), listOf("15h30", "15h40", "15h45"), "SATURDAY", "")
        loadFromAPI(463, "463", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("07h30", "07h45", "08h00"), "SATURDAY", "")
        loadFromAPI(464, "464", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("08h30", "08h45", "09h00"), "SATURDAY", "")
        loadFromAPI(465, "465", listOf("Praia da Vitória", "Posto 1", "Azória"), listOf("16h30", "16h45", "17h00"), "SATURDAY", "")
        loadFromAPI(466, "466", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("08h00", "08h15", "08h30"), "SATURDAY", "")
        loadFromAPI(467, "467", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("16h00", "16h15", "16h30"), "SATURDAY", "")
        loadFromAPI(468, "468", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("17h00", "17h15", "17h30"), "SATURDAY", "")
        loadFromAPI(469, "469", listOf("Praia da Vitória", "Posto 1", "Serra Santiago"), listOf("12h15", "12h30", "12h45"), "SATURDAY", "")
        loadFromAPI(470, "470", listOf("Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("12h45", "13h00", "13h15"), "SATURDAY", "")
        loadFromAPI(471, "471", listOf("Base Aérea 4", "Serra Santiago", "Posto 1", "Praia da Vitória"), listOf("09h00", "09h10", "09h15", "09h30"), "SATURDAY", "")
        loadFromAPI(472, "472", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("07h45", "07h49", "07h50", "07h51", "08h05", "08h09", "08h12", "08h17", "08h27", "08h37", "08h42", "08h52", "08h59", "09h09"), "SATURDAY", "")
        loadFromAPI(473, "473", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("10h30", "10h34", "10h35", "10h36", "10h50", "10h54", "10h57", "11h02", "11h12", "11h22", "11h27", "11h37", "11h44", "11h54"), "SATURDAY", "")
        loadFromAPI(474, "474", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("13h00", "13h04", "13h05", "13h06", "13h20", "13h24", "13h27", "13h32", "13h42", "13h52", "13h57", "14h07", "14h14", "14h24"), "SATURDAY", "")
        loadFromAPI(475, "475", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("16h00", "16h04", "16h05", "16h06", "16h20", "16h24", "16h27", "16h32", "16h42", "16h52", "16h57", "17h07", "17h14", "17h24"), "SATURDAY", "")
        loadFromAPI(476, "476", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("19h00", "19h04", "19h05", "19h06", "19h20", "19h24", "19h27", "19h32", "19h42", "19h52", "19h57", "20h07", "20h14", "20h24"), "SATURDAY", "")
        loadFromAPI(477, "477", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("06h20", "06h30", "06h37", "06h48", "06h53", "07h03", "07h13", "07h18", "07h20", "07h25", "07h40", "07h41", "07h45"), "SATURDAY", "")
        loadFromAPI(478, "478", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("07h20", "07h30", "07h37", "07h48", "07h53", "08h03", "08h13", "08h18", "08h20", "08h25", "08h40", "08h41", "08h45"), "SATURDAY", "")
        loadFromAPI(479, "479", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("09h30", "09h40", "09h47", "09h58", "10h03", "10h13", "10h23", "10h28", "10h30", "10h35", "10h50", "10h51", "10h55"), "SATURDAY", "")
        loadFromAPI(480, "480", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("13h00", "13h10", "13h17", "13h28", "13h33", "13h43", "13h53", "13h58", "14h00", "14h05", "14h20", "14h21", "14h25"), "SATURDAY", "")
        loadFromAPI(481, "481", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("17h30", "17h40", "17h47", "17h58", "18h03", "18h13", "18h23", "18h28", "18h30", "18h35", "18h50", "18h51", "18h55"), "SATURDAY", "")

        /* SUNDAY */
        loadFromAPI(482, "482", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("11h00", "11h01", "11h04", "11h08", "11h13", "11h18", "11h25", "11h27", "11h32", "11h35", "11h45", "11h55"), "SUNDAY", "")
        loadFromAPI(483, "483", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Porto Martins - Igreja", "Cabo da Praia", "Praia da Vitória"), listOf("15h00", "15h01", "15h04", "15h08", "15h13", "15h18", "15h25", "15h27", "15h32", "15h35", "15h45", "15h55"), "SUNDAY", "")
        loadFromAPI(484, "484", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("08h00", "08h05", "08h10", "08h13", "08h18", "08h25", "08h30", "08h35", "08h42", "08h50"), "SUNDAY", "")
        loadFromAPI(485, "485", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("12h00", "12h05", "12h10", "12h13", "12h18", "12h25", "12h30", "12h35", "12h42", "12h50"), "SUNDAY", "")
        loadFromAPI(486, "486", listOf("Praia da Vitória", "Cabo da Praia", "Porto Martins - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("16h00", "16h05", "16h10", "16h13", "16h18", "16h25", "16h30", "16h35", "16h42", "16h50"), "SUNDAY", "")
        loadFromAPI(487, "487", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("10h00", "10h05", "10h15", "10h18", "10h25", "10h29", "10h37", "10h42", "10h45", "10h50"), "SUNDAY", "")
        loadFromAPI(488, "488", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("14h00", "14h05", "14h15", "14h18", "14h25", "14h29", "14h37", "14h42", "14h45", "14h50"), "SUNDAY", "")
        loadFromAPI(489, "489", listOf("Praia da Vitória", "Cabo da Praia - Igreja", "Fonte Bastardo - Império", "Ribeira Seca", "Praça da Vila de São Sebastião", "Largo da Cruz", "Ribeira do Testo", "Feteira - Igreja", "Santo Amaro", "Praça Velha - Inter-Urbanas"), listOf("18h00", "18h05", "18h15", "18h18", "18h25", "18h29", "18h37", "18h42", "18h45", "18h50"), "SUNDAY", "")
        loadFromAPI(490, "490", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("09h00", "09h01", "09h04", "09h08", "09h10", "09h12", "09h14", "09h25", "09h27", "09h32", "09h37", "09h50"), "SUNDAY", "")
        loadFromAPI(491, "491", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("13h00", "13h01", "13h04", "13h08", "13h10", "13h12", "13h14", "13h25", "13h27", "13h32", "13h37", "13h50"), "SUNDAY", "")
        loadFromAPI(492, "492", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Largo da Cruz", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("17h00", "17h01", "17h04", "17h08", "17h10", "17h12", "17h14", "17h25", "17h27", "17h32", "17h37", "17h50"), "SUNDAY", "")
        loadFromAPI(493, "493", listOf("Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem", "Santo Amaro", "Feteira - Igreja", "Ribeira do Testo", "Praça da Vila de São Sebastião", "Ribeira Seca", "Fonte Bastardo - Império", "Cabo da Praia - Igreja", "Praia da Vitória"), listOf("19h00", "19h01", "19h05", "19h10", "19h15", "19h20", "19h25", "19h27", "19h32", "19h37", "19h50"), "SUNDAY", "")
        loadFromAPI(494, "494", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("12h00", "12h07", "12h10", "12h15", "12h25", "12h35", "12h50", "13h00"), "SUNDAY", "")
        loadFromAPI(495, "495", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("16h00", "16h07", "16h10", "16h15", "16h25", "16h35", "16h50", "17h00"), "SUNDAY", "")
        loadFromAPI(496, "496", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Lajes - Igreja", "Vila Nova - Praça", "Agualva - Igreja", "Quatro Ribeiras - Igreja", "Biscoitos"), listOf("18h00", "18h07", "18h10", "18h15", "18h25", "18h35", "18h50", "19h00"), "SUNDAY", "")
        loadFromAPI(497, "497", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("09h00", "09h05", "09h18", "09h28", "09h38", "09h40", "09h50", "10h00"), "SUNDAY", "")
        loadFromAPI(498, "498", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("14h00", "14h05", "14h18", "14h28", "14h38", "14h40", "14h50", "15h00"), "SUNDAY", "")
        loadFromAPI(499, "499", listOf("Biscoitos", "Quatro Ribeiras - Igreja", "Agualva - Igreja", "Vila Nova - Praça", "Lajes - Igreja", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("17h00", "17h05", "17h18", "17h28", "17h38", "17h40", "17h50", "18h00"), "SUNDAY", "")
        loadFromAPI(500, "500", listOf("Ribeirinha (Serra)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("10h00", "10h03", "10h08", "10h09", "10h10", "10h23", "10h27", "10h30", "10h33"), "SUNDAY", "")
        loadFromAPI(501, "501", listOf("Ribeirinha (Serra)", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Regatos"), listOf("17h00", "17h03", "17h08", "17h09", "17h10", "17h23", "17h27", "17h30", "17h33"), "SUNDAY", "")
        loadFromAPI(502, "502", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("08h20", "08h23", "08h26", "08h29", "08h32", "08h36", "08h42", "08h43", "08h46"), "SUNDAY", "")
        loadFromAPI(503, "503", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("14h30", "14h33", "14h38", "14h43", "14h52", "14h53", "14h56"), "SUNDAY", "")
        loadFromAPI(504, "504", listOf("Cruz das Cinco", "São Bartolomeu (Igreja)", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("18h30", "18h33", "18h38", "18h43", "18h52", "18h53", "18h56"), "SUNDAY", "")
        loadFromAPI(505, "505", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("10h30", "10h33", "10h36", "10h44", "10h52", "10h53", "10h56"), "SUNDAY", "")
        loadFromAPI(506, "506", listOf("Regatos", "S. Bartolomeu (Igreja) 2", "Terra Alta", "Canada de Belém", "Praça Velha - Sub-Urbanas", "Praça Almeida Garrett", "Lar de Idosos"), listOf("17h30", "17h33", "17h36", "17h44", "17h52", "17h53", "17h56"), "SUNDAY", "")
        loadFromAPI(507, "507", listOf("Ribeirinha - Caminho Novo", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("07h45", "07h48", "07h53", "07h54", "07h55", "08h05", "08h09", "08h12", "08h18"), "SUNDAY", "")
        loadFromAPI(508, "508", listOf("Ribeirinha - Caminho Novo", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("14h00", "14h03", "14h08", "14h09", "14h10", "14h20", "14h24", "14h27", "14h33"), "SUNDAY", "")
        loadFromAPI(509, "509", listOf("Ribeirinha - Caminho Novo", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("18h00", "18h03", "18h08", "18h09", "18h10", "18h20", "18h24", "18h27", "18h33"), "SUNDAY", "")
        loadFromAPI(510, "510", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("12h00", "12h10", "12h15", "12h25"), "SUNDAY", "")
        loadFromAPI(511, "511", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("15h00", "15h10", "15h15", "15h25"), "SUNDAY", "")
        loadFromAPI(512, "512", listOf("Praia da Vitória", "Fontinhas", "Canada das Covas (Chafariz)", "Quatro Canadas"), listOf("18h00", "18h10", "18h15", "18h25"), "SUNDAY", "")
        loadFromAPI(513, "513", listOf("Quatro Canadas", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("08h30", "08h40", "08h45", "08h55"), "SUNDAY", "")
        loadFromAPI(514, "514", listOf("Quatro Canadas", "Canada das Covas (Chafariz) 2", "Fontinhas", "Praia da Vitória"), listOf("11h00", "11h10", "11h15", "11h25"), "SUNDAY", "")
        loadFromAPI(515, "515", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("13h30", "13h34", "13h38", "13h45", "13h46", "13h49", "13h52", "13h55", "13h57", "14h00"), "SUNDAY", "")
        loadFromAPI(516, "516", listOf("Escola Tomás de Borba", "Silveira 2", "Portões de S. Pedro", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Grota do Vale", "Atalaia", "Santo Amaro", "Ribeirinha"), listOf("16h30", "16h34", "16h38", "16h45", "16h46", "16h49", "16h52", "16h55", "16h57", "17h00"), "SUNDAY", "")
        loadFromAPI(517, "517", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("10h00", "10h05", "10h08", "10h12", "10h25", "10h26", "10h27", "10h30", "10h33"), "SUNDAY", "")
        loadFromAPI(518, "518", listOf("Ribeirinha", "Santo Amaro", "Atalaia", "Grota do Vale", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Silveira", "Escola Tomás de Borba"), listOf("17h00", "17h05", "17h08", "17h12", "17h25", "17h26", "17h27", "17h30", "17h33"), "SUNDAY", "")
        loadFromAPI(519, "519", listOf("Ribeirinha - Caminho Novo", "Santo Amaro", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("07h45", "07h48", "08h02", "08h08", "08h09", "08h10", "08h23", "08h27", "08h30", "08h36"), "SUNDAY", "")
        loadFromAPI(520, "520", listOf("Ribeirinha - Caminho Novo", "Santo Amaro", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("14h00", "14h03", "14h17", "14h23", "14h24", "14h25", "14h38", "14h42", "14h45", "14h51"), "SUNDAY", "")
        loadFromAPI(521, "521", listOf("Ribeirinha - Caminho Novo", "Santo Amaro", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Canada de Belém", "Terra Alta", "São Bartolomeu - Igreja", "Cruz das Cinco"), listOf("18h00", "18h03", "18h17", "18h23", "18h24", "18h25", "18h38", "18h42", "18h45", "18h51"), "SUNDAY", "")
        loadFromAPI(522, "522", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("08h30", "08h50", "08h51", "08h53", "09h00"), "SUNDAY", "")
        loadFromAPI(523, "523", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("13h30", "13h50", "13h51", "13h53", "14h00"), "SUNDAY", "")
        loadFromAPI(524, "524", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Vinha Brava"), listOf("17h30", "17h50", "17h51", "17h53", "18h00"), "SUNDAY", "")
        loadFromAPI(525, "525", listOf("Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("10h00", "10h02", "10h09", "10h10", "10h11", "10h31"), "SUNDAY", "")
        loadFromAPI(526, "526", listOf("Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("14h00", "14h02", "14h09", "14h10", "14h11", "14h31"), "SUNDAY", "")
        loadFromAPI(527, "527", listOf("Vinha Brava", "Hospital", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "2 Caminhos"), listOf("18h00", "18h02", "18h09", "18h10", "18h11", "18h31"), "SUNDAY", "")
        loadFromAPI(528, "528", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Boa Hora", "2 Caminhos"), listOf("08h00", "08h02", "08h03", "08h06", "08h07", "08h08", "08h12", "08h28"), "SUNDAY", "")
        loadFromAPI(529, "529", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Boa Hora", "2 Caminhos"), listOf("13h00", "13h02", "13h03", "13h06", "13h07", "13h08", "13h12", "13h28"), "SUNDAY", "")
        loadFromAPI(530, "530", listOf("Vinha Brava", "Hospital", "Lar de Idosos", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Boa Hora", "2 Caminhos"), listOf("17h00", "17h02", "17h03", "17h06", "17h07", "17h08", "17h12", "17h28"), "SUNDAY", "")
        loadFromAPI(531, "531", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Reguinho"), listOf("10h30", "10h50", "10h51", "10h54", "11h05"), "SUNDAY", "")
        loadFromAPI(532, "532", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Reguinho"), listOf("14h30", "14h50", "14h51", "14h54", "15h05"), "SUNDAY", "")
        loadFromAPI(533, "533", listOf("2 Caminhos", "Praça Velha - Urbanas", "Praça Almeida Garrett", "Lar de Idosos", "Reguinho"), listOf("18h30", "18h50", "18h51", "18h54", "19h05"), "SUNDAY", "")
        loadFromAPI(534, "534", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("08h00", "08h05", "08h10", "08h30"), "SUNDAY", "")
        loadFromAPI(535, "535", listOf("Praia da Vitória", "Posto 1", "Aeroporto", "Rua do Ramo Grande"), listOf("10h30", "10h35", "10h40", "11h00"), "SUNDAY", "")
        loadFromAPI(536, "536", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("12h30", "12h40", "12h45", "13h00"), "SUNDAY", "")
        loadFromAPI(537, "537", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("15h30", "15h40", "15h45", "16h00"), "SUNDAY", "")
        loadFromAPI(538, "538", listOf("Rua do Ramo Grande", "Aeroporto", "Posto 1", "Praia da Vitória"), listOf("18h30", "18h40", "18h45", "19h00"), "SUNDAY", "")
        loadFromAPI(539, "539", listOf("Praia da Vitória", "Quatro Canadas", "Lajes - Igreja"), listOf("12h00", "12h15", "12h30"), "SUNDAY", "")
        loadFromAPI(540, "540", listOf("Praia da Vitória", "Quatro Canadas", "Lajes - Igreja"), listOf("15h00", "15h15", "15h30"), "SUNDAY", "")
        loadFromAPI(541, "541", listOf("Praia da Vitória", "Quatro Canadas", "Lajes - Igreja"), listOf("18h00", "18h15", "18h30"), "SUNDAY", "")
        loadFromAPI(542, "542", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("12h00", "12h04", "12h05", "12h06", "12h20", "12h24", "12h27", "12h32", "12h42", "12h52", "12h57", "13h07", "13h14", "13h24"), "SUNDAY", "")
        loadFromAPI(543, "543", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("16h00", "16h04", "16h05", "16h06", "16h20", "16h24", "16h27", "16h32", "16h42", "16h52", "16h57", "17h07", "17h14", "17h24"), "SUNDAY", "")
        loadFromAPI(544, "544", listOf("Av. Álvaro Martins Homem", "Jardim Duque da Terceira", "Alto das Covas", "Portões de S. Pedro", "Pesqueiro", "Cruz das Cinco", "Cinco Ribeiras", "Santa Bárbara", "Doze Ribeiras", "Serreta", "Serreta (Estalagem)", "Raminho", "Altares - Igreja", "Biscoitos"), listOf("19h00", "19h04", "19h05", "19h06", "19h20", "19h24", "19h27", "19h32", "19h42", "19h52", "19h57", "20h07", "20h14", "20h24"), "SUNDAY", "")
        loadFromAPI(545, "545", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("10h30", "10h40", "10h47", "10h58", "11h03", "11h13", "11h23", "11h28", "11h30", "11h35", "11h50", "11h51", "11h55"), "SUNDAY", "")
        loadFromAPI(546, "546", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("13h30", "13h40", "13h47", "13h58", "14h03", "14h13", "14h23", "14h28", "14h30", "14h35", "14h50", "14h51", "14h55"), "SUNDAY", "")
        loadFromAPI(547, "547", listOf("Biscoitos", "Altares - Igreja", "Raminho", "Serreta (Estalagem)", "Serreta", "Doze Ribeiras", "Santa Bárbara", "Cinco Ribeiras", "Cruz das Cinco", "Pesqueiro", "Praça Velha - Inter-Urbanas", "Praça Almeida Garrett", "Av. Álvaro Martins Homem"), listOf("17h30", "17h40", "17h47", "17h58", "18h03", "18h13", "18h23", "18h28", "18h30", "18h35", "18h50", "18h51", "18h55"), "SUNDAY", "")
        Log.d("Routes: ", allRoutes.toString())
    }

    /*private fun loadRoutes(){
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
    }*/

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

    fun loadFromAPI(id: Int, route: String, stops: List<String>, times: List<String>, type_of_day: String, information: String){
        var day: TypeOfDay = TypeOfDay.WEEKDAY
        when (type_of_day) {
            "WEEKDAY" -> {
                day = TypeOfDay.WEEKDAY
            }
            "SATURDAY" -> {
                day = TypeOfDay.SATURDAY
            }
            "SUNDAY" -> {
                day = TypeOfDay.SUNDAY
            }
        }

        var info: JSONObject? = null
        if (information == "") {
            info = JSONObject("{'pt': '', 'en': '', 'es': '', 'fr': '', 'de': ''}")
        } else {
            info = JSONObject(information)
        }

        var img: Int? = R.drawable.evt_logo


        var stop_times: MutableMap<Stop, List<String>> = mutableMapOf()
        for (i in 0 until stops.size) stop_times[getStop(stops.get(i))] = listOf<String>(times.get(i))

        val trip: Route? = img?.let {
            Route(
                route, id.toString(), stop_times, day, it, info?.getString(currentLanguage)
            )
        }

        if (trip != null) {
            allRoutes.add(trip)
        }
    }

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