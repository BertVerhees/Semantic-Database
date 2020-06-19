package nl.rosa.semanticdatabase.bmmdata.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BmmBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
