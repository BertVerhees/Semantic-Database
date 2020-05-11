package nl.rosa.semanticdatabase.referencemodel.core;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 * Author: Claude Nanjo
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Open type reference to a single type parameter, i.e. typically 'T', 'V', 'K' etc. The parameter must be in the
 * type declaration of the owning BMM_class.
 *
 * Created by cnanjo on 4/11/16.
 */

@Getter
@Setter
public class RMOpenType extends RMType implements Serializable {

    /**
     * The generic constraint, which will be 'Any' if nothing set in original model.
     */
    private RMGenericParameter genericConstraint;


    /**
     * Return generic_constraint.conformance_type_name.
     *
     * @return
     */
    @Override
    public String getConformanceTypeName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public RMClass getBaseClass() {
        return getGenericConstraint().getConformsToType();
    }
}
