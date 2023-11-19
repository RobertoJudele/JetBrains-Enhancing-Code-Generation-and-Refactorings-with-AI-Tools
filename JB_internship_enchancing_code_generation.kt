import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
fun compressText(text: String): String {
    if (text.isEmpty()) return ""

    val finalStr = StringBuilder()
    var count = 1

    for (i in 0 until text.length - 1) {
        if (text[i + 1] == text[i]) {
            count++
        } else {
            finalStr.append("${text[i]}±$count")
            count = 1
        }
    }

    finalStr.append("${text.last()}±$count")
    return finalStr.toString()
}

fun decompressText(text:String):String{
    var i=0
    var cnt=i+3
    var final_str=""
    while (i<=text.length-2){
        var frecv = 0
        if(cnt==text.length){
            frecv = text[cnt-1].digitToInt()
            final_str += text[i].toString().repeat(frecv)
            return final_str
        }
        else if(text[cnt-1].isDigit() && text[cnt].isDigit()) {
            frecv = text[cnt-1].digitToInt()
            while (text[cnt-1].isDigit() && text[cnt].isDigit() && cnt <= text.length-2) {
                frecv *= 10
                frecv += text[cnt].digitToInt()
                cnt++
            }
            if (cnt==text.length-1){
                frecv *= 10
                frecv += text.last().digitToInt()
            }
        }
        else {
            frecv = text[cnt-1].digitToInt()
        }
        final_str += text[i].toString().repeat(frecv)
        cnt+=3
        i=cnt-3
    }
    return final_str
}

fun main(){
    val userInput = readLine().orEmpty()
    val text = readLine().orEmpty()
    if(userInput=="Compresie")
        println(compressText(text))
    else if (userInput=="Decompresie")
        println(decompressText(text))
}
class TextCompressionTest {
    @Test
    fun testCompressText() {
        assertEquals("A±14", compressText("AAAAAAAAAAAAAA"))
        assertEquals("p±1e±1r±1 ±1e±1s±1p±1e±1r±1a±1 ±1a±1d±1 ±1a±1s±1t±1r±1a±1", compressText("per espera ad astra"))
        assertEquals("L±1o±1r±1e±1m±1 ±1i±1p±1s±1u±1m±1 ±1d±1o±1l±1o±1r±1 ±1s±1i±1t±1 ±1a±1m±1e±1t±1,±1 ±1c±1o±1n±1s±1e±1c±1t±1e±1t±1u±1r±1 ±1a±1d±1i±1p±1i±1s±1c±1i±1n±1g±1 ±1e±1l±1i±1t±1.±1 ±1I±1n±1t±1e±1g±1e±1r±1 ±1i±1d±1 ±1s±1a±1p±1i±1e±1n±1 ±1u±1t±1 ±1j±1u±1s±1t±1o±1 ±1v±1e±1n±1e±1n±1a±1t±1i±1s±1 ±1u±1l±2a±1m±1c±1o±1r±1p±1e±1r±1.±1 ±1C±1u±1r±1a±1b±1i±1t±1u±1r±1 ±1l±1a±1o±1r±1e±2t±1,±1 ±1n±1e±1q±1u±1e±1 ±1a±1c±1 ±1f±1e±1u±1g±1i±1a±1t±1 ±1c±1o±1m±2o±1d±1o±1,±1 ±1o±1d±1i±1o±1 ±1l±1i±1g±1u±1l±1a±1 ±1t±1e±1m±1p±1u±1s±1 ±1n±1i±1s±1i±1,±1 ±1v±1e±1l±1 ±1g±1r±1a±1v±1i±1d±1a±1 ±1e±1r±1o±1s±1 ±1a±1u±1g±1u±1e±1 ±1v±1e±1l±1 ±1j±1u±1s±1t±1o±1.±1 ±1S±1e±1d±1 ±1e±1f±2i±1c±1i±1t±1u±1r±1 ±1e±1r±1o±1s±1 ±1e±1u±1i±1s±1m±1o±1d±1,±1 ±1e±1u±1 ±1u±1l±2a±1m±1c±1o±1r±1p±1e±1r±1 ±1n±1u±1l±2a±1 ±1t±1i±1n±1c±1i±1d±1u±1n±1t±1.±1 ±1A±1e±1n±1e±1a±1n±1 ±1e±1t±1 ±1i±1p±1s±1u±1m±1 ±1u±1t±1 ±1l±1i±1g±1u±1l±1a±1 ±1v±1a±1r±1i±1u±1s±1 ±1f±1a±1c±1i±1l±1i±1s±1i±1s±1.±1 ±1Q±1u±1i±1s±1q±1u±1e±1 ±1e±1f±2i±1c±1i±1t±1u±1r±1 ±1f±1e±1l±1i±1s±1 ±1e±1u±1 ±1t±1o±1r±1t±1o±1r±1 ±1g±1r±1a±1v±1i±1d±1a±1,±1 ±1a±1t±1 ±1l±1a±1o±1r±1e±2t±1 ±1m±1i±1 ±1u±1l±1t±1r±1i±1c±1i±1e±1s±1.±1 ±1S±1e±1d±1 ±1n±1o±1n±1 ±1n±1i±1s±1i±1 ±1e±1u±1 ±1e±1x±1 ±1t±1i±1n±1c±1i±1d±1u±1n±1t±1 ±1u±1l±2a±1m±1c±1o±1r±1p±1e±1r±1 ±1a±1 ±1v±1e±1l±1 ±1q±1u±1a±1m±1.±1 ±1I±1n±1 ±1v±1e±1l±1 ±1n±1i±1b±1h±1 ±1i±1d±1 ±1q±1u±1a±1m±1 ±1d±1a±1p±1i±1b±1u±1s±1 ±1v±1e±1n±1e±1n±1a±1t±1i±1s±1.±1 ±1N±1u±1l±2a±1 ±1f±1a±1c±1i±1l±1i±1s±1i±1.±1 ±1S±1e±1d±1 ±1b±1i±1b±1e±1n±1d±1u±1m±1 ±1e±1x±1 ±1v±1e±1l±1 ±1e±1s±1t±1 ±1b±1l±1a±1n±1d±1i±1t±1,±1 ±1i±1n±1 ±1t±1e±1m±1p±1u±1s±1 ±1m±1e±1t±1u±1s±1 ±1s±1u±1s±1c±1i±1p±1i±1t±1.±1", compressText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer id sapien ut justo venenatis ullamcorper. Curabitur laoreet, neque ac feugiat commodo, odio ligula tempus nisi, vel gravida eros augue vel justo. Sed efficitur eros euismod, eu ullamcorper nulla tincidunt. Aenean et ipsum ut ligula varius facilisis. Quisque efficitur felis eu tortor gravida, at laoreet mi ultricies. Sed non nisi eu ex tincidunt ullamcorper a vel quam. In vel nibh id quam dapibus venenatis. Nulla facilisi. Sed bibendum ex vel est blandit, in tempus metus suscipit."))
        assertEquals("a±5", compressText("aaaaa"))
        assertEquals(" ±1", compressText(" "))
        assertEquals(" ±5", compressText("     "))
        assertEquals("~±1!±1@±1#±1%±1^±1&±1*±1(±1)±1-±1_±1=±1+±1`±1{±1}±4[±1]±1|±1:±1;±1'±1<±1>±1,±1.±1?±1/±1a±4b±2c±1d±1e±3f±1g±1h±1i±1j±1k±1l±1m±1n±1o±1p±1q±1r±1s±1t±1u±1v±1w±1x±1y±1z±1A±1B±1C±1D±1E±1F±1G±1H±1I±1J±1K±1L±1M±1N±1O±1P±1Q±1R±1S±1T±1U±1V±1W±1X±1Y±1Z±1", compressText("~!@#%^&*()-_=+`{}}}}[]|:;'<>,.?/aaaabbcdeeefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"))
        assertEquals("", compressText(""))
        assertEquals("a±1b±1c±1", compressText("abc"))
        assertEquals("a±5b±4", compressText("aaaaabbbb"))
        assertEquals("a±5 ±2", compressText("aaaaa  "))
        assertEquals("a±5 ±2b±1", compressText("aaaaa  b"))
    }

    @Test
    fun testDecompressText() {
        assertEquals("The quick brown fox jumps over the lazy dog. Pack my box with five dozen liquor jugs. How razorback-jumping frogs can level six piqued gymnasts! The five boxing wizards jump quickly. Mr Jock, TV quiz PhD, bags few lynx.", decompressText("T±1h±1e±1 ±1q±1u±1i±1c±1k±1 ±1b±1r±1o±1w±1n±1 ±1f±1o±1x±1 ±1j±1u±1m±1p±1s±1 ±1o±1v±1e±1r±1 ±1t±1h±1e±1 ±1l±1a±1z±1y±1 ±1d±1o±1g±1.±1 ±1P±1a±1c±1k±1 ±1m±1y±1 ±1b±1o±1x±1 ±1w±1i±1t±1h±1 ±1f±1i±1v±1e±1 ±1d±1o±1z±1e±1n±1 ±1l±1i±1q±1u±1o±1r±1 ±1j±1u±1g±1s±1.±1 ±1H±1o±1w±1 ±1r±1a±1z±1o±1r±1b±1a±1c±1k±1-±1j±1u±1m±1p±1i±1n±1g±1 ±1f±1r±1o±1g±1s±1 ±1c±1a±1n±1 ±1l±1e±1v±1e±1l±1 ±1s±1i±1x±1 ±1p±1i±1q±1u±1e±1d±1 ±1g±1y±1m±1n±1a±1s±1t±1s±1!±1 ±1T±1h±1e±1 ±1f±1i±1v±1e±1 ±1b±1o±1x±1i±1n±1g±1 ±1w±1i±1z±1a±1r±1d±1s±1 ±1j±1u±1m±1p±1 ±1q±1u±1i±1c±1k±1l±1y±1.±1 ±1M±1r±1 ±1J±1o±1c±1k±1,±1 ±1T±1V±1 ±1q±1u±1i±1z±1 ±1P±1h±1D±1,±1 ±1b±1a±1g±1s±1 ±1f±1e±1w±1 ±1l±1y±1n±1x±1.±1"))
        assertEquals("xyz", decompressText("x±1y±1z±1"))
        assertEquals("a", decompressText("a±1"))
        assertEquals("aaaaa", decompressText("a±5"))
        assertEquals(" ", decompressText(" ±1"))
        assertEquals("     ", decompressText(" ±4 +1"))
        assertEquals("..", decompressText(".±1.±1"))
        assertEquals("", decompressText(""))
        assertEquals("xKkkjRddhHTtJOOQWCCwwXcFZzzLllyYQqtTOXvVPpMmWdDfhH", decompressText("x±1K±1k±2j±1R±1d±2h±1H±1T±1t±1J±1O±2Q±1W±1C±2w±2X±1c±1F±1Z±1z±2L±1l±2y±1Y±1Q±1q±1t±1T±1O±1X±1v±1V±1P±1p±1M±1m±1W±1d±1D±1f±1h±1H±1"))
        assertEquals("aaaaabbbb", decompressText("a±5b±4"))
        assertEquals("aaaaa  ", decompressText("a±5 ±2"))
        assertEquals("aaaaa  b", decompressText("a±5 ±2b±1"))
    }
}
