package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.converter.DtoToJsonConvertor;
import sample.dto.Result;
import sample.helper.ValueComparator;
import sample.model.GrapeComponent;
import sample.model.GrapeComponentYearVariety;
import sample.model.Wine;

import java.util.*;

@Service
public class YearVarietyWiseBreakDownImpl implements BreakDownService {

    @Autowired
    DtoToJsonConvertor dtoToJsonConvertor;

    @Override
    public Result execute(Wine wine) {
        Map<GrapeComponentYearVariety, Double> yearAndVarietyWisePercentage = new HashMap<>();
        yearAndVarietyWisePercentage = buildyearVarietyPcntgeMap(yearAndVarietyWisePercentage, wine);
        //Sort the result map in the descending order of percentage
        TreeMap<GrapeComponentYearVariety, Double> sortedyearAndVarietyWisePercentage = sortyearAndVarietyWisePercentageMap(yearAndVarietyWisePercentage);
        return dtoToJsonConvertor.convertBreakDownYearVarietyToJson(sortedyearAndVarietyWisePercentage, "Year", "Variety", "Percentage");
    }

    public Map<GrapeComponentYearVariety, Double> buildyearVarietyPcntgeMap(Map<GrapeComponentYearVariety, Double> yearAndVarietyWisePercentage, Wine wine) {
        Iterator<GrapeComponent> itr = wine.getComponents().iterator();
        while (itr.hasNext()) {
            GrapeComponent component = itr.next();
            GrapeComponentYearVariety grapeComponentYearVariety = new GrapeComponentYearVariety(component.getYear(), component.getVariety());
            if (!yearAndVarietyWisePercentage.containsKey(grapeComponentYearVariety)) {
                yearAndVarietyWisePercentage.put(grapeComponentYearVariety, component.getPercentage());
            } else {
                yearAndVarietyWisePercentage.put(grapeComponentYearVariety, yearAndVarietyWisePercentage.get(grapeComponentYearVariety) + component.getPercentage());
            }
        }
        return yearAndVarietyWisePercentage;
    }

    public TreeMap<GrapeComponentYearVariety, Double> sortyearAndVarietyWisePercentageMap(Map<GrapeComponentYearVariety, Double> yearAndVarietyWisePercentage) {

        Comparator<GrapeComponentYearVariety> comparator = new ValueComparator<>(yearAndVarietyWisePercentage);
        TreeMap<GrapeComponentYearVariety, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(yearAndVarietyWisePercentage);
        return sortedMap;
    }
}
