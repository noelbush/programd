/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.graph;

import java.util.Set;

/**
 * A <code>Nodemapper</code> maps the branches in a {@link MemoryGraphmapper} structure.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 * @author Richard Wallace
 */
public interface Nodemapper {

  /**
   * Tells whether the <code>Nodemapper</code> contains the given key.
   * 
   * @param key the key to look for
   * @return boolean indicating whether the <code>Nodemapper</code> contains the key
   */
  public boolean containsKey(String key);

  /**
   * Gets an object from the <code>Nodemapper</code>.
   * 
   * @param key the key to use in retrieving the object
   * @return the object with that key (if found)
   */
  public Object get(String key);

  /**
   * Returns a weighted average of the sizes of this <code>Nodemapper</code> and its children. The average is
   * &quot;weighted&quot; by giving this <code>Nodemapper</code>'s size and the average size of its children equal
   * weight. If this <code>Nodemapper</code> does not have a parent (i.e., is the root), then its size is excluded from
   * the calculation.
   * 
   * @return the sizes of this <code>Nodemapper</code> and all its children.
   */
  public double getAverageSize();

  /**
   * Returns the height of the <code>Nodemapper</code>. The height is the minimum number of words needed to reach a leaf
   * node from here.
   * 
   * @return the height of the <code>Nodemapper</code>
   */
  public int getHeight();

  /**
   * Returns the parent of the <code>Nodemapper</code>
   * 
   * @return the parent of the <code>Nodemapper</code>
   */
  public Nodemapper getParent();

  /**
   * Returns the key set for the <code>Nodemapper</code>.
   * 
   * @return the Set of keys
   */
  public Set<String> keySet();

  /**
   * Puts an object into the <code>Nodemapper</code>.
   * 
   * @param key the key with which the object should be stored / will be retrieved
   * @param value the object to be stored
   * @return the same object that is stored
   */
  public Object put(String key, Object value);

  /**
   * Removes a node from the <code>Nodemapper</code>.
   * 
   * @param value the value to remove
   */
  public void remove(Object value);

  /**
   * Sets the parent of the <code>Nodemapper</code>
   * 
   * @param parent the parent of the <code>Nodemapper</code>
   */
  public void setParent(Nodemapper parent);

  /**
   * Sets the height of this <code>Nodemapper</code> to &quot;top&quot;, i.e. <code>0</code> (zero), causing each
   * ancestor <code>n</code> to have a minimum height of <code>n</code>, unless the ancestor is the root node.
   */
  public void setTop();

  /**
   * Returns the size of the <code>Nodemapper</code>
   * 
   * @return the size of the <code>Nodemapper</code>
   */
  public int size();
}
