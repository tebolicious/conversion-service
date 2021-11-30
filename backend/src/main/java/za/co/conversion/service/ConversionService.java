package za.co.conversion.service;

import za.co.conversion.model.Conversion;
import za.co.conversion.model.ConversionRequest;

import java.util.List;

public interface ConversionService {

    List<Conversion> getConversions();
    Conversion createConversion(Conversion conversion);

    Double convert(ConversionRequest conversionRequest);
}
