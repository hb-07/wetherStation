package assessment_2.weatherStation

import java.io.FileNotFoundException
import java.io.FileReader
import kotlin.math.max
import kotlin.math.min

// a record class contains a timestamp,weatherStation code, temperature and wind speed
data class Record(val timeStamp: String, val weatherStationCode: String, val temperatureAvg: Int, val temperatureMax: Int, val temperatureMin: Int, val windSpeed: Double)


class RecordData {
    fun accumulatedData(stations: List<Station>) {
        var weatherRecord: List<Record> = listOf()
        try {
            val weatherList = FileReader("src//main//kotlin//assessment_2//sources//weather.csv")

            weatherList.forEachLine {
                weatherRecord +=
                    Record(
                        it.split(",")[0],
                        it.split(",")[1],
                        it.split(",")[2].toInt(),
                        it.split(",")[3].toInt(),
                        it.split(",")[4].toInt(),
                        it.split(",")[5].toDouble()
                    )
            }

            var stationCods: List<String> = listOf()
            for (st in stations) {
                stationCods += st.code
            }

            println("\nWeather data in a single station:")
            println("StationCode,TemperatureAvg,TemperatureMax,TemperatureMin,windSpeedAvg")

            for (station in stations) {
                var sum = 0
                var maxTemp = 0
                var windSpeed = 0.0
                var minTemp = 200
                var stationCode =""
                var count = 1
                for (record in weatherRecord) {
                    if (record.weatherStationCode in stationCods) {
                        if (station.code == record.weatherStationCode) {
                            //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                            sum += (record.temperatureAvg)
                            maxTemp = max(maxTemp, (record.temperatureMax))
                            minTemp = min(minTemp, (record.temperatureMin))
                            windSpeed += (record.windSpeed)
                            stationCode = record.weatherStationCode
                            count++
                        }
                    }
                }
                println("$stationCode,${(sum / count)},$maxTemp,$minTemp,${windSpeed / count}")
            }
        } catch (i: FileNotFoundException) {
            println(i.cause)
        }
    }

    fun stationsInState(stations: List<Station>) {

        var weatherRecord: List<Record> = listOf()
        try {
            val weatherList = FileReader("src//main//kotlin//assessment_2//sources//weather.csv")

            weatherList.forEachLine {
                weatherRecord +=
                    Record(
                        it.split(",")[0],
                        it.split(",")[1],
                        it.split(",")[2].toInt(),
                        it.split(",")[3].toInt(),
                        it.split(",")[4].toInt(),
                        it.split(",")[5].toDouble()
                    )
            }

            var stationCods: List<String> = listOf()
            for (st in stations) {
                stationCods += st.code
            }

            println("\n weather data in state")
            println("State,TemperatureAvg,TemperatureMax,TemperatureMin,windSpeedAvg")

            for (station in stations) {
                var sum = 0
                var maxTemp = 0
                var windSpeed = 0.0
                var minTemp = 200
                var state =""
                var count = 1
                for (record in weatherRecord) {
                    if (record.weatherStationCode in stationCods) {
                        when (station.state) {
                            "Alaska" -> {
                                //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                                sum += (record.temperatureAvg)
                                maxTemp = max(maxTemp, (record.temperatureMax))
                                minTemp = min(minTemp, (record.temperatureMin))
                                windSpeed += (record.windSpeed)
                                state = station.state
                                count++
                            }
                            "Alabama" -> {
                                //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                                sum += (record.temperatureAvg)
                                maxTemp = max(maxTemp, (record.temperatureMax))
                                minTemp = min(minTemp, (record.temperatureMin))
                                windSpeed += (record.windSpeed)
                                state = station.state
                                count++
                            }
                            "Texas" -> {
                                //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                                sum += (record.temperatureAvg)
                                maxTemp = max(maxTemp, (record.temperatureMax))
                                minTemp = min(minTemp, (record.temperatureMin))
                                windSpeed += (record.windSpeed)
                                state = station.state
                                count++
                            }
                            "Tennessee" -> {
                                //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                                sum += (record.temperatureAvg)
                                maxTemp = max(maxTemp, (record.temperatureMax))
                                minTemp = min(minTemp, (record.temperatureMin))
                                windSpeed += (record.windSpeed)
                                state = station.state
                                count++

                            }
                            "Utah" -> {
                                //calculate averageTemp, maxTemp, minTemp and avgWindSpeed of a single station
                                sum += (record.temperatureAvg)
                                maxTemp = max(maxTemp, (record.temperatureMax))
                                minTemp = min(minTemp, (record.temperatureMin))
                                windSpeed += (record.windSpeed)
                                state = station.state
                                count++
                            }
                        }
                    }
                }
                println("$state,${(sum / count)},$maxTemp,$minTemp,${windSpeed / count}")

            }
        } catch (i: FileNotFoundException) {
            println(i.cause)
        }
    }
}