<!DOCTYPE html>
<!-- saved from url=(0047)http://getbootstrap.com/examples/justified-nav/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon"  href='/innoassessment/static/images/vitruvio.png'/>
    <title>Innoassessment</title>
    <!-- Bootstrap core CSS -->    
    <link href='/innoassessment/static/modernStyle/bootstrap.min.css' rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->    
    <link href='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.css' rel="stylesheet">
     <!-- Custom styles for this template -->
    <link href='/innoassessment/static/modernStyle/justified-nav.css' rel="stylesheet">
	 <script src='/innoassessment/static/modernStyle/ie-emulation-modes-warning.js' ></script>
</head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Product Innovation Assessment Tool</h3>
        <nav>
          <ul class="nav nav-justified">
            <li class="active"><a href="<c:url value='/home'/>">Home</a></li>
            <li><a href="<c:url value='/home-administration'/>">Administration</a></li>
            <li><a href="http://getbootstrap.com/examples/justified-nav/#">Services</a></li>
            <li><a href="http://getbootstrap.com/examples/justified-nav/#">Downloads</a></li>
            <li><a href="http://getbootstrap.com/examples/justified-nav/#">About</a></li>
            <li><a href="http://getbootstrap.com/examples/justified-nav/#">Contact</a></li>
          </ul>
        </nav>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Sistemas Intensivos en Software</h1>
        <p class="lead">
El estudio y an�lisis de los factores que afectan a la innovaci�n de productos de software para determinar el �xito de los mismos es crucial y determinante. 
Aplicando t�cnicas de evaluaci�n de productos de software podemos determinar el �xito de los mismos.
</p>
        <p><a class="btn btn-lg btn-success" href="http://getbootstrap.com/examples/justified-nav/#" role="button">Get started today</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Safari bug warning!</h2>
          <p class="text-danger">As of v8.0, Safari exhibits a bug in which resizing your browser horizontally causes rendering errors in the justified nav that are cleared upon refreshing.</p>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="http://getbootstrap.com/examples/justified-nav/#" role="button">View details �</a></p>
        </div>
        <div class="col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="http://getbootstrap.com/examples/justified-nav/#" role="button">View details �</a></p>
       </div>
        <div class="col-lg-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
          <p><a class="btn btn-primary" href="http://getbootstrap.com/examples/justified-nav/#" role="button">View details �</a></p>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>� 2015 Company, Inc.</p>
      </footer>

    </div> <!-- /container -->



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js' ></script>
  

</body></html>