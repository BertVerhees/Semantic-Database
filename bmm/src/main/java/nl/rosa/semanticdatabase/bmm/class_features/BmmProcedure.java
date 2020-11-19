package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A formal element with signature of the form: name ({arg:TArg}*).
 * A procedure is a computed (rather than data) element, generally assumed to be state-changing.
 * 
*/
public class BmmProcedure extends BmmRoutine {

    //***** BmmProcedure *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmProcedure build() {
        return new BmmProcedure(
            parameters,
            locals,
            preConditions,
            postConditions,
            body,
            visibility,
            featureExtensions,
            group,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmProcedure(
            List<BmmParameter> parameters,
            List<BmmLocal> locals,
            List<BmmAssertion> preConditions,
            List<BmmAssertion> postConditions,
            BmmRoutineBody body,
            BmmVisibility visibility,
            List<BMM_FEATURE_EXTENSION> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( group == null ) {
            throw new NullPointerException("Property:group has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.parameters = parameters;
        this.locals = locals;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
        this.body = body;
        this.visibility = visibility;
        this.featureExtensions = featureExtensions;
        this.group = group;
        this.scope = scope;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
    }

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK *****
 * 
 * ISC License
 * 
 * Copyright (c) 2020, Bert Verhees
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/
