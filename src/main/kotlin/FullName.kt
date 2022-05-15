class FullName {
    var firstName = ""
        set(value){

            if(isStringCorrect(value))
                field = value
        }

    var secondName = ""
        set(value){
            if(isStringCorrect(value))
                field = value
        }

    var lastName = ""
    set(value){
        if(isStringCorrect(value))
            field = value
    }

    fun createFirstName(sex: String){
        when (sex) {
            "МУЖ" -> firstName = maleNames.random()
            "ЖЕН" -> firstName = femaleNames.random()
        }
    }

    fun createSecondName(sex: String){
        when (sex) {
            "МУЖ" -> secondName = maleSecondNames.random()
            "ЖЕН" -> secondName = femaleSecondNames.random()
        }
    }

    fun createLastName(sex: String){
        when (sex) {
            "МУЖ" -> lastName = maleLastNames.random()
            "ЖЕН" -> lastName = femaleLastNames.random()
        }
    }

    private fun isStringCorrect(value: String): Boolean {
        return value.isNotEmpty() && isBigRussianLetter(value[0]) && value.subSequence(1,value.length-1).all(isRussianLetterPredicate)
    }

    private val isRussianLetterPredicate: (Char) -> Boolean = {it in 'а'..'я'}

    private fun isBigRussianLetter(symbol: Char): Boolean {
        return symbol in 'А'..'Я'
    }
}

val maleNames: Array<String> = arrayOf("Александр", "Владимир", "Василий","Сергей","Андрей","Алексей","Павел",
    "Михаил","Юрий","Николай","Роман","Олег","Виктор","Евгений","Борис", "Игорь")

val femaleNames: Array<String> = arrayOf("София", "Анна", "Мария", "Алиса", "Ева", "Виктория", "Елена",
    "Полина", "Василиса", "Варвара", "Ксения", "Анастасия", "Елизавета", "Дарья", "Милена", "Лидия")

val femaleSecondNames: Array<String> = arrayOf("Егоровна", "Антоновна", "Васильевна", "Сергеевна", "Андреевна", "Игоревна",
    "Алексеевна", "Павловна", "Михайловна","Юрьевна", "Николаевна", "Романовна", "Олеговна", "Викторовна", "Евгеньевна", "Борисовна")

val maleSecondNames: Array<String> = arrayOf("Егорович", "Антонович", "Васильевич", "Сергеевич", "Андреевич",
    "Алексеевич", "Павлович", "Михайлович", "Юрьевич", "Николаевич", "Романович", "Олегович", "Викторович",
    "Евгеньевич", "Борисович", "Игоревич")

val maleLastNames: Array<String> = arrayOf("Смирнов", "Иванов", "Кузнецов", "Романов", "Захаров", "Меведев", "Тиньков",
    "Майков", "Тетерин", "Колобков", "Рогов", "Зиновьев", "Деревянко", "Мусатов", "Логинов", "Сафонов")

val femaleLastNames: Array<String> = arrayOf("Савина", "Афанасьева", "Шубина", "Молчанова", "Гурьева", "Русакова",
    "Котова", "Власова", "Воронцова", "Цветкова", "Давыдова", "Громова", "Николаева", "Григорьева", "Лазарева", "Дорофеева")