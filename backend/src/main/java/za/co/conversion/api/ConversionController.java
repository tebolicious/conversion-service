package za.co.conversion.api;

import za.co.conversion.model.Conversion;
import za.co.conversion.model.ConversionRequest;
import za.co.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @PostMapping
    public Double convert(@RequestBody ConversionRequest conversionRequest) {
        System.out.println("Its coming here");
        return conversionService.convert(conversionRequest);
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Conversion add(@RequestBody Conversion conversion) {
        return conversionService.createConversion(conversion);
    }

    @GetMapping
    @ResponseBody
    public List<Conversion> list() {

        return conversionService.getConversions();
    }
}
