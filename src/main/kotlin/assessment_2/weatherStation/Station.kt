package assessment_2.weatherStation

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

data class Station(val city: String, val code: String, val state: String, val USPS: String)

fun main() {
    val stationList = ReadStations()
    val readStations = stationList.readStation()
    val writeStations = StationPrinter()

    //prints all station to csv file
    writeStations.printToSCVFile(readStations)

    //prints all filtered weather records
    val data = RecordData()
    //prints data of weather in a single station
    data.accumulatedData(readStations)
    //prints data of weather in a state
    data.stationsInState(readStations)
}

class ReadStations {
    // read station1 and station2 csv files and return as a list of stations
    fun readStation(): List<Station> {
        val stationsList: MutableList<Station> = mutableListOf()

        try {
            File("stations.csv")
            val stationList1 = FileReader("src//main//kotlin//assessment_2//sources//stations1.csv")
            val stationList2 = FileReader("src//main//kotlin//assessment_2//sources//stations2.csv")

            stationList2.forEachLine { stationsList += Station(
                it.split(",")[0],
                it.split(",")[1],
                it.split(",")[2],
                it.split(",")[3],
            )
            }
            stationList1.forEachLine { stationsList += Station(
                it.split(",")[0],
                it.split(",")[1],
                it.split(",")[2],
                it.split(",")[3])
            }
        }catch (e: FileNotFoundException) {
            println("File not found!")
        }
        return stationsList
    }
}


class StationPrinter {
    fun printToSCVFile(stations: List<Station>) {
        val file = File("src//main//kotlin//assessment_2//sources//stations.csv")
        val printWriter = file.printWriter()

        //print out each row
        stations.forEach {
            printWriter.println("${it.city},${it.code},${it.state},${it.USPS}")
        }

        println("csv file successfully created!")
        printWriter.flush()

    }
}




