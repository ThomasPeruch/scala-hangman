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
def mainGame() = {
  setupGame()
}

def setupGame() = {
  val wordIndex = Random.nextInt(words.size)
  word = words(wordIndex).toUpperCase()
  println(word)
}


