package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import sample.VintraceApplication;
import sample.model.Wine;
import sample.repository.WineRepository;
import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VintraceApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class WineServiceTest {

    @Autowired
    WineRepository wineRepository;

    @Test
    public void checkWineDetails(){

        Optional<Wine> wine = wineRepository.findById(1);
        assertEquals(wine.get().getLotCode(),"16ZFYVPN" );
    }


}
