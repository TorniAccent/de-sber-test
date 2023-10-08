package task2

object PositiveNegativeCount extends App {

  def count(list: List[Int]): Int = {

    val rawAnswer = list.foldLeft(0) { (acc, element) =>
      // sgnElement є {
      //    -1 if e < 0,
      //    0 if e == 0,
      //    1 if e > 0
      // }
      val sgnElement = Integer.signum(element)
      if (sgnElement * acc <= 0 && acc != 0) acc
      else -sgnElement * (Math.abs(acc) + 1)
    }

    if (rawAnswer == 0) 0
    else Math.abs(rawAnswer) - 1
  }

}


