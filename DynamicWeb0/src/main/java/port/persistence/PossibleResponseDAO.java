package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.PossibleResponse;

public class PossibleResponseDAO implements IPossibleResponseDao {
	
	private String table = "possible_response";
	
	private String queryForResponses(String qid) {
		String query = "SELECT * from possible_response where questionId = '" + qid +"'";
		return query;
	}
	public String deleteResponseFromQuestion(String questionId, String responseId) {
		String sql = "DELETE FROM possible_question WHERE questionId='"+questionId+"' AND responseId='" + responseId + "'";
		return sql;
	}
	public boolean insertPossibleResponse(PossibleResponse response) throws SQLException {
		return this.insert(this.insertNewReponseQuery(response));
	}
	
	private String insertNewReponseQuery(PossibleResponse response) {
		String text = response.getText();
		boolean isCorrect = response.isCorrect();
		String qid = response.questionId();
		String rid = response.responseId();
		String name = response.getName();
		
		String sql = "INSERT INTO TABLE(questionid,responseid,iscorrect,text,name) VALUES(QID,RID,ISCOR,TEXT,NAME)";
		sql = sql.replace("QID", "'"+qid+"'")
				.replace("RID", "'"+rid+"'")
				.replace("ISCOR", ""+isCorrect)
				.replace("TEXT", "'"+text+"'")
				.replace("NAME", "'"+name+"'");
		return sql;
	}
	public String assignReponsesToQuestion(List<PossibleResponse> responses) {
//		String sql = "INSERT INTO possible_response VALUES \n";
//		for(int i = 0; i < responses.size(); i++) {
//			PossibleResponse response = responses.get(i);
//			sql = sql + "(" + response.questionId() + ", " +  response.responseId() + ", " + response.isCorrect() + ", " + response.getText() + ")";
//			if(i == responses.size() - 1) {
//				sql += ";";
//			} else {
//				sql += ",";
//			}
//		}
//		return sql;
		String sql = "";
		for(PossibleResponse pr : responses) {
			sql += this.insertPossibleResponse(pr) + ",\n";
		}
		sql += sql.substring(0, sql.length()-2) + ";";
		return sql;
		
	}
	public List<PossibleResponse> getResponsesFromQuestion(String qid) {
		Connection conn = DbSupport.getConnection();
		//List<PossibleResponse> responses = new ArrayList<>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(queryForResponses(qid));
			List<PossibleResponse> responses = loadResponses(rs);
			return responses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	private List<PossibleResponse> loadResponses(ResultSet rs) throws SQLException {
		List<PossibleResponse> responses = new ArrayList<>();
		while(rs.next()) {
			boolean isCorrect = rs.getBoolean(3);
			String text = rs.getString(4);
			PossibleResponse pr = new PossibleResponse();
			pr.setAsCorrect(isCorrect);
			pr.setText(text);
			responses.add(pr);
			return responses;
		}
		return null;
	}
	
	private boolean insert(String sql) throws SQLException {
		Statement s = DbSupport.getConnection().createStatement();
		int res = s.executeUpdate(sql);
		return res!=0;
	}
	private List<PossibleResponse> find(String sql) throws SQLException {
		Statement s = DbSupport.getConnection().createStatement();
		ResultSet set  = s.executeQuery(sql);
		return map(set);
	}
	private List<PossibleResponse> map(ResultSet rs) throws SQLException {
		List<PossibleResponse> responses = new LinkedList<>();
		while(rs.next()) {
			boolean isCorrect = rs.getBoolean("isCorrect");
			String text = rs.getString("text");
			String responseId = rs.getString("responseid");
			String questionId = rs.getString("questionId");
			String name = rs.getString("name");
			PossibleResponse response = new PossibleResponse(responseId, questionId, isCorrect, text, name);
			responses.add(response);
		}
		return responses;
	}
	@Override
	public void createNewResponse(PossibleResponse aResponse) {
	}
	@Override
	public void updateResponse(PossibleResponse aResponse) {
	}
	@Override
	public void deleteREsponse(PossibleResponse aResponse) {
	}
	@Override
	public Collection<PossibleResponse> getReponsesByQuestion(String questionId) {
		return null;
	}
	
	
}
