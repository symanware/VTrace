package sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sample.adapter.WineDataAdapter;
import sample.adapter.WineDetailAdapter;
import sample.dto.Result;
import sample.dto.WineData;
import sample.dto.WineDetail;
import sample.model.Wine;
import sample.service.*;

import java.util.List;

//Exception Handling
//TestCases
//Logger

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/v1/wines")
public class WineController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WineService wineService;

    @Autowired
    private WineDetailAdapter wineDetailAdapter;

    @Autowired
    private WineDataAdapter wineDataAdapter;

    @Autowired
    private BreakDownServiceHelper breakDownServiceHelper;

    @Autowired
    private UserAuntheticationService userAuntheticationService;

    @GetMapping("/{id}")
    public WineDetail getWineByID(@PathVariable(value = "id") Integer wineId, Authentication auth)  {
        logger.info("Authenticating the user");
        userAuntheticationService.checkUserAuthorization(auth);

        logger.info("Restrieving data for wine id "+ wineId);
        Wine wine = wineService.findWineById(wineId);
        return wineDetailAdapter.createWineDto(wine);
    }

    @GetMapping("/productState/{id}")
    public List<WineData> getWineByProductStateID(@PathVariable(value = "id") Integer productStateId) {
        List<Wine> wine = wineService.findByProductStateId(productStateId);
        return wineDataAdapter.createWineDataDTO(wine);
    }

    @GetMapping("/owner/{id}")
    public List<WineData> getWineByOwnerID(@PathVariable(value = "id") Integer ownerId) {
        List<Wine> wine = wineService.findByOwnerId(ownerId);
        return wineDataAdapter.createWineDataDTO(wine);
    }

    @GetMapping("{wineid}/breakdown/{type}")
    public Result getWineByBreakDown(@PathVariable(value = "wineid") Integer wineId, @PathVariable(value = "type") String breakDownType)  {
        Wine wine = wineService.findWineById(wineId);
        return breakDownServiceHelper.getBreakDownService(breakDownType).execute(wine);
    }
}
