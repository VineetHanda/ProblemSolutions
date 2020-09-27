package orange

object test3 extends App {

  class User(n:String){
    val name:String=n
  }
  var u=new User(n="Frankl")
  println(u.name)

}
