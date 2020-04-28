package nl.rosa.semanticdatabase.archetypeobjectmodel.adl14.aom14;

import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;

import java.util.Map;

public class TermCodeList {

    private Map<String, ArchetypeTerm> items;

    public Map<String, ArchetypeTerm> getItems() {
        return items;
    }

    public void setItems(Map<String, ArchetypeTerm> items) {
        this.items = items;
    }
}
