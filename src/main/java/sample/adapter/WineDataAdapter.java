package sample.adapter;

import org.springframework.stereotype.Component;
import sample.dto.WineData;
import sample.model.Wine;

import java.util.ArrayList;
import java.util.List;

@Component
public class WineDataAdapter {
   public List<WineData> createWineDataDTO(List<Wine> wine){


       List<WineData> wineDataList = new ArrayList<>();

        for(Wine wineSpecificData : wine) {
            WineData wineData = new WineData();
            wineData.setLotCode(wineSpecificData.getLotCode());
            wineData.setVolume(wineSpecificData.getVolume());
            wineData.setTankCode(wineSpecificData.getTank().getCode());
            wineDataList.add(wineData);
        }
        return wineDataList;

    }
}
