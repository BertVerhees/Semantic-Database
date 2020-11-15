<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl" xmlns:do="http://whatever"
    exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>
    <xsl:variable name="packageBase" select="'nl/rosa/semanticdatabase/'"/>
    <xsl:variable name="sourceBase" select="'generated_source/main/java/'"/>
    <xsl:variable name="fourSp" select="'    '"/>
    <xsl:variable name="implements" as="xs:string*"
        select="
            'BMM_MODEL_METADATA',
            'BMM_INSTANTIABLE',
            'BMM_TYPED_FEATURE',
            'BMM_TYPED',
            'EL_AGENT_CALL',
            'P_BMM_PACKAGE_CONTAINER',
            'TEST_INTERFACE_1',
            'TEST_CHAIN_INTERFACE_5',
            'TEST_CHAIN_INTERFACE_6'
            "/>

    <xsl:template match="/">
        <xsl:variable name="root">
            <xsl:element name="packages">
                <xsl:variable name="baseDirectorytest" select="'test'"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:copy-of select="do:basePackageInfo(document(concat($baseDirectorytest, '.html')), concat($packageBase, $baseDirectorytest))"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$baseDirectorytest"/>
                    </xsl:element>
                </xsl:element>
                <xsl:for-each select="document(concat($baseDirectorytest, '.html'))/html/body[1]/div[2]/div">
                    <xsl:call-template name="analyzeClassDocument">
                        <xsl:with-param name="context" select="."/>
                        <xsl:with-param name="baseDirectory" select="$baseDirectorytest"/>
                    </xsl:call-template>
                </xsl:for-each>
                <xsl:variable name="baseDirectory0" select="'base_types'"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:copy-of select="do:basePackageInfo(document(concat($baseDirectory0, '.html')), concat($packageBase, $baseDirectory0))"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$baseDirectory0"/>
                    </xsl:element>
                </xsl:element>
                <xsl:for-each select="document(concat($baseDirectory0, '.html'))/html/body[1]/div[2]/div">
                    <xsl:call-template name="analyzeClassDocument">
                        <xsl:with-param name="context" select="."/>
                        <xsl:with-param name="baseDirectory" select="$baseDirectory0"/>
                    </xsl:call-template>
                </xsl:for-each>
                <xsl:variable name="baseDirectory1" select="'bmm'"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:copy-of select="do:basePackageInfo(document(concat($baseDirectory1, '.html')), concat($packageBase, $baseDirectory1))"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$baseDirectory1"/>
                    </xsl:element>
                </xsl:element>
                <xsl:for-each select="document(concat($baseDirectory1, '.html'))/html/body[1]/div[2]/div">
                    <xsl:call-template name="analyzeClassDocument">
                        <xsl:with-param name="context" select="."/>
                        <xsl:with-param name="baseDirectory" select="$baseDirectory1"/>
                    </xsl:call-template>
                </xsl:for-each>
                <xsl:variable name="baseDirectory2" select="'bmm_persistence'"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:copy-of select="do:basePackageInfo(document(concat($baseDirectory2, '.html')), concat($packageBase, $baseDirectory2))"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$baseDirectory2"/>
                    </xsl:element>
                </xsl:element>
                <xsl:for-each select="document(concat($baseDirectory2, '.html'))/html/body[1]/div[2]/div">
                    <xsl:call-template name="analyzeClassDocument">
                        <xsl:with-param name="context" select="."/>
                        <xsl:with-param name="baseDirectory" select="$baseDirectory2"/>
                    </xsl:call-template>
                </xsl:for-each>
            </xsl:element>
        </xsl:variable>
        <xsl:variable name="allClasses" as="xs:string*">
            <xsl:for-each select="$root/packages/package">
                <xsl:for-each select="class">
                    <xsl:value-of select="classNameOrgAbstractStripped"/>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <xsl:for-each select="$root/packages/package">
            <xsl:variable name="pd" select="packageDirectory/text()"/>
            <xsl:variable name="package" select="."/>
            <xsl:if test="count(class) > 0">
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/package-info.java">
                    <xsl:copy-of select="packageInfo"/>
                </xsl:result-document>
            </xsl:if>
            <!--<xsl:for-each select="class">
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/{classFileName}.java">
                    <xsl:if test="enumeration = false()">
                        <xsl:value-of select="do:writeInterface($root/packages, $package, .)"/>
                    </xsl:if>
                    <xsl:if test="enumeration = true()">
                        <xsl:value-of select="do:writeEnumeration($root/packages, .)"/>
                    </xsl:if>
                </xsl:result-document>
            </xsl:for-each>-->
            <xsl:for-each select="class">
                <xsl:value-of select="do:message(concat('###', ./packageDirectory, '.', ./className))"/>
                <xsl:variable name="includeSequence" as="xs:string*" select="do:getIncludes($root/packages, ., $allClasses)"/>
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/{classFileName}.java">
                    <xsl:choose>
                        <xsl:when test="enumeration = true()">
                            <xsl:value-of select="do:writeEnumeration($root/packages, .)"/>
                        </xsl:when>
                        <xsl:when test="do:is-value-in-sequence(classNameOrgAbstractStripped, $implements)">
                            <xsl:value-of select="do:writeInterface($root/packages, $package, ., $includeSequence)"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="do:writeClasses($root/packages, $package, ., $includeSequence)"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:result-document>
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>

    <xsl:function name="do:getInterfaceInherited" as="node()*">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:variable name="result" as="node()*">
            <xsl:copy-of select="$class"/>
            <xsl:for-each select=" $class/implementOrg">
                <xsl:variable name="inheritedClass" as="node()" select="do:findClass($packages, .)"/>
                <xsl:if test="$inheritedClass">
                    <xsl:copy-of select="do:getInterfaceInherited($packages, $inheritedClass)"></xsl:copy-of>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:copy-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:findClass" as="node()">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="classToFind" as="xs:string"/>
        <xsl:copy-of select="$packages/package/class[classNameOrgAbstractStripped = $classToFind]"/>
    </xsl:function>

    <xsl:function name="do:writeClassHeader">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:if test="count(distinct-values($includeSequence)) > 0">
            <xsl:for-each select="distinct-values($includeSequence)">
                <xsl:variable name="found" select="do:findClass($packages, .)"/>
                <xsl:if test="$found">
                    <xsl:if test="not($found/packageDirectory = $package/packageDirectory)">
                        <xsl:value-of select="do:output(concat('import ', replace($packageBase, '/', '.'), replace($found/packageDirectory, '/', '.'), '.', $found/className, ';'))"/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('#By: Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('#Copyright: Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('#License: See bottom of file')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:variable name="inherit">
            <xsl:choose>
                <xsl:when test="string-length(normalize-space(string-join($class/inherit, ','))) > 0">
                    <xsl:value-of select="concat(' extends ', normalize-space(string-join($class/inherit, ',')))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="''"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:variable name="implements">
            <xsl:choose>
                <xsl:when test="string-length(normalize-space(string-join($class/implement, ','))) > 0">
                    <xsl:value-of select="concat(' implements ', normalize-space(string-join($class/implement, ',')))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="''"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:choose>
            <xsl:when test="$class/abstract = true()">
                <xsl:value-of select="do:output(concat('public abstract class ', $class/className, $inherit, $implements, ' {'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:output(concat('public class ', $class/className, $inherit, $implements, ' {'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeClassFooter">
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput('***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('The contents of this file are subject to the Mozilla Public License Version')"/>
        <xsl:value-of select="do:commentOutput('1.1 (the &quot;License&quot;); you may not use this file except in compliance with the')"/>
        <xsl:value-of select="do:commentOutput('License. You may obtain a copy of the License at http://www.mozilla.org/MPL/')"/>
        <xsl:value-of select="do:commentOutput('')"/>        
        <xsl:value-of select="do:commentOutput('Software distributed under the License is distributed on an &quot;AS IS&quot; basis,')"/>
        <xsl:value-of select="do:commentOutput('WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for')"/>
        <xsl:value-of select="do:commentOutput('the specific language governing rights and limitations under the License.')"/>
        <xsl:value-of select="do:commentOutput('')"/>         
        <xsl:value-of select="do:commentOutput('The Initial Developer of the Original Code is Bert Verhees.')"/>
        <xsl:value-of select="do:commentOutput('the Initial Developer Copyright (C) 2020 the Initial Developer.')"/>
        <xsl:value-of select="do:commentOutput('All Rights Reserved.')"/>
        <xsl:value-of select="do:commentOutput('')"/>        
        <xsl:value-of select="do:commentOutput('Contributor(s): Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('')"/>        
        <xsl:value-of select="do:commentOutput('Software distributed under the License is distributed on an &quot;AS IS&quot; basis,')"/>
        <xsl:value-of select="do:commentOutput('WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for')"/>
        <xsl:value-of select="do:commentOutput('the specific language governing rights and limitations under the License.')"/>
        <xsl:value-of select="do:commentOutput('')"/>        
        <xsl:value-of select="do:commentOutput('***** END LICENSE BLOCK *****')"/>
        <xsl:value-of select="do:commentClose()"/>
    </xsl:function>

    <xsl:function name="do:writeClassImplementationType">
        <xsl:param name="type" as="xs:string"/>
        <xsl:variable name="implementationType">
            <xsl:choose>
                <xsl:when test="starts-with(lower-case($type), 'list')">
                    <xsl:value-of select="'ArrayList'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'set')">
                    <xsl:value-of select="'HashSet'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'map')">
                    <xsl:value-of select="'HashMap'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'hash')">
                    <xsl:value-of select="'HashMap'"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$type"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$implementationType"/>
    </xsl:function>

    <xsl:function name="do:writeClassAttribute">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1)"/>
        <xsl:choose>
            <xsl:when test="$nameAndTypeAndKind/container = true() and starts-with($nameAndTypeAndKind/cardinality, '1')">
                <xsl:variable name="implementationType" select="do:writeClassImplementationType($type)"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'private ', $type, ' ', $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'private ', $type, ' ', $name, ';'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeComment">
        <xsl:param name="comment" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:if test="not(normalize-space($comment) = '') or not(normalize-space($cardinality) = '')">
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:if test="not(normalize-space($comment) = '')">
                <xsl:value-of select="do:commentOutput($comment)"/>
            </xsl:if>
            <xsl:if test="not(normalize-space($cardinality) = '')">
                <xsl:value-of select="do:commentOutput(concat('cardinality: ', $cardinality))"/>
            </xsl:if>
            <xsl:value-of select="do:commentClose()"/>
        </xsl:if>
    </xsl:function>

    <xsl:function name="do:writeClassConstants">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, '')"/>
        <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:value-of select="do:outputSpaces(concat('    final ', $type, ' ', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ' = ', $nameAndTypeAndKind/value, ';'))"/>
    </xsl:function>
    <!-- TODO PARAMETERS -->
    <xsl:function name="do:writeClassFunctions">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:choose>
            <xsl:when test="$nameAndTypeAndKind/kind = 'void-function'">
                <xsl:value-of select="do:outputSpaces(concat($fourSp, concat('public void  ', $nameAndTypeAndKind/name, '() {')))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', $type, '  ', $nameAndTypeAndKind/name, '() {'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $type, '  result', ';'))"/>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return  result', ';'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeClassPojos">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:choose>
            <xsl:when test="starts-with($type, 'List') or starts-with($type, 'Set')">
                <xsl:value-of select="do:writeListPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType)"/>
            </xsl:when>
            <xsl:when test="starts-with($type, 'Map')">
                <xsl:value-of select="do:writeMapPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, concat('public ', $type, ' get', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '() {')))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return ', $nameAndTypeAndKind/name, ';'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, concat('public void set', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '(', $type, ' value) {')))"/>
                <xsl:if test="starts-with($nameAndTypeAndKind/cardinality, '1')">
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $nameAndTypeAndKind/name, ' == null ) {'))"/>
                    <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; ', $nameAndTypeAndKind/name, ' has cardinality NonNull, but is null&quot;)'))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                </xsl:if>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $nameAndTypeAndKind/name, ' = ', $nameAndTypeAndKind/name, ';'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeMapPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after($type, '&lt;'), '&gt;'), ',')"/>
        <xsl:variable name="processedType" as="xs:string" select="do:processType($packages, $type)"/>
        <xsl:variable name="keyType" as="xs:string" select="do:processType($packages, normalize-space($types[1]))"/>
        <xsl:variable name="valueType" as="xs:string" select="do:processType($packages, normalize-space($types[2]))"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, 0)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0)"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- PUT item -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void put', $singleAttributeNameInFunction, '(', $keyType, ' key, ', $valueType, ' value ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $name, '.put( key, value);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- PUT items -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void put', $attributeNameInFunction, '(', do:processType($packages, $type), ' items ) {'))"/>
        <xsl:value-of
            select="do:outputSpaces(concat($fourSp, $fourSp, 'items.keySet().forEach(key -&gt; put', do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0), '(key, items.get(key)));'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- GET item -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', $valueType, ' get', $singleAttributeNameInFunction, '(', $keyType, ' key ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'return null;'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return ', $name, '.get( key);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- REMOVE item -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void remove', $singleAttributeNameInFunction, '(', $keyType, ' key ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' != null ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, '.remove(key);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- REMOVE items -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void remove', $attributeNameInFunction, '( Collection &lt;', $keyType, '&gt; keys ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'keys.forEach(this::remove', $singleAttributeNameInFunction, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, ' get', $attributeNameInFunction, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this.', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void set', $attributeNameInFunction, '(', $processedType, ' ', $name, ') {'))"/>
        <xsl:if test="starts-with($cardinality, '1')">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; ', $name, ' has cardinality NonNull, but is null&quot;)'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', $processedType, ' ', $name, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return Collections.unmodifiableMap(this.', $name, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
    </xsl:function>

    <xsl:function name="do:writeListPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:variable name="processedType" as="xs:string" select="do:processType($packages, substring-before(substring-after($type, '&lt;'), '&gt;'))"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, 0)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0)"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- ADD item -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void add', $singleAttributeNameInFunction, '(', $processedType, ' value ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $name, '.add( value);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- ADD items -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void add', $attributeNameInFunction, '(', do:processType($packages, $type), ' values ) {'))"/>
        <xsl:value-of
            select="do:outputSpaces(concat($fourSp, $fourSp, 'values.forEach(value -&gt; add', do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0), '(value));'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- REMOVE item -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void remove', $singleAttributeNameInFunction, '(', $processedType, ' item ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' != null ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, '.remove(item);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- REMOVE items -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public void remove', $attributeNameInFunction, '( Collection &lt;', $processedType, '&gt; values ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'values.forEach(this::remove', $singleAttributeNameInFunction, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, ' get', $attributeNameInFunction, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this.', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void set', $attributeNameInFunction, '(', $processedType, ' ', $name, ') {'))"/>
        <xsl:if test="starts-with($cardinality, '1')">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; ', $name, ' has cardinality NonNull, but is null&quot;)'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', do:processType($packages, $type), ' ', $name, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return Collections.unmodifiable', substring-before(do:processType($packages, $type), '&lt;'), '(this.', $name, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
    </xsl:function>

    <xsl:function name="do:writeClassProperties">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <!-- If inherit do recursion -->
        <xsl:variable name="result">
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'attribute']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:outputSpaces(concat('    //***** ', $class/className, ' *****'))"/>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * FIELDS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'attribute'">
                        <xsl:value-of select="do:writeClassAttribute(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * POJOS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'attribute'">
                        <xsl:variable name="implementationType" select="do:writeClassImplementationType(type)"/>
                        <xsl:value-of select="do:writeClassPojos(., $packages, $implementationType)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'void-function' or kind = 'value-function']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * FUNCTIONS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                        <xsl:value-of select="do:writeClassFunctions(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'constant']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * CONSTANTS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'constant'">
                        <xsl:value-of select="do:writeClassConstants(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
        </xsl:variable>
        <xsl:value-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:writeClasses">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of select="do:writeClassHeader($packages, $package, $class, $includeSequence)"/>
        <xsl:variable name="classes" select="do:getInterfaceInherited($packages, $class)"/>
        <xsl:if test="count($classes)>0">
            <xsl:for-each select="$classes">
                <xsl:value-of select="do:writeClassProperties($packages, .)"/>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="do:writeClassFooter()"/>
    </xsl:function>


    <xsl:function name="do:writeInterface">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <!-- Package of class -->
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:if test="count(distinct-values($includeSequence)) > 0">
            <xsl:for-each select="distinct-values($includeSequence)">
                <xsl:variable name="found" select="do:findClass($packages, .)"/>
                <xsl:if test="$found">
                    <xsl:if test="not($found/packageDirectory = $package/packageDirectory)">
                        <xsl:value-of select="do:output(concat('import ', replace($packageBase, '/', '.'), replace($found/packageDirectory, '/', '.'), '.', $found/className, ';'))"/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="do:output('')"/>
        <!-- Class comments -->
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <!-- Class line include inheritance -->
        <xsl:choose>
            <xsl:when test="not(normalize-space(string-join($class/inherit, ',')) = '')">
                <xsl:value-of select="do:output(concat('public interface ', $class/className, ' extends ', normalize-space(string-join($class/inherit, ',')), ';'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:output(concat('public interface ', $class/className, ' {'))"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * ATTRIBUTE * */')"/>
        <!-- Getters and Setters declarations for interface -->
        <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
            <xsl:if test="kind = 'attribute'">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:commentOpen()"/>
                <xsl:value-of select="do:commentOutput(description)"/>
                <xsl:value-of select="do:commentOutput(concat('cardinality:', cardinality))"/>
                <xsl:value-of select="do:commentClose()"/>
                <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, type))"/>
                <xsl:variable name="singleAttributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(replace(substring(name, 0, string-length(name)), 'ie', 'y'), 0)"/>
                <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(name, 0)"/>
                <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after($type, '&lt;'), '&gt;'), ',')"/>
                <xsl:choose>
                    <xsl:when test="starts-with($type, 'List') or starts-with($type, 'Set')">
                        <xsl:variable name="collectionType">
                            <xsl:choose>
                                <xsl:when test="starts-with($type, 'List')">
                                    <xsl:value-of select="'List'"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:value-of select="'Set'"/>
                                </xsl:otherwise>
                            </xsl:choose>
                        </xsl:variable>
                        <xsl:variable name="valueType" as="xs:string" select="do:processType($packages, normalize-space($types[1]))"/>
                        <xsl:variable name="processedType" as="xs:string" select="concat($collectionType, '&lt;', $valueType, '&gt;')"/>
                        <xsl:value-of select="do:output('')"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void add', $singleAttributeNameInFunction, '(', $valueType, ' value );'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void add', $attributeNameInFunction, '(', $processedType, ' values );'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void remove', $singleAttributeNameInFunction, '(', $valueType, ' item );'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void remove', $attributeNameInFunction, '( Collection &lt;', $processedType, '&gt; values );'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, ' ', name, '();'))"/>
                    </xsl:when>
                    <xsl:when test="starts-with($type, 'Map')">
                        <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after($type, '&lt;'), '&gt;'), ',')"/>
                        <xsl:variable name="keyType" as="xs:string" select="do:processType($packages, normalize-space($types[1]))"/>
                        <xsl:variable name="valueType" as="xs:string" select="do:processType($packages, normalize-space($types[2]))"/>
                        <xsl:variable name="processedType" as="xs:string" select="concat('Map&lt;', $keyType, ', ', $valueType, '&gt; ')"/>
                        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(name, 0)"/>
                        <xsl:variable name="singleAttributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase(replace(substring(name, 0, string-length(name)), 'ie', 'y'), 0)"/>
                        <xsl:value-of select="do:output($fourSp)"/>
                        <!-- PUT item -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void put', $singleAttributeNameInFunction, '(', $keyType, ' key, ', $valueType, ' value );'))"/>
                        <!-- PUT items -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void put', $attributeNameInFunction, '(', $processedType, ' items );'))"/>
                        <!-- GET item -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $valueType, ' get', $singleAttributeNameInFunction, '(', $keyType, ' key );'))"/>
                        <!-- REMOVE item -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void remove', $singleAttributeNameInFunction, '(', $keyType, ' key );'))"/>
                        <!-- REMOVE items -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void remove', $attributeNameInFunction, '( Collection &lt;', $keyType, '&gt; keys );'))"/>
                        <!-- GETTER/SETTER -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, ' get', $attributeNameInFunction, '();'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void set', $attributeNameInFunction, '(', $processedType, ' ', do:snakeUpperCaseToCamelCase(name, 1), ');'))"/>
                        <!-- GETTER unmodifiable -->
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, do:snakeUpperCaseToCamelCase(name, 1), '();'))"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $type, ' get', do:snakeUpperCaseToCamelCase(name, 0), '();'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'void set', do:snakeUpperCaseToCamelCase(name, 0), '(', $type, ' value);'))"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:if>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * FUNCTION * */')"/>
        <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
            <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:commentOpen()"/>
                <xsl:value-of select="do:commentOutput(description)"/>
                <xsl:value-of select="do:commentClose()"/>
                <xsl:choose>
                    <xsl:when test="kind = 'void-function'">
                        <xsl:value-of select="do:outputSpaces(concat('    ', concat('void  ', name, '();')))"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, type))"/>
                        <xsl:value-of select="do:outputSpaces(concat('    ', concat($type, '  ', name, '();')))"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:if>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * CONSTANTS * */')"/>
        <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
            <xsl:if test="kind = 'constant'">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:commentOpen()"/>
                <xsl:value-of select="do:commentOutput(description)"/>
                <xsl:value-of select="do:commentClose()"/>
                <xsl:variable name="type" as="xs:string" select="string-join(do:processType($packages, type))"/>
                <xsl:value-of select="do:outputSpaces(concat('    ', $type, ' ', do:snakeUpperCaseToCamelCase(name, 1), ' = ', value, ';'))"/>
            </xsl:if>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>

    <xsl:function name="do:writeEnumeration">
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:value-of select="do:output(concat('public enum ', $class/className, ' {'))"/>
        <xsl:variable name="count" select="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind)"/>
        <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:choose>
                <xsl:when test="position() &lt; $count">
                    <xsl:value-of select="do:outputSpaces(concat('    ', enumType, ','))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:outputSpaces(concat('    ', enumType))"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>

    <xsl:function name="do:createFieldDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"/>
        <xsl:value-of select="concat(do:processType($packages, $incomingString), ' ', do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString, ':')[1]), 1), '();')"/>
    </xsl:function>

    <xsl:function name="do:processType">
        <xsl:param name="packages"/>
        <xsl:param name="incomingString" as="xs:string"/>
        <xsl:variable name="result">
            <xsl:choose>
                <xsl:when test="$packages/package/class[classNameOrgAbstractStripped = $incomingString]/className">
                    <xsl:value-of select="$packages/package/class[classNameOrgAbstractStripped = $incomingString]/className"/>
                </xsl:when>
                <xsl:when test="contains($incomingString, '&lt;')">
                    <xsl:variable name="type">
                        <xsl:choose>
                            <xsl:when test="starts-with(lower-case($incomingString), 'hash')">
                                <xsl:value-of select="'Map'"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of select="substring-before($incomingString, '&lt;')"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:variable>
                    <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after($incomingString, '&lt;'), '&gt;'), ',')"/>
                    <xsl:variable name="newTypes">
                        <xsl:for-each select="$types">
                            <xsl:variable name="testType" select="."/>
                            <xsl:variable name="newType">
                                <xsl:value-of select="do:processType($packages, $testType)"/>
                            </xsl:variable>
                            <xsl:if test="position() > 1">
                                <xsl:value-of select="','"/>
                            </xsl:if>
                            <xsl:value-of select="$newType"/>
                        </xsl:for-each>
                    </xsl:variable>
                    <xsl:value-of select="concat($type, '&lt;', $newTypes, '&gt;')"/>
                </xsl:when>
                <xsl:when test="$incomingString = 'Any'">
                    <xsl:value-of select="'Object'"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$incomingString"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:enumItem">
        <xsl:param name="incomingString"/>
        <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString, ':')[1]), 1)"/>
    </xsl:function>

    <xsl:template name="analyzeClassDocument">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="baseDirectory"/>
        <xsl:variable name="tag" select="string($context/h2[1]/a[1]/@href)"/>
        <xsl:variable name="packageName" select="substring($tag, 3)"/>
        <xsl:if test="not($packageName = '')">
            <xsl:variable name="package">
                <xsl:element name="package">
                    <xsl:variable name="packageDirectory" select="concat($baseDirectory, '/', $packageName)"/>
                    <xsl:element name="packageInfo">
                        <xsl:value-of select="do:output(concat('package ', $packageDirectory, ';'))"/>
                        <xsl:value-of select="do:commentOpen()"/>
                        <xsl:value-of select="do:commentOutput('')"/>
                        <xsl:value-of select="do:commentOutput($context/h2[1])"/>
                        <xsl:for-each select="$context/div/div">
                            <xsl:value-of select="do:commentOutput(h3)"/>
                            <xsl:value-of select="do:commentOutput(./div/p)"/>
                            <xsl:for-each select="div/dl/*">
                                <xsl:value-of select="do:commentOutput(.)"/>
                            </xsl:for-each>
                            <xsl:for-each select="./div">
                                <xsl:value-of select="do:commentOutput(h4)"/>
                                <xsl:value-of select="do:commentOutput(./div)"/>
                            </xsl:for-each>
                        </xsl:for-each>
                        <xsl:value-of select="do:commentClose()"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$packageDirectory"/>
                    </xsl:element>
                    <xsl:for-each select="$context/descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                        <xsl:variable name="className" select="normalize-space(string-join(tbody/tr[1]/th[2]/p/strong))"/>
                        <xsl:if test="string-length($className) > 0">
                            <xsl:variable name="class">
                                <xsl:element name="class">
                                    <xsl:element name="packageDirectory">
                                        <xsl:value-of select="$packageDirectory"/>
                                    </xsl:element>
                                    <xsl:element name="includes"/>
                                    <xsl:value-of select="do:message($className)"/>
                                    <!-- Check abstract by scanning for word abstract -->
                                    <xsl:element name="abstract">
                                        <xsl:value-of select="do:message(concat('    abstr:', contains(tbody/tr[1]/th[2]/p/strong, '(abstract)')))"/>
                                        <xsl:value-of select="contains(tbody/tr[1]/th[2]/p/strong, '(abstract)')"/>
                                    </xsl:element>
                                    <!-- check enumaration for checking the word enumeration -->
                                    <xsl:element name="enumeration">
                                        <xsl:value-of select="do:message(concat('    enum:', normalize-space(tbody/tr[1]/th[1]/p/strong/text()[1]) = 'Enumeration'))"/>
                                        <xsl:value-of select="normalize-space(tbody/tr[1]/th[1]/p/strong/text()[1]) = 'Enumeration'"/>
                                    </xsl:element>
                                    <!-- NormalClassName -->
                                    <xsl:element name="className">
                                        <xsl:value-of select="tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1]"/>
                                    </xsl:element>
                                    <!-- NormalClassName with generic-parameters stripped -->
                                    <xsl:element name="classFileName">
                                        <xsl:value-of select="do:message(concat('    filename:', tokenize(tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1], '&lt;')[1]))"/>
                                        <xsl:value-of select="tokenize(tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1], '&lt;')[1]"/>
                                    </xsl:element>
                                    <!-- UPPERCASE_UNDERSCORE_CLASSNAME (abstract) -->
                                    <xsl:element name="classNameOrg">
                                        <xsl:value-of select="do:message(concat('    classNameOrg:', $className))"/>
                                        <xsl:value-of select="$className"/>
                                    </xsl:element>
                                    <!-- UPPERCASE_UNDERSCORE_CLASSNAME -->
                                    <xsl:element name="classNameOrgAbstractStripped">
                                        <xsl:variable name="classNameOrgAbstractStripped" as="xs:string">
                                            <xsl:choose>
                                                <xsl:when test="contains($className, '(')">
                                                    <xsl:value-of select="normalize-space(tokenize($className, '\(')[1])"/>
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <xsl:value-of select="$className"/>
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </xsl:variable>
                                        <xsl:value-of select="do:message(concat('    classNameOrgAbstractStripped:', $classNameOrgAbstractStripped))"/>
                                        <xsl:value-of select="$classNameOrgAbstractStripped"/>
                                    </xsl:element>
                                    <!-- Class Comments -->
                                    <xsl:for-each select="tbody/tr[2]/td/div">
                                        <xsl:variable name="classComment" select="."/>
                                        <xsl:if test="string-length($classComment) > 0">
                                            <xsl:element name="classComment">
                                                <xsl:value-of select="do:message(concat('    comm:', normalize-space($classComment)))"/>
                                                <xsl:value-of select="normalize-space($classComment)"/>
                                            </xsl:element>
                                        </xsl:if>
                                    </xsl:for-each>
                                    <xsl:for-each select="tbody/tr[3]/td/p/code">
                                        <xsl:choose>
                                            <xsl:when test="not(do:is-value-in-sequence(normalize-space(.), $implements))">
                                                <!-- ClassNames from parents (evt more then one) -->
                                                <xsl:variable name="inherit" as="xs:string" select="do:snakeUpperCaseToCamelCase(normalize-space(.), 0)"/>
                                                <xsl:value-of select="do:message(concat('         inherit:', $inherit))"/>
                                                <xsl:element name="inherit">
                                                    <xsl:value-of select="$inherit"/>
                                                </xsl:element>
                                                <!-- CLASS_NAMES from parents (original) -->
                                                <xsl:variable name="inheritOrg" as="xs:string" select="normalize-space(.)"/>
                                                <xsl:value-of select="do:message(concat('INHERITANCE:    ', $inheritOrg))"/>
                                                <xsl:element name="inheritOrg">
                                                    <xsl:value-of select="normalize-space($inheritOrg)"/>
                                                </xsl:element>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <!-- ClassNames from parents (evt more then one) -->
                                                <xsl:variable name="implement" as="xs:string" select="do:snakeUpperCaseToCamelCase(normalize-space(.), 0)"/>
                                                <xsl:value-of select="do:message(concat('         implement:', $implement))"/>
                                                <xsl:element name="implement">
                                                    <xsl:value-of select="$implement"/>
                                                </xsl:element>
                                                <!-- CLASS_NAMES from parents (original) -->
                                                <xsl:variable name="implementOrg" as="xs:string" select="normalize-space(.)"/>
                                                <xsl:value-of select="do:message(concat('IMPLEMENT:    ', $implementOrg))"/>
                                                <xsl:element name="implementOrg">
                                                    <xsl:value-of select="normalize-space($implementOrg)"/>
                                                </xsl:element>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </xsl:for-each>
                                    <!-- Functions and Attributes and enum-values -->
                                    <xsl:element name="functionsAndAttributesAndConstants">
                                        <xsl:for-each select="tbody/tr">
                                            <xsl:variable name="cardinality" select="string(normalize-space(string-join(th/p)))"/>
                                            <xsl:variable name="nameAndType" select="string(normalize-space(string-join(td[1]/p)))"/>
                                            <xsl:variable name="description" select="string(normalize-space(string-join(td[2])))"/>
                                            <xsl:if test="string-length(normalize-space($nameAndType)) > 0 and not($cardinality = 'Inherit')">
                                                <xsl:element name="nameAndTypeAndKind">
                                                    <xsl:choose>
                                                        <!-- enumeration -->
                                                        <xsl:when test="normalize-space($cardinality) = ''">
                                                            <xsl:variable name="enumType" select="do:snakeUpperCaseToCamelCase(normalize-space($nameAndType), 1)"/>
                                                            <xsl:variable name="kind" select="'enum-value'"/>
                                                            <xsl:element name="enumType">
                                                                <xsl:value-of select="$enumType"/>
                                                            </xsl:element>
                                                            <xsl:element name="kind">
                                                                <xsl:value-of select="$kind"/>
                                                            </xsl:element>
                                                            <xsl:value-of select="do:message(concat('            kind: ', $kind, ', name: ', $enumType))"/>
                                                        </xsl:when>
                                                        <!-- function or attribute -->
                                                        <xsl:otherwise>
                                                            <xsl:choose>
                                                                <!-- functions -->
                                                                <xsl:when test="contains($nameAndType, ')')">
                                                                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(normalize-space(substring-before($nameAndType, '(')), 1)"/>
                                                                    <xsl:element name="name">
                                                                        <xsl:value-of select="$name"/>
                                                                    </xsl:element>
                                                                    <xsl:value-of select="do:message(concat('            ---function:', $name))"/>
                                                                    <!-- kind of function -->
                                                                    <xsl:variable name="kind">
                                                                        <xsl:choose>
                                                                            <!-- value-function -->
                                                                            <xsl:when test="contains(substring-after($nameAndType, ')'), ':')">
                                                                                <xsl:value-of select="'value-function'"/>
                                                                            </xsl:when>
                                                                            <!-- void function -->
                                                                            <xsl:otherwise>
                                                                                <xsl:value-of select="'void-function'"/>
                                                                            </xsl:otherwise>
                                                                        </xsl:choose>
                                                                    </xsl:variable>
                                                                    <!-- function return-type -->
                                                                    <xsl:variable name="return-type">
                                                                        <xsl:choose>
                                                                            <!-- value-function -->
                                                                            <xsl:when test="contains(substring-after($nameAndType, ')'), ':')">
                                                                                <xsl:value-of select="normalize-space(do:substring-after-last($nameAndType, ':'))"/>
                                                                            </xsl:when>
                                                                            <!-- void function -->
                                                                            <xsl:otherwise>
                                                                                <xsl:value-of select="'void'"/>
                                                                            </xsl:otherwise>
                                                                        </xsl:choose>
                                                                    </xsl:variable>
                                                                    <xsl:variable name="container"
                                                                        select="starts-with(lower-case($return-type), 'list') or starts-with(lower-case($return-type), 'set') or starts-with(lower-case($return-type), 'hash') or starts-with(lower-case($return-type), 'container')"/>
                                                                    <xsl:element name="container">
                                                                        <xsl:value-of select="$container"/>
                                                                    </xsl:element>
                                                                    <xsl:element name="type">
                                                                        <xsl:value-of select="$return-type"/>
                                                                    </xsl:element>
                                                                    <xsl:element name="kind">
                                                                        <xsl:value-of select="$kind"/>
                                                                    </xsl:element>
                                                                    <xsl:value-of
                                                                        select="do:message(concat('            kind:', $kind, ', name: ', $name, ', return-type: ', $return-type, ', cardinality:', $cardinality))"/>
                                                                    <!-- function parameters -->
                                                                    <xsl:element name="parameters">
                                                                        <xsl:variable name="parameterPart" select="normalize-space(substring-after(substring-before($nameAndType, ')'), '('))"/>
                                                                        <xsl:value-of select="do:message(concat('            parameterPart:', $parameterPart))"/>
                                                                        <xsl:value-of select="$parameterPart"/>
                                                                        <xsl:for-each select="tokenize($parameterPart, ',')">
                                                                            <xsl:value-of select="do:message(concat('                parameter:', normalize-space(.)))"/>
                                                                            <xsl:element name="parameter">
                                                                                <xsl:element name="name">
                                                                                    <xsl:variable name="name">
                                                                                        <xsl:choose>
                                                                                            <xsl:when test="contains(., ':')">
                                                                                                <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(substring-before(., ':')), 1)"/>
                                                                                            </xsl:when>
                                                                                            <xsl:otherwise>
                                                                                                <xsl:value-of select="."/>
                                                                                            </xsl:otherwise>
                                                                                        </xsl:choose>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of select="do:message(concat('                    name:', $name))"/>
                                                                                    <xsl:value-of select="normalize-space(substring-before(., ':'))"/>
                                                                                </xsl:element>
                                                                                <xsl:element name="type">
                                                                                    <xsl:variable name="type">
                                                                                        <xsl:if test="contains(., ':')">
                                                                                            <xsl:value-of select="normalize-space(substring-after(., ':'))"/>
                                                                                        </xsl:if>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of select="do:message(concat('                    type:', $type))"/>
                                                                                    <xsl:variable name="type-name">
                                                                                        <xsl:choose>
                                                                                            <xsl:when test="contains(normalize-space(substring-after(., ':')), '[')">
                                                                                                <xsl:value-of select="normalize-space(substring-before($type, '['))"/>
                                                                                            </xsl:when>
                                                                                            <xsl:otherwise>
                                                                                                <xsl:value-of select="normalize-space($type)"/>
                                                                                            </xsl:otherwise>
                                                                                        </xsl:choose>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of select="do:message(concat('                    type-name:', $type-name))"/>
                                                                                    <xsl:variable name="type-cardinality">
                                                                                        <xsl:if test="contains($type, '[')">
                                                                                            <xsl:value-of select="substring-after(normalize-space(substring-before($type, ']')), '[')"/>
                                                                                        </xsl:if>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of select="do:message(concat('                    type-cardinality:', $type-cardinality))"/>
                                                                                    <xsl:variable name="container"
                                                                                        select="starts-with(lower-case($type-name), 'list') or starts-with(lower-case($type-name), 'set') or starts-with(lower-case($type-name), 'hash') or starts-with(lower-case($type-name), 'container')"/>
                                                                                    <xsl:element name="container">
                                                                                        <xsl:value-of select="$container"/>
                                                                                    </xsl:element>
                                                                                    <xsl:element name="type-name">
                                                                                        <xsl:value-of select="$type-name"/>
                                                                                    </xsl:element>
                                                                                    <xsl:element name="type-cardinality">
                                                                                        <xsl:value-of select="$type-cardinality"/>
                                                                                    </xsl:element>
                                                                                </xsl:element>
                                                                            </xsl:element>
                                                                        </xsl:for-each>
                                                                    </xsl:element>
                                                                </xsl:when>
                                                                <xsl:otherwise>
                                                                    <xsl:choose>
                                                                        <xsl:when test="contains($nameAndType, '=')">
                                                                            <xsl:variable name="name" select="normalize-space(substring-before($nameAndType, ':'))"/>
                                                                            <xsl:variable name="type"
                                                                                select="replace(normalize-space(substring-before(normalize-space(substring-after($nameAndType, ':')), '=')), '&#160;', '')"/>
                                                                            <xsl:variable name="value" select="replace(normalize-space(substring-after($nameAndType, '=')), '&#160;', '')"/>
                                                                            <xsl:variable name="kind" select="'constant'"/>
                                                                            <xsl:element name="name">
                                                                                <xsl:value-of select="$name"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="type">
                                                                                <xsl:value-of select="$type"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="value">
                                                                                <xsl:value-of select="$value"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="kind">
                                                                                <xsl:value-of select="$kind"/>
                                                                            </xsl:element>
                                                                            <xsl:value-of
                                                                                select="do:message(concat('            ', $kind, ', name: ', $name, ' type: ', $type, '  value:', $value, ', cardinality:', $cardinality))"
                                                                            />
                                                                        </xsl:when>
                                                                        <!-- attribute -->
                                                                        <xsl:otherwise>
                                                                            <xsl:variable name="name" select="normalize-space(substring-before($nameAndType, ':'))"/>
                                                                            <xsl:variable name="type" select="normalize-space(substring-after($nameAndType, ':'))"/>
                                                                            <xsl:variable name="container"
                                                                                select="starts-with(lower-case($type), 'list') or starts-with(lower-case($type), 'set') or starts-with(lower-case($type), 'hash') or starts-with(lower-case($type), 'container')"/>
                                                                            <xsl:variable name="kind" select="'attribute'"/>
                                                                            <xsl:element name="name">
                                                                                <xsl:value-of select="$name"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="type">
                                                                                <xsl:value-of select="$type"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="container">
                                                                                <xsl:value-of select="$container"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="kind">
                                                                                <xsl:value-of select="$kind"/>
                                                                            </xsl:element>
                                                                            <xsl:value-of
                                                                                select="do:message(concat('            ---', $kind, ', name: ', $name, ', type: ', $type, ', container:', $container, ', cardinality:', $cardinality))"
                                                                            />
                                                                        </xsl:otherwise>
                                                                    </xsl:choose>
                                                                </xsl:otherwise>
                                                            </xsl:choose>
                                                            <xsl:element name="cardinality">
                                                                <xsl:value-of select="$cardinality"/>
                                                            </xsl:element>
                                                        </xsl:otherwise>
                                                    </xsl:choose>
                                                    <xsl:element name="description">
                                                        <xsl:value-of select="normalize-space($description)"/>
                                                    </xsl:element>
                                                </xsl:element>
                                            </xsl:if>
                                        </xsl:for-each>
                                    </xsl:element>
                                </xsl:element>
                            </xsl:variable>
                            <xsl:copy-of select="$class"/>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:element>
            </xsl:variable>
            <xsl:copy-of select="$package"/>
        </xsl:if>
    </xsl:template>

    <xsl:function name="do:is-value-in-sequence" as="xs:boolean">
        <xsl:param name="value" as="xs:anyAtomicType?"/>
        <xsl:param name="seq" as="xs:anyAtomicType*"/>
        <xsl:sequence select="$value = $seq"/>
    </xsl:function>

    <xsl:function name="do:basePackageInfo">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="directory"/>
        <xsl:value-of select="do:output(concat('package ', $directory, ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat(' Title: ', $context/html/head[1]/title[1]))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)')"/>
        <xsl:value-of select="do:commentOutput('From BMM-document:')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
            select="
                do:commentOutput(concat(
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4])))"
        />
    </xsl:function>

    <xsl:function name="do:getIncludes">
        <xsl:param name="packages"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="allClasses" as="xs:string*"/>
        <xsl:sequence>
            <xsl:for-each select="$class/inheritOrg">
                <xsl:value-of select="./text()"/>
            </xsl:for-each>
            <xsl:for-each select="$class/implementOrg">
                <xsl:value-of select="./text()"/>
            </xsl:for-each>
            <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                <xsl:if test="kind = 'attribute' or kind = 'void-function' or kind = 'value-function'">
                    <xsl:choose>
                        <xsl:when test="container = true()">
                            <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after(type, '&lt;'), '&gt;'), ',')"/>
                            <xsl:for-each select="$types">
                                <xsl:if test="do:is-value-in-sequence(., $allClasses)">
                                    <xsl:value-of select="."/>
                                </xsl:if>
                            </xsl:for-each>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:if test="do:is-value-in-sequence(type, $allClasses)">
                                <xsl:value-of select="type"/>
                            </xsl:if>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:if>
                <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                    <xsl:for-each select="parameters/parameter">
                        <xsl:choose>
                            <xsl:when test="type/container = true()">
                                <xsl:variable name="types" as="xs:string*" select="tokenize(substring-before(substring-after(type/type-name, '&lt;'), '&gt;'), ',')"/>
                                <xsl:for-each select="$types">
                                    <xsl:if test="do:is-value-in-sequence(., $allClasses)">
                                        <xsl:value-of select="."/>
                                    </xsl:if>
                                </xsl:for-each>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:if test="do:is-value-in-sequence(type/type-name, $allClasses)">
                                    <xsl:value-of select="type/type-name"/>
                                </xsl:if>
                            </xsl:otherwise>
                        </xsl:choose>

                    </xsl:for-each>
                </xsl:if>
            </xsl:for-each>
        </xsl:sequence>
    </xsl:function>

    <xsl:function name="do:addToIncludes">
        <xsl:param name="packages"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="classNameToAdd" as="xs:string"/>
        <xsl:variable name="classToAdd" select="do:findClass($packages, $classNameToAdd)"/>
        <xsl:variable name="includeToAdd" select="$classToAdd/packageDirectory"/>
        <xsl:if test="not($class[include/text() = $includeToAdd]) and not($class/../../packageDirectory = $includeToAdd)">
            <xsl:value-of select="$includeToAdd"/>
        </xsl:if>
    </xsl:function>

    <xsl:function name="do:snakeUpperCaseToCamelCase">
        <xsl:param name="className"/>
        <xsl:param name="lowerStart"/>
        <xsl:variable name="upper-case" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'"/>
        <xsl:variable name="lower-case" select="'abcdefghijklmnopqrstuvwxyz'"/>
        <xsl:variable name="new-name">
            <xsl:for-each select="tokenize($className, '_')">
                <xsl:choose>
                    <xsl:when test="position() = $lowerStart">
                        <xsl:value-of select="translate(., $upper-case, $lower-case)"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="translate(substring(., 1, 1), $lower-case, $upper-case)"/>
                        <xsl:value-of select="translate(substring(., 2), $upper-case, $lower-case)"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </xsl:variable>
        <xsl:value-of select="$new-name"/>
    </xsl:function>

    <xsl:function name="do:output">
        <xsl:param name="input" as="xs:string"/>
        <xsl:value-of select="concat(normalize-space(string-join($input)), $newline)"/>
    </xsl:function>

    <xsl:function name="do:outputSpaces">
        <xsl:param name="input" as="xs:string"/>
        <xsl:value-of select="concat(string-join($input), $newline)"/>
    </xsl:function>

    <xsl:function name="do:commentOutput">
        <xsl:param name="input" as="xs:string*"/>
        <xsl:value-of select="concat(' * ', replace(normalize-space(string-join($input)), '\. ', concat('.', $newline, ' * ')), $newline)"/>
    </xsl:function>

    <xsl:function name="do:commentOpen">
        <xsl:value-of select="do:output('/**')"/>
        <xsl:value-of select="do:commentOutput('')"/>
    </xsl:function>

    <xsl:function name="do:commentClose">
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:output(' */')"/>
    </xsl:function>

    <xsl:function name="do:substring-after-last" as="xs:string">
        <xsl:param name="arg" as="xs:string?"/>
        <xsl:param name="delim" as="xs:string"/>
        <xsl:sequence select="
                replace($arg, concat('^.*', do:escape-for-regex($delim)), '')
                "/>
    </xsl:function>

    <xsl:function name="do:escape-for-regex" as="xs:string">
        <xsl:param name="arg" as="xs:string?"/>
        <xsl:sequence select="
                replace($arg,
                '(\.|\[|\]|\\|\||\-|\^|\$|\?|\*|\+|\{|\}|\(|\))', '\\$1')
                "/>
    </xsl:function>

    <xsl:function name="do:message">
        <xsl:param name="message"/>
        <xsl:message>
            <xsl:value-of select="$message"/>
        </xsl:message>
    </xsl:function>

</xsl:stylesheet>
