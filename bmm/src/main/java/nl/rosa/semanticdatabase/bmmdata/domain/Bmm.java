package nl.rosa.semanticdatabase.bmmdata.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Generated Id for BmmClass is not located here, but located in the class before BMMClass to make it possible
 * that BmmClass can have a MapsId to provide BmmModelType with a good OneToOne with MapsId
 */

@Getter
@Document(collection = "bmm")
@EqualsAndHashCode
public abstract class Bmm implements Serializable {

    @Transient
    StringBuilder classPath;
    public StringBuilder appendToClassPath(String path) {
        classPath.append(path);
        return classPath;
    }

    @Id
    private String id;

    public Bmm setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean equals(Bmm obj){
        return id != null && id.equals( obj.id) && this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode(){
        return 2021;
    }


}
