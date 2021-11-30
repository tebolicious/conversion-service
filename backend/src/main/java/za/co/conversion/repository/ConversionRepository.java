package za.co.conversion.repository;


import za.co.conversion.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Zhu Lin on 3/13/2018.
 */

public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    Conversion findConversionByUnitFromAndUnitToAndAndCategory(String unitFrom, String unitTo, String category);
}
