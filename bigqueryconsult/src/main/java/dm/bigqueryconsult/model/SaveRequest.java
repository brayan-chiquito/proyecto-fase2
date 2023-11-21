package dm.bigqueryconsult.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_save;
    @ManyToOne
    @JoinColumn(name = "idUser")
    User user;
    String request;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Comment> comments;
}
