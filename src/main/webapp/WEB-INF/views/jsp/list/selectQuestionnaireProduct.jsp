<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"  href="<c:url value='/static/images/bulb-favicon.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo-origin.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">

<script type="text/javascript">
function showProductVersions(productId) {
	reloadPage('productId',productId);
}

function loadBuildQuestionnaire(questionnaireId){
	var selectBox = document.getElementById("ddlProductVersion");
    var productVersionId = selectBox.options[selectBox.selectedIndex].value;
	var url = '/innoassessment/questionnaire-build/'+questionnaireId + '?productVersionId='+productVersionId;
	window.location.href = url;
}

function reloadPage(param,value){
	param = param + "=" + value;
	var url = window.location.href; 
	if (url.indexOf('?') > -1){
		if (param.substring(0,8) == "productId"){
	 	var res = url.substring(0,url.indexOf('?'))
	 	url = res + '?' + param
		}
		else {
			url +=  '&' + param;
		}
	}else{
	   	url += '?' + param
	}
	window.location.href = url;
}
</script>
<title>Innoassessment</title>
</head>

<body>   
     <div class="myheader">
            Questionnaire Products
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>
      <fieldset name='date_evaluation'>
                <legend>Evaluation Date</legend><p />
                Model: <b>${questionnaireDetail.modelName}</b> 
                - Questionnaire: <b>${questionnaireDetail.name}</b>
                Date: <input name='evaluation_date' value='${fecha}'/>
                Time: <input name='evaluation_time' value='${hora}'/>
                <input type='hidden' name='model' value='questionnaireDetail.modelId' />
                <input type='hidden' name='questionnaire' value='questionnaireDetail.id'/><br><br>
                <a href="<c:url value='/model-questionnaire/'/>">Change Model</a>
      </fieldset>
      
      <c:choose>
    <c:when test="${!empty param.productId && param.productId > 0}">
       <fieldset name='product_evaluation'>
                <legend>Product</legend><p/>
                Name: <b>${product.name}</b> 
                - Description: <b>${product.description}</b>
                <input type='hidden' name='product' value='product.id' /><br><br>              
      	<a href="<c:url value='/questionnaire-product/${questionnaireDetail.id}'/>">Change Product</a>
      	</fieldset>
       <fieldset name='product_version'>
        <legend>Product Version</legend><p/>
         Select a version of the product:
    	<select name="product" id = "ddlProductVersion" >
                <c:forEach items="${productVersionList}" var="productVersion" varStatus="status">
  					<option value="${productVersion.id}">${productVersion.name}</option>
				</c:forEach> 
		</select>
		</fieldset>
		 <button id='btn_submit' class = 'mybutton' style = 'display: block;' type="submit" value="Submit" 
		 onclick="loadBuildQuestionnaire(${questionnaireDetail.id});">
		 Build Questionnaire</button>
    	</c:when>    
    	<c:otherwise>
         <div class="myheader2" align='center'>Product List</div>
    		<table  class="table table-bordered">
        		<thead>
           		 <tr>
            		<th>Product Id</th>
                	<th>Model Name</th>
               	 	<th>Model Description</th>
               		<th>Model Provider</th>  
                	<th>#</th>                                             
            	</tr>
        		</thead>
        	<tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.provider}</td>                   
                	<td><input id="product" type='radio' name='product' value="${product.id}" onchange="showProductVersions(${product.id});" ${param.productId==product.id?'checked':''}></td>			    				
                </tr>
            </c:forEach>
        	</tbody>
    		</table>      
    	</c:otherwise>
		</c:choose>   
	<p><a href="<c:url value='/home'/>">Home</a></p>
</body>
</html>