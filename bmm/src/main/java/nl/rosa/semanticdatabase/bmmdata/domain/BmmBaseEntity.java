package nl.rosa.semanticdatabase.bmmdata.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Generated Id for BmmClass is not located here, but located in the class before BMMClass to make it possible
 * that BmmClass can have a MapsId to provide BmmModelType with a good OneToOne with MapsId
 */

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("BBE")
public abstract class BmmBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BmmBaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean equals(BmmBaseEntity obj){
        return id != null && id.equals( obj.id) && this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode(){
        return 2021;
    }


}
