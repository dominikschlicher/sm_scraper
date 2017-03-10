package twitter

import akka.actor.ActorSystem

object TwitterPullAkka extends TwitterAuth {

  def run() {
    populatePropertiesFromConfigFile("twitter.properties")
    val twitterIns = getTwitterInstance

    implicit val system = ActorSystem("TwitterFutureSystem")

  }

}

//Twitter feeds registrieren
// Akka ein Actor pro Feed --> Pro Eintrag im Feed ein Aktor
//Kafka-Connector