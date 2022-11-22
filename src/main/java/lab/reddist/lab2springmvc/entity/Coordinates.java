package lab.reddist.lab2springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coordinates")
public class Coordinates {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinates_id")
    private Long coordinatesId;

    @XmlElement
    @NotNull
    @Max(value = 273)
    @Column(name = "x")
    private Long x; //Максимальное значение поля: 273, Поле не может быть null

    @XmlElement
    @NotNull
    @Max(value = 343)
    @Column(name = "y")
    private Long y; //Максимальное значение поля: 343, Поле не может быть null
}
