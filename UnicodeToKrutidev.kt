package `in`.animall.android.features.sell.workers


private val arrayOne = arrayOf(
    "‘", "’", "“", "”", "(", ")", "{", "}", "=", "।", "?", "-", "µ", "॰", ",", ".", "् ",
    "०", "१", "२", "३", "४", "५", "६", "७", "८", "९", "x",
    "फ़्", "क़", "ख़", "ग़", "ज़्", "ज़", "ड़", "ढ़", "फ़", "य़", "ऱ", "ऩ",
    "त्त्", "त्त", "क्त", "दृ", "कृ",
    "ह्न", "ह्य", "हृ", "ह्म", "ह्र", "ह्", "द्द", "क्ष्", "क्ष", "त्र्", "त्र", "ज्ञ",
    "छ्य", "ट्य", "ठ्य", "ड्य", "ढ्य", "द्य", "द्व",
    "श्र", "ट्र", "ड्र", "ढ्र", "छ्र", "क्र", "फ्र", "द्र", "प्र", "ग्र", "रु", "रू",
    "्र",
    "ओ", "औ", "आ", "अ", "ई", "इ", "उ", "ऊ", "ऐ", "ए", "ऋ",
    "क्", "क", "क्क", "ख्", "ख", "ग्", "ग", "घ्", "घ", "ङ",
    "चै", "च्", "च", "छ", "ज्", "ज", "झ्", "झ", "ञ",
    "ट्ट", "ट्ठ", "ट", "ठ", "ड्ड", "ड्ढ", "ड", "ढ", "ण्", "ण",
    "त्", "त", "थ्", "थ", "द्ध", "द", "ध्", "ध", "न्", "न",
    "प्", "प", "फ्", "फ", "ब्", "ब", "भ्", "भ", "म्", "म",
    "य्", "य", "र", "ल्", "ल", "ळ", "व्", "व",
    "श्", "श", "ष्", "ष", "स्", "स", "ह",
    "ऑ", "ॉ", "ो", "ौ", "ा", "ी", "ु", "ू", "ृ", "े", "ै",
    "ं", "ँ", "ः", "ॅ", "ऽ", "् ", "्"
)
private val array_two = arrayOf(
    "^", "*", "Þ", "ß", "¼", "½", "¿", "À", "¾", "A", "\\", "&", "&", "Œ", "]", "-", "~ ",
    //"å", "ƒ", "„", "…", "†", "‡", "ˆ", "‰", "Š", "‹", "Û",
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Û",
    "¶", "d", "[k", "x", "T", "t", "M+", "<+", "Q", ";", "j", "u",
    "Ù", "Ùk", "Dr", "–", "—",
    "à", "á", "â", "ã", "ºz", "º", "í", "{", "{k", "«", "=", "K",
    "Nî", "Vî", "Bî", "Mî", "<î", "|", "}",
    "J", "Vª", "Mª", "<ªª", "Nª", "Ø", "Ý", "æ", "ç", "xz", "#", ":",
    "z",
    "vks", "vkS", "vk", "v", "bZ", "b", "m", "Å", ",s", ",", "_",
    "D", "d", "ô", "[", "[k", "X", "x", "?", "?k", "³",
    "pkS", "P", "p", "N", "T", "t", "÷", ">", "¥",
    "ê", "ë", "V", "B", "ì", "ï", "M", "<", ".", ".k",
    "R", "r", "F", "Fk", ")", "n", "/", "/k", "U", "u",
    "I", "i", "¶", "Q", "C", "c", "H", "Hk", "E", "e",
    "¸", ";", "j", "Y", "y", "G", "O", "o",
    "'", "'k", "\"", "\"k", "L", "l", "g",
    "v‚", "‚", "ks", "kS", "k", "h", "q", "w", "`", "s", "S",
    "a", "¡", "%", "W", "·", "~ ", "~"
)

fun unicodeToKrutiDev(unicodeSubstring: String): String {

    var modifiedSubstring = unicodeSubstring
    var positionOfQuote = modifiedSubstring.indexOf("'")
    while (positionOfQuote >= 0) {
        modifiedSubstring = modifiedSubstring.replaceFirst("'", "^")
        modifiedSubstring = modifiedSubstring.replaceFirst("'", "*")
        positionOfQuote = modifiedSubstring.indexOf("'")
    }
    var positionOfDquote = modifiedSubstring.indexOf("\"")
    while (positionOfDquote >= 0) {
        modifiedSubstring = modifiedSubstring.replaceFirst("\"", "ß")
        modifiedSubstring = modifiedSubstring.replaceFirst("\"", "Þ")
        positionOfDquote = modifiedSubstring.indexOf("\"")
    }

    // first Replace the two-byte nukta_varNa with corresponding one-byte nukta varNas.
    modifiedSubstring = modifiedSubstring.replace("क़", "क़")
    modifiedSubstring = modifiedSubstring.replace("ख़", "ख़")
    modifiedSubstring = modifiedSubstring.replace("ग़", "ग़")
    modifiedSubstring = modifiedSubstring.replace("ज़", "ज़")
    modifiedSubstring = modifiedSubstring.replace("ड़", "ड़")
    modifiedSubstring = modifiedSubstring.replace("ढ़", "ढ़")
    modifiedSubstring = modifiedSubstring.replace("ऩ", "ऩ")
    modifiedSubstring = modifiedSubstring.replace("फ़", "फ़")
    modifiedSubstring = modifiedSubstring.replace("य़", "य़")
    modifiedSubstring = modifiedSubstring.replace("ऱ", "ऱ")

    // code for replacing "ि" (chhotee ee kii maatraa) with "f"  and correcting its position too.
    var positionOfF = modifiedSubstring.indexOf("ि")
    while (positionOfF != -1) //while-02
    {
        val characterLeftToF = modifiedSubstring[positionOfF - 1]
        modifiedSubstring = modifiedSubstring.replace(characterLeftToF.toString() + "ि", "f$characterLeftToF")
        positionOfF -= 1
        while (positionOfF != 0 && modifiedSubstring[positionOfF - 1] == '्') {
            val stringToBeReplaced = modifiedSubstring[positionOfF - 2].toString() + "्"
            modifiedSubstring = modifiedSubstring.replace(stringToBeReplaced + "f", "f$stringToBeReplaced")
            positionOfF -= 2
        }
        positionOfF = modifiedSubstring.indexOf("ि", positionOfF + 1) // search for f ahead of the current position.
    } // end of while-02 loop


    //************************************************************
    //     modified_substring = modified_substring.Replace( /fर्", "£"  )  ;
    //************************************************************
    // Eliminating "र्" and putting  Z  at proper position for this.
    val setOfMatras = "ािीुूृेैोौं:ँॅ"
    modifiedSubstring += "  " // add two spaces after the string to avoid UNDEFINED char in the following code.
    var positionOfHalfR = modifiedSubstring.indexOf("र्")
    while (positionOfHalfR > 0) {

        // "र्"  is two bytes long
        var probablePositionOfZ = positionOfHalfR + 2
        var characterRightToProbablePositionOfZ = modifiedSubstring[probablePositionOfZ + 1].code

        // trying to find non-maatra position right to probable_position_of_Z .
        while (setOfMatras.indexOf(characterRightToProbablePositionOfZ.toChar()) != -1) {
            probablePositionOfZ += 1
            characterRightToProbablePositionOfZ = modifiedSubstring[probablePositionOfZ + 1].code
        } // end of while-05

        val stringToBeReplaced = modifiedSubstring.substring(positionOfHalfR + 2, positionOfHalfR + 2 + probablePositionOfZ - positionOfHalfR - 1)
        modifiedSubstring = modifiedSubstring.replace("र्$stringToBeReplaced", stringToBeReplaced + "Z")
        positionOfHalfR = modifiedSubstring.indexOf("र्")
    } // end of while-04

    modifiedSubstring = modifiedSubstring.substring(0, modifiedSubstring.length - 2)

    //substitute array_two elements in place of corresponding array_one elements
    for (inputSymbolIdx in arrayOne.indices) {
        var idx = 0 // index of the symbol being searched for Replacement
        while (idx != -1) {
            modifiedSubstring = modifiedSubstring.replace(arrayOne[inputSymbolIdx], array_two[inputSymbolIdx])
            idx = modifiedSubstring.indexOf(arrayOne[inputSymbolIdx])
        } // end of while-00 loop
    } // end of for loop
    return modifiedSubstring
}

fun main(args: Array<String>) {
    print(unicodeToKrutiDev(args[0]))
}