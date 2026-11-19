import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random

val words = List("elbow", "writer", "circle", "polish", "bridge", "store", "summer","football","eagle","wolf","hospital",
  "fang", "scarecrow", "show", "jeans", "wilderness", "attempt", "waxing", "winter","knee","cross","uppercut","step","kick",
  "aftermath", "banana", "wrist", "wheel", "spring", "cherries", "nerve", "guitar","microphone", "history", "electronic")
var word = ""
val guesses = ArrayBuffer[Char]()
var remainingGuesses = 6
var mistakes = 0
var gameOver = false

@main
def mainGame(): Unit =
  setupGame()

def setupGame(): Unit =
  val wordIndex = Random.nextInt(words.size)
  word = words(wordIndex).toUpperCase()
  println(word)

  for (i <- word.indices)
    guesses.addOne('_')

  while(!gameOver) {
    printGameStatus()
    println("Enter a letter:")
    var input = StdIn.readChar().toUpper
    if(word.contains(input)){
      for (i <- word.indices){
        if(word.charAt(i) == input)
          guesses.update(i, input)
      }
      if (!guesses.contains('_')){
        gameOver = true
      }
    }else{
      println("That's not part of the word")
      remainingGuesses = remainingGuesses-1
      mistakes = mistakes + 1
      println("\n\n")
      if ( mistakes >= 6 )
        gameOver = true
    }

  }
  if (mistakes == 6) {
    println(s"You lost, the word was: $word")
  }else{
    println(s"Congratulations, you won. The word was: $word")
  }




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
  print("WORD: ")
  for (letter <- guesses){
    print(s"$letter ")
  }

  println(s"\nYou have $remainingGuesses guess(es) left")


