package lab.reddist.lab2springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @XmlElement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @XmlElement
    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @XmlElement(type = Coordinates.class)
    @NotNull
    @OneToOne
    @JoinColumn(name = "coordinates_id", nullable = false)
    private Coordinates coordinates; //Поле не может быть null

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @NotNull
    @Column(name = "creationDate")
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @XmlElement
    @Positive
    @Column(name = "height")
    private Double height; //Поле может быть null, Значение поля должно быть больше 0

    @XmlElement
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 34)
    @Column(name = "passport_id")
    private String passportID; //Строка не может быть пустой, Длина строки должна быть не меньше 10, Длина строки не должна быть больше 34, Поле не может быть null

    @XmlElement(type = Color.class)
    @Column(name = "eye_color")
    private Color eyeColor; //Поле может быть null

    @XmlElement(type = Country.class)
    @Column(name = "nationality")
    private Country nationality; //Поле может быть null

    @XmlElement(type = Location.class)
    @NotNull
    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; //Поле не может быть null
}
