/*--

 Copyright (C) 2000-2012 Jason Hunter & Brett McLaughlin.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions, and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions, and the disclaimer that follows
    these conditions in the documentation and/or other materials
    provided with the distribution.

 3. The name "JDOM" must not be used to endorse or promote products
    derived from this software without prior written permission.  For
    written permission, please contact <request_AT_jdom_DOT_org>.

 4. Products derived from this software may not be called "JDOM", nor
    may "JDOM" appear in their name, without prior written permission
    from the JDOM Project Management <request_AT_jdom_DOT_org>.

 In addition, we request (but do not require) that you include in the
 end-user documentation provided with the redistribution and/or in the
 software itself an acknowledgement equivalent to the following:
     "This product includes software developed by the
      JDOM Project (http://www.jdom.org/)."
 Alternatively, the acknowledgment may be graphical using the logos
 available at http://www.jdom.org/images/logos.

 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE JDOM AUTHORS OR THE PROJECT
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 This software consists of voluntary contributions made by many
 individuals on behalf of the JDOM Project and was originally
 created by Jason Hunter <jhunter_AT_jdom_DOT_org> and
 Brett McLaughlin <brett_AT_jdom_DOT_org>.  For more information
 on the JDOM Project, please see <http://www.jdom.org/>.

 */

package org.jdom2.input;

import static org.jdom2.JDOMConstants.SAX_FEATURE_EXTERNAL_ENT;
import static org.jdom2.JDOMConstants.SAX_PROPERTY_DECLARATION_HANDLER;
import static org.jdom2.JDOMConstants.SAX_PROPERTY_LEXICAL_HANDLER;
import static org.jdom2.JDOMConstants.SAX_PROPERTY_LEXICAL_HANDLER_ALT;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

import org.jdom2.DefaultJDOMFactory;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.EntityRef;
import org.jdom2.JDOMException;
import org.jdom2.JDOMFactory;
import org.jdom2.Verifier;
import org.jdom2.input.sax.BuilderErrorHandler;
import org.jdom2.input.sax.DefaultSAXHandlerFactory;
import org.jdom2.input.sax.SAXBuilderEngine;
import org.jdom2.input.sax.SAXEngine;
import org.jdom2.input.sax.SAXHandler;
import org.jdom2.input.sax.SAXHandlerFactory;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderSAX2Factory;
import org.jdom2.input.sax.XMLReaders;

/**
 * Builds a JDOM Document using a SAX parser.
 * <p>
 * SAXbuilder uses a third-party SAX parser (chosen by JAXP by default, or you
 * can configure it manually) to handle the parsing duties and uses an instance
 * of a SAXHandler to listen to the SAX events in order to construct a document
 * with JDOM content using a JDOMFactory. Information about SAX can be found at
 * <a href="http://www.saxproject.org">http://www.saxproject.org</a>.
 * <p>
 * For a complete description of how SAXBuilder is used, and how to customise
 * the process you should look at the {@link org.jdom2.input.sax} package
 * documentation.
 * <p>
 * JDOM users needing to customise the SAX parsing process have traditionally
 * sub-classed this SAXBuilder class. In JDOM2 this should never be necessary.
 * Please read the full documentation of this class, {@link SAXHandler},
 * {@link SAXHandlerFactory}, {@link JDOMFactory}, and the package documentation
 * for {@link org.jdom2.input.sax} before overriding this class. Future versions
 * of JDOM2 may make this class 'final'. I you feel you have a good reason to
 * subclass SAXBuilder please mention it on <a
 * href="http://www.jdom.org/involved/lists.html">jdom-interest</a> mailing list
 * so that SAXBuilder can be extended or adapted to handle your use-case.
 * <p>
 * Neither SAXBuilder nor anything derived from SAXBuilder is thread-safe. You
 * must ensure that SAXBuilder is used in a single thread, or that sufficient
 * locking is in place to ensure that SAXBuilder is not concurrently accessed.
 * See the special note on {@link #buildEngine()}. 
 * <p>
 * Known issues:
 * <ul>
 * <li>Relative paths for a {@link DocType} or {@link EntityRef} may be
 * converted by the SAX parser into absolute paths.
 * <li>SAX does not recognise whitespace character content outside the root
 * element (nor does JDOM) so any formatting outside the root Element will be
 * lost.
 * </ul>
 * 
 * @see org.jdom2.input.sax
 * @author Jason Hunter
 * @author Brett McLaughlin
 * @author Dan Schaffer
 * @author Philip Nelson
 * @author Alex Rosen
 * @author Rolf Lear
 */
public class SAXBuilder implements SAXEngine {

	/** Default source of SAXHandlers */
	private static final SAXHandlerFactory DEFAULTSAXHANDLERFAC =
			new DefaultSAXHandlerFactory();

	/** Default source of JDOM Content */
	private static final JDOMFactory DEFAULTJDOMFAC = new DefaultJDOMFactory();

	/*
	 * ====================================================================
	 */

	/**
	 * The XMLReader pillar of SAXBuilder
	 */
	private XMLReaderJDOMFactory readerfac = null;

	/**
	 * The SAXHandler pillar of SAXBuilder
	 */
	private SAXHandlerFactory handlerfac = null;

	/**
	 * The JDOMFactory pillar for creating new JDOM objects
	 */
	private JDOMFactory jdomfac = null;

	/*
	 * ========================================================================
	 * Configuration settings for SAX parsing.
	 * ========================================================================
	 */

	/** User-specified features to be set on the SAX parser */
	private final HashMap<String, Boolean> features = new HashMap<String, Boolean>(5);

	/** User-specified properties to be set on the SAX parser */
	private final HashMap<String, Object> properties = new HashMap<String, Object>(5);

	/** ErrorHandler class to use */
	private ErrorHandler saxErrorHandler = null;

	/** EntityResolver class to use */
	private EntityResolver saxEntityResolver = null;

	/** DTDHandler class to use */
	private DTDHandler saxDTDHandler = null;

	/** XMLFilter instance to use */
	private XMLFilter saxXMLFilter = null;

	/** Whether expansion of entities should occur */
	private boolean expand = true;

	/** Whether to ignore ignorable whitespace */
	private boolean ignoringWhite = false;

	/** Whether to ignore all whitespace content */
	private boolean ignoringBoundaryWhite = false;

	/** Whether parser reuse is allowed. */
	private boolean reuseParser = true;

	/** The current SAX parser, if parser reuse has been activated. */
	private SAXEngine engine = null;

	/**
	 * Creates a new JAXP-based SAXBuilder. The underlying parser will not
	 * validate.
	 * 
	 * @see SAXBuilder#SAXBuilder(XMLReaderJDOMFactory, SAXHandlerFactory,
	 *      JDOMFactory)
	 * @see XMLReaders#NONVALIDATING
	 * @see DefaultSAXHandlerFactory
	 * @see DefaultJDOMFactory
	 */
	public SAXBuilder() {
		this(null, null, null);
	}

	/**
	 * Creates a new JAXP-based SAXBuilder. The underlying parser will validate
	 * (using DTD) or not according to the given parameter. If you want Schema
	 * validation then use SAXBuilder(XMLReaders.XSDVALIDATOR)
	 * 
	 * @see SAXBuilder#SAXBuilder(XMLReaderJDOMFactory, SAXHandlerFactory,
	 *      JDOMFactory)
	 * @see XMLReaders#NONVALIDATING
	 * @see XMLReaders#DTDVALIDATING
	 * @see DefaultSAXHandlerFactory
	 * @see DefaultJDOMFactory
	 * @see org.jdom2.input.sax for important details on SAXBuilder
	 * @param validate
	 *        <code>boolean</code> indicating if DTD validation should occur.
	 * @deprecated use {@link SAXBuilder#SAXBuilder(XMLReaderJDOMFactory)} with 
	 *              either {@link XMLReaders#DTDVALIDATING}
	 *              or {@link XMLReaders#NONVALIDATING} 
	 */
	@Deprecated
	public SAXBuilder(final boolean validate) {
		this(validate
				? XMLReaders.DTDVALIDATING
				: XMLReaders.NONVALIDATING,
				null, null);
	}

	/**
	 * Creates a new SAXBuilder using the specified SAX parser. The underlying
	 * parser will not validate.
	 * 
	 * @see SAXBuilder#SAXBuilder(XMLReaderJDOMFactory, SAXHandlerFactory,
	 *      JDOMFactory)
	 * @see XMLReaderSAX2Factory
	 * @see DefaultSAXHandlerFactory
	 * @see DefaultJDOMFactory
	 * @see org.jdom2.input.sax for important details on SAXBuilder
	 * @param saxDriverClass
	 *        <code>String</code> name of SAX Driver to use for parsing.
	 * @deprecated use {@link SAXBuilder#SAXBuilder(XMLReaderJDOMFactory)} with 
	 *        {@link XMLReaderSAX2Factory#XMLReaderSAX2Factory(boolean, String)}
	 */
	@Deprecated
	public SAXBuilder(final String saxDriverClass) {
		this(saxDriverClass, false);
	}

	/**
	 * Creates a new SAXBuilder using the specified SAX2.0 parser source. The
	 * underlying parser will validate or not according to the given parameter.
	 * 
	 * @see SAXBuilder#SAXBuilder(XMLReaderJDOMFactory, SAXHandlerFactory,
	 *      JDOMFactory)
	 * @see XMLReaderSAX2Factory
	 * @see DefaultSAXHandlerFactory
	 * @see DefaultJDOMFactory
	 * @see org.jdom2.input.sax for important details on SAXBuilder
	 * @param saxDriverClass
	 *        <code>String</code> name of SAX Driver to use for parsing.
	 * @param validate
	 *        <code>boolean</code> indicating if validation should occur.
	 * @deprecated use {@link SAXBuilder#SAXBuilder(XMLReaderJDOMFactory)} with 
	 *        {@link XMLReaderSAX2Factory#XMLReaderSAX2Factory(boolean, String)}
	 */
	@Deprecated
	public SAXBuilder(final String saxDriverClass, final boolean validate) {
		this(new XMLReaderSAX2Factory(validate, saxDriverClass), null, null);
	}

	/**
	 * Creates a new SAXBuilder with the specified XMLReaderJDOMFactory.
	 * <p>
	 * 
	 * @see SAXBuilder#SAXBuilder(XMLReaderJDOMFactory, SAXHandlerFactory,
	 *      JDOMFactory)
	 * @see XMLReaderJDOMFactory
	 * @see XMLReaders#NONVALIDATING
	 * @see DefaultSAXHandlerFactory
	 * @see DefaultJDOMFactory
	 * @see org.jdom2.input.sax for important details on SAXBuilder
	 * @param readersouce
	 *        the {@link XMLReaderJDOMFactory} that supplies XMLReaders. If the
	 *        value is null then a Non-Validating JAXP-based SAX2.0 parser will
	 *        be used.
	 */
	public SAXBuilder(final XMLReaderJDOMFactory readersouce) {
		this(readersouce, null, null);
	}

	/**
	 * Creates a new SAXBuilder. This is the base constructor for all other
	 * SAXBuilder constructors: they all find a way to create a
	 * JDOMXMLReaderFactory and then call this constructor with that factory,
	 * and the {@link DefaultSAXHandlerFactory} and {@link DefaultJDOMFactory}.
	 * <p>
	 * 
	 * @see XMLReaderJDOMFactory
	 * @see XMLReaders#NONVALIDATING
	 * @see SAXHandlerFactory
	 * @see DefaultSAXHandlerFactory
	 * @see JDOMFactory
	 * @see DefaultJDOMFactory
	 * @see org.jdom2.input.sax for important details on SAXBuilder
	 * @param xmlreaderfactory
	 *        a {@link XMLReaderJDOMFactory} that creates XMLReaders. Specify
	 *        null for the default.
	 * @param handlerfactory
	 *        a {@link SAXHandlerFactory} that creates SAXHandlers Specify null
	 *        for the default.
	 * @param jdomfactory
	 *        a {@link JDOMFactory} that creates JDOM Content. Specify null for
	 *        the default.
	 */
	public SAXBuilder(final XMLReaderJDOMFactory xmlreaderfactory, final SAXHandlerFactory handlerfactory,
			final JDOMFactory jdomfactory) {
		this.readerfac = xmlreaderfactory == null
				? XMLReaders.NONVALIDATING
				: xmlreaderfactory;
		this.handlerfac = handlerfactory == null
				? DEFAULTSAXHANDLERFAC
				: handlerfactory;
		this.jdomfac = jdomfactory == null
				? DEFAULTJDOMFAC
				: jdomfactory;
	}

	/**
	 * Returns the driver class assigned in the constructor, or null if none.
	 * The driver class is only available if a SAX2 source was specified. This
	 * method is available for backward-compatibility with JDOM 1.x
	 * 
	 * @return the driver class assigned in the constructor
	 * @deprecated as the driver class is only available in limited situations
	 *             and anyway it had to be supplied in a constructor as either a
	 *             direct value or as an {@link XMLReaderSAX2Factory} instance.
	 */
	@Deprecated
	public String getDriverClass() {
		if (readerfac instanceof XMLReaderSAX2Factory) {
			return ((XMLReaderSAX2Factory) readerfac).getDriverClassName();
		}
		return null;
	}

	/**
	 * Returns the current {@link org.jdom2.JDOMFactory} in use.
	 * 
	 * @return the factory in use
	 * @deprecated as it is replaced by {@link #getJDOMFactory()}
	 */
	@Deprecated
	public JDOMFactory getFactory() {
		return getJDOMFactory();
	}

	/**
	 * Returns the current {@link org.jdom2.JDOMFactory} in use.
	 * 
	 * @return the factory in use
	 */
	@Override
	public JDOMFactory getJDOMFactory() {
		return jdomfac;
	}

	/**
	 * This sets a custom JDOMFactory for the builder. Use this to build the
	 * tree with your own subclasses of the JDOM classes.
	 * 
	 * @param factory
	 *        <code>JDOMFactory</code> to use
	 * @deprecated as it is replaced by {@link #setJDOMFactory(JDOMFactory)}
	 */
	@Deprecated
	public void setFactory(final JDOMFactory factory) {
		setJDOMFactory(factory);
	}

	/**
	 * This sets a custom JDOMFactory for the builder. Use this to build the
	 * tree with your own subclasses of the JDOM classes.
	 * 
	 * @param factory
	 *        <code>JDOMFactory</code> to use
	 */
	public void setJDOMFactory(final JDOMFactory factory) {
		this.jdomfac = factory;
		engine = null;
	}

	/**
	 * Get the current XMLReader factory.
	 * 
	 * @return the current JDOMXMLReaderFactory
	 */
	public XMLReaderJDOMFactory getXMLReaderFactory() {
		return readerfac;
	}

	/**
	 * Set the current XMLReader factory.
	 * 
	 * @param rfac
	 *        the JDOMXMLReaderFactory to set. A null rfac will indicate the
	 *        default {@link XMLReaders#NONVALIDATING}
	 */
	public void setXMLReaderFactory(final XMLReaderJDOMFactory rfac) {
		readerfac = rfac == null
				? XMLReaders.NONVALIDATING
				: rfac;
		engine = null;
	}

	/**
	 * Get the SAXHandlerFactory used to supply SAXHandlers to this SAXBuilder.
	 * 
	 * @return the current SAXHandlerFactory (never null).
	 */
	public SAXHandlerFactory getSAXHandlerFactory() {
		return handlerfac;
	}

	/**
	 * Set the SAXHandlerFactory to be used by this SAXBuilder.
	 * 
	 * @param factory
	 *        the required SAXHandlerFactory. A null input factory will request
	 *        the {@link DefaultSAXHandlerFactory}.
	 */
	public void setSAXHandlerFactory(final SAXHandlerFactory factory) {
		this.handlerfac = factory == null ? DEFAULTSAXHANDLERFAC : factory;
		engine = null;
	}

	/**
	 * Returns whether validation is to be performed during the build.
	 * 
	 * @return whether validation is to be performed during the build
	 * @deprecated in lieu of {@link #isValidating()}
	 */
	@Deprecated
	public boolean getValidation() {
		return isValidating();
	}

	/**
	 * Returns whether validation is to be performed during the build.
	 * 
	 * @return whether validation is to be performed during the build
	 */
	@Override
	public boolean isValidating() {
		return readerfac.isValidating();
	}

	/**
	 * This sets validation for the builder.
	 * <p>
	 * <b>Do Not Use</b>
	 * <p>
	 * JDOM2 introduces the concept of XMLReader factories. The XMLReader is
	 * what determines the type of validation. A simple boolean is not enough to
	 * indicate what sort of validation is required. The
	 * {@link #setXMLReaderFactory(XMLReaderJDOMFactory)} method provides a
	 * means to be more specific about validation.
	 * <p>
	 * For backward compatibility this method has been retained, but its use is
	 * discouraged. It does make some logical choices though. The code is
	 * equivalent to:
	 * <p>
	 * 
	 * <pre>
	 * setXMLReaderFactory(XMLReaders.DTDVALIDATING)
	 * </pre>
	 * 
	 * for true, and
	 * 
	 * <pre>
	 * setXMLReaderFactory(XMLReaders.NONVALIDATING)
	 * </pre>
	 * 
	 * for false.
	 * 
	 * @see #setXMLReaderFactory(XMLReaderJDOMFactory)
	 * @see XMLReaders#NONVALIDATING
	 * @see XMLReaders#DTDVALIDATING
	 * @param validate
	 *        <code>boolean</code> indicating whether validation should occur.
	 * @deprecated use {@link #setXMLReaderFactory(XMLReaderJDOMFactory)}
	 */
	@Deprecated
	public void setValidation(final boolean validate) {
		setXMLReaderFactory(validate
				? XMLReaders.DTDVALIDATING
				: XMLReaders.NONVALIDATING);
	}

	/**
	 * Returns the {@link ErrorHandler} assigned, or null if none. When the
	 * SAXBuilder parses a document it will always have an ErrorHandler but it
	 * will be an instance of {@link BuilderErrorHandler} unless you specify a
	 * different ErrorHandler in {@link #setErrorHandler(ErrorHandler)}. In
	 * other words, a null return value from here indicates a default will be
	 * used.
	 * 
	 * @return the ErrorHandler assigned, or null if SAXBuilder will create a
	 *         default ErrorHandler when needed.
	 */
	@Override
	public ErrorHandler getErrorHandler() {
		return saxErrorHandler;
	}

	/**
	 * This sets custom ErrorHandler for the Builder. Setting a null value will
	 * indicate SAXBuilder should create a default ErrorHandler when needed.
	 * 
	 * @param errorHandler
	 *        <code>ErrorHandler</code>
	 */
	public void setErrorHandler(final ErrorHandler errorHandler) {
		saxErrorHandler = errorHandler;
		engine = null;
	}

	/**
	 * Returns the {@link EntityResolver} assigned, or null if none.
	 * 
	 * @return the EntityResolver assigned
	 */
	@Override
	public EntityResolver getEntityResolver() {
		return saxEntityResolver;
	}

	/**
	 * This sets custom EntityResolver for the <code>Builder</code>.
	 * 
	 * @param entityResolver
	 *        <code>EntityResolver</code>
	 */
	public void setEntityResolver(final EntityResolver entityResolver) {
		saxEntityResolver = entityResolver;
		engine = null;
	}

	/**
	 * Returns the {@link DTDHandler} assigned, or null if the assigned
	 * {@link SAXHandler} will be used for DTD SAX events.
	 * 
	 * @return the DTDHandler assigned
	 */
	@Override
	public DTDHandler getDTDHandler() {
		return saxDTDHandler;
	}

	/**
	 * This sets custom DTDHandler for the <code>Builder</code>. Setting a null
	 * value indicates that SAXBuilder should use the assigned SAXHandler for
	 * DTD processing.
	 * 
	 * @param dtdHandler
	 *        <code>DTDHandler</code>
	 */
	public void setDTDHandler(final DTDHandler dtdHandler) {
		saxDTDHandler = dtdHandler;
		engine = null;
	}

	/**
	 * Returns the {@link XMLFilter} used during parsing, or null if none.
	 * 
	 * @return the XMLFilter used during parsing
	 */
	public XMLFilter getXMLFilter() {
		return saxXMLFilter;
	}

	/**
	 * This sets a custom {@link org.xml.sax.XMLFilter} for the builder.
	 * <p>
	 * Care should be taken to ensure that the specified xmlFilter is reentrant
	 * and thread-safe.
	 * <p>
	 * SAXBuilder will set this instance as the parent instance for all
	 * XMLReaders that may be created, and these may (depending on SAXBuilder
	 * usage) be accessed concurrently. It is the responsibility of the JDOM
	 * user to ensure that if the XMLFilter is not thread-safe then neither the
	 * SAXBuilder nor any of it's SAXEngines are accessed concurrently.
	 * 
	 * @param xmlFilter
	 *        the XMLFilter to use
	 */
	public void setXMLFilter(final XMLFilter xmlFilter) {
		saxXMLFilter = xmlFilter;
		engine = null;
	}

	/**
	 * Returns whether element content whitespace is to be ignored during the
	 * build.
	 * 
	 * @return whether element content whitespace is to be ignored during the
	 *         build
	 */
	@Override
	public boolean getIgnoringElementContentWhitespace() {
		return ignoringWhite;
	}

	/**
	 * Specifies whether or not the parser should eliminate whitespace in
	 * element content (sometimes known as "ignorable whitespace") when building
	 * the document. Only whitespace which is contained within element content
	 * that has an element only content model will be eliminated (see XML Rec
	 * 3.2.1). For this setting to take effect requires that validation be
	 * turned on. The default value of this setting is <code>false</code>.
	 * 
	 * @param ignoringWhite
	 *        Whether to ignore ignorable whitespace
	 */
	public void setIgnoringElementContentWhitespace(final boolean ignoringWhite) {
		this.ignoringWhite = ignoringWhite;
		engine = null;
	}

	/**
	 * Returns whether or not the parser will eliminate element content
	 * containing only whitespace.
	 * 
	 * @return <code>boolean</code> - whether only whitespace content will be
	 *         ignored during build.
	 * @see #setIgnoringBoundaryWhitespace
	 */
	@Override
	public boolean getIgnoringBoundaryWhitespace() {
		return ignoringBoundaryWhite;
	}

	/**
	 * Specifies whether or not the parser should elminate boundary whitespace,
	 * a term that indicates whitespace-only text between element tags. This
	 * feature is a lot like
	 * {@link #setIgnoringElementContentWhitespace(boolean)} but this feature is
	 * more aggressive and doesn't require validation be turned on. The
	 * {@link #setIgnoringElementContentWhitespace(boolean)} call impacts the
	 * SAX parse process while this method impacts the JDOM build process, so it
	 * can be beneficial to turn both on for efficiency. For implementation
	 * efficiency, this method actually removes all whitespace-only text()
	 * nodes. That can, in some cases (like between an element tag and a
	 * comment) include whitespace that isn't just boundary whitespace. The
	 * default is <code>false</code>.
	 * 
	 * @param ignoringBoundaryWhite
	 *        Whether to ignore whitespace-only text nodes
	 */
	public void setIgnoringBoundaryWhitespace(final boolean ignoringBoundaryWhite) {
		this.ignoringBoundaryWhite = ignoringBoundaryWhite;
		engine = null;
	}

	/**
	 * Returns whether or not entities are being expanded into normal text
	 * content.
	 * 
	 * @return whether entities are being expanded
	 */
	@Override
	public boolean getExpandEntities() {
		return expand;
	}

	/**
	 * <p>
	 * This sets whether or not to expand entities for the builder. A true means
	 * to expand entities as normal content. A false means to leave entities
	 * unexpanded as <code>EntityRef</code> objects. The default is true.
	 * </p>
	 * <p>
	 * When this setting is false, the internal DTD subset is retained; when
	 * this setting is true, the internal DTD subset is not retained.
	 * </p>
	 * <p>
	 * Note that Xerces (at least up to 1.4.4) has a bug where entities in
	 * attribute values will be incorrectly reported if this flag is turned off,
	 * resulting in entities appearing within element content. When turning
	 * entity expansion off either avoid entities in attribute values, or use
	 * another parser like Crimson.
	 * http://nagoya.apache.org/bugzilla/show_bug.cgi?id=6111
	 * </p>
	 * 
	 * @param expand
	 *        <code>boolean</code> indicating whether entity expansion should
	 *        occur.
	 */
	public void setExpandEntities(final boolean expand) {
		this.expand = expand;
		engine = null;
	}

	/**
	 * Returns whether the contained SAX parser instance is reused across
	 * multiple parses. The default is true.
	 * 
	 * @return whether the contained SAX parser instance is reused across
	 *         multiple parses
	 */
	public boolean getReuseParser() {
		return reuseParser;
	}

	/**
	 * Specifies whether this builder will reuse the same SAX parser when
	 * performing subsequent parses or allocate a new parser for each parse. The
	 * default value of this setting is <code>true</code> (parser reuse).
	 * <p>
	 * <strong>Note</strong>: SAX parser instances are not thread safe (they are
	 * not even reentrant), and nor are SAXBuilder instances. Setting parser
	 * reuse does not imply the parser is thread-safe.
	 * </p>
	 * 
	 * @param reuseParser
	 *        Whether to reuse the SAX parser.
	 */
	public void setReuseParser(final boolean reuseParser) {
		this.reuseParser = reuseParser;
		if (!reuseParser) {
			engine = null;
		}
	}

	/**
	 * Specifies whether this builder will do fast reconfiguration of the
	 * underlying SAX parser when reuseParser is true. This improves performance
	 * in cases where SAXBuilders are reused and lots of small documents are
	 * frequently parsed. This avoids attempting to set features on the SAX
	 * parser each time build() is called which result in
	 * SaxNotRecognizedExceptions. This should ONLY be set for builders where
	 * this specific case is an issue. The default value of this setting is
	 * <code>false</code> (no fast reconfiguration). If reuseParser is false,
	 * calling this has no effect.
	 * 
	 * @param fastReconfigure
	 *        Whether to do a fast reconfiguration of the parser
	 * @deprecated All reused Parsers are now fast-reconfigured. No need to set
	 *             it.
	 */
	@Deprecated
	public void setFastReconfigure(final boolean fastReconfigure) {
		// do nothing
	}

	/**
	 * This sets a feature on the SAX parser. See the SAX documentation for
	 * more information. </p>
	 * <p>
	 * NOTE: SAXBuilder requires that some particular features of the SAX parser
	 * be set up in certain ways for it to work properly. The list of such
	 * features may change in the future. Therefore, the use of this method may
	 * cause parsing to break, and even if it doesn't break anything today it
	 * might break parsing in a future JDOM version, because what JDOM parsers
	 * require may change over time. Use with caution.
	 * </p>
	 * JDOM uses {@link XMLReaderJDOMFactory} instances to provide XMLReader
	 * instances. If you require special configuration on your XMLReader you
	 * should consider extending or implementing an XMLReaderJDOMFactory in the
	 * {@link org.jdom2.input.sax} package.
	 * 
	 * @param name
	 *        The feature name, which is a fully-qualified URI.
	 * @param value
	 *        The requested state of the feature (true or false).
	 */
	public void setFeature(final String name, final boolean value) {
		// Save the specified feature for later.
		features.put(name, value ? Boolean.TRUE : Boolean.FALSE);
		engine = null;
	}

	/**
	 * This sets a property on the SAX parser. See the SAX documentation for
	 * more information.
	 * <p>
	 * NOTE: SAXBuilder requires that some particular properties of the SAX
	 * parser be set up in certain ways for it to work properly. The list of
	 * such properties may change in the future. Therefore, the use of this
	 * method may cause parsing to break, and even if it doesn't break anything
	 * today it might break parsing in a future JDOM version, because what JDOM
	 * parsers require may change over time. Use with caution.
	 * </p>
	 * JDOM uses {@link XMLReaderJDOMFactory} instances to provide XMLReader
	 * instances. If you require special configuration on your XMLReader you
	 * should consider extending or implementing an XMLReaderJDOMFactory in the
	 * {@link org.jdom2.input.sax} package.
	 * 
	 * @param name
	 *        The property name, which is a fully-qualified URI.
	 * @param value
	 *        The requested value for the property.
	 */
	public void setProperty(final String name, final Object value) {
		// Save the specified property for later.
		properties.put(name, value);
		engine = null;
	}

	/**
	 * This method builds a new and reusable {@link SAXEngine}.
	 * Each time this method is called a new instance of a SAXEngine will be
	 * returned.
	 * <p>
	 * This method is used internally by the various SAXBuilder.build(*) methods
	 * (if any configuration has changed) but can also be used as a mechanism
	 * for creating SAXEngines to be used in parsing pools or other optimised
	 * structures.
	 * 
	 * @return a {@link SAXEngine} representing the current state of the
	 *         current SAXBuilder settings.
	 * @throws JDOMException
	 *         if there is any problem initialising the engine.
	 */
	public SAXEngine buildEngine() throws JDOMException {

		// Create and configure the content handler.
		final SAXHandler contentHandler = handlerfac.createSAXHandler(jdomfac);

		contentHandler.setExpandEntities(expand);
		contentHandler.setIgnoringElementContentWhitespace(ignoringWhite);
		contentHandler.setIgnoringBoundaryWhitespace(ignoringBoundaryWhite);

		final XMLReader parser = createParser();
		// Configure parser
		configureParser(parser, contentHandler);
		final boolean valid = readerfac.isValidating();

		return new SAXBuilderEngine(parser, contentHandler, valid);
	}

	/**
	 * Allow overriding classes access to the Parser before it is used in a
	 * SAXBuilderEngine.
	 * 
	 * @return a XMLReader parser.
	 * @throws JDOMException
	 *         if there is a problem
	 */
	protected XMLReader createParser() throws JDOMException {
		XMLReader parser = readerfac.createXMLReader();

		// Install optional filter
		if (saxXMLFilter != null) {
			// Connect filter chain to parser
			XMLFilter root = saxXMLFilter;
			while (root.getParent() instanceof XMLFilter) {
				root = (XMLFilter) root.getParent();
			}
			root.setParent(parser);

			// Read from filter
			parser = saxXMLFilter;
		}

		return parser;
	}

	/**
	 * This method retrieves (or builds) a SAXBuilderEngine that represents the
	 * current SAXBuilder state.
	 * 
	 * @return a {@link SAXBuilderEngine} representing the current state of the
	 *         current SAXBuilder settings.
	 * @throws JDOMException
	 *         if there is any problem initializing the engine.
	 */
	private SAXEngine getEngine() throws JDOMException {

		if (engine != null) {
			return engine;
		}

		engine = buildEngine();
		return engine;
	}

	/**
	 * This configures the XMLReader to be used for reading the XML document.
	 * <p>
	 * The default implementation sets various options on the given XMLReader,
	 * such as validation, DTD resolution, entity handlers, etc., according to
	 * the options that were set (e.g. via <code>setEntityResolver</code>) and
	 * set various SAX properties and features that are required for JDOM
	 * internals. These features may change in future releases, so change this
	 * behavior at your own risk.
	 * </p>
	 * 
	 * @param parser
	 *        the XMLReader to configure.
	 * @param contentHandler
	 *        The SAXHandler to use for the XMLReader
	 * @throws JDOMException
	 *         if configuration fails.
	 */
	protected void configureParser(final XMLReader parser, final SAXHandler contentHandler)
			throws JDOMException {

		// Setup SAX handlers.

		parser.setContentHandler(contentHandler);

		if (saxEntityResolver != null) {
			parser.setEntityResolver(saxEntityResolver);
		}

		if (saxDTDHandler != null) {
			parser.setDTDHandler(saxDTDHandler);
		} else {
			parser.setDTDHandler(contentHandler);
		}

		if (saxErrorHandler != null) {
			parser.setErrorHandler(saxErrorHandler);
		} else {
			parser.setErrorHandler(new BuilderErrorHandler());
		}

		boolean success = false;

		try {
			parser.setProperty(SAX_PROPERTY_LEXICAL_HANDLER,
					contentHandler);
			success = true;
		} catch (final SAXNotSupportedException e) {
			// No lexical reporting available
		} catch (final SAXNotRecognizedException e) {
			// No lexical reporting available
		}

		// Some parsers use alternate property for lexical handling (grr...)
		if (!success) {
			try {
				parser.setProperty(SAX_PROPERTY_LEXICAL_HANDLER_ALT,
						contentHandler);
				success = true;
			} catch (final SAXNotSupportedException e) {
				// No lexical reporting available
			} catch (final SAXNotRecognizedException e) {
				// No lexical reporting available
			}
		}

		// Set any user-specified features on the parser.
		for (final Map.Entry<String, Boolean> me : features.entrySet()) {
			internalSetFeature(parser, me.getKey(), me.getValue().booleanValue(), me.getKey());
		}

		// Set any user-specified properties on the parser.
		for (final Map.Entry<String, Object> me : properties.entrySet()) {
			internalSetProperty(parser, me.getKey(), me.getValue(), me.getKey());
		}

		// Set entity expansion
		// Note SAXHandler can work regardless of how this is set, but when
		// entity expansion it's worth it to try to tell the parser not to
		// even bother with external general entities.
		// Apparently no parsers yet support this feature.
		// XXX It might make sense to setEntityResolver() with a resolver
		// that simply ignores external general entities
		try {
			if (parser.getFeature(SAX_FEATURE_EXTERNAL_ENT) != expand) {
				parser.setFeature(SAX_FEATURE_EXTERNAL_ENT, expand);
			}
		} catch (final SAXException e) { /* Ignore... */
		}

		// Try setting the DeclHandler if entity expansion is off
		if (!expand) {
			try {
				parser.setProperty(SAX_PROPERTY_DECLARATION_HANDLER,
						contentHandler);
				success = true;
			} catch (final SAXNotSupportedException e) {
				// No lexical reporting available
			} catch (final SAXNotRecognizedException e) {
				// No lexical reporting available
			}
		}

	}

	/**
	 * Tries to set a feature on the parser. If the feature cannot be set,
	 * throws a JDOMException describing the problem.
	 */
	private void internalSetFeature(final XMLReader parser, final String feature,
			final boolean value, final String displayName) throws JDOMException {
		try {
			parser.setFeature(feature, value);
		} catch (final SAXNotSupportedException e) {
			throw new JDOMException(
					displayName + " feature not supported for SAX driver " + parser.getClass().getName());
		} catch (final SAXNotRecognizedException e) {
			throw new JDOMException(
					displayName + " feature not recognized for SAX driver " + parser.getClass().getName());
		}
	}

	/**
	 * <p>
	 * Tries to set a property on the parser. If the property cannot be set,
	 * throws a JDOMException describing the problem.
	 * </p>
	 */
	private void internalSetProperty(final XMLReader parser, final String property,
			final Object value, final String displayName) throws JDOMException {
		try {
			parser.setProperty(property, value);
		} catch (final SAXNotSupportedException e) {
			throw new JDOMException(
					displayName + " property not supported for SAX driver " + parser.getClass().getName());
		} catch (final SAXNotRecognizedException e) {
			throw new JDOMException(
					displayName + " property not recognized for SAX driver " + parser.getClass().getName());
		}
	}

	/**
	 * This builds a document from the supplied input source.
	 * 
	 * @param in
	 *        <code>InputSource</code> to read from
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final InputSource in)
			throws JDOMException, IOException {

		try {
			return getEngine().build(in);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}

	}

	/**
	 * <p>
	 * This builds a document from the supplied input stream.
	 * </p>
	 * 
	 * @param in
	 *        <code>InputStream</code> to read from
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed.
	 */
	@Override
	public Document build(final InputStream in)
			throws JDOMException, IOException {
		try {
			return getEngine().build(in);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied filename.
	 * </p>
	 * 
	 * @param file
	 *        <code>File</code> to read from
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final File file)
			throws JDOMException, IOException {
		try {
			return getEngine().build(file);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied URL.
	 * </p>
	 * 
	 * @param url
	 *        <code>URL</code> to read from.
	 * @return <code>Document</code> - resultant Document object.
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed.
	 */
	@Override
	public Document build(final URL url)
			throws JDOMException, IOException {
		try {
			return getEngine().build(url);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied input stream.
	 * </p>
	 * 
	 * @param in
	 *        <code>InputStream</code> to read from.
	 * @param systemId
	 *        base for resolving relative URIs
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final InputStream in, final String systemId)
			throws JDOMException, IOException {
		try {
			return getEngine().build(in, systemId);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied Reader. It's the programmer's
	 * responsibility to make sure the reader matches the encoding of the file.
	 * It's often easier and safer to use an InputStream rather than a Reader,
	 * and to let the parser auto-detect the encoding from the XML declaration.
	 * </p>
	 * 
	 * @param characterStream
	 *        <code>Reader</code> to read from
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final Reader characterStream)
			throws JDOMException, IOException {
		try {
			return getEngine().build(characterStream);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied Reader. It's the programmer's
	 * responsibility to make sure the reader matches the encoding of the file.
	 * It's often easier and safer to use an InputStream rather than a Reader,
	 * and to let the parser auto-detect the encoding from the XML declaration.
	 * </p>
	 * 
	 * @param characterStream
	 *        <code>Reader</code> to read from.
	 * @param systemId
	 *        base for resolving relative URIs
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final Reader characterStream, final String systemId)
			throws JDOMException, IOException {

		try {
			return getEngine().build(characterStream, systemId);
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

	/**
	 * <p>
	 * This builds a document from the supplied URI. The URI is typically a file name, or a URL.
	 * Do not use this method for parsing XML content that is in a Java String variable.
	 * <p>
	 * <ul>
	 * <li><Strong>Right:</Strong> <code>....build("path/to/file.xml");</code>
	 * <li><Strong>Right:</Strong> <code>....build("http://my.example.com/xmlfile");</code>
	 * <li><Strong>Wrong:</Strong> <code>....build("&lt;root>data&lt/root>");</code>
	 * </ul>
	 * </p>
	 * If your XML content is in a Java String variable and you want to parse it, then use:<br/>
	 * <code>    ....build(new StringReader("&lt;root>data&lt/root>"));</code>
	 * <p>
	 * 
	 * @param systemId
	 *        URI for the input
	 * @return <code>Document</code> resultant Document object
	 * @throws JDOMException
	 *         when errors occur in parsing
	 * @throws IOException
	 *         when an I/O error prevents a document from being fully parsed
	 */
	@Override
	public Document build(final String systemId)
			throws JDOMException, IOException {
		if (systemId == null) {
			throw new NullPointerException(
					"Unable to build a URI from a null systemID.");
		}
		try {
			return getEngine().build(systemId);
		} catch (IOException ioe) {
			// OK, Issue #63
			// it is common for people to pass in raw XML content instead of
			// a SystemID. To make troubleshooting easier, we do a simple check
			// all valid XML documents start with a '<' character.
			// no URI ever has an '<' character.
			// if we think an XML document was passed in, we wrap the exception
			// Typically this problem causes a MalformedURLException to be
			// thrown, but that is not particular specified that way. Of
			// interest, depending on the broken systemID, you could get a
			// FileNotFoundException which is also an IOException, which will
			// also be processed by this handler....
			
			final int len = systemId.length();
			int i = 0;
			while (i < len && Verifier.isXMLWhitespace(systemId.charAt(i))) {
				i++;
			}
			if (i < len && '<' == systemId.charAt(i)) {
				// our systemID URI has a '<' - this is likely the problem. 
				MalformedURLException mx = new MalformedURLException(
						"SAXBuilder.build(String) expects the String to be " +
						"a systemID, but in this instance it appears to be " +
						"actual XML data.");
				// include the original problem for accountability, and perhaps
				// a false positive.... though very unlikely
				mx.initCause(ioe);
				throw mx;
			}
			// it is likely not an XML document - re-throw the exception  
			throw ioe;
		} finally {
			if (!reuseParser) {
				engine = null;
			}
		}
	}

}
