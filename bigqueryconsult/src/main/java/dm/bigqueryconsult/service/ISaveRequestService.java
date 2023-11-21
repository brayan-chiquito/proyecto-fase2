package dm.bigqueryconsult.service;

import dm.bigqueryconsult.model.SaveRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISaveRequestService {

    public List<SaveRequest> findAllByUserId(Integer idUser);
    public SaveRequest save(SaveRequest saveRequest);

}
