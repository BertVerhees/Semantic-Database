<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:do="http://whatever"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="text"/>
    <xsl:variable name='newline' select="'&#xA;'"/>

    <xsl:template match="/">
        <xsl:element name="xs:schema" namespace="http://www.w3.org/2001/XMLSchema">
            <xsl:result-document href="src/bmm/package-info.java">
                <xsl:value-of select="do:output('package bmm;')"/>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:commentOpen()"/>
                <xsl:value-of select="do:commentOutput(concat(' Title: ', ./html/head[1]/title[1]))"/>
                <xsl:value-of select="do:commentOutput('')"/>
                <xsl:value-of select="do:commentOutput('Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)')"/>
                <xsl:value-of select="do:commentOutput('From BMM-document:')"/>
                <xsl:value-of select="do:commentOutput('')"/>
                <xsl:value-of select="do:commentOutput(concat(
                    /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/p[1]/text(),
                    ':',
                    /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]/text(),
                    ':',
                    /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/p[1]/text(),
                    ':',
                    /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/p[1]/text()))"/>
                <xsl:value-of select="do:commentClose()"/>
            </xsl:result-document>
            <xsl:for-each select="/html/body[1]/div[2]/div">
                <xsl:variable name="tag" select="h2[1]/a[1]/@href"/>
                <xsl:choose>
                    <xsl:when test="$tag='#_amendment_record' or $tag='#_acknowledgements' or $tag='#_preface' or $tag='#_overview'">
                    </xsl:when>
                    <xsl:when test="h2[1]/a[1]/@href='#_amendment_record'">
                    </xsl:when>
                    <xsl:when test="h2[1]/a[1]/@href='#_acknowledgements'">
                        <xsl:element name="xs:annotation">
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="'1'"/>
                                <xsl:value-of select="h2[1]"/>
                            </xsl:element>
                            <xsl:for-each select="div/div">
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="h3"/>
                                </xsl:element>
                                <xsl:for-each select="div/ul/li">
                                    <xsl:element name="xs:documentation">
                                        <xsl:value-of select="p/text()"/>
                                    </xsl:element>
                                </xsl:for-each>
                            </xsl:for-each>
                        </xsl:element>
                    </xsl:when>
                    <xsl:when test="h2[1]/a[1]/@href='#_preface'">
                        <xsl:element name="xs:annotation">
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="'2'"/>
                                <xsl:value-of select="h2[1]"/>
                            </xsl:element>
                            <xsl:for-each select="div/div">
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="h3"/>
                                </xsl:element>
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="div/p/text()"/>
                                </xsl:element>
                            </xsl:for-each>
                        </xsl:element>
                    </xsl:when>
                    <xsl:when test="h2[1]/a[1]/@href='#_overview'">
                        <xsl:element name="xs:annotation">
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="'3'"/>
                                <xsl:value-of select="h2[1]"/>
                            </xsl:element>
                            <xsl:for-each select="div/div">
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="h3"/>
                                </xsl:element>
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="div/p/text()"/>
                                </xsl:element>
                            </xsl:for-each>
                        </xsl:element>
                    </xsl:when>
                </xsl:choose>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>
    
    <xsl:function name="do:output">
        <xsl:param name="input" as="xs:string"></xsl:param>
        <xsl:value-of select="concat(normalize-space($input), $newline)"/>
    </xsl:function>
    
    <xsl:function name="do:commentOutput">
        <xsl:param name="input" as="xs:string"></xsl:param>
        <xsl:value-of select="concat(' * ', normalize-space($input), $newline)"/>
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