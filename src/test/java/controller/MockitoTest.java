package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.VintraceApplication;
import sample.model.Owner;
import sample.model.ProductState;
import sample.model.Wine;
import sample.repository.WineRepository;
import sample.service.WineServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VintraceApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class MockitoTest {

    @MockBean
    WineRepository wineRepository;

    @Autowired
    WineServiceImpl wineService;

    @Test(expected = sample.exception.ResourceNotFoundException.class)
    public void testWineDetailsJSONResponse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //Path wiki_path = Paths.get("F:\\2018\\SampleRest\\src\\test\\java\\mockFiles\\WineDetails.json");
        //WineDetail value = mapper.readValue(new File("F:\\2018\\SampleRest\\src\\test\\java\\mockFiles\\WineDetails.json"), WineDetail.class);
        when(wineRepository.findById(232)).thenReturn(Optional.empty());
        wineService.findWineById(232);
    }

    @Test
    public void testWineDetailsJSONResponse2() {
        ObjectMapper mapper = new ObjectMapper();
        //Path wiki_path = Paths.get("F:\\2018\\SampleRest\\src\\test\\java\\mockFiles\\WineDetails.json");
        //WineDetail value = mapper.readValue(new File("F:\\2018\\SampleRest\\src\\test\\java\\mockFiles\\WineDetails.json"), WineDetail.class);
        when(wineRepository.findById(1)).thenReturn(getWineObject());
        List<Wine> wines1 = new ArrayList<>();
        wines1.add(getWineObject().get());
        //when(wineRepository.findByOwnerId(1)).thenReturn(wines1);
        //when(wineRepository.findByOwnerId(1)).thenCallRealMethod();
        //wineService.findWineById(1);
        List<Wine> wines = wineService.findByOwnerId(1);
        Assert.assertEquals(1, wines.size());
    }

    @Test
    public void testWineDetailsAreValid() {
        when(wineRepository.findById(any())).thenReturn(getWineObject()).thenReturn(getWineObject2());
        Wine wine = wineService.findWineById(2323);
        Assert.assertEquals("Bingo", wine.getLotCode());

        Wine wine2 = wineService.findWineById(2323);
        Assert.assertEquals("Bingo", wine.getLotCode());
    }

    public Optional<Wine> getWineObject() {
        Wine wine = new Wine();
        wine.setLotCode("16ZFYVPN");
        wine.setDescription("2016 Yarra Valley Pinot Noir");
        wine.setVolume(10350);
        wine.getTank().setCode("T25-01");
        wine.setOwner(new Owner(1, "Zane", "Zane@vintrace.com"));
        wine.setProductState(new ProductState(1, "Ready to bottle"));
        return of(wine);
    }

    public Optional<Wine> getWineObject2() {
        Wine wine = new Wine();
        wine.setLotCode("16ZFYVPN2");
        wine.setDescription("2016 Yarra Valley Pinot Noir");
        wine.setVolume(10350);
        wine.getTank().setCode("T25-01");
        wine.setOwner(new Owner(1, "Zane", "Zane@vintrace.com"));
        wine.setProductState(new ProductState(1, "Ready to bottle"));
        return of(wine);
    }

    public void readJSONFile(File file) {

    }
}



