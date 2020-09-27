package orange

object fiboTest extends App {
  def fibonacci(n: Int): Int = {
    if(n <= 2) 1
    else
      fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(4))

}
