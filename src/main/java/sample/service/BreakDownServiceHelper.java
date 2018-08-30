package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BreakDownServiceHelper {

    @Autowired
    private YearWiseBreakdownImpl yearWiseBreakDown;

    @Autowired
    private VarietyWiseBreakDownImpl varietyWiseBreakDown;

    @Autowired
    private RegionWiseBreakDownImpl regionWiseBreakDown;

    @Autowired
    private YearVarietyWiseBreakDownImpl yearVarietyWiseBreakDown;

    public BreakDownService getBreakDownService(String breakDownType) {

        switch (breakDownType) {

            case "year":
                return yearWiseBreakDown;


            case "variety":
                return varietyWiseBreakDown;


            case "region":
                return regionWiseBreakDown;


            case "yearvariety":
                return yearVarietyWiseBreakDown;


            default:
                //throw some exception invalid request
        }

        return null;
    }
}
