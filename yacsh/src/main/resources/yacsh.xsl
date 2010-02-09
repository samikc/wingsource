<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="4.0" encoding="iso-8859-1" indent="yes"/>


	<xsl:template match="/">
	<html>	
	<head>
	<title>Test XSLT</title>
	<xsl:for-each select="//link[@type='CSS']">
		<link rel="stylesheet" href="{@url}"></link>
	</xsl:for-each>
	</head>
	<body>
	<xsl:for-each select="//layout">
		<ul class="column" style='width:{width}%'>
		<xsl:for-each select="gadget">
			<li id='{uuid}' class="gadgets-gadget-chrome" spec='{url}'><xsl:value-of select="title"></xsl:value-of></li>		
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