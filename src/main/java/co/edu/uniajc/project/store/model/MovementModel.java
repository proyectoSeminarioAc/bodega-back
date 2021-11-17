package co.edu.uniajc.project.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Generated
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movement")
public class MovementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "provider_id")
    private Long provider_id;

    @Column(name = "detail_id")
    private Long detail_id;



}

