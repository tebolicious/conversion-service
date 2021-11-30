package za.co.conversion.service.impl;

import za.co.conversion.model.Conversion;
import za.co.conversion.model.ConversionRequest;
import za.co.conversion.repository.ConversionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ConversionServiceImplTest {

    @InjectMocks
    private ConversionServiceImpl conversionService;

    @Mock
    private ConversionRepository conversionRepository;



    private Conversion conversion;

    @Before
    public void setUp() {
        conversion = new Conversion();
        conversion.setCategory("LENGTH");
        conversion.setUnitFrom("Meters");
        conversion.setUnitTo("Kilometers");
        conversion.setValueFrom(0.001);
        conversion.setValueTo(1000.0);
    }

    @Test
    public void createConversionTest() {
        when(conversionRepository.save(conversion)).thenReturn(conversion);

        conversionService.createConversion(conversion);

        Mockito.verify(conversionRepository, Mockito.times(1)).save(conversion);
    }



    @Test
    public void convertorTest() {

        createConversionTest();

        ConversionRequest conversionRequest = new ConversionRequest();
        conversionRequest.setAmount(100.0);
        conversionRequest.setCategory("LENGTH");
        conversionRequest.setSourceUnit("Meters");
        conversionRequest.setDestinationUnit("Kilometers");

        conversion.setValueTo(0.001);

        when(conversionRepository.findConversionByUnitFromAndUnitToAndAndCategory(any(),any(),any())).thenReturn(conversion);
        Double results = conversionService.convert(conversionRequest);
        assertEquals(0.1, results);



    }
}
