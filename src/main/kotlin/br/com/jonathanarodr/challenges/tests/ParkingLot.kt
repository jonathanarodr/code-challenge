package br.com.jonathanarodr.challenges.tests

/**
 * Provide code for a parking lot with the following assumptions,
 *
 * • The parking lot has multiple levels. Each level has multiple rows of spots.
 * • The parking lot has motorcycle spots and car spots.
 * • A motorcycle can park in any empty spot.
 * • A car can only park in a single empty car spot.
 *
 *
 * Provide 3 functions for a working parking lot:
 *
 * 1. Given a vehicle, you should be able to park it.
 * 2. Given a vehicle, you should be able to unpark it.
 * 3. Given a spot, you should be able to find the vehicle parked in it.
 */

/**
 * Notes:
 * multi levels = matrix
 * card = park only spot car
 * motorcycle = park any spot
 * park first spot founded bottom / up
 */
enum class VehicleType {
    Car,
    Motorcycle,
}

data class Vehicle(
    val license: String,
    val type: VehicleType,
)

data class Spot(
    val type: VehicleType,
    var vehicle: Vehicle? = null,
)

typealias LevelSpot = Pair<Int, Int>

class ParkingLot {

    /**
     * spots [x, x, x, x]
     * level [x = spots, x = spots, x = spots, x = spots]]
     */
    val levels = listOf(
        listOf(
            Spot(type = VehicleType.Motorcycle),
            Spot(type = VehicleType.Car),
            Spot(type = VehicleType.Car),
            Spot(type = VehicleType.Car),
        ),
        listOf(
            Spot(type = VehicleType.Car),
            Spot(type = VehicleType.Motorcycle),
            Spot(type = VehicleType.Motorcycle),
            Spot(type = VehicleType.Car),
        ),
    )

    val parkedVehicle = hashMapOf<Vehicle, LevelSpot>()

    private fun isParkingAllowed(spot: Spot, vehicle: Vehicle): Boolean {
        return spot.vehicle == null && (spot.type == vehicle.type || vehicle.type == VehicleType.Motorcycle)
    }

    fun park(vehicle: Vehicle) {
        if (vehicle in parkedVehicle) {
            println("Vehicle $vehicle already parked")
            return
        }

        levels.forEachIndexed { level, spots ->
            spots.forEachIndexed { id, spot ->
                if (isParkingAllowed(spot, vehicle)) {
                    println("Parking in level: $level spot: $id")
                    spot.vehicle = vehicle
                    parkedVehicle[vehicle] = level to id
                    return
                }
            }
        }
    }

    fun unpark(vehicle: Vehicle): Boolean {
        val levelSpot = parkedVehicle[vehicle] ?: return false

        println("Unparking vehicle in level ${levelSpot.first} spot: ${levelSpot.second}")
        levels[levelSpot.first][levelSpot.second].vehicle = null
        parkedVehicle.remove(vehicle)

        return true
    }

    fun findVehicle(vehicle: Vehicle): Spot? {
        return parkedVehicle[vehicle]?.run {
            levels[this.first][this.second]
        }
    }
}

fun main() {

    val parkingLot = ParkingLot()

    val motorcycle = Vehicle("ABC123", VehicleType.Motorcycle)
    val car = Vehicle("QWE123", VehicleType.Car)

    parkingLot.park(motorcycle)
    parkingLot.park(car)

    println(parkingLot.findVehicle(car))
    println(parkingLot.findVehicle(motorcycle))
    println(parkingLot.unpark(car))
}
