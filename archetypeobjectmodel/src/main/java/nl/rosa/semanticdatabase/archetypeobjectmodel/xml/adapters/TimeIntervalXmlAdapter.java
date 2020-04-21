package nl.rosa.semanticdatabase.archetypeobjectmodel.xml.adapters;

/**
 * Created by pieter.bos on 28/07/16.
 */
public class TimeIntervalXmlAdapter extends AbstractIntervalAdapter {
    public TimeIntervalXmlAdapter() {
        super(new TimeXmlAdapter());
    }
}
