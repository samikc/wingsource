//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.14 at 11:49:44 AM IST 
//


package org.wingsource.plugin.lang.xml.crawler;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wingsource.plugin.lang.xml.crawler package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wingsource.plugin.lang.xml.crawler
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Required }
     * 
     */
    public Required createRequired() {
        return new Required();
    }

    /**
     * Create an instance of {@link Crawler }
     * 
     */
    public Crawler createCrawler() {
        return new Crawler();
    }

}
