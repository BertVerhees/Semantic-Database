<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:do="http://whatever" exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>

    <xsl:template match="/">
        <xsl:variable name="classes" select="do:analyzeClassDocument(document('bmm.html'))"/>
        <xsl:result-document href="src/bmm/package-info.java">
            <xsl:value-of select="do:handleTextDocument('bmm',document('bmm.html'))"/>
        </xsl:result-document>
    </xsl:template>
    
    <xsl:function name="do:analyzeClassDocument">
        <xsl:param name="context"></xsl:param>
        <xsl:element name="class">
            <xsl:for-each select="$context/html/body[1]/div[2]/div">
            </xsl:for-each>
        </xsl:element>
    </xsl:function>
    
    <xsl:function name="do:handleTextDocument">
        <xsl:param name="directory"/>
        <xsl:param name="context"></xsl:param>
        <xsl:value-of select="do:output(concat('package ',$directory,';'))"/>
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
                <xsl:when test="h2[1]/a[1]/@href = '#_acknowledgements'">
                    <xsl:value-of select="do:commentOutput('')"/>
                    <xsl:value-of select="do:commentOutput(h2[1])"/>
                    <xsl:for-each select="div/div">
                        <xsl:value-of select="do:commentOutput(h3)"/>
                        <xsl:for-each select="div/ul/li">
                            <xsl:value-of select="do:commentOutput(.)"/>
                        </xsl:for-each>
                    </xsl:for-each>
                </xsl:when>
                <xsl:when test="h2[1]/a[1]/@href = '#_amendment_record'"> </xsl:when>
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
