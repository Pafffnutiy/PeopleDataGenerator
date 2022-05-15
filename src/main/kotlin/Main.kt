import Man
import com.itextpdf.kernel.font.PdfFont
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.property.TextAlignment
import java.nio.file.Paths

fun main(args: Array<String>) {
    // Creating a Pdf
    val dest = "PeopleData.pdf"
    val pdf = PdfDocument(PdfWriter(dest))
    for (cnt in (1..5))
        pdf.addNewPage(PageSize.A4.rotate());
    val doc = Document(pdf)

    //Creating a table
    var tableConf: FloatArray = configureTable(pdf)
    val table = Table(tableConf)
    createHead(table)

    println("Insert number of people")
    var count = readLine()!!.toInt()
    for (ind in 1..count)
        insertMan(table)

    doc.add(table)

    doc.close()

    val path = Paths.get("").toAbsolutePath().toString()
    println("Файл создан. Путь: $path/$dest")
}

val FONTTTF = "./resources/20927.ttf"
val font: PdfFont = PdfFontFactory.createFont(FONTTTF, "Identity-H", true)

fun configureTable(pdf: PdfDocument): FloatArray {
    val columnWidth: Float = pdf.getPage(1).pageSize.width / 14
    val pointColumnWidths = FloatArray(14) { columnWidth }

    pointColumnWidths[0] += 13f
    pointColumnWidths[1] += 20f
    pointColumnWidths[2] += 24f
    pointColumnWidths[3] -= 4f
    pointColumnWidths[4] -= 23f
    pointColumnWidths[5] += 13f
    pointColumnWidths[6] += 10f
    pointColumnWidths[7] -= 8f
    pointColumnWidths[8] -= 10f
    pointColumnWidths[11] -= 10f
    pointColumnWidths[12] -= 28f
    pointColumnWidths[13] -= 38f

    return pointColumnWidths
}

fun createHead(tab: Table) {
    val headField = arrayOf(
        "Имя", "Фамилия", "Отчество", "Возраст", "Пол", "Дата рождения", "Место рождения",
        "Индекс", "Страна", "Область", "Город", "Улица", "Дом", "Кв"
    )

    headField.forEach {
        tab.addCell(Cell().add(it).setFont(font).setTextAlignment(TextAlignment.CENTER))
    }
}

fun insertMan(tab: Table) {
    var man = Man()
    man.createPersonalData()

    val manData = arrayOf(
        man.data.name.firstName, man.data.name.lastName, man.data.name.secondName,
        man.data.getAge().toString(), man.data.sex, man.data.birthRepresentation(man.data.birth),
        man.data.birthCity, man.address.index.toString(), man.address.country,
        man.address.region, man.address.city, man.address.street, man.address.apt.toString(),
        man.address.flat.toString()
    )

    manData.forEach {
        tab.addCell(Cell().add(it).setFont(font))
    }
}