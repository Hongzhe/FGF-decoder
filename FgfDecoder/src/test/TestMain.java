package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fdoGeometry.FgfGeometry;
import fdoGeometry.FgfGeometryException;
import fdoGeometry.FgfGeometryFactory;
import fdoGeometry.FgfGeometryType;
import fdoGeometry.FgfPoint;
import fdoGeometry.FgfPosition;

public class TestMain {

	public static void main(String[] args) throws SQLException,FgfGeometryException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:sqlite:D://HAD_Repo//fdo//20596647.sqlite");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * FROM HAD_NODE WHERE NODE_PID=11124";
		ResultSet rs = statement.executeQuery(cmd);
		byte[] bytes = rs.getBytes("GEOMETRY");
		FgfGeometryFactory factory = FgfGeometryFactory.getInstance();
		FgfGeometry geom = factory.createFgfGeometry(bytes);
		if(geom.getDrivedType() == FgfGeometryType.POINT) {
			FgfPoint point = (FgfPoint)geom;
			FgfPosition position = point.getPosition();
			//position.getX();
			System.out.println(position.getX() + " " + position.getY() + " " + position.getZ());
		}
	}

}
