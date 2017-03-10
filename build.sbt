name := "SM_Scraper"

scalaVersion   := "2.11.8"
scalacOptions ++= Vector(
  "-unchecked",
  "-deprecation",
  "-target:jvm-1.8"
)

libraryDependencies ++= Vector(
  "org.apache.logging.log4j"  %  "log4j-api"                         % "2.6",
  "org.apache.logging.log4j"  %  "log4j-core"                        % "2.6",

  "oauth.signpost"            %  "signpost-core"                     % "1.2",
  "oauth.signpost"            %  "signpost-commonshttp4"             % "1.2",

  "org.apache.httpcomponents" % "httpclient"                         % "4.2",
  "org.apache.commons"        % "commons-io"                         % "1.3.2",
  "org.apache.httpcomponents" % "httpcore"                           % "4.4.4",

  "org.scalatest"             %% "scalatest"                         % "2.2.5" % Test,
  "org.scalacheck"            %% "scalacheck"                        % "1.12.2" % Test,

  "joda-time"                 % "joda-time"                          % "2.9.7",
  "org.twitter4j"             % "twitter4j-stream"                   % "4.0.4",

  "com.typesafe.akka"         % "akka-actor_2.11"                    % "2.4.17"
)


import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)



