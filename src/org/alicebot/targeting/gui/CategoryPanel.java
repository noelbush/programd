/*
    Alicebot Program D
    Copyright (C) 1995-2001, A.L.I.C.E. AI Foundation
    
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.
    
    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, 
    USA.
*/

package org.alicebot.targeting.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.alicebot.targeting.Target;
import org.alicebot.targeting.TargetingTool;

/**
 *  A panel for viewing categories and their activation counts.
 */
public class CategoryPanel extends TargetAwareTabulator
{
    /**
     *  Creates a new <code>CategoryPanel</code>, loading
     *  data from the currently live targets.
     */
    public CategoryPanel(TargetingGUI gui)
    {
        super(
            new String[] { "activations", "<pattern>", "<that>", "<topic>" },
            gui);
    }

    public void updateFromTargets()
    {
        List targets = TargetingTool.getSortedTargets();
        Iterator targetIterator = targets.iterator();
        ArrayList rows = new ArrayList();

        while (targetIterator.hasNext())
        {
            Target target = (Target) targetIterator.next();
            rows.add(
                new Object[] {
                    new Integer(target.getActivations()),
                    target.getMatchPattern(),
                    target.getMatchThat(),
                    target.getMatchTopic(),
                    target,
                    new Integer(1)});
        }
        Object[][] newData = new Object[][] {
        };
        newData = (Object[][]) rows.toArray(newData);
        if (newData.length > 0)
        {
            reloadData(newData);
        }
    }
}