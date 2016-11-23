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
                            <a class="nav-link" href="/products/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/orders/${userId}">Shopping Cart</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/payments/${userId}">Payment Info</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                    </ul>
                    <!--Search form-->
                    <form class="form-inline">
                        <a href="/logout"><button class="btn btn-danger">logout</button></a>
                    </form>
                </div>
                <!--/.Collapse content-->

            </div>

        </nav>
        <!--/.Navbar-->

    </header>

    <main>

        <!--Main layout-->
        <div class="container">
            <div class="row">
                <!--Main column-->
                <div class="col-md-12">

                    <!--First row-->
                    <div class="row col-md-8 col-md-offset-4">
                        <div class="widget-wrapper">
                        <h4>Credit Info:</h4>
                        <br>
                        <form class="card" method="post" action="/payments/${userId}/new">
                            <div class="card-block">
                                <p><strong>Add your card detail</strong></p>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="cardType" class="form-control" name="cardType" value="Credit" readonly="readonly" />
                                    <label for="cardType">Card Type {Currently only credit card is supported}</label>
                                </div>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="cardNumber" class="form-control" name="cardNumber">
                                    <label for="cardNumber">Card Number</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="CVV" class="form-control" name="CVV">
                                        <label for="CVV">CVV</label>
                                </div>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="ExpirtyDate" class="form-control" name="expiryDate">
                                    <label for="ExpirtyDate">DD/MM/YYYY</label>
                                </div>
                                <div class="md-form clearfix">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="nameOnCard" class="form-control" name="nameOnCard">
                                    <label for="nameOnCard">Name on your card</label>
                                </div>
                                <button class="btn btn-primary">Submit</button>

                            </div>
                        </form>
                    </div>
                    </div>
                    <!--/.First row-->
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


</body>

</html>