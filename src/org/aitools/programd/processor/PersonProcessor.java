/*    
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.
    
    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, 
    USA.
*/

package org.aitools.programd.processor;

import org.aitools.programd.bot.Bots;
import org.aitools.programd.parser.TemplateParser;
import org.aitools.programd.parser.XMLNode;
import org.aitools.programd.util.Substituter;

/**
 *  <p>
 *  Handles a
 *  <code><a href="http://www.alicebot.org/TR/2001/WD-aiml/#section-person">person</a></code>
 *  element.
 *  </p>
 *  <p>
 *  Currently does not permit definition of person substitutions
 *  in an external file (they are hard-coded in {@link Substituter#person}.
 *  </p>
 *
 *  @version    4.1.3
 *  @author     Jon Baer
 *  @author     Thomas Ringate, Pedro Colla
 */
public class PersonProcessor extends AIMLProcessor
{
    public static final String label = "person";

    public String process(int level, XMLNode tag, TemplateParser parser)
    {
        if (tag.XMLType == XMLNode.TAG)
        {
            try
            {
                // Return the processed contents of the element, properly substituted.
                return parser.processResponse(
                    applySubstitutions(
                        parser.evaluate(level++, tag.XMLChild),
                        parser.getBotID()));
            }
            catch (ProcessorException e)
            {
                return EMPTY_STRING;
            }
        }
        else
        {
            return parser.shortcutTag(
                level,
                label,
                tag.TAG,
                EMPTY_STRING,
                StarProcessor.label,
                tag.EMPTY);
        }
    }

    /**
     *  Applies substitutions as defined in the {@link #substitutionMap}.
     *  Comparisons are case-insensitive.
     *
     *  @param  input   the input on which to perform substitutions
     *
     *  @return the input with substitutions performed
     */
    public static String applySubstitutions(String input, String botid)
    {
        return Substituter.applySubstitutions(
            Bots.getBot(botid).getPersonSubstitutionsMap(),
            input);
    }
}
