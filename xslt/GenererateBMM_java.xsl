<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:do="http://whatever" exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>

    <xsl:template match="/">
        <xsl:for-each select="document('bmm.html')/html/body[1]/div[2]/div[@class = 'sect1']">
            <xsl:variable name="tag" select="string(h2[1]/a[1]/@href)"/>
            <xsl:if
                test="not($tag = '#_preface' or $tag = '#_acknowledgements' or $tag = '#_amendment_record')">
                <xsl:element name="package">
                    <xsl:element name="packageInfo">
<!--                        <xsl:message>
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
                            
                        </xsl:message>
-->                    </xsl:element>
                    <xsl:element name="packageName">
                        <xsl:message>
                            <xsl:value-of select="substring($tag, 3)"/>
                        </xsl:message>
                    </xsl:element>
                    <xsl:for-each
                        select="descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                        <xsl:variable name="className" select="normalize-space(tbody/tr[1]/th[2]/p/strong/text()[1])"/>
                        <xsl:if test="string-length($className) > 0">
                            <xsl:message><xsl:value-of select="do:snakeUpperCaseToCamelCase($className, 0)"/></xsl:message>
                        </xsl:if>
                        <xsl:for-each select="tbody/tr[2]/td/div">
                            <xsl:variable name="classComment" select="./div[position()]/p"/>
                            <xsl:if test="string-length($className) > 0">
                                <xsl:message><xsl:value-of select="normalize-space($classComment)"/></xsl:message>
                            </xsl:if>
                        </xsl:for-each>
                    </xsl:for-each>
                </xsl:element>
                <xsl:element name="class"> </xsl:element>
            </xsl:if>
        </xsl:for-each>

        <xsl:variable name="packages" select="do:analyzeClassDocument(document('bmm.html'))"/>
        <xsl:result-document href="src/bmm/package-info.java">
            <xsl:value-of select="do:handleTextDocument('bmm', document('bmm.html'))"/>
        </xsl:result-document>
    </xsl:template>


    <xsl:function name="do:analyzeClassDocument">
        <xsl:param name="context"/>
        <xsl:for-each select="$context/html/body[1]/div[2]/div">
            <xsl:variable name="tag" select="string(h2[1]/a[1]/@href)"/>
            <xsl:if
                test="not($tag = '#_preface' or $tag = '#_acknowledgements' or $tag = '#_amendment_record')">
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
                    <xsl:element name="packageName"><xsl:value-of select="substring($tag, 3)"/></xsl:element>
                    <xsl:for-each
                        select="descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                        <xsl:element name="class">
                            <xsl:variable name="className" select="normalize-space(tbody/tr[1]/th[2]/p/strong/text()[1])"/>
                            <xsl:if test="string-length($className) > 0">
                                <xsl:element name="className"><xsl:value-of select="do:snakeUpperCaseToCamelCase($className, 0)"/></xsl:element>
                            </xsl:if>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <xsl:element name="class"> </xsl:element>
            </xsl:if>
        </xsl:for-each>
    </xsl:function>

    <xsl:function name="do:handleTextDocument">
        <xsl:param name="directory"/>
        <xsl:param name="context"/>
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
                $context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1],
                ':',
                $context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2],
                ':',
                $context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3],
                ':',
                $context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4]))"/>
        <xsl:for-each select="$context/html/body[1]/div[2]/div">
            <xsl:variable name="tag" select="h2[1]/a[1]/@href"/>
            <xsl:choose>
                <xsl:when test="$tag = '#_acknowledgements'">
                    <xsl:value-of select="do:commentOutput('')"/>
                    <xsl:value-of select="do:commentOutput(h2[1])"/>
                    <xsl:for-each select="div/div">
                        <xsl:value-of select="do:commentOutput(h3)"/>
                        <xsl:for-each select="div/ul/li">
                            <xsl:value-of select="do:commentOutput(.)"/>
                        </xsl:for-each>
                    </xsl:for-each>
                </xsl:when>
                <xsl:when test="$tag = '#_amendment_record'"> </xsl:when>
                <xsl:otherwise>
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
                </xsl:otherwise>
            </xsl:choose>
        </xsl:for-each>
        <xsl:value-of select="do:commentClose()"/>
    </xsl:function>

    <xsl:function name="do:snakeUpperCaseToCamelCase">
        <xsl:param name="className"/>
        <xsl:param name="upperStart"/>
        <xsl:variable name="upper-case" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'"/>
        <xsl:variable name="lower-case" select="'abcdefghijklmnopqrstuvwxyz'"/>
        <xsl:variable name="new-name">
            <xsl:for-each select="tokenize($className, '_')">

                <xsl:choose>
                    <xsl:when test="position() = $upperStart">
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
