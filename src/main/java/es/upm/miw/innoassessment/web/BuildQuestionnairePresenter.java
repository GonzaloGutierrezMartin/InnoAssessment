package es.upm.miw.innoassessment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.AssessmentLineController;
import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.EvaluationController;
import es.upm.miw.innoassessment.business.controllers.LineValueController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.controllers.SourceUrlController;
import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListAssessmentLine;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.LineValue;
import es.upm.miw.innoassessment.data.entities.SourceUrl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class BuildQuestionnairePresenter {

	static final String PATH = "jsp/public/build-questionnaire";
	
	@Autowired
	private AssessmentLineController assessmentLineController;

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductVersionController productVersionController;

	@Autowired
	private ModelController modelController;

	@Autowired
	private QuestionnaireController questionnaireController;

	@Autowired
	private EvaluationController evaluationController;

	@Autowired
	private LineValueController lineValueController;
	
	@Autowired
	private SourceUrlController sourceUrlController;
		
			
	@RequestMapping("/build-questionnaire-select-model")
	public ModelAndView buildQuestionnaireSelectModel(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView(PATH + "/buildQuestionnaireSelectModel");
		modelAndView.addObject("modelList", modelController.showModels());
		if (modelId != 0) {
			modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnairesByModel(modelId));
		}
		return modelAndView;
	}
	
	@RequestMapping("/build-questionnaire-select-product/{id}")
	public ModelAndView buildQuestionnaireSelectProduct(Model model, @PathVariable int id,
			@RequestParam(value = "productId", required = false, defaultValue = "0") int productId) {
		ModelAndView modelAndView = new ModelAndView(PATH+"/buildQuestionnaireSelectProduct");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("productList", productController.showProducts());
		if (productId != 0) {
			modelAndView.addObject("product", productController.showProduct(productId));
			modelAndView.addObject("productVersionList",
					productVersionController.showProductVersionsByProduct(productId));
			modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(id));
		}
		return modelAndView;
	}
	
	@RequestMapping(value = { "/build-questionnaire/{id}" })
	public ModelAndView buildQuestionnaire(@PathVariable int id, Model model,
			@RequestParam(value = "productVersionId", required = true) int productVersionId,
			@RequestParam(value = "processQuestionnaire", required = false, defaultValue = "0") int processQuestionnaire) {
		ModelAndView modelAndView = new ModelAndView(PATH + "/buildQuestionnaire");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("productVersion", productVersionController.showProductVersion(productVersionId));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(id));
		ListAssessmentLine listAssessmentLine = new ListAssessmentLine();
		listAssessmentLine.setAssessmentList(assessmentLineController.showAssessmentLinesByQuestionnaire(id));
		modelAndView.addObject("listAssessmentLine", listAssessmentLine);
		return modelAndView;
	}

	@RequestMapping(value = {
			"/build-questionnaire/{questionnaireId}/productversion/{productVersionId}" }, method = RequestMethod.POST)
	public String buildQuestionnaireSubmit(@PathVariable int questionnaireId, @PathVariable int productVersionId,
			@ModelAttribute("listAssessmentLine") ListAssessmentLine listAssessmentLine, BindingResult bindingResult,
			Model model) {
		int evaluationId = evaluationController.createEvaluation(questionnaireId, productVersionId);
		ArrayList<LineValue> lineValues = new ArrayList<LineValue>();
		for (AssessmentLineWrapper assessmentLine : listAssessmentLine.getAssessmentList()) {
			String [] arrayURLInit = assessmentLine.getArrayUrl();
			List<SourceUrl> sourcesUrls = new ArrayList<SourceUrl>();
			for (int i = 0; i < arrayURLInit.length; i++) {
				if (arrayURLInit[i] != null && arrayURLInit[i] != ""){
					sourcesUrls.add(new SourceUrl(arrayURLInit[i]));
				}				
			}; 
			sourceUrlController.createSourceUrl(sourcesUrls);
			lineValues.add(new LineValue(new Evaluation(evaluationId), new AssessmentLine(assessmentLine.getId()),
					assessmentLine.getRadioValue(), 0, sourcesUrls, null));
		}
		lineValueController.createLineValues(lineValues, questionnaireId, evaluationId);
		return "jsp/home";
	}

}
