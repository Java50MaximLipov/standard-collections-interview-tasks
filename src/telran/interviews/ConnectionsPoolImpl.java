package telran.interviews;

import java.util.*;

public class ConnectionsPoolImpl implements ConnectionsPool {
	int limit; // limit of connections number in a pool
	LinkedHashMap<Integer, Connection> connections = new LinkedHashMap<>(16, 0.75f, true) {
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Connection> eldestEntry) {
			return size() > limit;
		}
	};

	public ConnectionsPoolImpl(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		if (!connections.containsKey(connection.getId())) {
			res = true;
			connections.put(connection.getId(), connection);
		}
		return res;
	}

	@Override
	public Connection getConnection(int id) {
		return connections.get(id);
	}
}