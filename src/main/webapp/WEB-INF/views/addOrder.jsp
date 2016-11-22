<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:if test="${not empty pageContext.request.userPrincipal}">
    User <c:out value="${pageContext.request.userPrincipal}" />
</c:if>

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
                        </div>

                        <!--First review-->
                            <div class="media">
                                <a class="media-left" href="#">
                                    <img class="img-circle" src="/products/image/${product.id}" alt="Generic placeholder image" width="50px">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">${product.name}</h4>
                                    <ul class="rating inline-ul">
                                        <li><i class="fa fa-star amber-text"></i></li>
                                        <li><i class="fa fa-star amber-text"></i></li>
                                        <li><i class="fa fa-star amber-text"></i></li>
                                        <li><i class="fa fa-star"></i></li>
                                        <li><i class="fa fa-star"></i></li>
                                    </ul>
                                    <p>Price: ${product.unitPrice}</p>
                                    <p>Description: ${product.description}</p>
                                </div>
                                <a class="media-right" href="#">
                                    <img class="img-circle" src="/suppliers/image/${product.supplier.id}" alt="Generic placeholder image" width="50px">
                                </a>
                            </div>
                            <form class="card" method="post" action="/orders/${userId}/${product.id}/new">
                                <div class="card-block">
                                    <p><strong>Add your order</strong></p>
                                    <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="number" id="quantity" class="form-control" name="quantity">
                                        <label for="quantity">Quantity</label>
                                    </div>
                                    <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="price" class="form-control" name="none" readonly>
                                        <label for="price">Price</label>
                                    </div>
                                    <button class="btn btn-primary">Submit</button>

                                </div>
                            </form>
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
            $('#quantity').change(function() {
                console.log("changing");
                var unitPrice = ${product.unitPrice};
                var quantity = $('#quantity').val();
                $("#price").val(unitPrice * quantity);
                $("#price").addClass("active");
                console.log($("#price").closest("i"));
                $("#price").closest("i").addClass("active");
            });
        });
    </script>
</body>

</html>