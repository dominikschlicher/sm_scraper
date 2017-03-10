package twitterTest

import org.joda.time.DateTime

case class TwitterPollDataSequence(timeStart: DateTime, timeEnd: DateTime, twitterName: String) {
  require(twitterName != null || twitterName.nonEmpty, "Twitter account should be not empty.")
  require(timeStart.isBefore(timeEnd), "Start time should be before end time.")
  require(timeStart.isAfterNow, "Start time should be before now.")
  require(timeEnd.isAfterNow, "Start time should be before now.")
}
