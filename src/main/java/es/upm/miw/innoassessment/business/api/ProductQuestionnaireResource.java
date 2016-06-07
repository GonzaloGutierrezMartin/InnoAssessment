package es.upm.miw.innoassessment.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.QUESTIONNAIREBYMODEL)
public class ProductQuestionnaireResource {

	private QuestionnaireController questionnaireController;

	@Autowired
	public void setQuestionnaireController(QuestionnaireController questionnaireController) {
		this.questionnaireController = questionnaireController;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void selectQuestionnaire(@RequestParam(required = true) int modelId) {
		//TODO
		System.out.println("-------------product questionnaire resource");
		//this.questionnaireController.showQuestionnairesByModel(modelId);
		//this.modelController.createModel(name, year, version, description);
	}
	

	@RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
	public void deleteQuestionnaire(@PathVariable int id) {
		this.questionnaireController.deleteQuestionnaire(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionnaireWrapper> showQuestionnaires() {
		System.out.println("-------------product questionnaire showQuestionnaires");
		return questionnaireController.showQuestionnaires();
	}

}
