import kotlin.math.abs
import kotlin.math.ceil

fun main(){
	val ls = ArrayList<String>()
	var line: String? = ""
	while(line != null){
		line = readLine()
		line?.let { ls.add(it) }
	}
	var output = 0.0
	for(x in 0 until ls.size){
		if(!isNum(ls[x])) {
			var sum = 0
			ls.filterIndexed { index, i -> abs(index - x) <= 2 && index != x && isNum(i) }
				.forEach { sum += it.toInt() }
			output += ceil(((sum / 4).toDouble()))
		}else{
			output += ls[x].toDouble()
		}
	}
	println(ceil((output/ls.size)))
}

fun isNum(i: String): Boolean{
	return (i.toDoubleOrNull()?.let { true } ?: false)
}