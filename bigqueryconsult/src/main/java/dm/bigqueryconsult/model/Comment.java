package dm.bigqueryconsult.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name_user_comment;
    String comment;
    @ManyToOne
    @JoinColumn(name = "id_save") // Nombre de la columna que actuará como clave foránea
    SaveRequest saveRequest;
}
