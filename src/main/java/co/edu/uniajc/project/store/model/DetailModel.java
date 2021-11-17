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
@Table(name = "detail")
public class DetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "amount")
    private String amount;

    @Column(name = "amount_total")
    private String amount_total;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "store_id")
    private Long store_id;

}

