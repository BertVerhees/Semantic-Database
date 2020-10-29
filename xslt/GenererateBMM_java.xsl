<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:do="http://whatever" exclude-result-prefixes="xs" version="2.0"
    >

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>
    <xsl:variable name="packageBase" select="'nl/rosa/semanticdatabase/'"/>
    <xsl:variable name="sourceBase" select="'src/main/java/'"/>
    
    <xsl:template match="/">
        <xsl:variable name="root">
            <xsl:element name="packages">
                <xsl:variable name="baseDirectory1" select="'bmm'"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:copy-of
                            select="do:basePackageInfo(document(concat($baseDirectory1, '.html')), concat($packageBase,$baseDirectory1))"
                        />
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
                        <xsl:copy-of
                            select="do:basePackageInfo(document(concat($baseDirectory2, '.html')), concat($packageBase,$baseDirectory2))"
                        />
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
        <xsl:for-each select="$root/packages/package">
            <xsl:variable name="pd" select="packageDirectory/text()"/>
            <xsl:variable name="package" select="."/>
            <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/package-info.java">
                <xsl:copy-of select="packageInfo"/>                
            </xsl:result-document>
            <xsl:for-each select="class">
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/{classFileName}.java">
                    <xsl:if test="enumeration=false()">
                        <xsl:value-of select="do:writeInterface($root/packages, $package, .)"/>
                    </xsl:if>
                    <xsl:if test="enumeration=true()">
                        <xsl:value-of select="do:writeEnumeration($root/packages, .)"/>
                    </xsl:if>
                </xsl:result-document>    
            </xsl:for-each>
            <xsl:for-each select="class">
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/{classFileName}Impl.java">
                    <xsl:if test="enumeration=false()">
                        <xsl:value-of select="do:writeClasses($root/packages, $package, .)"/>
                    </xsl:if>
                </xsl:result-document>    
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>
    
    <xsl:function name="do:writeClasses">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"></xsl:param>
        <xsl:param name="class" as="node()"></xsl:param>
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase,$package/packageDirectory),'/','.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:value-of select="do:output(concat('public class ',$class/className, 'Impl implements ', normalize-space(string-join($class/inherit,',')),'{'))"/>
        <xsl:element name="class">
            <xsl:copy-of select="do:getInheritedAttributes($packages, $class)"></xsl:copy-of>    
        </xsl:element>
        
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * ATTRIBUTE * */')"/>
        <xsl:for-each select="$class/attribute">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    private ',do:createFieldDeclaration($packages, $class,nameAndType)))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * POJO * */')"/>
        <xsl:for-each select="$class/attribute">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    public ',do:createGetterDeclaration($packages, $class,nameAndType)))"/>
            <xsl:value-of select="do:outputSpaces(concat('    public ',do:createSetterDeclaration($packages, $class,nameAndType)))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * FUNCTION * */')"/>
        <xsl:for-each select="$class/function">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentOutput(nameAndType)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    public ',do:createFunctionDeclaration($packages, $class,nameAndType)))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>
    
    <xsl:function name="do:getInheritedAttributes">
        <xsl:param name="packages" as="node()"></xsl:param>
        <xsl:param name="class" as="node()"></xsl:param>
        <xsl:message><xsl:value-of select="$class/className"/></xsl:message>
        <xsl:message><xsl:value-of select="count($class/attribute)"/></xsl:message>
        <xsl:variable name="result">
            <xsl:copy-of select="$class"/>
            <xsl:for-each select="$class/inheritOrg">
                <xsl:message><xsl:value-of select="."/></xsl:message>
                <xsl:variable name="inheritedClass" as="node()" select="do:findClass($packages,.)"/>
                <xsl:message><xsl:value-of select="$inheritedClass/classNameOrg"/></xsl:message>
                <xsl:if test="$inheritedClass">
                    <xsl:for-each select="$inheritedClass/attribute">
                        <xsl:message><xsl:value-of select="nameAndType"/></xsl:message>
                        <xsl:copy-of select="."></xsl:copy-of>    
                    </xsl:for-each>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:message><xsl:value-of select="count($result/attribute)"/></xsl:message>
        <xsl:value-of select="$result"/>
    </xsl:function>
    
    <xsl:function name="do:findClass">
        <xsl:param name="packages" as="node()"></xsl:param>
        <xsl:param name="classToFind" as="xs:string"></xsl:param>
        <xsl:variable name="result">
            <xsl:for-each select="$packages/package">
                <xsl:message><xsl:value-of select="count(./class)"/></xsl:message>
                <xsl:for-each select="class">
                    <xsl:message><xsl:value-of select="count(./class)"/></xsl:message>
                    <xsl:if test="classNameOrg=$classToFind">
                        <xsl:value-of select="."/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <xsl:message><xsl:value-of select="$result/classNameOrg"/></xsl:message>
        <xsl:value-of select="$result"/>
    </xsl:function>
    
    
    <xsl:function name="do:writeEnumeration">
        <xsl:param name="package" as="node()"></xsl:param>
        <xsl:param name="class" as="node()"></xsl:param>
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase,$package/packageDirectory),'/','.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:value-of select="do:output(concat('public enum ',$class/className, ' {'))"/>
        <xsl:for-each select="$class/attribute">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    ',nameAndType,','))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>
        
    <xsl:function name="do:writeInterface">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"></xsl:param>
        <xsl:param name="class" as="node()"></xsl:param>
        <xsl:value-of select="do:output(concat('package ', replace(concat($packageBase,$package/packageDirectory),'/','.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:choose>
            <xsl:when test="not(normalize-space(string-join($class/inherit,','))='')">
                <xsl:value-of select="do:output(concat('public interface ',$class/className, ' extends ', normalize-space(string-join($class/inherit,',')), ' {'))"/>        
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:output(concat('public interface ',$class/className, ' {'))"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * ATTRIBUTE * */')"/>
        <xsl:for-each select="$class/attribute">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    ',do:createGetterDeclaration($packages, $class, nameAndType)))"/>
            <xsl:value-of select="do:outputSpaces(concat('    ',do:createSetterDeclaration($packages, $class, nameAndType)))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/* * FUNCTION * */')"/>
        <xsl:for-each select="$class/function">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentOutput(nameAndType)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:value-of select="do:outputSpaces(concat('    ',do:createFunctionDeclaration($packages, $class,nameAndType)))"/>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>
    
    <xsl:function name="do:createFunctionDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:variable name="icS" select="normalize-space(tokenize($incomingString,'Post:')[1])"/>
        <xsl:variable name="name">
            <xsl:choose>
                <xsl:when test="not(contains(do:processFunctionName($context, $icS), '('))">
                    <xsl:value-of select="concat(do:processFunctionName($context, $icS), '()')"/>
                </xsl:when>
                <xsl:when test="not(contains(do:processFunctionName($context, $icS), ')'))">
                    <xsl:value-of select="concat(do:processFunctionName($context, $icS), ')')"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:processFunctionName($context, $icS)"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="concat($packages, do:processFunctionType($packages, $context, $icS),' ', $name, ';')"/>
    </xsl:function>
    
    <xsl:function name="do:createFieldDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:value-of select="concat(do:processAttributeType($packages, $context, $incomingString),' ',do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[1]),1),'();')"/>
    </xsl:function>
    
    <xsl:function name="do:createGetterDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:value-of select="concat(do:processAttributeType($packages, $context, $incomingString),' get',do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[1]),0),'();')"/>
    </xsl:function>
    
    <xsl:function name="do:createSetterDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:value-of select="concat('void set',do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[1]),0),'(value ',do:processAttributeType($packages, $context, $incomingString),');')"/>
    </xsl:function>

    <xsl:function name="do:processVariableName">
        <xsl:param name="incomingString"></xsl:param>
        <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[1]),1)"/>
    </xsl:function>

    <xsl:function name="do:processFunctionType">
        <xsl:param name="packages"></xsl:param>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:variable name="tokenizedIncomingSecondPartString" select="normalize-space(tokenize($incomingString,'\):')[2])"/>
        <xsl:message><xsl:value-of select="$tokenizedIncomingSecondPartString"/></xsl:message>
        <xsl:variable name="result">
            <xsl:choose>
                <!-- is a classname_org (underscore and uppercase) -->
                <xsl:when test="do:findClass($packages, $tokenizedIncomingSecondPartString) 
                    and count(tokenize($tokenizedIncomingSecondPartString, '_'))>1 
                    and upper-case($tokenizedIncomingSecondPartString)=$tokenizedIncomingSecondPartString">
                    <xsl:message><xsl:value-of select="$context/className"/></xsl:message>
                    <xsl:value-of select="$context/className"/>
                </xsl:when>
                <!-- is another kind of type (not an Internal class) -->
                <xsl:when test="count(tokenize($incomingString,'\):'))>1">
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase($tokenizedIncomingSecondPartString,0)"/>            
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="'void'"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$result"/>        
    </xsl:function>
    
    <xsl:function name="do:processFunctionName">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:variable name="result">
            <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,'\):')[1]),1)"/>            
        </xsl:variable>
        <xsl:value-of select="$result"/>        
    </xsl:function>
    
    <xsl:function name="do:processAttributeType">
        <xsl:param name="packages"></xsl:param>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"></xsl:param>
        <xsl:variable name="result">
            <xsl:choose>
                <xsl:when test="do:findClass($packages, normalize-space(tokenize($incomingString,':')[2]))">
                    <xsl:value-of select="$context/className"/>
                </xsl:when>
                <xsl:when test="count(tokenize($incomingString,':'))>1">
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[2]),0)"/>            
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="'void'"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$result"/>        
    </xsl:function>

    <xsl:function name="do:enumItem">
        <xsl:param name="incomingString"></xsl:param>
        <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString,':')[1]),1)"/>
    </xsl:function>

    <xsl:template name="analyzeClassDocument">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="baseDirectory"/>
        <xsl:variable name="tag" select="string($context/h2[1]/a[1]/@href)"/>
        <xsl:variable name="packageName" select="substring($tag, 3)"/>
        <xsl:if test="not($packageName='')">
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
                <xsl:for-each
                    select="$context/descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                    <xsl:variable name="className"
                        select="normalize-space(string-join(tbody/tr[1]/th[2]/p/strong))"/>
                    <xsl:if test="string-length($className) > 0">
                        <xsl:variable name="class">
                            <xsl:element name="class">
                                <!-- Check abstract by scanning for word abstract -->
                                <xsl:element name="abstract">
                                    <xsl:value-of select="contains(tbody/tr[1]/th[2]/p/strong,'(abstract)')"/>
                                </xsl:element>
                                <!-- check enumaration for checking the word enumeration -->
                                <xsl:element name="enumeration">
                                    <xsl:value-of select="normalize-space(tbody/tr[1]/th[1]/p/strong/text()[1])='Enumeration'"/>
                                </xsl:element>
                                <!-- NormalClassName -->
                                <xsl:element name="className">
                                    <xsl:value-of
                                        select="tokenize(do:snakeUpperCaseToCamelCase($className, 0),' ')[1]"/>
                                </xsl:element>
                                <!-- NormalClassName with generic-parameters stripped -->
                                <xsl:element name="classFileName">
                                    <xsl:value-of select="tokenize(tokenize(do:snakeUpperCaseToCamelCase($className, 0),' ')[1], '&lt;')[1]"/>
                                </xsl:element>
                                <!-- UPPERCASE_UNDERSCORE_CLASSNAME -->
                                <xsl:element name="classNameOrg">
                                    <xsl:value-of select="$className"/>
                                </xsl:element>
                                <!-- Class Comments -->
                                <xsl:for-each select="tbody/tr[2]/td/div">
                                    <xsl:variable name="classComment" select="."/>
                                    <xsl:if test="string-length($classComment) > 0">
                                        <xsl:element name="classComment">
                                            <xsl:value-of select="normalize-space($classComment)"/>
                                        </xsl:element>
                                    </xsl:if>
                                </xsl:for-each>
                                <xsl:for-each select="tbody/tr[3]/td/p/code">
                                    <!-- ClassNames from parents (evt more then one) -->
                                    <xsl:variable name="inherit" select="."/>
                                    <xsl:element name="inherit">
                                        <xsl:value-of
                                            select="do:snakeUpperCaseToCamelCase(normalize-space($inherit), 0)"/>
                                    </xsl:element>
                                    <!-- CLASS_NAMES from parents (original) -->
                                    <xsl:element name="inheritOrg">
                                        <xsl:value-of
                                            select="normalize-space($inherit)"/>
                                    </xsl:element>
                                </xsl:for-each>
                                <xsl:for-each select="tbody/tr">
                                    <xsl:variable name="cardinality"
                                        select="string(normalize-space(string-join(th/p)))"/>
                                    <xsl:variable name="nameAndType"
                                        select="string(normalize-space(string-join(td[1]/p)))"/>
                                    <xsl:variable name="description"
                                        select="string(normalize-space(string-join(td[2])))"/>
                                    <xsl:if
                                        test="string-length(normalize-space($nameAndType)) > 0 and not($cardinality = 'Inherit')">
                                        <xsl:choose>
                                            <!-- when there is a void function, there is no : in the signature and no (), that is why the double check -->
                                            <xsl:when test="not(contains($nameAndType, '(')) and not(contains($nameAndType, ':'))">
                                                <xsl:element name="attribute">
                                                    <xsl:element name="nameAndType">
                                                        <xsl:value-of select="$nameAndType"/>
                                                    </xsl:element>
                                                    <xsl:element name="description">
                                                        <xsl:value-of select="$description"/>
                                                    </xsl:element>
                                                </xsl:element>
                                            </xsl:when>
                                            <xsl:when test="contains($nameAndType, '(') or not(contains($nameAndType, ':'))">
                                                <xsl:element name="function">
                                                  <xsl:element name="cardinality">
                                                  <xsl:value-of select="$cardinality"/>
                                                  </xsl:element>
                                                  <xsl:element name="nameAndType">
                                                  <xsl:value-of select="$nameAndType"/>
                                                  </xsl:element>
                                                  <xsl:element name="description">
                                                  <xsl:value-of select="$description"/>
                                                  </xsl:element>
                                                </xsl:element>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <xsl:element name="attribute">
                                                  <xsl:element name="cardinality">
                                                    <xsl:value-of select="$cardinality"/>
                                                  </xsl:element>
                                                  <xsl:element name="nameAndType">
                                                  <xsl:value-of select="$nameAndType"/>
                                                  </xsl:element>
                                                  <xsl:element name="description">
                                                  <xsl:value-of select="$description"/>
                                                  </xsl:element>
                                                </xsl:element>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </xsl:if>
                                </xsl:for-each>
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

    <xsl:function name="do:basePackageInfo">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="directory"/>
        <xsl:value-of select="do:output(concat('package ', $directory, ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat(' Title: ', $context/html/head[1]/title[1]))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
            select="do:commentOutput('Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)')"/>
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
        <xsl:value-of select="concat(' * ', replace(normalize-space(string-join($input)),'\. ',concat('.',$newline, ' * ')), $newline)"/>
    </xsl:function>

    <xsl:function name="do:commentOpen">
        <xsl:value-of select="do:output('/**')"/>
        <xsl:value-of select="do:commentOutput('')"/>
    </xsl:function>
    <xsl:function name="do:commentClose">
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:output(' */')"/>
    </xsl:function>
</xsl:stylesheet>
