<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Food Delivery System</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Food Delivery System -->
    <link href="/css/mdb.min.css" rel="stylesheet">

    <!-- Template styles -->
    <style rel="stylesheet">
        /* TEMPLATE STYLES */
        
        main {
            padding-top: 3rem;
            padding-bottom: 2rem;
        }
        
        .widget-wrapper {
            padding-bottom: 2rem;
            border-bottom: 1px solid #e0e0e0;
            margin-bottom: 2rem;
        }
        
        .reviews {
            text-align: center;
            border-top: 1px solid #e0e0e0;
            border-bottom: 1px solid #e0e0e0;
            padding: 1rem;
            margin-top: 1rem;
            margin-bottom: 2rem;
        }
        
        .price {
            position: absolute;
            left: 0;
            top: 0;
            margin-top: -2px;
        }
        
        .price .tag {
            margin: 0;
        }
    </style>

</head>

<body>
<<<<<<< HEAD
	<div style="margin: 0 auto; width: 300px">
		<br /> <br />
		<h2>Login</h2>
		<br /> <br />
		<form action="/login" method="post">
			<div style="float: left; padding: 8px 0px">
				<label for="userName">User Name</label> <input type="text"
					name="username" id="username" required autofocus>
			</div>
			<br />
			<div style="float: left; padding: 8px 0px">
				<label for="password">Password</label> <input type="password"
					name="password" id="password" required>
			</div>
			<br />
			<input type="hidden"       
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
			<div style="float: left; padding: 8px 0px">
				<button style="margin-left: 74px" type="submit">Sign in</button>
			</div>
			<br>
			<a href="/signUp">Sign Up?</a>
		</form>
	</div>
	<br />
=======


    <header>

        <!--Navbar-->
        <nav class="navbar navbar-dark primary-color-dark">

            <!-- Collapse button-->
            <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse" data-target="#collapseEx">
                <i class="fa fa-bars"></i>
            </button>

            <div class="container">

                <!--Collapse content-->
                <div class="collapse navbar-toggleable-xs" id="collapseEx">
                    <!--Navbar Brand-->
                    <a class="navbar-brand" href="http://mdbootstrap.com/material-design-for-bootstrap/" target="_blank">MDB</a>
                    <!--Links-->
                    <ul class="nav navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="/products">Home <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                    <!--Search form-->
                </div>
                <!--/.Collapse content-->

            </div>

        </nav>
        <!--/.Navbar-->

    </header>

    <main>

        <!--Main layout-->
                <!--Main column-->
                <div class="col-md-8 offset-md-2">

                    <!--Second row-->
                    <div class="row">

                        <!--Heading-->
                        <div class="reviews">
                            <h2 class="h2-responsive">Login</h2>
                        </div>

                        <br>
                        <form class="card" action="/login" method="post">
                            <div class="card-block">
                                <p><strong>Add a Product</strong></p>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                   <input type="text" id="username" name="username" id="username" required autofocus>
                                    <label for="username">UserName</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="password" id="password" name="password" id="password" required>
                                        <label for="password">Password</label>
                                </div>
                                <button class="btn btn-primary">Submit</button>
								<a href="/consumer/signUp">register now</a>
                            </div>
                        </form>

                </div>
                <!--/.Main column-->

            </div>
        </div>
        <!--/.Main layout-->

    </main>


    <!-- SCRIPTS -->

    <!-- JQuery -->
    <script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="/js/tether.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="/js/mdb.min.js"></script>

>>>>>>> 6f9b56950f71bb2dcbf32cb4faa5a3103020f818

</body>

</html>