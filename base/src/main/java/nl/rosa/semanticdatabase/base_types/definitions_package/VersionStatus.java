package nl.rosa.semanticdatabase.base_types.definitions_package.;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * 
 * Status of a versioned artefact, as one of a number of possible values: uncontrolled, prerelease, release, build.
 * 
*/
public enum VersionStatus {

/**
 * 
 * Value representing a version which is 'unstable', i.e.
 * contains an unknown size of change with respect to its base version.
 * Rendered with the build number as a string in the form N.M.P-alpha.B e.g.
 * 2.0.1-alpha.154.
 * 
*/
    alpha,

/**
 * 
 * Value representing a version which is 'beta', i.e.
 * contains an unknown but reducing size of change with respect to its base version.
 * Rendered with the build number as a string in the form N.M.P-beta.B e.g.
 * 2.0.1-beta.154.
 * 
*/
    beta,

/**
 * 
 * Value representing a version which is 'release candidate', i.e.
 * contains only patch-level changes on the base version.
 * Rendered as a string as N.M.P-rc.B e.g.
 * 2.0.1-rc.27.
 * 
*/
    releaseCandidate,

/**
 * 
 * Value representing a version which is 'released', i.e.
 * is the definitive base version.
 * N.M.P e.g.
 * 2.0.1.
 * 
*/
    released,

/**
 * 
 * Value representing a version which is a build of the current base release.
 * Rendered with the build number as a string in the form N.M.P+B e.g.
 * 2.0.1+33.
 * 
*/
    build

}
