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

/**
 * Type reference that specifies containers with one generic parameter.
 *
 * Created by cnanjo on 4/11/16.
 */
public class RMContainerType extends RMType {

    /**
     * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
     */
    private RMClass containerType;
    /**
     *
     */
    private RMType baseType;

    @Override
    public RMClass getBaseClass() {
        return baseType.getBaseClass();
    }

    /**
     * Return full type name, e.g. 'List&lt;ELEMENT&gt;'.
     *
     * @return
     */
    @Override
    public String getTypeName() {
        return containerType.getName() + "<" + baseType.getTypeName() + ">";
    }

    /**
     * Return base_type.conformance_type_name; e.g. if this type is 'List&lt;ELEMENT&gt;', return 'ELEMENT'.
     *
     * @return
     */
    public String getConformanceTypeName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
