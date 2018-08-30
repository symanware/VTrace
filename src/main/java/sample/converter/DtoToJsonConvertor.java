package sample.converter;

import org.springframework.stereotype.Component;
import sample.dto.Property;
import sample.dto.Result;
import sample.model.GrapeComponentYearVariety;

import java.util.List;
import java.util.Map;

@Component
public class DtoToJsonConvertor {

    public <K, V> Result convertBreakDownToJson(Map<K, V> breakDownMap,String propertyName1, String propertyName2){
        Result result = new Result();
        for(Map.Entry<K,V> entry : breakDownMap.entrySet()){

            List<Property> row = result.createRow();
            Property property = new Property(propertyName1, entry.getKey().toString());
            row.add(property);
            property = new Property(propertyName2,entry.getValue().toString());
            row.add(property);
        }
        return result;
    }

    public Result convertBreakDownYearVarietyToJson(Map<GrapeComponentYearVariety, Double> yearVarietyBreakDown, String propertyName1, String propertyName2, String propertyName3){

        Result result = new Result();
        for (Map.Entry<GrapeComponentYearVariety, Double> entry : yearVarietyBreakDown.entrySet()) {
            List<Property> row = result.createRow();
            Property property = new Property(propertyName1, entry.getKey().getYear());
            row.add(property);
            property = new Property(propertyName2, entry.getKey().getVariety());
            row.add(property);
            property = new Property(propertyName3, entry.getValue().toString());
            row.add(property);
        }
        return result;
    }
}
