package org.cts;

import org.cts.crs.CRSException;
import org.cts.crs.CoordinateReferenceSystem;
import org.cts.crs.GeodeticCRS;
import org.cts.cs.CoordinateSystem;
import org.cts.datum.GeodeticDatum;
import org.cts.op.CoordinateOperation;
import org.cts.op.CoordinateOperationException;
import org.cts.op.CoordinateOperationFactory;
import org.cts.registry.EPSGRegistry;
import org.cts.registry.RegistryException;
import org.cts.registry.RegistryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClassForUnity {

    public static String returnTestValue(){
        return "Hat geklappt";
    }

    public static String calculateWithEPSGCode(double lat, double lng, int sourceEPSGCode, int targetEPSGCode) throws CRSException, CoordinateOperationException, IllegalCoordinateException {


        // Create a new CRSFactory, a necessary element to create a CRS without defining one by one all its components
        CRSFactory cRSFactory = new CRSFactory();

// Add the appropriate registry to the CRSFactory's registry manager. Here the EPSG registry is used.
        RegistryManager registryManager = cRSFactory.getRegistryManager();
        registryManager.addRegistry(new EPSGRegistry());

// CTS will read the EPSG registry seeking the 4326 code, when it finds it,
// it will create a CoordinateReferenceSystem using the parameters found in the registry.
        //CoordinateReferenceSystem crs1 = cRSFactory.getCRS("EPSG:4326");

        CoordinateReferenceSystem crs1 = cRSFactory.getCRS("EPSG:"+sourceEPSGCode);
        CoordinateReferenceSystem crs2 = cRSFactory.getCRS("EPSG:"+targetEPSGCode);


        GeodeticCRS sourceGCRS = (GeodeticCRS) crs1;
        GeodeticCRS targetGCRS = (GeodeticCRS) crs2;

         Set<CoordinateOperation> coordOps =  CoordinateOperationFactory.createCoordinateOperations(sourceGCRS,targetGCRS);


// Note that we get a List and not a single CoordinateTransformation, because several methods may exist to
// transform a position from crs1 to crs2

        String value = "";
        if (coordOps.size() != 0) {

        // Test each transformation method (generally, only one method is available)
        for (CoordinateOperation op : coordOps) {
         //Transform coord using the op CoordinateOperation from crs1 to crs2

            double[] dd  = op.transform(new double[]{lng,lat});

            value += dd[0] + "/"+dd[1] + "; ";

        }

        }
        return value;
    }

    public static List<String> getAllCoordinateSystems() throws RegistryException {
        // Create a new CRSFactory, a necessary element to create a CRS without defining one by one all its components
        CRSFactory cRSFactory = new CRSFactory();

// Add the appropriate registry to the CRSFactory's registry manager. Here the EPSG registry is used.
        RegistryManager registryManager = cRSFactory.getRegistryManager();
        registryManager.addRegistry(new EPSGRegistry());

        List<String> returnList = new ArrayList<>(cRSFactory.getSupportedCodesWithNames("EPSG"));
        return returnList;

    }


}
