<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="xml" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <xsl:element name="xs:schema" namespace="http://www.w3.org/2001/XMLSchema">
            <xsl:element name="xs:annotation">
                <xsl:element name="xs:documentation">
                    <xsl:value-of select="./html/head[1]/title[1]"/>
                </xsl:element>
                <xsl:element name="xs:documentation">
                    <xsl:value-of select="'XSD Created by Bert Verhees'"/>
                </xsl:element>
                <xsl:element name="xs:documentation">
                    <xsl:value-of select="'From BMM-document:'"/>
                </xsl:element>
                <xsl:element name="xs:documentation">
                    <xsl:value-of select="concat(
                        /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/p[1]/text(),
                        ':',
                        /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]/text(),
                        ':',
                        /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/p[1]/text(),
                        ':',
                        /html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/p[1]/text())"/>
                </xsl:element>
            </xsl:element>
            <xsl:for-each select="/html/body[1]/div[2]/div[4]">
                <xsl:for-each select="div[1]/div[1]">
                    <xsl:element name="xs:annotation">
                        <xsl:element name="xs:documentation">
                            <xsl:value-of select="h3[1]"/>
                        </xsl:element>
                        <xsl:for-each select="div[1]/ul[1]/li[1]/p[1]">
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="h3"/>
                            </xsl:element>
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="div[1]/p/text()"/>
                            </xsl:element>
                        </xsl:for-each>
                    </xsl:element>
                </xsl:for-each>
            </xsl:for-each>
            <xsl:for-each select="/html/body[1]/div[2]/div[5]">
                <xsl:choose>
                    <xsl:when test="h2[1]/a[1]/@href='#_preface'">
                        <xsl:element name="xs:annotation">
                            <xsl:element name="xs:documentation">
                                <xsl:value-of select="h2[1]"/>
                            </xsl:element>
                            <xsl:for-each select="div[1]/div">
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="h3"/>
                                </xsl:element>
                                <xsl:element name="xs:documentation">
                                    <xsl:value-of select="div[1]/p/text()"/>
                                </xsl:element>
                            </xsl:for-each>
                        </xsl:element>
                    </xsl:when>
                </xsl:choose>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>
    
</xsl:stylesheet>