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
public class YearWiseBreakdownImpl implements BreakDownService {

    @Autowired
    private DtoToJsonConvertor dtoToJsonConvertor;

    @Override
    public Result execute(Wine wine) {

        Map<String, Double> yearWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr =  wine.getComponents().iterator();
        while (itr.hasNext()){
            GrapeComponent component = itr.next();
            if(!yearWisePercentage.containsKey(component.getYear())) {
                yearWisePercentage.put(component.getYear(), component.getPercentage());
            }
            else{
                    yearWisePercentage.put(component.getYear(),yearWisePercentage.get(component.getYear()) + component.getPercentage());
            }
        }
        Comparator<String> comparator = new ValueComparator<>(yearWisePercentage);
        TreeMap<String, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(yearWisePercentage);
        return dtoToJsonConvertor.convertBreakDownToJson(yearWisePercentage,"Year","Percentage");
    }
}
