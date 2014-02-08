<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <title>Bootply.com - Blue Template Fixed Sidebar + Header</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-glyphicons.css" type="text/css" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link rel="shortcut icon" href="/bootstrap/img/favicon.ico">
        <link rel="apple-touch-icon" href="/bootstrap/img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="/bootstrap/img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="/bootstrap/img/apple-touch-icon-114x114.png">


        <!-- CSS code from Bootply.com editor -->
        
        <style type="text/css">
            body {
	padding-top:50px;
}

#masthead {
	min-height:270px;
	background-color:#000044;
  	color:#aaaacc;
}

#masthead h1 {
	font-size: 55px;
	line-height: 1;
}

#masthead .well {
	margin-top:13%;
	background-color:#111155;
  	border-color:#000033;
}

.icon-bar {
	background-color:#fff;
}

@media screen and (min-width: 768px) {
	#masthead h1 {
		font-size: 100px;
	}
}

.navbar-bright {
	background-color:#111155;
    color:#fff;
}
  
.navbar-bright a, #masthead a, #masthead .lead {
  	color:#aaaacc;
}

.navbar-bright li > a:hover {
    background-color:#000033;
}

.affix-top,.affix{
	position: static;
}

@media (min-width: 979px) {
  #sidebar.affix-top {
    position: static;
  	margin-top:30px;
  	width:228px;
  }
  
  #sidebar.affix {
    position: fixed;
    top:70px;
    width:228px;
  }
}

#sidebar li.active {
  	border:0 #eee solid;
  	border-right-width:4px;
}

        </style>
    </head>
    
    <!-- HTML code from Bootply.com editor -->
    
    <body  >
        
        
<header class="navbar navbar-bright navbar-fixed-top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="/" class="navbar-brand">Bootply</a>
    </div>
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav">
        <li>
          <a href="#sec">Get Started</a>
        </li>
        <li>
          <a href="#sec">Edit</a>
        </li>
        <li>
          <a href="#sec">Visualize</a>
        </li>
        <li>
          <a href="#sec">Prototype</a>
        </li>
      </ul>
    </nav>
  </div>
</header>

<div id="masthead">  
  <div class="container">
      <div class="row">
        <div class="col-md-7">
          <h1>Bootply
            <p class="lead">The easiest way to apply Bootstrap</p>
          </h1>
        </div>
        <div class="col-md-5">
            <div class="well well-lg"> 
              <div class="row">
                <div class="col-sm-6">
        	      	<img src="//placehold.it/180x100" class="img-responsive">
                </div>
                <div class="col-sm-6">
	              	<strong>Important</strong>
                  	<p>Blah blah blah blah bla!</p>
                </div>
              </div>
            </div>
        </div>
      </div> 
  </div><!-- /cont -->
</div>

<!-- Begin Body -->
<div class="container">
	<div class="row">
  			<div class="col-md-3" id="leftCol">              
<tiles:insertAttribute name="leftsidebar"/>
      		</div>  
      		<div class="col-md-9">
              	<tiles:insertAttribute name="content"/>
              
              </div> 
  	</div>
</div>



        
        <script type='text/javascript' src="js/jquery-1.10.2.min.js"></script>


        <script type='text/javascript' src="js/bootstrap.min.js"></script>



        
        <!-- JavaScript jQuery code from Bootply.com editor -->
        
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            $('#sidebar').affix({
      offset: {
        top: 245
      }
});

var $body   = $(document.body);
var navHeight = $('.navbar').outerHeight(true) + 10;

$body.scrollspy({
	target: '#leftCol',
	offset: navHeight
});
        
        });
        
        </script>
        
    </body>
</html>