/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.logging;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Filters out chatlog events.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 */
public class ChatLogEventFilter extends Filter {

  /**
   * @see org.apache.log4j.spi.Filter#decide(org.apache.log4j.spi.LoggingEvent)
   */
  @Override
  public int decide(LoggingEvent event) {
    return event instanceof ChatLogEvent ? Filter.NEUTRAL : Filter.DENY;
  }
}
