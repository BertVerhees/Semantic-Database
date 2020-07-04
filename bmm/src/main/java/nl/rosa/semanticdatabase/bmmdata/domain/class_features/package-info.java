/**
 * Default created on 4-7-2020
 *
 * Within the definition of each class in a BMM model are found the declarations of its
 * features, consisting of routines, properties and constants.
 * The overall meta-model of features, as well as the elements that occur within them,
 * namely parameters and local variables is shown below, and described in this section.
 *
 * The taxonomy of meta-types that classify the concrete meta-types representing features
 * is somewhat complicated in an object-oriented approach by the presence of procedures,
 * which are declared features (sometimes called commands or modifiers) that change
 * internal object state, rather than returning a value as is the case with all other
 * kinds of features. The consequence is that the cleanest approach to definition of
 * meta-attributes is the use of two taxonomies, one corresponding to feature declarations
 * (including procedures) and one to do with typed value-returning entities,
 * which excludes procedures.
 *
 * Features are understood in BMM as entities referenceable within a module or lower context.
 * The 'module' in BMM is the class. Class features consist of the formal sub-parts of
 * a class
 */

package nl.rosa.semanticdatabase.bmmdata.domain.class_features;