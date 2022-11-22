package lab.reddist.lab2springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @XmlElement
    @NotNull
    @Column(name = "x")
    private Long x; //Поле не может быть null

    @XmlElement
    @NotNull
    @Column(name = "y")
    private Integer y; //Поле не может быть null

    @XmlElement
    @NotNull
    @Column(name = "z")
    private Integer Z; //Поле не может быть null
}
