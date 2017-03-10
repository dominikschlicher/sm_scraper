package twitter

import twitter4j.{Twitter, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

import scala.io.Source.fromFile

/**
  * A base class to handle Twitter setup needs.
  */
class TwitterAuth {

  // twitter
  var consumerKey = ""
  var consumerSecret = ""
  var accessToken = ""
  var accessTokenSecret = ""

  def getTwitterInstance: Twitter = {
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret)
    return new TwitterFactory(cb.build()).getInstance
  }

  def populatePropertiesFromConfigFile(propertiesFilename: String) {
    val properties = parseProperties("twitter.properties");
    consumerKey = properties.get("oauth.consumerKey").get
    consumerSecret = properties.get("oauth.consumerSecret").get
    accessToken = properties.get("oauth.accessToken").get
    accessTokenSecret = properties.get("oauth.accessTokenSecret").get
  }

  def parseProperties(filename: String): Map[String, String] = {
    val lines = fromFile(filename).getLines.toSeq
    val cleanLines = lines.map(_.trim).filter(!_.startsWith("#")).filter(_.contains("="))
    cleanLines.map(line => {
      val Array(a, b) = line.split("=", 2); (a.trim, b.trim)
    }).toMap
  }

}