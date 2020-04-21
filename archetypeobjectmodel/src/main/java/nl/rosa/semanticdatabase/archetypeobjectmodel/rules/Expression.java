package nl.rosa.semanticdatabase.archetypeobjectmodel.rules;

/**
 * Created by pieter.bos on 27/10/15.
 */
public class Expression extends RuleElement {
    /**
     * If true, this statement originally was placed between ()-signs
     */
    private boolean precedenceOverridden = false;

    public boolean isPrecedenceOverridden() {
        return precedenceOverridden;
    }

    public void setPrecedenceOverridden(boolean precedenceOverridden) {
        this.precedenceOverridden = precedenceOverridden;
    }
}
