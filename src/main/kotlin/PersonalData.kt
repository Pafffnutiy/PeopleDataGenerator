import FullName

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class PersonalData {
    var name = FullName()
    var sex = if ((0..1).random()==0) "МУЖ" else "ЖЕН"
    var birth = LocalDate.parse("1970-01-01")
    var birthCity = ""

    fun birthRepresentation(date: LocalDate):String{
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return date.format(formatter)
    }

    fun createFullName() {
        name.createFirstName(sex)
        name.createSecondName(sex)
        name.createLastName(sex)
    }

    fun createBirthday(){
        var year = (1900..2020).random()
        var month = (1..12).random()
        var day = 0

        when(month){
            in daysMonth30 -> day = (1..30).random()
            in daysMonth31 -> day = (1..31).random()
            2 -> day = (1..28).random()
        }

        birth = LocalDate.of(year,month,day)
    }

    fun getAge() : Int {
        var currentDate = LocalDate.now()
        var period = Period.between(birth, currentDate)
        return period.years
    }
}

val daysMonth31: Array<Int> = arrayOf(1,3,5,7,8,10,12)
val daysMonth30: Array<Int> = arrayOf(4,6,9,11)

fun isLeapYear(value: Int): Boolean{
    return ((value % 4 == 0) && (value % 100 !=0) || value % 400 == 0)
}