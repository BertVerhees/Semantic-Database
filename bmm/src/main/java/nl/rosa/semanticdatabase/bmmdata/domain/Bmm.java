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
@EqualsAndHashCode
public abstract class Bmm implements Serializable {

    @Transient
    StringBuilder classPath;
    public StringBuilder appendToClassPath(String path) {
        classPath.append(path);
        return classPath;
    }

    @Transient
    Long id;

    public void setId(Long id) {
        this.id = id;
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
