import PersonalData
import Address

class Man {
    var data: PersonalData = PersonalData()
    var address: Address = Address()

    fun createPersonalData() {
        data.createFullName()
        data.createBirthday()
        data.birthCity = cities.random()
    }
}