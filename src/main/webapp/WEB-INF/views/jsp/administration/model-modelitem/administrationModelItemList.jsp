<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href='/innoassessment/static/images/vitruvio.png' />
<title>Innoassessment</title>
<!-- Bootstrap core CSS -->
<link href='/innoassessment/static/modernStyle/bootstrap.min.css'
	rel="stylesheet">
<link href='/innoassessment/static/css/estilo.css' rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.css'
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href='/innoassessment/static/modernStyle/justified-nav.css'
	rel="stylesheet">
<script
	src='/innoassessment/static/modernStyle/ie-emulation-modes-warning.js'></script>
</head>

<body>
	<div class="container">
		<%@ include file="../../common/header.jsp" %> 	     
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">ModelItem List</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Model Name</th>
							<th>Model Year</th>
							<th>Model Version</th>
							<th>Model Description</th>
							<th>Dimension Name</th>
							<th>Factor Name</th>
							<th>Factor Definition</th>
							<th>Impact</th>
							<th>Weight</th>
							<th>Interpretation</th>
							<th>Help</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${modelItemList}" var="modelItem">
							<tr>
								<td>${modelItem.id}</td>
								<td>${modelItem.modelName}</td>
								<td>${modelItem.modelYear}</td>
								<td>${modelItem.modelVersion}</td>
								<td>${modelItem.modelDescription}</td>
								<td>${modelItem.dimensionName}</td>
								<td>${modelItem.factorName}</td>
								<td>${modelItem.factorDefinition}</td>
								<td>${modelItem.impact}</td>
								<td>${modelItem.weight}</td>
								<td>${modelItem.interpretation}</td>
								<td>${modelItem.help}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12" align="center">
				<p>
					<a class="btn btn-primary"
						href="/innoassessment/administration/create-modelitem"
						role="button">Create ModelItem �</a>
				</p>
			</div>
		</div>

		<%@ include file="../../common/footer.jsp" %> 	
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>

</body>
</html>