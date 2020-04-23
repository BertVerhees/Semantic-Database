package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CObject;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CPrimitiveObject;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Getter
@Setter
public class CBoolean extends CPrimitiveObject<Boolean, Boolean> {
    private Boolean assumedValue;
    @Nullable
    private List<Boolean> constraint = new ArrayList<>();

    @Override
    public void addConstraint(Boolean constraint) {
        this.constraint.add(constraint);
    }

    @Override
    public boolean cConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypeNamesConformant) {
        if(!super.cConformsTo(other, rmTypeNamesConformant)) {
            return false;
        }
        //now guaranteed to be the same class

        CBoolean otherBoolean = (CBoolean) other;
        if(otherBoolean.constraint.isEmpty()) {
            return true;
        }

        if(!(constraint.size() <= otherBoolean.constraint.size())) {
            return false;
        }

        for(Boolean constraint:constraint) {
            if(!otherBoolean.constraint.contains(constraint)) {
                return false;
            }
        }
        return true;
    }
}
