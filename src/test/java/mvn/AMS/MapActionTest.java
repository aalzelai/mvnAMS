package mvn.AMS;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import domain.dao.DaoFlight;
import domain.model.Flight;
import struts.action.MapAction;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class MapActionTest extends EasyMockSupport{


	private MapAction action = new MapAction();
	private DaoFlight dao = new DaoFlight();
	
	@Before
    public void setUp() throws Exception {
		
		
    }
    /**
     * Test if the login is ok.
     * @throws TestingEngineResponseException is the throw
     */
    @Test
    public void testActionMapOK(){
    	
 	    assertEquals("success",action.execute());
    }
}
