package dm.bigqueryconsult.controller;

import dm.bigqueryconsult.model.Filter;
import dm.bigqueryconsult.model.TrendInfo;
import dm.bigqueryconsult.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
@CrossOrigin(origins = "http://localhost:9000")
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private QueryService queryService;

    @GetMapping("/query")
    public List<TrendInfo> runQuery(){
        logger.info("runQuery() method called");
        return this.queryService.runQuery();
    }
    @GetMapping("/query/{filter}")
    public List<TrendInfo> runQueryWithFilter(@RequestBody Filter filter){
        logger.info("runQueryWithFilter() method called");
        return this.queryService.filterQuery(filter);
    }

}
