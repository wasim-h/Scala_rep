import scala.util.Random

var user_score = 0
var com_score = 0
var total: Option[Int] = None

@main
def main(): Unit = {
  println("1. Head\n2. Tail\nEnter your choice : ")
  val ch = scala.io.StdIn.readInt()
  val toss = Random.between(1, 3)  
  println(s"Toss result: $toss")

  if (ch == toss) {
    println("You won the toss!\n1. Batting\n2. Bowling\nEnter your choice : ")
    val choice = scala.io.StdIn.readInt()
    if (choice == 1) {
      bat()
      total = Some(user_score)
      ball()
    } else if (choice == 2) {
      ball()
      total = Some(com_score)
      bat()
    } else {
      println("Invalid choice!")
    }
  } else {
    println("Computer won the toss and chose to bat first!")
    ball()
    total = Some(com_score)
    bat()
  }

  println(s"Final Score - You: $user_score, Computer: $com_score")
  if (user_score > com_score) println("You win!")
  else if (com_score > user_score) println("Computer wins!")
  else println("It's a tie!")
}

def bat(): Unit = {
  println("You are batting. Enter 1-6. OUT if you match the computer!")
  while (true) {
    print("Enter your choice: ")
    val score = scala.io.StdIn.readInt()
    val ba = Random.between(1,7)

    if (score >= 1 && score <= 6) {
      if (score == ba) {
        println("OUT!")
        println(f"Your final score: $user_score")
        return
      } else {
        user_score += score
        println(f"Your current score: $user_score")
        if (total.isDefined && user_score > com_score) {
          println("You win early!")
          return
        }
      }
    } else {
      println("The range is from 1 to 6.")
    }
  }
}

def ball(): Unit = {
  println("You are bowling. Enter 1-6. OUT if you match the computer!")
  while (true) {
    print("Enter your choice: ")
    val ball_sc = scala.io.StdIn.readInt()
    val bat_sc = Random.between(1, 7)

    if (ball_sc >= 1 && ball_sc <= 6) {
      if (ball_sc == bat_sc) {
        println("Computer is OUT!")
        println(f"Computer's final score: $com_score")
        return
      } else {
        com_score += bat_sc
        println(f"Computer's current score: $com_score")
        if (total.isDefined && com_score > user_score) {
          println("Computer wins early!")
          return
        }
      }
    } else {
      println("The range is from 1 to 6.")
    }
  }
}
