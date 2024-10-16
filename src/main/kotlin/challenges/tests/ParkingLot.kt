package challenges.tests

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * Provide code for a parking lot with the following assumptions,
 *
 * • The parking lot has multiple levels. Each level has multiple rows of spots.
 * • The parking lot has motorcycle spots and car spots.
 * • A motorcycle can park in any empty spot.
 * • A car can only park in a single empty car spot.
 *
 * Provide 3 functions for a working parking lot:
 *
 * 1. Given a vehicle, you should be able to park it.
 * 2. Given a vehicle, you should be able to unpark it.
 * 3. Given a spot, you should be able to find the vehicle parked in it.
 */

private enum class VehicleType {
    MOTORCYCLE,
    CAR,
}

private data class Vehicle(
    val type: VehicleType,
    val license: String,
)

private data class ParkSpot(
    val level: Int,
    val type: VehicleType,
    var vehicle: Vehicle? = null,
)

private class ParkingLot {

    val parking = arrayOf(
        ParkSpot(level = 1, type = VehicleType.MOTORCYCLE),
        ParkSpot(level = 1, type = VehicleType.MOTORCYCLE),
        ParkSpot(level = 1, type = VehicleType.CAR),
        ParkSpot(level = 2, type = VehicleType.CAR),
        ParkSpot(level = 2, type = VehicleType.CAR),
        ParkSpot(level = 2, type = VehicleType.MOTORCYCLE),
    )

    val usedVehicleSpot = hashMapOf<Vehicle, Int>()

    /**
     * Park the vehicle in the space when the space is empty and match the vehicle type if it is a car
     * Complexity: O(n)
     */
    fun parkVehicle(vehicle: Vehicle) {
        if (usedVehicleSpot.containsKey(vehicle)) {
            return
        }

        parking.forEachIndexed { index, parkSpot ->
            if ((parkSpot.vehicle == null) &&
                (parkSpot.type == vehicle.type || vehicle.type == VehicleType.MOTORCYCLE)
            ) {
                parkSpot.vehicle = vehicle
                usedVehicleSpot[vehicle] = index
                return
            }
        }
    }

    /**
     * Unpark vehicle parked in a spot using license key
     * Complexity: O(1)
     */
    fun unparkVehicle(vehicle: Vehicle) {
        val spotId = usedVehicleSpot[vehicle] ?: return

        if (parking[spotId].vehicle?.license == vehicle.license) {
            parking[spotId].vehicle = null
            usedVehicleSpot.remove(vehicle)
            return
        }
    }

    /**
     * Find spot by index and return vehicle license parked
     * Complexity: O(n)
     */
    fun getVehicle(spotId: Int): Vehicle? {
        usedVehicleSpot.forEach {
            if (it.value == spotId) {
                return it.key
            }
        }

        return null
    }
}

fun main() {
    val parkingLot = ParkingLot()

    val motorcycle1 = Vehicle(type = VehicleType.MOTORCYCLE, license = "ABC123")
    val motorcycle2 = Vehicle(type = VehicleType.MOTORCYCLE, license = "ZXC456")
    val motorcycle3 = Vehicle(type = VehicleType.MOTORCYCLE, license = "KTL141")
    val car1 = Vehicle(type = VehicleType.CAR, license = "QWE123")
    val car2 = Vehicle(type = VehicleType.CAR, license = "BMW789")

    parkingLot.parkVehicle(car1)
    parkingLot.parking[2].vehicle equalsTo car1

    parkingLot.parkVehicle(motorcycle1)
    parkingLot.parking[0].vehicle equalsTo motorcycle1

    parkingLot.parkVehicle(motorcycle2)
    parkingLot.parking[1].vehicle equalsTo motorcycle2

    parkingLot.parkVehicle(motorcycle3)
    parkingLot.parking[3].vehicle equalsTo motorcycle3

    parkingLot.parkVehicle(car2)
    parkingLot.parking[4].vehicle equalsTo car2

    parkingLot.unparkVehicle(car1)
    parkingLot.parking[2].vehicle equalsTo null

    parkingLot.unparkVehicle(car2)
    parkingLot.parking[4].vehicle equalsTo null

    parkingLot.getVehicle(spotId = 2) equalsTo null
    parkingLot.getVehicle(spotId = 3) equalsTo motorcycle3
    parkingLot.getVehicle(spotId = 4) equalsTo null
}
