package dm.bigqueryconsult.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Filter {
    boolean week = false;
    boolean term = false; //palabra clave
    String termValue = "";
    boolean orderAsc = false;
    boolean orderDesc = false;
    boolean categorie = false;
    String categorieValue = "";
}
