<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="<c:url value='/static/images/vitruvio.png' />" />
	<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
	<script language='Javascript' src="<c:url value='/static/js/tabsQuestionnaire.js' />"></script>
	<script language='Javascript' src="<c:url value='/static/js/overlib.js' />"></script>
	
	<script type="text/javascript">
	function processQuestionnaire(questionnaireId,productVersionId){
		alert("processQuestionnaire");
		var url = window.location.href; 
		url += "&processQuestionnaire=1";
		//var url = '/innoassessment/process-questionnaire/'+questionnaireId + '?productVersionId='+productVersionId;
		//window.location.href = url;
		var urltemp ="/innoassessment/build-questionnaire/1/productversion/1";
		window.location.href = urltemp;
	}

	</script>
	<title>Innoassessment</title>
</head>
    <body>
        <div class="myheader">
            Product innovation assessment questionnaire
             <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
        </div>
            <fieldset name='date_evaluation'>
                <legend>Evaluation Date</legend><p />
                Model: <b>${questionnaireDetail.modelName}</b> 
                - Questionnaire: <b>${questionnaireDetail.name}</b>
                Date: <input name='evaluation_date' value='${fecha}'/>
                Time: <input name='evaluation_time' value='${hora}'/>
                <input type='hidden' name='model' value='questionnaireDetail.modelId' />
                <input type='hidden' name='questionnaire' value='questionnaireDetail.Id' />
            </fieldset>
            <fieldset name='product_evaluation'>
                <legend>Product</legend><p/>
                Name: <b>${productVersion.productName}</b> 
                - Description: <b>${productVersion.productDescription}</b></br>
                Version of Product: <b>${productVersion.name}</b>
                <input type='hidden' name='productVersion' value='productVersion.id' /></br></br>     	
      		</fieldset>
      		
      		
    

      		<div id='pestanas'>
		<div id='dTabs' style='padding-left: 1%;'>
			<c:forEach items="${dimensionList}" var="dimension">
				<input id='btnDim${dimension.id}' type='button' class='tab' style='border: 2px solid #568FBD;' onClick="showAssessments(${dimension.id})"
					value='${dimension.name}'>
			</c:forEach>
		</div>

<form:form method="post" action="/innoassessment/build-questionnaire/${questionnaireDetail.modelId}/productversion/1" modelAttribute="listAssessmentLine">
		<div id='cont'
			style='border: 1px solid #4682B4; border-radius: 8px; padding: 1%; margin-top: -0.9%;'>
			<div id='pesta0' style='display: block;'>
				<c:forEach items="${listAssessmentLine.assessmentList}" var="assessmentLine" varStatus = "status">
					<div
						id='al_${assessmentLine.modelItemDimensionId}-${assessmentLine.id}'>
						<fieldset name='${assessmentLine.id}'>
							<legend>${assessmentLine.modelItemFactorName}<a
									onmouseover="return overlib('<b><i>${assessmentLine.modelItemFactorName}</i></b><br><br><b>Definition:</b><br>${assessmentLine.modelItemFactorDefinition}.<br><br><b>Interpretation:</b><br>${assessmentLine.modelItemInterpretation}<br><br><b>Help:</b><br> ${assessmentLine.modelItemHelp}',ABOVE, WIDTH, 500, FGCOLOR, '#FFF4CB', BGCOLOR, '#174A75', TEXTCOLOR, '#A68E34');"
									onmouseout='return nd();'
									style='position: relative; top: 1.5px; left: 4px;'> 
									<img src="<c:url value='/static/images/icon_help.gif' />" alt='Help' height='16px' width='16px'/>
									
									</a>
							</legend>
							
							<table width='100%'>
								<tr>
									<td>									
									 <input name="assessmentList[${status.index}].id" value='${assessmentLine.id}'  type="hidden"/>									
									  
										<div style='text-align: center'>
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion0' value='Unknown' checked='checked'> 
												<label for='opcion0'>Unknown</label> 
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion9' value='Not Applicable'> 
												<label for='opcion9'>Not Applicable</label> 
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion1' value='Very Few'> 
												<label for='opcion1'>Very Few</label>
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion2' value='Few'> 
												<label for='opcion2'>Few</label> 
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion3' value='Medium'> 
												<label for='opcion3'>Medium</label> 
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion4' value='High'>
												<label for='opcion4'>High</label> 
												<input type='radio' name='assessmentList[${status.index}].id' id='opcion5' value='Very High'>
												<label for='opcion5'>Very High</label>
												
												



												
												
												
												
										</div>
										
									</td>
									<td>
										<div id='btnSee' style='text-align: center'>
											<input id='btnUploads_${assessmentLine.id}' type='button'
												value='Add Files'
												onclick="showDivUploads('sf_${assessmentLine.id}', 'btnUploads_${assessmentLine.id}');" />
										</div>
									</td>
								</tr>
							</table>
							<div id='sf_${assessmentLine.id}' style='display: none;'>
								<table width='100%'>
									<tr>
										<td width='50%'>
											<fieldset name='url' style='text-align: center;'>
												<legend>Add url</legend>
												<div id='${assessmentLine.id}_url'>
													<input type='url' id='urlstoupload_${assessmentLine.id}'
														name='urlstoupload_${assessmentLine.id}' multiple=''>
												</div>
												<a href='#'
													onclick="addFieldUrl('${assessmentLine.id}_url', '${assessmentLine.id}')">
													<button type='button'>Add more</button>
												</a>
											</fieldset>
										</td>
										<td>
											<fieldset name='files' style='text-align: center;'>
												<legend>Add file</legend>
												<div id='${assessmentLine.id}_files'>
													<input type='hidden' name='MAX_FILE_SIZE' value='5000000'>
													<input type='file' id='filestoupload_${assessmentLine.id}'
														name='filestoupload_${assessmentLine.id}[]'>
												</div>
												<a href='#' onclick="addField('${assessmentLine.id}_files')">
													<button type='button'>Add more</button>
												</a>
											</fieldset>
										</td>
									</tr>
								</table>
							</div>
						</fieldset>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>  
	 <button id='btn_submit' class = 'mybutton' style = 'display: block;' type="submit"   value="Submit">Submit Questionnaire</button>   
	</form:form>     
			        
           
         
           
           
    </body>
</html>