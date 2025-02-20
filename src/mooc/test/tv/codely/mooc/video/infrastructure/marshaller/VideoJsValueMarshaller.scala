package tv.codely.mooc.video.infrastructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import tv.codely.mooc.video.domain.Video

object VideoJsValueMarshaller {
  def marshall(v: Video): JsObject = JsObject(
      "id"                  -> JsString(v.id.value.toString),
      "title"               -> JsString(v.title.value),
      "duration_in_seconds" -> JsNumber(v.duration.value.toSeconds),
      "category"            -> JsString(v.category.toString),
      "creator_id"          -> JsString(v.creatorId.value.toString)
  )
  def marshall(videos: Seq[Video]): JsArray = JsArray(
    videos.map(v => marshall(v)).toVector
  )
}
