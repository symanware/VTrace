package sample.adapter;

import org.springframework.stereotype.Component;
import sample.dto.WineDetail;
import sample.model.Wine;

@Component
public class WineDetailAdapter {

       public WineDetail createWineDto(Wine wine){
        WineDetail wineDetail = new WineDetail();
        wineDetail.setDescription(wine.getDescription());
        wineDetail.setLotCode(wine.getLotCode());
        wineDetail.setVolume(wine.getVolume());
        wineDetail.setTankCode(wine.getTank().getCode());
        wineDetail.setOwner(wine.getOwner());
        wineDetail.setProductState(wine.getProductState());
        return wineDetail;
     }
}
