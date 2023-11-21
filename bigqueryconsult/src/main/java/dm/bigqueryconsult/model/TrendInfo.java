package dm.bigqueryconsult.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrendInfo {
    Integer dma_id;
    String term;
    String wake;
    Integer score;
    Integer rank;
    String refresh_date;
    String dma_name;
}
