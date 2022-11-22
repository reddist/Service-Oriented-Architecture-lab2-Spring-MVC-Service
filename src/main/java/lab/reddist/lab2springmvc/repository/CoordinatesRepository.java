package lab.reddist.lab2springmvc.repository;

import lab.reddist.lab2springmvc.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}