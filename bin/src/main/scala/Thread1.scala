object ThreadsMain extends App {
 val t: Thread = Thread.currentThread
  val name = t.getName
  println(s"I am the thread $name")
}

//sbt is the program that run your project
//sbt is the main thread
// in order to made your project as main thread
//what does the fork do? made the thread1 as the main thread