package dm.bigqueryconsult.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.*;
import dm.bigqueryconsult.model.Filter;
import dm.bigqueryconsult.model.TrendInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueryService implements IQueryService {

    private final BigQuery bigQuery;

    public QueryService() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                        getClass().getClassLoader().getResourceAsStream("proyecto-fase-2-v1-2c1a3a940444.json"))
                .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

        this.bigQuery = BigQueryOptions.newBuilder()
                .setCredentials(credentials)
                .build()
                .getService();
    }


    @Override
    public List<TrendInfo> runQuery() {
        String query = "";
        query = "SELECT * FROM bigquery-public-data.google_trends.top_terms LIMIT 1000";
        try {
            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
            Job queryJob = bigQuery.create(JobInfo.newBuilder(queryConfig).build());

            // Resto de tu lógica para procesar los resultados de la consulta
            queryJob = queryJob.waitFor();

            // Verificar si hay errores
            if (queryJob != null && queryJob.getStatus() != null && queryJob.getStatus().getError() == null) {
                // Obtener los resultados de la consulta
                TableResult result = queryJob.getQueryResults();

                // Procesar los resultados y almacenarlos en una lista de TrendInfo
                List<TrendInfo> resultList = new ArrayList<>();
                for (FieldValueList row : result.iterateAll()) {
                    // Crear una instancia de TrendInfo
                    TrendInfo trendInfo = new TrendInfo();

                    // Establecer los valores de los atributos con los valores de la fila
                    trendInfo.setDma_id(Math.toIntExact(row.get("dma_id").isNull() ? null : row.get("dma_id").getLongValue()));
                    trendInfo.setTerm(row.get("term").isNull() ? null : row.get("term").getStringValue().toString());
                    trendInfo.setWake(row.get("week").isNull() ? null : row.get("week").getStringValue());
                    trendInfo.setScore(row.get("score").isNull() ? null : Math.toIntExact(row.get("score").getLongValue()));
                    trendInfo.setRank(Math.toIntExact(row.get("rank").isNull() ? null : row.get("rank").getLongValue()));
                    trendInfo.setRefresh_date(row.get("refresh_date").isNull() ? null : row.get("refresh_date").getStringValue());
                    trendInfo.setDma_name(row.get("dma_name").isNull() ? null : row.get("dma_name").getStringValue());

                    // Agregar la instancia de TrendInfo a la lista de resultados
                    resultList.add(trendInfo);
                }

                // Devolver la lista de resultados
                return resultList;
            } else {
                System.err.println("Error en la ejecución de la consulta: " + queryJob.getStatus());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<TrendInfo> filterQuery(Filter filter){
        String query = constructConsult(filter);
        System.out.println("query = " + query);

        try {
            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
            Job queryJob = bigQuery.create(JobInfo.newBuilder(queryConfig).build());

            // Resto de tu lógica para procesar los resultados de la consulta
            queryJob = queryJob.waitFor();

            // Verificar si hay errores
            if (queryJob != null && queryJob.getStatus() != null && queryJob.getStatus().getError() == null) {
                // Obtener los resultados de la consulta
                TableResult result = queryJob.getQueryResults();

                // Procesar los resultados y almacenarlos en una lista de TrendInfo
                List<TrendInfo> resultList = new ArrayList<>();
                for (FieldValueList row : result.iterateAll()) {
                    // Crear una instancia de TrendInfo
                    TrendInfo trendInfo = new TrendInfo();

                    // Establecer los valores de los atributos con los valores de la fila
                    trendInfo.setDma_id(Math.toIntExact(row.get("dma_id").isNull() ? null : row.get("dma_id").getLongValue()));
                    trendInfo.setTerm(row.get("term").isNull() ? null : row.get("term").getStringValue().toString());
                    trendInfo.setWake(row.get("week").isNull() ? null : row.get("week").getStringValue());
                    trendInfo.setScore(row.get("score").isNull() ? null : Math.toIntExact(row.get("score").getLongValue()));
                    trendInfo.setRank(Math.toIntExact(row.get("rank").isNull() ? null : row.get("rank").getLongValue()));
                    trendInfo.setRefresh_date(row.get("refresh_date").isNull() ? null : row.get("refresh_date").getStringValue());
                    trendInfo.setDma_name(row.get("dma_name").isNull() ? null : row.get("dma_name").getStringValue());

                    // Agregar la instancia de TrendInfo a la lista de resultados
                    resultList.add(trendInfo);
                }

                // Devolver la lista de resultados
                return resultList;
            } else {
                System.err.println("Error en la ejecución de la consulta: " + queryJob.getStatus());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String constructConsult(Filter filter) {
        // Query principal
        // Query principal
        StringBuilder query = new StringBuilder("SELECT * FROM bigquery-public-data.google_trends.top_terms ");

        // Verificar si hay algún filtro seleccionado
        if (filter.isWeek() || filter.isTerm() || filter.isOrderAsc() || filter.isOrderDesc() || filter.isCategorie()) {
            query.append("WHERE ");

            if (filter.isWeek()) {
                query.append("week BETWEEN DATE('2023-01-01') AND DATE('2023-12-31') ");
            }

            if (filter.isTerm()) {
                query.append("term = " + filter.getTermValue() );
            }

            if (filter.isOrderAsc()) {
                query.append("ORDER BY score ASC ");
            }

            if (filter.isOrderDesc()) {
                query.append("ORDER BY score DESC ");
            }

            if (filter.isCategorie()) {
                query.append("categoria = " + filter.getCategorieValue() );
            }
        }

        // Añadir límite al final
        query.append("LIMIT 1000");

        return query.toString();
    }
}
