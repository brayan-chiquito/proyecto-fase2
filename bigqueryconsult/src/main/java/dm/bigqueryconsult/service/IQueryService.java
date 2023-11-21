package dm.bigqueryconsult.service;

import dm.bigqueryconsult.model.Filter;
import dm.bigqueryconsult.model.TrendInfo;

import java.util.List;

public interface IQueryService {

    public List<TrendInfo> runQuery();
    public List<TrendInfo> filterQuery(Filter filter);
}
