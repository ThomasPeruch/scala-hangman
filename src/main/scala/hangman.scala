import scala.collection.mutable.ArrayBuffer
import scala.util.Random

val words = List("elbow", "writer", "circle", "polish", "bridge", "store", "summer","football","eagle","wolf","hospital",
  "fang", "scarecrow", "show", "jeans", "wilderness", "attempt", "waxing", "winter","knee","cross","uppercut","step","kick",
  "aftermath", "banana", "wrist", "wheel", "spring", "cherries", "nerve", "guitar","microphone", "history", "electronic")
var word = ""
val guesses = ArrayBuffer[Char]()
var remainingGuesses = 6
var mistakes = 0

@main
def mainGame(): Unit =
  setupGame()

def setupGame(): Unit =
  val wordIndex = Random.nextInt(words.size)
  word = words(wordIndex).toUpperCase()
  println(word)
  printGameStatus()


def printGameStatus(): Unit =
  mistakes match {
    case 0 => print0Mistakes()
    case 1 => print1Mistake()
    case 2 => print2Mistakes()
    case 3 => print3Mistakes()
    case 4 => print4Mistakes()
    case 5 => print5Mistakes()
    case 6 => print6Mistakes()
  }

