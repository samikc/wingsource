<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"
    doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
    version="4.0" 
    media-type="text/html"
    encoding="iso-8859-1" 
    indent="yes"/>
	<xsl:template match="/">
	<html>	
	<head>
	<title>Test XSLT</title>
	<xsl:for-each select="//link[@type='CSS']">
		<link rel="stylesheet" href="{@url}"></link>
	</xsl:for-each>
	</head>
	<body>
			<xsl:for-each select="//panel">
				<ul class="column" style='width:{width}%'>
				<xsl:for-each select="gadget">
					<xsl:choose>
						<xsl:when test="content">
							<li id='{uuid}' spec='{url}'><xsl:value-of select="content" disable-output-escaping="yes" ></xsl:value-of></li>
						</xsl:when>
						<xsl:otherwise>
							<li id='{uuid}' class="gadgets-gadget-chrome" spec='{url}'><xsl:value-of select="title"></xsl:value-of></li>
						</xsl:otherwise>
					</xsl:choose>
							
				</xsl:for-each>
				</ul>
			</xsl:for-each>
	</body>
	<xsl:for-each select="//link[@type='js']">
		<script type="text/javascript" src="{@url}"></script>
	</xsl:for-each>
	</html>
	</xsl:template>
</xsl:stylesheet>