package twitterTest

import twitter4j.{Paging, TwitterFactory}


object AuthenficationData {
  val AccessToken = "809739429849997312-qrTDQIpwIVeItKBHL4jGwUpCdyl1yQS"
  val AccessSecret = "2jMDFZIiMSlS5hovuGnNl4Qr0tYlx72b1gHG6QauS0dBH"
  val ConsumerKey = "uretuSqWFykkmLNd88gJwVoNe"
  val ConsumerSecret = "qalPsEmg95LeMxqQPjQRPKIRuCtZDO2yKCbG4JjX4EFDBsIrNU"
}

object Authenficator {
  def main(args: Array[String]) {
    val config = new twitter4j.conf.ConfigurationBuilder()
      .setDebugEnabled(true)
      .setOAuthConsumerKey(AuthenficationData.ConsumerKey)
      .setOAuthConsumerSecret(AuthenficationData.ConsumerSecret)
      .setOAuthAccessToken(AuthenficationData.AccessToken)
      .setOAuthAccessTokenSecret(AuthenficationData.AccessSecret)

    val twitter = new TwitterFactory(config.build()).getInstance()

    var paging = new Paging(1, 100);


    val statuses = twitter.getUserTimeline("HashtagMarkus", paging)
    //System.out.println(statuses)
    val it = statuses.iterator()
    while (it.hasNext()) {
      val status = it.next()
      println(status.getUser().getName() + ":" +
        status.getText());
    }
  }
}

//http://bcomposes.com/2013/02/09/using-twitter4j-with-scala-to-access-streaming-tweets/