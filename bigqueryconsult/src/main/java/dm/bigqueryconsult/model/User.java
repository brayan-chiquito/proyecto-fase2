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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUser;
    String nameUser;
    @Column(unique = true)
    String emailUser;
    @OneToMany(mappedBy = "user")
    private List<SaveRequest> saveRequests;
}
