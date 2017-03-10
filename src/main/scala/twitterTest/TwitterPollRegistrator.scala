package twitterTest

import org.joda.time.DateTime

import scala.collection.mutable.ListBuffer


class TwitterPollRegistrator {

  var list = new ListBuffer[TwitterPollDataSequence]()

  def registerTwitterAccount(timeStart: DateTime, timeEnd: DateTime, twitterName: String): Unit ={
    list += TwitterPollDataSequence(timeStart,timeEnd,twitterName)
  }

}
