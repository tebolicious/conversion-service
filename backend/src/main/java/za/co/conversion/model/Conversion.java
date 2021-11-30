package za.co.conversion.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created By Zhu Lin on 3/12/2018.
 */
@Entity
@Data
@Table(name = "conversions")
@NoArgsConstructor
public class Conversion implements Serializable {

    private static final long serialVersionUID = 4887904943282174032L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String category;

    private String unitFrom;


    private String unitTo;

    private Double valueFrom;

    private Double valueTo;






}

