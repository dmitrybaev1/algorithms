package org.example

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    collarsAndDogs()
}

fun collarsAndDogs(){ //ошейники и песики
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt() // dogs and collars count
    val neckRadiusArr = reader.readLine().split(" ")
    val collarRadiusArr = reader.readLine().split(" ")
    var smallestDissSum = Int.MAX_VALUE
    var houseNumber = 0
    for(i in 0..<n){
        var startIndex = i
        var dissSum = 0
        for(j in i..i+(n-1)){
            val diff = if(j < n) collarRadiusArr[j-i].toInt() - neckRadiusArr[j].toInt()
                else collarRadiusArr[j-i].toInt() - neckRadiusArr[j-n].toInt()
            if(diff in 1..100)
                dissSum += diff/2
            else if(diff > 100)
                dissSum += 30
        }
        if(dissSum < smallestDissSum) {
            smallestDissSum = dissSum
            houseNumber = startIndex + 1
        }
    }
    writer.write("$houseNumber $smallestDissSum")
    reader.close()
    writer.close()
}

fun hardestLetter(){ // самая сложная буква
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val s = reader.readLine()
    val arr = reader.readLine().split(" ")
    var longestInterval = 0
    var indexOfLongestInterval = 0
    for(i in n-1 downTo 1){
        val interval = arr[i].toInt() - arr[i-1].toInt()
        if(interval > longestInterval){
            longestInterval = interval
            indexOfLongestInterval = i
        }

    }
    val first = arr[0].toInt()
    if(first>longestInterval) {
        longestInterval = first
        indexOfLongestInterval = 0
    }

    writer.write(s[indexOfLongestInterval].toString())

    writer.close()
    reader.close()
}