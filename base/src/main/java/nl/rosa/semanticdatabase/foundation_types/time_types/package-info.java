package nl.rosa.semanticdatabase.foundation_types.time_types;
/**
 * 
 * 
 * 6.
 * Time Types
 * 6.1.
 * Overview
 * The primitive Date/Time types used in openEHR are represented by classes defined in the package base.foundation_types.time.
 * These are concrete types based on the ISO 8601 (2019) date/time standard semantics, which supports partial dates, times, and complex durations, all of which are needed in the biomedical and clinical domains.
 * These classes have a String physical representation.
 * and are assumed to exist in close to the form specified here, because they are specified in other openEHR specifications.The time package is shown below.
 * 
 * 
 * 
 * 
 * 
 * Figure 6.
 * base.foundation_types.time package
 * 6.2.
 * Primitive Time Types
 * The set of ISO 8601 based types define dates and times with a String representation (as per ISO 8601), and the ISO 8601 'partial' and 'extended' semantics.
 * They are defined as descendents of the native types described above, and add the necessary elements required for ISO 8601.ISO 8601 semantics not included in these types include:Deviations from the published standard include the following.Negation for ISO 8601 durations is also supported by W3C XML-schema and various programming languages.
 * See Wikipedia and the official ISO 8601 standard for details.
 * Note that in the date, time and date/time formats shown below, 'Z' and 'T' are literals.
 * In the duration class shown below, 'P', 'Y', 'M', 'W', 'D', 'H', 'S' and 'T' are literals.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 6.3.
 * Derived Interval / Time Types
 * A number of useful types may be generated from the Date/time classes and the Interval classes.
 * These are shown in blue on the following diagram.
 * 
 * 
 * 
 * Figure 7.
 * Useful time interval types
 * 6.4.
 * Computational Functions
 * A number of computational functions are defined in the interfaces of the concrete data/time types, of two kinds:Most of the functions defined on the date/time types are of the definite kind.
 * The exception is functions involving Iso8601_duration values, which take both definite and nominal forms.
 * The definite forms are named using the standard names add(), subtract() etc, while the nominal versions have names of the form xxx_nominal(), e.g.
 * add_nominal() etc.An example of an operation having both forms is addition for the type Iso8601_date.
 * The definite operation is called add() and treats the Iso8601_duration argument as an exact amount, based on constant values for length of year and month, defined by Time_definitions.Average_days_in_month and Time_definitions.Average_days_in_year.The nominal form of the operation is add_nominal(), and is computed according to 'everyday' rules, i.e.
 * in which the phrase 'a year from now' means the same date next year (with occasional slight adjustment), and 'in a month' means the same date next month (or possibly a day or more earlier due to next month being shorter).
 * In a similar way, the addition of a period of one day ('P1D'), although itself a regular quantity is computed differently to the definite form: in the definite form, addition of P1D results in the addition of exactly 24h of time to the date, which may result in a time that is different by one hour due to a change of summer time during the interval, while the nominal addition results in the same time on the next of previous day, even though occasionally this will represent 23 or 25 hours' difference.The definite functions have standard operators such as '+', '-', etc associated with them, while the nominal functions have the operators '++', '--', etc.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 6.5.
 * Class Definitions
 * 
 * 6.5.1.
 * Time_Definitions Class
 * 
 * 6.5.2.
 * Temporal Class
 * 
 * 6.5.3.
 * Iso8601_type Class
 * 
 * 6.5.4.
 * Iso8601_date Class
 * 
 * 6.5.5.
 * Iso8601_time Class
 * 
 * 6.5.6.
 * Iso8601_date_time Class
 * 
 * 6.5.7.
 * Iso8601_duration Class
 * 
 * 6.5.8.
 * Iso8601_timezone Class
 * 
 * 
*/
