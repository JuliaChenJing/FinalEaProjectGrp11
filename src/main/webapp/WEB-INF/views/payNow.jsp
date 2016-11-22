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
                            <a class="nav-link" href="/products">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/orders/${userId}">Shopping Cart</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                    </ul>
                    <!--Search form-->
                    <form class="form-inline">
                        <input class="form-control" type="text" placeholder="Search">
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
                <div class="col-md-8">

                    <div class="row">

                        <!--Heading-->
                        <div class="Products">
                            <h2 class="h2-responsive">Order</h2>
                            <c:forEach var="order" items="${allOrders}">
                                <li>${order.product.name} : ${order.price}</li>
                            </c:forEach>
                            <p>Your total : ${total}</p>
                        </div>

                        <form class="card" method="post" action="/payments/${userId}/new">
                            <div class="card-block">
                                <p><strong>Update your address</strong></p>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="city" class="form-control" name="city" value="${user.city}" />
                                    <label for="city">City</label>
                                </div>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="street" class="form-control" name="street" value="${user.street}">
                                    <label for="street">Street Address</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="Zip" class="form-control" name="zip" value="${user.zip}">
                                        <label for="Zip">Zip</label>
                                </div>
                                <button type="button" id="updateAddress" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                    <div class="row">
                        <button class="btn btn-primary" id="makePay">Make Payment</button>
                    </div>

                    <div class="row">
                        <a href="/payments/${userId}"><button class="btn btn-primary">Update credit card</button></a>
                    </div>
                    <!--/.Second row-->
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
     <script type="text/javascript">
        $( document ).ready(function() {
            $("#updateAddress").click(function() {
                
                var updateBtn = confirm("Do you want to update your Address?");
                if(updateBtn) {
                    $.ajax({
                        url: '/consumer/${userId}/updateaddress',
                        data: {
                            "street": $("#street").val(),
                            "city": $("#city").val(),
                            "zip": $("#zip").val()
                        },
                        type: 'POST',
                        success: function(result) {
                            alert("update successful");
                        }
                    });
                }
            });

            $("#makePay").click(function() {
                
                var updateBtn = confirm("Do you want to pay now?");
                if(updateBtn) {
                    $.ajax({
                        url: '/payments/${userId}/pay',
                        type: 'POST',
                        success: function(result) {
                            alert("Your purchase will arrive within 30 minutes or its on us. Mean while go buy some more");
                            window.location.href="/products/";
                        },
                        error: function() {
                            alert("it seems you don't have enough credit on your account. Please use another card");
                        }
                    });
                }
            });
        });
    </script>
</body>

</html>