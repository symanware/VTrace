package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.converter.DtoToJsonConvertor;
import sample.dto.Result;
import sample.helper.ValueComparator;
import sample.model.GrapeComponent;
import sample.model.Wine;

import java.util.*;

@Service
public class VarietyWiseBreakDownImpl implements BreakDownService {

    @Autowired
    DtoToJsonConvertor dtoToJsonConverter;
    public Result execute(Wine wine) {

        Map<String, Double> varietyWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = wine.getComponents().iterator();
        while(itr.hasNext()){
            GrapeComponent component = itr.next();
            if(!varietyWisePercentage.containsKey(component.getVariety())){
                varietyWisePercentage.put(component.getVariety(), component.getPercentage());
            }
            else{
                varietyWisePercentage.put(component.getVariety(), varietyWisePercentage.get(component.getVariety()) + component.getPercentage());
            }
        }
        ValueComparator<String, Double> comparator = new ValueComparator<>(varietyWisePercentage);
        TreeMap<String, Double> sortedmap = new TreeMap<>(comparator);
        sortedmap.putAll(varietyWisePercentage);
        return dtoToJsonConverter.convertBreakDownToJson(sortedmap, "Variety", "Percentage");
    }
}
