/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.parser;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.aitools.programd.Core;
import org.aitools.programd.processor.ProcessorException;
import org.aitools.programd.processor.aiml.AIMLProcessor;
import org.apache.log4j.Logger;

/**
 * <code>TemplateParser</code> has been rewritten (starting in 4.5) to use DOM for parsing. It also eliminates
 * handling of "deprecated AIML" (this will be possible to handle again later with an extensible version of D).
 */
public class TemplateParser extends GenericParser<AIMLProcessor>
{
    /**
     * The values captured from the input by wildcards in the <code>pattern</code>.
     */
    private ArrayList<String> inputStars = new ArrayList<String>();

    /**
     * The values captured from the input path by wildcards in the <code>that</code>.
     */
    private ArrayList<String> thatStars = new ArrayList<String>();

    /**
     * The values captured from the input path by wildcards in the <code>topic</code>.
     */
    private ArrayList<String> topicStars = new ArrayList<String>();

    /**
     * The input that matched the <code>pattern</code> associated with this template (helps to avoid endless loops).
     */
    private ArrayList<String> inputs = new ArrayList<String>();

    /** The userid for which this parser is used. */
    private String _userid;

    /** The botid on whose behalf this parser is working. */
    private String _botid;

    /**
     * Initializes an <code>TemplateParser</code>. The <code>input</code> is a required parameter!
     * 
     * @param input the input that matched the <code>pattern</code> associated with this template (helps to avoid
     *            endless loops)
     * @param userid the userid for whom the template is being parsed
     * @param botid the botid for whom the template is being parsed
     * @param core the Core in use
     * @throws TemplateParserException if the <code>input</code> is null
     */
    public TemplateParser(String input, String userid, String botid, Core core) throws TemplateParserException
    {
        super(core.getAIMLProcessorRegistry(), core);
        if (input == null)
        {
            throw new TemplateParserException("No input supplied for TemplateParser!");
        }
        this.inputs.add(input);
        this._userid = userid;
        this._botid = botid;
    }

    /**
     * Processes the AIML within and including a given AIML element.
     * 
     * @param element the elment to process
     * @return the result of processing the tag
     * @throws ProcessorException if the AIML cannot be processed
     */
    public String processTag(Element element) throws ProcessorException
    {
        try
        {
            return super.processElement(element);
        }
        catch (StackOverflowError e)
        {
            Logger.getLogger("programd").error("Stack overflow error processing " + element.getLocalName() + " tag.");
            return "";
        }
    }

    /**
     * @see org.aitools.programd.parser.GenericParser#processResponse(java.lang.String)
     */
    @Override
    public String processResponse(String templateContent) throws ProcessorException
    {
        return super.processResponse(templateContent);
    }

    /**
     * Adds an input to the inputs list (for avoiding infinite loops).
     * 
     * @param input the input to add
     */
    public void addInput(String input)
    {
        this.inputs.add(input);
    }

    /**
     * Returns the input that matched the <code>pattern</code> associated with this template.
     * 
     * @return the input that matched the <code>pattern</code> associated with this template
     */
    public ArrayList<String> getInputs()
    {
        return this.inputs;
    }

    /**
     * Returns the values captured from the input path by wildcards in the <code>pattern</code>.
     * 
     * @return the values captured from the input path by wildcards in the <code>pattern</code>
     */
    public ArrayList<String> getInputStars()
    {
        return this.inputStars;
    }

    /**
     * Returns the the values captured from the input path by wildcards in the <code>that</code>.
     * 
     * @return the values captured from the input path by wildcards in the <code>that</code>
     */
    public ArrayList<String> getThatStars()
    {
        return this.thatStars;
    }

    /**
     * Returns the values captured from the input path by wildcards in the <code>topic name</code>.
     * 
     * @return the values captured from the input path by wildcards in the <code>topic name</code>
     */
    public ArrayList<String> getTopicStars()
    {
        return this.topicStars;
    }

    /**
     * Sets the <code>inputStars</code> list.
     * 
     * @param stars values captured from the input path by wildcards in the <code>pattern</code>
     */
    public void setInputStars(ArrayList<String> stars)
    {
        this.inputStars = stars;
    }

    /**
     * Sets the <code>thatStars</code> list.
     * 
     * @param stars values captured from the input path by wildcards in the <code>that</code>
     */
    public void setThatStars(ArrayList<String> stars)
    {
        this.thatStars = stars;
    }

    /**
     * Sets the <code>topicStars</code> Vector.
     * 
     * @param stars captured from the input path by wildcards in the <code>topic name</code>
     */
    public void setTopicStars(ArrayList<String> stars)
    {
        this.topicStars = stars;
    }

    /**
     * @return the userid
     */
    public String getUserID()
    {
        return this._userid;
    }

    /**
     * @return the botid
     */
    public String getBotID()
    {
        return this._botid;
    }
}
