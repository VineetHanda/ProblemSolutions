package orange

object test1  extends App {

  case class Person(name:String, age: Int)
  val v1 = new Person("1",20)
  val v2 = new Person("1",20)
  print(v1==v2)
}
