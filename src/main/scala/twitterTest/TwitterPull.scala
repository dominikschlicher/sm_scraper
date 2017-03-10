package twitterTest

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer
import org.apache.commons.io.IOUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

object TwitterPull {

  val AccessToken = "809739429849997312-qrTDQIpwIVeItKBHL4jGwUpCdyl1yQS"
  val AccessSecret = "2jMDFZIiMSlS5hovuGnNl4Qr0tYlx72b1gHG6QauS0dBH"
  val ConsumerKey = "uretuSqWFykkmLNd88gJwVoNe"
  val ConsumerSecret = "qalPsEmg95LeMxqQPjQRPKIRuCtZDO2yKCbG4JjX4EFDBsIrNU"

  def main(args: Array[String]) {

    val consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret)
    consumer.setTokenWithSecret(AccessToken, AccessSecret)

  //  val request = new HttpGet("https://stream.twitter.com/1.1/statuses/sample.json") // Followers
    val request = new HttpGet("https://sitestream.twitter.com/1.1/site.json?follow=6253282") // Followers

//    val request = new HttpGet("https://api.twitter.com/1.1/followers/ids.json?cursor=-1&screen_name=josdirksen") // Followers
    // from jodsdirksen
    consumer.sign(request)
    val client = new DefaultHttpClient()
    val response = client.execute(request)

    println(response.getStatusLine.getStatusCode)
    println(IOUtils.toString(response.getEntity.getContent))
  }
}

//1 Server opens streaming Connection
// - Authentication via OAuth
//2 Receive streamed Tweets
//3 Close connection

// --> Public Streams
