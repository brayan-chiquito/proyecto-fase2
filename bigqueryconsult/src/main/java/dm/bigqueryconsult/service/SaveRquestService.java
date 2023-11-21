package dm.bigqueryconsult.service;

import dm.bigqueryconsult.model.SaveRequest;
import dm.bigqueryconsult.repository.SaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveRquestService implements ISaveRequestService{

    @Autowired
    private SaveRequestRepository saveRequestRepository;

    @Override
    public List<SaveRequest> findAllByUserId(Integer idUser) {
        return this.saveRequestRepository.findAllByUserId(idUser);
    }

    @Override
    public SaveRequest save(SaveRequest saveRequest) {
        return this.saveRequestRepository.save(saveRequest);
    }
}
