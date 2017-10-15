logLevel := Level.Warn

resolvers += Resolver.bintrayIvyRepo("jw3", "sbt-plugin-releases")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC11")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.8.5")
addSbtPlugin("com.github.jw3" % "sbt-openshift" % "0.1")
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "3.0.2")
addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.2.0")
