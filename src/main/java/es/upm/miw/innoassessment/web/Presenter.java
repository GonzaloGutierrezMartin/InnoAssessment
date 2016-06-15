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
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {

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
	private ModelItemController modelItemController;


	@Autowired
	private QuestionnaireController questionnaireController;

	// Se ejecuta siempre y antes. Añade un atributo al Model
	@ModelAttribute("now")
	public String now() {
		return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		// La vista resultante no lleva extensión (.jsp) configurado en
		// WebConfig.java
		return "jsp/home";
	}
	
	@RequestMapping("/homeDevelop")
	public String homedevelop(Model model) {
		// La vista resultante no lleva extensión (.jsp) configurado en
		// WebConfig.java
		return "jsp/homeDevelop";
	}

	@RequestMapping("/assessmentLine-list")
	public ModelAndView listAssessmentLines(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/assessmentLineList");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}

	

	@RequestMapping("/product-list")
	public ModelAndView listProduct(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productList");
		modelAndView.addObject("productList", productController.showProducts());
		return modelAndView;
	}

	@RequestMapping("/productversion-list")
	public ModelAndView listProductVersion(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersions());
		return modelAndView;
	}

	@RequestMapping(value = { "/search-productversion/{id}" })
	public ModelAndView searchProductVersion(@PathVariable int id, Model model) {
		System.out.println("---- PRESENTER searchProductVersion  " + id);
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(id));
		return modelAndView;		
	}

	@RequestMapping("/model-list")
	public ModelAndView listModel(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/modelList");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}
	
	@RequestMapping("/modelitem-list")
	public ModelAndView listModelItem(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/modelItemList");
		modelAndView.addObject("modelItemList", modelItemController.showModelItems());
		//modelAndView.addObject("modelItemList", modelItemController.showModelItemsByModelAndDimension(1, 1));
		return modelAndView;
	}

	@RequestMapping("/questionnaire-list")
	public ModelAndView listQuestionnaire(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/questionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	@RequestMapping("/productQuestionnaire-list")
	public ModelAndView listProductQuestionnaire(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping("/assessmentline-list")
	public ModelAndView listAssessmentLine(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/assessmentLineList");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}
	
	@RequestMapping("/assessmentlinedimension-list")
	public ModelAndView listAssessmentDimensionLine(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/assessmentLineListByDimension");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLinesByDimension(2));
		return modelAndView;
	}

	@RequestMapping(value = "/productQuestionnaire-list", method = RequestMethod.POST)
	public String listProductQuestionnaireSelect(@Valid QuestionnaireWrapper questionnaire, BindingResult bindingResult,
			Model model) {
		System.out.println("-------------PRESENTER listProductQuestionnaireSelect");
		System.out.println("---- PRESENTER  " + questionnaire.getId());

		return "jsp/list/productQuestionnaireList";
	}

	@RequestMapping(value = { "/search-questionnaire/{id}" })
	public ModelAndView searchQuestionnaire(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		modelAndView.addObject("questionnaireListChoice", questionnaireController.showQuestionnairesByModel(id));
		return modelAndView;

		// return "jsp/list/productQuestionnaireList";
	}
	@RequestMapping("/productAssesmentQuestionnaire-list")
	public ModelAndView listProductAssessmentQuestionnaire(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productAssessmentQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/search-productAssessmentQuestionnaire/{id}" })
	public ModelAndView searchProductAssessmentQuestionnaire(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productAssessmentQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		modelAndView.addObject("questionnaireListChoice", questionnaireController.showQuestionnairesByModel(id));
		return modelAndView;
		// return "jsp/list/productQuestionnaireList";
	}
	
	@RequestMapping("/questionnaire-product2")
	public ModelAndView listQuestionnaireProducts2(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectQuestionnaireProduct");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/build-questionnaireOLD/{id}" })
	public ModelAndView buildQuestionnaireOLD(@PathVariable int id, Model model
			,@RequestParam(value="dimensionId", required=false, defaultValue="1") int dimensionId) {
		System.out.println("------------- RequestParam dimensionId: " + dimensionId);
		ModelAndView modelAndView = new ModelAndView("jsp/create/questionnaireBuild");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("productList", productController.showProducts());
		System.out.println("----------------------- PRESENTER BUIDQUESTIONNAIRE " + dimensionId);
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLinesByDimension(dimensionId));
		return modelAndView;
		
	}

	

	@RequestMapping(value = "/create-product", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new ProductWrapper());
		return "jsp/create/productCreate";
	}

	@RequestMapping(value = "/create-product", method = RequestMethod.POST)
	public String createProductSubmit(@Valid ProductWrapper product, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (productController.createProduct(product.getName(), product.getDescription(), product.getProvider())) {
				model.addAttribute("name", product.getName());
				model.addAttribute("description", product.getDescription());
				model.addAttribute("name", product.getProvider());
				model.addAttribute("id", product.getId());
				return "jsp/list/productList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product ya existente");
			}
		} 
		return "jsp/create/createProduct";
	}

	@RequestMapping(value = "/create-productversion/{id}", method = RequestMethod.GET)
	public ModelAndView createProductVersion(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/create/productVersionCreate");
		modelAndView.addObject("product", productController.showProduct(id));
		modelAndView.addObject("productVersion", new ProductVersionWrapper(id));
		return modelAndView;
	}

	@RequestMapping(value = "/create-productversion/{id}", method = RequestMethod.POST)
	public String createProductVersionSubmit(@Valid ProductVersionWrapper productVersion, BindingResult bindingResult,
			Model model) {
		System.out.println("--- CREATE PRODUCT VERSION:" +productVersion.getName()+"-" + productVersion.getProductId());
		System.out.println(bindingResult.toString());
		if (!bindingResult.hasErrors()) {
			System.out.println("--- CREAR");
			if (productVersionController.createProductVersion(productVersion.getName(), productVersion.getProductId())) {
				model.addAttribute("name", productVersion.getName());
				model.addAttribute("description", productVersion.getDescription());
				model.addAttribute("productId", productVersion.getProductId());
				return "jsp/list/productList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product version ya existente");
			}
		}
		return "jsp/list/productList";
	}
	

	@RequestMapping(value = "/create-productversionold", method = RequestMethod.POST)
	public String createProductVersionSubmitold(@Valid ProductVersionWrapper productVersion,
			BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (productVersionController.createProductVersion(productVersion.getName(),
					productVersion.getProductId())) {
				model.addAttribute("name", productVersion.getName());
				model.addAttribute("productId", productVersion.getProductId());
				return "jsp/list/productList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product version ya existente");
			}
		}
		return "jsp/create/createProductVersion";
	}

	@RequestMapping(value = "/create-model", method = RequestMethod.GET)
	public String createModel(Model model) {
		model.addAttribute("model", new ModelWrapper());
		return "jsp/create/modelCreate";
	}

	@RequestMapping(value = "/create-model", method = RequestMethod.POST)
	public String createModelSubmit(@Valid ModelWrapper modelw, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (modelController.createModel(modelw.getName(), modelw.getYear(), modelw.getVersion(),
					modelw.getDescription())) {
				model.addAttribute("name", modelw.getName());
				model.addAttribute("year", modelw.getYear());
				model.addAttribute("version", modelw.getVersion());
				model.addAttribute("description", modelw.getDescription());
				model.addAttribute("id", modelw.getId());
				return "jsp/registrationSuccess";
			} else {
				bindingResult.rejectValue("name", "error.model", "Model ya existente");
			}
		}
		return "jsp/create/createModel";
	}
	
	@RequestMapping(value = { "/build-questionnaireDimensions" })
	public ModelAndView buildQuestionnaireDimensions(Model model) {
		int questionnaireId = 1;
		ModelAndView modelAndView = new ModelAndView("jsp/create/questionnaireDimensions");
		// TODO CAMBIAR id questionario
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(1));

		// System.out.println("----------------------- PRESENTER
		// BUIDQUESTIONNAIRE DIMENSION: " + dimensionId);
		modelAndView.addObject("assessmentLineList",
				// assessmentLineController.showAssessmentLinesByDimension(dimensionId)
				assessmentLineController.showAssessmentLinesByQuestionnaire(questionnaireId));
		return modelAndView;

	}

	

	@RequestMapping(value = { "/delete-product/{id}" })
	public String deleteProduct(@PathVariable int id, Model model) {
		productController.deleteProduct(id);
		model.addAttribute("productList", productController.showProducts());
		return "jsp/list/productList";
	}
	@RequestMapping(value = { "/delete-productversion/{id}" })
	public String deleteProductVersion(@PathVariable int id, Model model) {
		productVersionController.deleteProductVersion(id);
		model.addAttribute("productVersionList", productVersionController.showProductVersions());
		return "jsp/list/productVersionList";
	}

	@RequestMapping(value = { "/delete-model/{id}" })
	public String deleteModel(@PathVariable int id, Model model) {
		modelController.deleteModel(id);
		model.addAttribute("modelList", modelController.showModels());
		return "jsp/list/modelList";
	}

}
