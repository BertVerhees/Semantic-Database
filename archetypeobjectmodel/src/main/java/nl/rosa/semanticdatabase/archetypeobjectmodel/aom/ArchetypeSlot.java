package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Assertion;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ArchetypeSlot extends CObject {

    private List<Assertion> includes = new ArrayList<>();
    private List<Assertion> excludes = new ArrayList<>();
    private boolean closed = false;

    @Override
    public boolean isLeaf() {
        return true;
    }
}
