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

                <!--Sidebar-->
                <div class="col-md-4">

                    <div class="widget-wrapper">
                        <h4>Categories:</h4>
                        <br>
                        <div class="list-group">
                            <a href="/products/list/all" class="list-group-item active">View Products</a>
                            <a href="/suppliers/list/all" class="list-group-item">View Supplier</a>
                            <a href="/category/list/all" class="list-group-item">View Category</a>
                            <a href="/orders/undelivered" class="list-group-item">View Orders</a>
                        </div>
                    </div>
                </div>
                <!--/.Sidebar-->
                      <!--Main layout-->
        <div class="container">
            <div class="row">

                <!--Main column-->
                <div class="col-md-8">

                    <div class="row">

                        <!--Heading-->
                        <div class="Products">
                            <h2 class="h2-responsive">Products</h2>
                            <a href="/products/add"><button class="btn btn-primary">Add Product</button></a>
                        </div>

                        <!--First review-->
                        <c:forEach var="product" items="${allProducts}">
                            <div class="media">
                                <a class="media-left" href="/products/${product.id}">
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

                        </c:forEach>
                    </div>
                    <!--/.Second row-->

                </div>
                <!--/.Main column-->

            </div>
        </div>
        <!--/.Main layout-->

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