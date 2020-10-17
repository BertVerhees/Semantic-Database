<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:do="http://whatever" exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>

    <xsl:template match="/">
        <xsl:variable name="baseDirectory" select="'bmm'"/>
        <xsl:result-document href="src/{$baseDirectory}/package-info.java">
            <xsl:value-of select="do:basePackageInfo(document(concat($baseDirectory,'.html')),$baseDirectory)"/>
        </xsl:result-document>
        <xsl:variable name="packages">
            <xsl:element name="packages">
                <xsl:for-each select="/html/body[1]/div[2]/div">
                    <xsl:variable name="tag" select="string(h2[1]/a[1]/@href)"/>
                    <xsl:variable name="packageName" select="substring($tag, 3)"/>
                    <xsl:variable name="packageDirectory" select="concat($baseDirectory,'/',$packageName)"/>
                    <xsl:element name="package">
                        <xsl:element name="packageInfo">
                            <xsl:value-of select="do:commentOutput('')"/>
                            <xsl:value-of select="do:commentOutput(h2[1])"/>
                            <xsl:for-each select="div/div">
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
                        </xsl:element>
                        <xsl:element name="packageDirectory"><xsl:value-of select="$packageDirectory"/></xsl:element>
                        <xsl:for-each
                            select="descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                            <xsl:variable name="className" select="normalize-space(tbody/tr[1]/th[2]/p/strong/text()[1])"/>
                            <xsl:if test="string-length($className) > 0">
                                <xsl:element name="class">
                                    <xsl:element name="className"><xsl:value-of select="do:snakeUpperCaseToCamelCase($className, 0)"/></xsl:element>
                                    <xsl:for-each select="tbody/tr[2]/td/div">
                                        <xsl:variable name="classComment" select="."/>
                                        <xsl:if test="string-length($classComment)>0">
                                            <xsl:element name="classComment">
                                                <xsl:value-of select="normalize-space($classComment)"/>
                                            </xsl:element>
                                        </xsl:if>
                                    </xsl:for-each>
                                    <xsl:for-each select="tbody/tr[3]/td/p/code">
                                        <xsl:variable name="inherit" select="."/>
                                        <xsl:element name="inherit">
                                            <xsl:value-of select="do:snakeUpperCaseToCamelCase($inherit,0)"/>
                                        </xsl:element>
                                    </xsl:for-each>
                                    <xsl:for-each select="tbody/tr">
                                        <xsl:choose>
                                            <xsl:when test="contains(/td[1]/p, '(')">
                                                <xsl:element name="function">
                                                    <xsl:element name="cardinality">
                                                        <xsl:value-of select="/th[1]/p[1]/strong[1]"/>
                                                    </xsl:element>
                                                    <xsl:element name="nameAndType">
                                                        <xsl:value-of select="/td[1]/p"/>
                                                    </xsl:element>
                                                    <xsl:element name="description">
                                                        <xsl:value-of select="/td[2]/div"/>
                                                    </xsl:element>
                                                </xsl:element>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <xsl:element name="attribute">
                                                    <xsl:element name="cardinality">
                                                        <xsl:value-of select="/th[1]/p[1]/strong[1]"/>
                                                    </xsl:element>
                                                    <xsl:element name="nameAndType">
                                                        <xsl:value-of select="/td[1]/p"/>
                                                    </xsl:element>
                                                    <xsl:element name="description">
                                                        <xsl:value-of select="/td[2]/div"/>
                                                    </xsl:element>
                                                </xsl:element>
                                            </xsl:otherwise>
                                            
                                        </xsl:choose>
                                    </xsl:for-each>
<!--                                    /html/body[1]/div[2]/div[7]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[4]/td[1]/p[1]
                                    /html/body[1]/div[2]/div[7]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[4]/td[2]/div[1]
                                    /html/body[1]/div[2]/div[8]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[6]/th[1]/p[1]/strong[1]
                                    /html/body[1]/div[2]/div[8]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[4]/th[1]/p[1]/strong[1]
                                    /html/body[1]/div[2]/div[8]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[5]
-->                                </xsl:element>
                            </xsl:if>
                        </xsl:for-each>
                    </xsl:element>
                </xsl:for-each>
            </xsl:element>
        </xsl:variable>
        <xsl:for-each select="$packages">
            <xsl:message><xsl:value-of select="text()"/></xsl:message>
        </xsl:for-each>
    </xsl:template>


    <xsl:function name="do:analyzeClassDocument">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="baseDirectory"></xsl:param>
        <xsl:for-each select="$context/html/body[1]/div[2]/div">
            <xsl:variable name="tag" select="string(h2[1]/a[1]/@href)"/>
            <xsl:variable name="packageName" select="substring($tag, 3)"/>
            <xsl:variable name="packageDirectory" select="concat($baseDirectory,'/',$packageName)"/>
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
                        <xsl:value-of select="do:commentOutput('')"/>
                        <xsl:value-of select="do:commentOutput(h2[1])"/>
                        <xsl:for-each select="div/div">
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
                    </xsl:element>
                    <xsl:element name="packageDirectory"><xsl:value-of select="$packageDirectory"/></xsl:element>
                    <xsl:for-each
                        select="descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                        <xsl:element name="class">
                            <xsl:variable name="className" select="normalize-space(tbody/tr[1]/th[2]/p/strong/text()[1])"/>
                            <xsl:if test="string-length($className) > 0">
                                <xsl:element name="className"><xsl:value-of select="do:snakeUpperCaseToCamelCase($className, 0)"/></xsl:element>
                            </xsl:if>
                            <xsl:for-each select="tbody/tr[2]/td/div">
                                <xsl:variable name="classComment" select="."/>
                                <xsl:if test="string-length($className) > 0">
                                    <xsl:value-of select="concat('classComment:', normalize-space($classComment))"/>
                                </xsl:if>
                            </xsl:for-each>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <xsl:element name="class"> </xsl:element>
        </xsl:for-each>
    </xsl:function>
    
    <xsl:function name="do:basePackageInfo">
        <xsl:param name="context" as="node()"></xsl:param>
        <xsl:param name="directory"></xsl:param>
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
            normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4])))"/>
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
                        <xsl:value-of
                            select="translate(substring(., 1, 1), $lower-case, $upper-case)"/>
                        <xsl:value-of select="translate(substring(., 2), $upper-case, $lower-case)"
                        />
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

    <xsl:function name="do:commentOutput">
        <xsl:param name="input" as="xs:string*"/>
        <xsl:value-of select="concat(' * ', normalize-space(string-join($input)), $newline)"/>
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
