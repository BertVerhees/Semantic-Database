package nl.rosa.semanticdatabase.archetypeobjectmodel.xml.adapters;

/**
 * Created by pieter.bos on 28/07/16.
 */
public class DateTimeIntervalXmlAdapter extends AbstractIntervalAdapter {
    public DateTimeIntervalXmlAdapter() {
        super(new DateTimeXmlAdapter());
    }
}
