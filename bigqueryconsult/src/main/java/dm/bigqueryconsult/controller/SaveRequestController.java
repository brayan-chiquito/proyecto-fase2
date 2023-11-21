package dm.bigqueryconsult.controller;

import dm.bigqueryconsult.model.SaveRequest;
import dm.bigqueryconsult.service.SaveRquestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/save-requests")
@CrossOrigin(origins = "http://localhost:9000")
public class SaveRequestController {
    private static final Logger logger = LoggerFactory.getLogger(SaveRequestController.class);
    @Autowired
    private SaveRquestService saveRquestService;

    @GetMapping("/query-save/{idUser}")
    public List<SaveRequest> findAllByUserId(@PathVariable Integer idUser){
        logger.info("findAllByUserId() method called");
        return this.saveRquestService.findAllByUserId(idUser);
    }
    @PostMapping("/query-save")
    public SaveRequest save(@RequestBody SaveRequest saveRequest){
        logger.info("save() method called");
        return this.saveRquestService.save(saveRequest);
    }

}
