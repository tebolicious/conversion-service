package za.co.conversion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {

    @NotNull(message = "sourceUnit cannot be null")
    private String sourceUnit;

    @NotNull(message = "destinationUnit cannot be null")
    private String destinationUnit;

    @NotNull(message = "category cannot be null")
    private String category;

    @NotNull(message = "amount cannot be null")
    private Double amount;
}
