package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.VintraceApplication;
import sample.dto.Result;
import sample.model.GrapeComponent;
import sample.model.Owner;
import sample.model.ProductState;
import sample.model.Wine;
import sample.service.YearVarietyWiseBreakDownImpl;

import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.Assert.*;

@SpringBootTest(classes = VintraceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class YearVarietyWiseBreakDownImplTest {

    @Autowired
    YearVarietyWiseBreakDownImpl yearVarietyWiseBreakDown;


    @Test
    public void test_execute_basic(){

        Result result =  yearVarietyWiseBreakDown.execute(getWineObject());
        assertEquals(5, result.getResults().size());


    }
    public Wine getWineObject() {
        Wine wine = new Wine();

        wine.setLotCode("16ZFYVPN");
        wine.setDescription("2016 Yarra Valley Pinot Noir");
        wine.setVolume(10350);
        wine.getTank().setCode("T25-01");
        wine.setOwner(new Owner(1, "Zane", "Zane@vintrace.com"));
        wine.setProductState(new ProductState(1, "Ready to bottle"));
        wine.getComponents().add(new GrapeComponent(80D, "2016", "Pinot Noir", "Yarra Valley"));
        wine.getComponents().add(new GrapeComponent(10D, "2015", "Pinot Noir", "Macedon"));
        wine.getComponents().add(new GrapeComponent(5D, "2016", "Chardonnay", "Mornington"));
        wine.getComponents().add(new GrapeComponent(5D, "2015", "Chardonnay", "Macedon"));
        // addition test data
        wine.getComponents().add(new GrapeComponent(10D, "2017", "Pinot Noir", "Yarra Valley"));
        wine.getComponents().add(new GrapeComponent(5D, "2017", "Pinot Noir", "Macedon"));
        return wine;
    }
}
