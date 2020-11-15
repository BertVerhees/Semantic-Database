package nl.rosa.semanticdatabase.bmm.overview;

import nl.rosa.semanticdatabase.base_types.definitions_package.BasicDefinitions;
import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definitions used by all BMM packages.
 * 
*/
public class BmmDefinitions extends BasicDefinitions {

    //***** BmmDefinitions *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
 * cardinality: 1..1
 * 
*/
    private String bmmInternalVersion;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
 * cardinality: 1..1
 * 
*/
    public String getBmmInternalVersion() {
        return Bmm_internal_version;
    }
    public void setBmmInternalVersion(String value) {
        if (Bmm_internal_version == null ) {
            throw new NullPointerException(" Bmm_internal_version has cardinality NonNull, but is null")
        }
        this.Bmm_internal_version = Bmm_internal_version;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * built-in class definition corresponding to the top `Any' class.
 * cardinality: 1..1
 * 
*/
    public abstract BmmSimpleClass  anyClass();

/**
 * 
 * Built-in type definition corresponding to the top `Any' type.
 * cardinality: 1..1
 * 
*/
    public abstract BmmSimpleType  anyType();

/**
 * 
 * Create schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * cardinality: 1..1
 * 
*/
    public abstract String  createSchemaId();

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Delimiter used to separate schema id from package path in a fully qualified path.
 * 
*/
    final String schemaNameDelimiter = "::";

/**
 * 
 * Delimiter used to separate package names in a package path.
 * 
*/
    final String packageNameDelimiter = ".";

/**
 * 
 * Extension used for BMM files.
 * 
*/
    final String bmmSchemaFileExtension = ".bmm";

/**
 * 
 * Appears between a name and a type in a declaration or type signature.
 * 
*/
    final Character typeDelimiter = ':';

/**
 * 
 * Left delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
    final Character genericLeftDelimiter = '<';

/**
 * 
 * Right delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
    final Character genericRightDelimiter = '>';

/**
 * 
 * Separator used in Generic types.
 * 
*/
    final Character genericSeparator = ',';

/**
 * 
 * Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.
 * 
*/
    final Character genericConstraintDelimiter = ':';

/**
 * 
 * Left delimiter of a Tuple type and also instance.
 * Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.
 * 
*/
    final Character tupleLeftDelim = '[';

/**
 * 
 * Right delimiter of a Tuple type and also instance.
 * 
*/
    final Character tupleRightDelim = ']';

/**
 * 
 * Separator used in Tuple types and instances.
 * 
*/
    final Character tupleSeparator = ',';

/**
 * 
 * Left delimiter used in serial form of instance constrained enumeration.
 * 
*/
    final Character constraintLeftDelim = '«';

/**
 * 
 * Right delimiter used in serial form of instance constrained enumeration.
 * 
*/
    final Character constraintRightDelim = '»';

/**
 * 
 * Attribute name of logical attribute 'bmm_version' in .bmm schema file.
 * 
*/
    final String metadataBmmVersion = "bmm_version";

/**
 * 
 * Attribute name of logical attribute 'schema_name' in .bmm schema file.
 * 
*/
    final String metadataSchemaName = "schema_name";

/**
 * 
 * Attribute name of logical attribute 'rm_publisher' in .bmm schema file.
 * 
*/
    final String metadataRmPublisher = "rm_publisher";

/**
 * 
 * Attribute name of logical attribute 'rm_release' in .bmm schema file.
 * 
*/
    final String metadataRmRelease = "rm_release";

/**
 * 
 * Attribute name of logical attribute 'schema_revision' in .bmm schema file.
 * 
*/
    final String metadataSchemaRevision = "schema_revision";

/**
 * 
 * Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.
 * 
*/
    final String metadataSchemaLifecycleState = "schema_lifecycle_state";

/**
 * 
 * Attribute name of logical attribute 'schema_description' in .bmm schema file.
 * 
*/
    final String metadataSchemaDescription = "schema_description";

/**
 * 
 * Path of schema file.
 * 
*/
    final String metadataSchemaPath = "schema_path";

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * 
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Initial Developer of the Original Code is Bert Verhees.
 * the Initial Developer Copyright (C) 2020 the Initial Developer.
 * All Rights Reserved.
 * 
 * Contributor(s): Bert Verhees
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/
