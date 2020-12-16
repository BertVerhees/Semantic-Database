package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public class DvQuantity extends DvAmount<Double> {

    private Long precision;
    private String units;
    private Double magnitude;
    private String unitsSystem;
    private String unitsDisplayName;


    /**
     * This has been r many archetypes to fail because they still define it. So introduce, but don't use
     * don't even serialize
     */
    @Deprecated
    private transient CodePhrase property;


    public DvQuantity() {
    }

    public DvQuantity(String units, Double magnitude,  Long precision) {
        this.precision = precision;
        this.units = units;
        this.magnitude = magnitude;
    }

    public DvQuantity( List<ReferenceRange> otherReferenceRanges,  DvInterval normalRange,  CodePhrase normalStatus,  Double accuracy,  Boolean accuracyIsPercent,  String magnitudeStatus, String units, Double magnitude,  Long precision) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.precision = precision;
        this.units = units;
        this.magnitude = magnitude;
    }

    
    public Long getPrecision() {
        return precision;
    }

    public void setPrecision( Long precision) {
        this.precision = precision;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    @Deprecated
    public CodePhrase getProperty() {
        return property;
    }

    @Deprecated
    public void setProperty(CodePhrase property) {
        this.property = property;
    }

    
    public String getUnitsSystem() {
        return unitsSystem;
    }

    public void setUnitsSystem( String unitsSystem) {
        this.unitsSystem = unitsSystem;
    }

    
    public String getUnitsDisplayName() {
        return unitsDisplayName;
    }

    public void setUnitsDisplayName( String unitsDisplayName) {
        this.unitsDisplayName = unitsDisplayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvQuantity that = (DvQuantity) o;
        return Objects.equals(precision, that.precision) &&
                Objects.equals(units, that.units) &&
                Objects.equals(magnitude, that.magnitude) &&
                Objects.equals(property, that.property) &&
                Objects.equals(unitsSystem, that.unitsSystem) &&
                Objects.equals(unitsDisplayName, that.unitsDisplayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), precision, units, magnitude, property);
    }
}
