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

/**
 * The Class MapActionTest.
 */
public class MapActionTest extends EasyMockSupport{


	/** The action. */
	private MapAction action = new MapAction();
	
	/** The dao. */
	private DaoFlight dao = new DaoFlight();
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
    public void setUp() throws Exception {
		
		
    }
    
    /**
     * Test if the login is ok.
     */
    @Test
    public void testActionMapOK(){
    	
 	    assertEquals("success",action.execute());
    }
}
