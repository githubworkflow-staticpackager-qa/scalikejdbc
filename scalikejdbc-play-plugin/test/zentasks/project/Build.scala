import sbt._
import Keys._

import play.Project._

object ApplicationBuild extends Build {

    val appName         = "zentask"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "org.scala-lang"     %  "scala-library"             % "2.10.0",
      "com.h2database"     %  "h2"                        % "[1.3,)",
      "postgresql"         %  "postgresql"                % "9.1-901.jdbc4",
      "com.github.seratch" %% "scalikejdbc"               % "1.5.0",
      "com.github.seratch" %% "scalikejdbc-interpolation" % "1.5.0",
      "com.github.seratch" %% "scalikejdbc-play-plugin"   % "1.5.0"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers ++= Seq(
        "Sonatype OSS Releases"  at "http://oss.sonatype.org/content/repositories/releases",
        "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
      ),
      externalResolvers ~= (_.filter(_.name != "Scala-Tools Maven2 Repository"))
    )

}
            
