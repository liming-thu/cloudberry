package edu.uci.ics.cloudberry.noah

import java.io.File
import java.util.Date
import edu.uci.ics.cloudberry.gnosis._
import org.scalatest.{FlatSpec, Matchers}
import edu.uci.ics.cloudberry.util.Profile._

class TwitterJSONTagToADMTest extends FlatSpec with Matchers {
  "USGeoGnosis" should "tag the us json file" in {
    val shapeMap = Map.apply(StateLevel -> new File("/root/cloudberry/examples/twittermap/web/public/data/state.json"),
      CountyLevel -> new File("/root/cloudberry/examples/twittermap/web/public/data/county.json"),
      CityLevel -> new File("/root/cloudberry/examples/twittermap/web/public/data/city.json"))
    val usGeoGnosis = profile("load shapes")(new USGeoGnosis(shapeMap))
    for (ln <- scala.io.Source.fromURL(getClass.getResource("/sample.json")).getLines()) {
      println(ln)
      println(TwitterJSONTagToADM.tagOneTweet(ln, usGeoGnosis))
    }
  }
}
