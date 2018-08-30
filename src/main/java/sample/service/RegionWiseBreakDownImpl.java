package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.converter.DtoToJsonConvertor;
import sample.dto.Result;
import sample.helper.ValueComparator;
import sample.model.GrapeComponent;
import sample.model.Wine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RegionWiseBreakDownImpl implements BreakDownService {

    @Autowired
    DtoToJsonConvertor dtoToJsonConverter;

    @Override
    public Result execute(Wine wine) {
        Map<String, Double> regionWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = wine.getComponents().iterator();
        while(itr.hasNext()){
            GrapeComponent component = itr.next();
            if(!regionWisePercentage.containsKey(component.getVariety())){
                regionWisePercentage.put(component.getVariety(), component.getPercentage());
            }
            else{
                regionWisePercentage.put(component.getVariety(), regionWisePercentage.get(component.getVariety()) + component.getPercentage());
            }
        }
        ValueComparator<String, Double> comparator = new ValueComparator<>(regionWisePercentage);
        TreeMap<String, Double> sortedmap = new TreeMap<>(comparator);
        sortedmap.putAll(regionWisePercentage);
        return dtoToJsonConverter.convertBreakDownToJson(sortedmap, "Region", "Percentage");

    }
}
