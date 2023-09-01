package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.*;

public class ConnectionsPoolTest {
	private static final int ID1 = 1;
	private static final int ID2 = 2;
	private static final int ID3 = 3;
	private static final int ID4 = 4;
	ConnectionsPool pool;
	Connection connection4 = new Connection(ID4, "", 0);
	Connection[] connections = { new Connection(ID1, "0.0.0.0", 0), new Connection(ID2, "0.0.0.0", 0),
			new Connection(ID3, "0.0.0.0", 0), };

	@BeforeEach
	void setUp() {
		pool = new ConnectionsPoolImpl(3);
		IntStream.range(0, connections.length).forEach(i -> pool.addConnection(connections[i]));
	}

	@Test
	void addConnectionTest() {
		assertFalse(pool.addConnection(connections[0]));
		assertTrue(pool.addConnection(connection4));
		assertTrue(pool.addConnection(connections[0]));
		assertTrue(pool.addConnection(connections[1]));
	}

	@Test
	void getConnectionTest() {
		assertNull(pool.getConnection(ID4));
		assertEquals(ID1, pool.getConnection(ID1).id);
		pool.addConnection(connection4);
		assertNull(pool.getConnection(ID2));
		assertNotNull(pool.getConnection(ID1));
	}
}