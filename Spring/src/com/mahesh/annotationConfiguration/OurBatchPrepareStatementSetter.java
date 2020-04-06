package com.mahesh.annotationConfiguration;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

public class OurBatchPrepareStatementSetter implements BatchPreparedStatementSetter {

	private List<DeveloperPojo> developerList;

	public OurBatchPrepareStatementSetter(List<DeveloperPojo> developerList) {
		this.developerList = developerList;
	}

	@Override
	public int getBatchSize() {
		return developerList.size();
	}

	@Override
	public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
		preparedStatement.setInt(1, developerList.get(i).getId());
		preparedStatement.setString(2, developerList.get(i).getName());
		preparedStatement.setInt(3, developerList.get(i).getAge());
		preparedStatement.setString(4, developerList.get(i).getCompanyName());
	}

}
