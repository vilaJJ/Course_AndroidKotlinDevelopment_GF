/*
* Type      Bit
*
* Double    64
* Float     32
*
* Long      64
* Int       32
* Short     16
* Byte      8
*
* Boolean   ?
*
* String    ?
*
* Char      ?
* */

fun main() {
    var char : Char = 'M';
    var string : String = "String text"
    var boolean : Boolean = true;
    var double : Double = 1269.78
    var float : Float = 1.83f
    var long : Long = 15L
    var int : Int = 20
    var short : Short = 35
    var byte : Byte = 8

    var idade : Byte = 20
    var altura : Float

    println("Double range: ${Double.MIN_VALUE} até ${Double.MAX_VALUE}")
    println("Float range: ${Float.MIN_VALUE} até ${Float.MAX_VALUE}")
    println("Long range: ${Long.MIN_VALUE} até ${Long.MAX_VALUE}")
    println("Int range: ${Int.MIN_VALUE} até ${Int.MAX_VALUE}")
    println("Short range: ${Short.MIN_VALUE} até ${Short.MAX_VALUE}")
    println("Byte range: ${Byte.MIN_VALUE} até ${Byte.MAX_VALUE}")
}