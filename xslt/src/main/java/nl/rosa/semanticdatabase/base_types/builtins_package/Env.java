package nl.rosa.semanticdatabase.base_types.builtins_package;

/**
 * 
 * Class representing the real-world environment, providing basic information like current time, date, etc.
 * 
*/
public interface Env {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Return today’s date in the current locale.
 * 
*/
    Iso8601_date  current_date();

/**
 * 
 * Return current time in the current locale.
 * 
*/
    Iso8601_time  current_time();

/**
 * 
 * Return current date/time in the current locale.
 * 
*/
    Iso8601_date_time  current_date_time();

/**
 * 
 * Return the timezone of the current locale.
 * 
*/
    Iso8601_timezone  time_zone();

}
