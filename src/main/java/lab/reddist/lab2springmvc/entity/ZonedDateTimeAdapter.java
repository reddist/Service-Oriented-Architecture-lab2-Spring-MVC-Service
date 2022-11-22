package lab.reddist.lab2springmvc.entity;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime>{
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

    public ZonedDateTime unmarshal(String v) throws Exception {
        LocalDateTime ldt = LocalDateTime.parse(v, formatter);
        return ZonedDateTime.of(ldt, ZoneId.systemDefault());
    }

    public String marshal(ZonedDateTime v) throws Exception {
        return v.toString();
    }
}
