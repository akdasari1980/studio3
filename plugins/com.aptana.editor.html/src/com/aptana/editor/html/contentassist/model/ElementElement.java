/**
 * This file Copyright (c) 2005-2010 Aptana, Inc. This program is
 * dual-licensed under both the Aptana Public License and the GNU General
 * Public license. You may elect to use one or the other of these licenses.
 * 
 * This program is distributed in the hope that it will be useful, but
 * AS-IS and WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, TITLE, or
 * NONINFRINGEMENT. Redistribution, except as permitted by whichever of
 * the GPL or APL you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or modify this
 * program under the terms of the GNU General Public License,
 * Version 3, as published by the Free Software Foundation.  You should
 * have received a copy of the GNU General Public License, Version 3 along
 * with this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Aptana provides a special exception to allow redistribution of this file
 * with certain other free and open source software ("FOSS") code and certain additional terms
 * pursuant to Section 7 of the GPL. You may view the exception and these
 * terms on the web at http://www.aptana.com/legal/gpl/.
 * 
 * 2. For the Aptana Public License (APL), this program and the
 * accompanying materials are made available under the terms of the APL
 * v1.0 which accompanies this distribution, and is available at
 * http://www.aptana.com/legal/apl/.
 * 
 * You may view the GPL, Aptana's exception and additional terms, and the
 * APL in the file titled license.html at the root of the corresponding
 * plugin containing this source file.
 * 
 * Any modifications to this file must keep this entire header intact.
 */
package com.aptana.editor.html.contentassist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mortbay.util.ajax.JSON.Output;

import com.aptana.core.util.StringUtil;
import com.aptana.index.core.IndexUtil;

public class ElementElement extends BaseElement
{
	private static final String USER_AGENTS_PROPERTY = "userAgents"; //$NON-NLS-1$
	private static final String SPECIFICATIONS_PROPERTY = "specifications"; //$NON-NLS-1$
	private static final String REFERENCES_PROPERTY = "references"; //$NON-NLS-1$
	private static final String EVENTS_PROPERTY = "events"; //$NON-NLS-1$
	private static final String ATTRIBUTES_PROPERTY = "attributes"; //$NON-NLS-1$
	private static final String REMARK_PROPERTY = "remark"; //$NON-NLS-1$
	private static final String RELATED_CLASS_PROPERTY = "relatedClass"; //$NON-NLS-1$
	private static final String EXAMPLE_PROPERTY = "example"; //$NON-NLS-1$
	private static final String DEPRECATED_PROPERTY = "deprecated"; //$NON-NLS-1$
	private static final String DISPLAY_NAME_PROPERTY = "displayName"; //$NON-NLS-1$

	private String _displayName;
	private String _relatedClass;
	private List<String> _attributes = new ArrayList<String>();
	private List<SpecificationElement> _specifications = new ArrayList<SpecificationElement>();
	private List<UserAgentElement> _userAgents = new ArrayList<UserAgentElement>();
	private String _deprecated;
	private List<String> _events = new ArrayList<String>();
	private String _example;
	private List<String> _references = new ArrayList<String>();
	private String _remark;

	/**
	 * ElementElement
	 */
	public ElementElement()
	{
	}

	/**
	 * addAttribute
	 * 
	 * @param attribute
	 *            the attribute to add
	 */
	public void addAttribute(String attribute)
	{
		this._attributes.add(attribute);
	}

	/**
	 * addEvent
	 * 
	 * @param event
	 *            the event to add
	 */
	public void addEvent(String event)
	{
		this._events.add(event);
	}

	/**
	 * @param reference
	 *            the reference to add
	 */
	public void addReference(String reference)
	{
		this._references.add(reference);
	}

	/**
	 * addSpecification
	 * 
	 * @param specification
	 *            the specification to add
	 */
	public void addSpecification(SpecificationElement specification)
	{
		this._specifications.add(specification);
	}

	/**
	 * addUserAgent
	 * 
	 * @param userAgent
	 *            the userAgents to add
	 */
	public void addUserAgent(UserAgentElement userAgent)
	{
		this._userAgents.add(userAgent);
	}

	/*
	 * (non-Javadoc)
	 * @see org.mortbay.util.ajax.JSON.Convertible#fromJSON(java.util.Map)
	 */
	@SuppressWarnings("rawtypes")
	public void fromJSON(Map object)
	{
		super.fromJSON(object);

		this.setDisplayName(StringUtil.getStringValue(object.get(DISPLAY_NAME_PROPERTY)));
		this.setDeprecated(StringUtil.getStringValue(object.get(DEPRECATED_PROPERTY)));
		this.setExample(StringUtil.getStringValue(object.get(EXAMPLE_PROPERTY)));
		this.setRelatedClass(StringUtil.getStringValue(object.get(RELATED_CLASS_PROPERTY)));

		IndexUtil.addStringItems(object.get(ATTRIBUTES_PROPERTY), this._attributes);
		IndexUtil.addStringItems(object.get(EVENTS_PROPERTY), this._events);
		IndexUtil.addStringItems(object.get(REFERENCES_PROPERTY), this._references);
		IndexUtil.addArrayItems(object.get(SPECIFICATIONS_PROPERTY), this._specifications, SpecificationElement.class);
		IndexUtil.addArrayItems(object.get(USER_AGENTS_PROPERTY), this._userAgents, UserAgentElement.class);
	}

	/**
	 * getAttributes
	 * 
	 * @return the attributes
	 */
	public List<String> getAttributes()
	{
		return this._attributes;
	}

	/**
	 * getDeprecated
	 * 
	 * @return the deprecated
	 */
	public String getDeprecated()
	{
		return StringUtil.getStringValue(this._deprecated);
	}

	/**
	 * getDisplayName
	 * 
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return StringUtil.getStringValue(this._displayName);
	}

	/**
	 * getEvents
	 * 
	 * @return the events
	 */
	public List<String> getEvents()
	{
		return this._events;
	}

	/**
	 * getExample
	 * 
	 * @return the example
	 */
	public String getExample()
	{
		return StringUtil.getStringValue(this._example);
	}

	/**
	 * getReferences
	 * 
	 * @return the references
	 */
	public List<String> getReferences()
	{
		return this._references;
	}

	/**
	 * getRelatedClass
	 * 
	 * @return the relatedClass
	 */
	public String getRelatedClass()
	{
		return StringUtil.getStringValue(this._relatedClass);
	}

	/**
	 * getRemark
	 * 
	 * @return the remark
	 */
	public String getRemark()
	{
		return StringUtil.getStringValue(this._remark);
	}

	/**
	 * getSpecifications
	 * 
	 * @return the specifications
	 */
	public List<SpecificationElement> getSpecifications()
	{
		return this._specifications;
	}

	/**
	 * getUserAgentNames
	 * 
	 * @return
	 */
	public List<String> getUserAgentNames()
	{
		List<String> result = new ArrayList<String>();

		for (UserAgentElement userAgent : this.getUserAgents())
		{
			result.add(userAgent.getPlatform());
		}

		return result;
	}

	/**
	 * @return the userAgents
	 */
	public List<UserAgentElement> getUserAgents()
	{
		return this._userAgents;
	}

	/**
	 * setDeprecated
	 * 
	 * @param deprecated
	 *            the deprecated to set
	 */
	public void setDeprecated(String deprecated)
	{
		this._deprecated = deprecated;
	}

	/**
	 * setDisplayName
	 * 
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName)
	{
		this._displayName = displayName;
	}

	/**
	 * setExample
	 * 
	 * @param example
	 *            the example to set
	 */
	public void setExample(String example)
	{
		this._example = example;
	}

	/**
	 * setRelatedClass
	 * 
	 * @param relatedClass
	 *            the relatedClass to set
	 */
	public void setRelatedClass(String relatedClass)
	{
		this._relatedClass = relatedClass;
	}

	/**
	 * setRemark
	 * 
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark)
	{
		this._remark = remark;
	}

	/*
	 * (non-Javadoc)
	 * @see org.mortbay.util.ajax.JSON.Convertible#toJSON(org.mortbay.util.ajax.JSON.Output)
	 */
	public void toJSON(Output out)
	{
		super.toJSON(out);

		out.add(DISPLAY_NAME_PROPERTY, this.getDisplayName());
		out.add(DEPRECATED_PROPERTY, this.getDeprecated());
		out.add(EXAMPLE_PROPERTY, this.getExample());
		out.add(RELATED_CLASS_PROPERTY, this.getRelatedClass());
		out.add(REMARK_PROPERTY, this.getRemark());

		out.add(ATTRIBUTES_PROPERTY, this.getAttributes());
		out.add(EVENTS_PROPERTY, this.getEvents());
		out.add(REFERENCES_PROPERTY, this.getReferences());
		out.add(SPECIFICATIONS_PROPERTY, this.getSpecifications());
		out.add(USER_AGENTS_PROPERTY, this.getUserAgents());
	}
}
