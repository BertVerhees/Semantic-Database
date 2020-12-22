package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.measurement.MeasurementService;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
    private MeasurementService measurementService;

    public static final char DECIMAL_SEPARATOR = '.';

    /**
     * This has been r many archetypes to fail because they still define it. So introduce, but don't use
     * don't even serialize
     */
    @Deprecated
    private transient CodePhrase property;

    /**
     * Constructs a integer Quantity by double value
     *
     * @param magnitude
     * @throws IllegalArgumentException
     */
    public DvQuantity(double magnitude) {
        this("", magnitude, 0L, null);
    }
    /**
     * Constructs a Quantity by units, getMagnitude and precision
     *
     * @param units
     * @param magnitude
     * @param precision >= 0
     * @throws IllegalArgumentException
     */
    public DvQuantity(String units, double magnitude, Long precision,
                      MeasurementService measurementService) {
        this(
                null,
                null,
                null,
                0,
                false,
                null,
                units,
                magnitude,
                precision,
                measurementService);
    }

    /**
     * Constructs a Measurable only by units
     *
     * @param magnitude
     * @param precision
     * @throws IllegalArgumentException if units is null
     */
    public DvQuantity(
            double magnitude,
            Long precision,

            MeasurementService measurementService) {
        this(
                "",
                magnitude,
                precision,
                measurementService);
    }


    public DvQuantity() {
    }

    /**
     * Constructs a Measurable only by units
     *
     * @param units not null
     * @throws IllegalArgumentException if units is null
     */
    public DvQuantity(
            String units,
            double magnitude,

            MeasurementService measurementService) {
        this(
                units,
                magnitude,
                0L,
                measurementService);
    }
    /**
     * New construct that does not require a measurementService
     *
     * @param units
     * @param magnitude
     * @param precision
     */
    public DvQuantity(
            String units,
            double magnitude,
            Long precision) {
        this(
                units,
                magnitude,
                precision,
                null);
    }


    public DvQuantity(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus,
            String units,
            Double magnitude,
            Long precision) {
        super(
                otherReferenceRanges,
                normalRange,
                normalStatus,
                accuracy,
                accuracyIsPercent,
                magnitudeStatus);
        this.precision = precision;
        this.units = units;
        this.magnitude = magnitude;
    }
    public DvQuantity(List<ReferenceRange> otherReferenceRanges,
                      DvInterval<DvQuantity> normalRange,
                      CodePhrase normalStatus,
                      double accuracy,
                      boolean accuracyPercent,
                      String magnitudeStatus,
                      String units,
                      double magnitude,
                      Long precision,
                      MeasurementService measurementService) {

        super(otherReferenceRanges, normalRange, normalStatus, accuracy,
                accuracyPercent, magnitudeStatus);

        if (precision < -1) {
            throw new IllegalArgumentException("negative precision");
        }


        /* Relaxed in order to create quantity without measurementService.
         * One possibility is to use the mixin class ExternalEnvironmentAccess
        if (StringUtils.isNotEmpty(units)
                && measurementService == null) {
            throw new IllegalArgumentException("null measurementService");
        }
        */
        this.magnitude = magnitude;
        this.precision = precision;
        this.measurementService = measurementService;
        this.units = units;
    }

    public DvQuantity parse(String value) {
        return valueOf(value);
    }

    public static DvQuantity valueOf(String value) {
        int i = value.indexOf(",");
        String num = value;
        String units = "";

        if (i >= 0) {
            num = value.substring(0, i);
            units = value.substring(i + 1);
        }
        Long precision = 0L;
        i = num.indexOf(DECIMAL_SEPARATOR);
        if (i >= 0) {
            precision = Long.valueOf(num.length() - i - 1);
        }
        try {
            double magnitude = Double.parseDouble(num);
            return new DvQuantity(units, magnitude, precision);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("failed to parse quantity["
                    + num + "]", nfe);
        }
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

    /**
     * string form displayable for humans
     *
     * @return string presentation
     */
    public String toString() {
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(precision.intValue());
        format.setMaximumFractionDigits(precision.intValue());
        DecimalFormatSymbols dfs = format.getDecimalFormatSymbols();
        dfs.setDecimalSeparator(DECIMAL_SEPARATOR);
        format.setDecimalFormatSymbols(dfs);
        format.setGroupingUsed(false);
        String tmp = format.format(magnitude) + (getUnits().isEmpty() ? "" : "," +
                getUnits());
        return tmp;
    }
}
