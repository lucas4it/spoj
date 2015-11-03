package com.lucas4it.spoj

import scala.collection.mutable.ListBuffer
import scala.util.Try

/**
 * PRIME1 - Prime Generator
 *
 * #number-theory #sieve-of-eratosthenes
 */
object Spoj002 {

  def tryToInt (s: String) = Try(s.toInt).toOption

  def isPrime(number: Int): Boolean = {
    if (number < 2) return false

    if (number == 2) return true

    for (i <- 3 until number) {
      if (number % i == 0) {
        return false
      }
    }
    return true
  }

  def calculatePrimeNumbers(t: Testcase): List[Int] = {
    val primes = new ListBuffer[Int]
    for (number <- t.minimum to t.maximum)
      if (isPrime(number)) primes += number

    return primes.toList
  }

  class Testcase (min: Int, max: Int) {
    val minimum: Int = min
    val maximum: Int = max
  }

  def main(args: Array[String]) {
    val numberOfTestCases = io.Source.stdin.getLines.next()
    val results = new ListBuffer[List[Int]]

    for (testcase <- 1 to tryToInt(numberOfTestCases).get) {
      val testcaseRange = io.Source.stdin.getLines.next()
      val testCase = new Testcase(tryToInt(testcaseRange.split(" ")(0)).getOrElse(0), tryToInt(testcaseRange.split(" ")(1)).getOrElse(0))

      results += calculatePrimeNumbers(testCase)
    }

    results.foreach(result => {
      result.foreach(number => println(number))
      println()
    })
  }
}
