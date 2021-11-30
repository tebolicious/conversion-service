package za.co.conversion.service.impl;

import za.co.conversion.exception.ConversionException;
import za.co.conversion.model.Conversion;
import za.co.conversion.model.ConversionRequest;
import za.co.conversion.repository.ConversionRepository;
import za.co.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    ConversionRepository conversionRepository;


    @Override
    public List<Conversion> getConversions() {
        return conversionRepository.findAll();
    }

    @Override
    public Conversion createConversion(Conversion conversion) {
        try {
            return conversionRepository.save(conversion);
        } catch (Exception e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public Double convert(ConversionRequest conversionRequest) {
        Conversion conversion = conversionRepository.findConversionByUnitFromAndUnitToAndAndCategory(conversionRequest.getSourceUnit(),conversionRequest.getDestinationUnit(),conversionRequest.getCategory());
        if(!"TEMPERATURE".equals(conversion.getCategory()))
        return conversion.getValueTo() * conversionRequest.getAmount();
        return conversionRequest.getAmount() + conversion.getValueTo();
    }
}
