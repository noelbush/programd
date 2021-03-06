/*
 * aitools utilities
 * Copyright (C) 2006 Noel Bush
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.aitools.util.resource;

import java.io.File;

/**
 * This exception indicates that an attempt to create a directory cannot be fulfilled, because there is already a file
 * with the requested name.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 * @since 4.5
 */
public class FileAlreadyExistsAsFileException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Creates a new FileAlreadyExistsAsFileException.
   * 
   * @param file the file that already exists
   */
  public FileAlreadyExistsAsFileException(File file) {
    super(String.format("\"%s\" already exists as a file.", file.getAbsolutePath()));
  }
}
