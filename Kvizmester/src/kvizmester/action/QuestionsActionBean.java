package kvizmester.action;

import java.util.List;

import kvizmester.beans.Category;
import kvizmester.beans.Question;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;

public class QuestionsActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/admin/questions.jsp";
	
	public static final String VIEW2 = "/WEB-INF/web/admin/newQuestion.jsp";
	
	public static final String VIEW3 = "/WEB-INF/web/admin/redirectToQuestion.jsp";
	
	List<Question> questionList;
	
	private int deleteQuestionId;
	
	private int modifyQuestionId;
	
	private int categoryId;
	
	private String question;
	
	private String answer;
	
	private String wrongAnswer1;
	
	private String wrongAnswer2;
	
	private String wrongAnswer3;
	
	private int level;
	
	private List<Category> categoryList;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		
		categoryList = test.getAllCategory();
		
		questionList = test.getAllQuestions();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution newQuestion() {
		OracleConnection test = new OracleConnection();
		
		categoryList = test.getAllCategory();
		
		return new ForwardResolution(VIEW2);
	}
	
	public Resolution uploadQuestion() {
		OracleConnection test = new OracleConnection();
		
		
		if(! test.uploadQuestion(categoryId, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW2);
		}
		
		categoryList = test.getAllCategory();
		
		questionList = test.getAllQuestions();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution deleteQuestion() {
		OracleConnection test = new OracleConnection();
				
		if(! test.deleteQuestion(deleteQuestionId)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW2);
		}
		
		categoryList = test.getAllCategory();
		
		questionList = test.getAllQuestions();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution updateQuestion() {
		OracleConnection test = new OracleConnection();
				
		if(! test.updateQuestionById(modifyQuestionId, categoryId, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, level)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW);
		}
		
		categoryList = test.getAllCategory();
		
		questionList = test.getAllQuestions();
		
		return new ForwardResolution(VIEW3);
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDeleteQuestionId() {
		return deleteQuestionId;
	}

	public void setDeleteQuestionId(int deleteQuestionId) {
		this.deleteQuestionId = deleteQuestionId;
	}
	
	public void setModifiedQuestionId(int modifiedQuestionId){
		this.modifyQuestionId = modifiedQuestionId;
	}
}
