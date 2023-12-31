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
package org.cts.registry;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * This class parses the ignf file available in the resources package.
 * For a given code, it returns a map of parameters required by
 * {@link org.cts.CRSHelper} to build a {@link org.cts.crs.CoordinateReferenceSystem}.
 *
 * @author Erwan Bocher
 */
public class IGNFRegistry extends AbstractProjRegistry {

    /**
     * The regex that must be used to parse IGNF registry.
     */
    static final Pattern IGNF_REGEX = Pattern.compile("[ ]\\+|\\s<>");

    @Override
    public String getRegistryName() {
        return "ignf";
    }

    @Override
    public Map<String, String> getParameters(String code) throws RegistryException {
        try {
            Map<String, String> crsParameters = projParser.readParameters(code, IGNF_REGEX);
            return crsParameters;
        } catch (IOException ex) {
            throw new RegistryException("Cannot load the IGNF registry", ex);
        }
    }

    @Override
    public Set<String> getSupportedCodes() throws RegistryException {
        try {
            return projParser.getSupportedCodes(IGNF_REGEX);
        } catch (IOException ex) {
            throw new RegistryException("Cannot load the IGNF registry", ex);
        }
    }

    public List<String> getSupportedCodesWithNames() throws RegistryException {
        try {
            return projParser.getSupportedCodesWithNames(IGNF_REGEX);
        } catch (IOException ex) {
            throw new RegistryException("Cannot load the IGNF registry", ex);
        }
    }
}
