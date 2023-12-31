/*
 * Coordinate Transformations Suite (abridged CTS)  is a library developped to 
 * perform Coordinate Transformations using well known geodetic algorithms 
 * and parameter sets. 
 * Its main focus are simplicity, flexibility, interoperability, in this order.
 *
 * This library has been originally developed by Michaël Michaud under the JGeod
 * name. It has been renamed CTS in 2009 and shared to the community from 
 * the OrbisGIS code repository.
 *
 * CTS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License.
 *
 * CTS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * CTS. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <https://github.com/orbisgis/cts/>
 */
package org.cts.cs;

import java.util.Arrays;

/**
 * An exception arising while trying to work out of a valid area defined by an
 * Extent object.
 *
 * @author Michaël Michaud
 */
public class OutOfExtentException extends Exception {

    /**
     * Create a new OutOfExtentException.
     *
     * @param exception description of this exception
     */
    public OutOfExtentException(String exception) {
        super(exception);
    }

    /**
     * Create a new OutOfExtentException.
     *
     * @param coord the coord responsible for this exception
     */
    public OutOfExtentException(double[] coord) {
        super("The coordinate " + Arrays.toString(coord) + " is out of the valid Extent");
    }

    /**
     * Create a new OutOfExtentException.
     *
     * @param coord the coord responsible for this exception
     * @param extent the valid extent
     */
    public OutOfExtentException(double[] coord, Extent extent) {
        super("The coordinate " + Arrays.toString(coord) + " is out of "
                + extent.toString());
    }
}
