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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Type reference based on a generic class, e.g. 'HashTable &lt;List &lt;Packet&gt;, String&gt;'
 *
 * Created by cnanjo on 4/11/16.
 */

@Getter
@Setter
public class RMGenericType extends RMType implements Serializable {

    public RMGenericType() {
        genericParameters = new ArrayList<>();
    }

    /**
     * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s
     * formal generic parameter declarations.
     */
    public List<RMType> genericParameters;
    /**
     * The base class of this type.
     */
    public RMGenericClass baseClass;

    /**
     * Adds a generic parameter to the generic type definition.
     *
     * @param genericParameter
     */
    public void addGenericParameter(RMType genericParameter) {
        this.genericParameters.add(genericParameter);
    }

}
