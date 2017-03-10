import twitter.TwitterPullAkka

object SM_Runner {
  def main(args: Array[String]): Unit = {
    TwitterPullAkka.run()
  }
}
