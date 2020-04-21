package nl.rosa.semanticdatabase.archetypeobjectmodel.xml.adapters;

/**
 * Created by pieter.bos on 28/07/16.
 */
public class DateIntervalXmlAdapter extends AbstractIntervalAdapter {

    public DateIntervalXmlAdapter() {
        super(new DateTimeXmlAdapter());
    }

}
