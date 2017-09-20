package beeline.co.gpx

import beeline.co.gpx.xml.XmlWritable
import beeline.co.gpx.xml.XmlWrite
import rx.Observable

data class RoutePoint(
        val lat: Double,
        val lon: Double,
        val time: Long? = null,
        val ele: Double? = null,
        val name: String? = null
) : XmlWritable {

    override val writeOperations: Observable<XmlWrite>
        get() = newTag("rtept",
                withAttribute("lat", lat.toString()),
                withAttribute("lon", lon.toString()),
                optionalTagWithText("ele", ele?.toString()),
                if (time != null) Time(time).writeOperations else Observable.empty(),
                optionalTagWithText("name", name)
        )

}