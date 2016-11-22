<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
                            <a class="nav-link" href="/orders/1">Shopping Cart</a>
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
                <div class="col-md-12">

                    <!--First row-->
                    <div class="row col-md-8 col-md-offset-4">
                        <div class="widget-wrapper">
                        <h4>Product Info:</h4>
                        <br>
                        <form class="card" method="post" action="/products/${product.id}/update">
                            <div class="card-block">
                                <p><strong>Add a Product</strong></p>
                                <div class="md-form">
                                    <i class="fa fa-credit-card prefix"></i>
                                    <input type="text" id="name" class="form-control" name="name" value="${product.name}">
                                    <label for="name">Product Name</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="description" class="form-control" name="description" value="${product.description}">
                                        <label for="description">Product Description</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="unitPrice" class="form-control" name="unitPrice"  value="${product.unitPrice}">
                                        <label for="unitPrice">Unit Price</label>
                                </div>
                                <div class="md-form">
                                        <i class="fa fa-credit-card prefix"></i>
                                        <input type="text" id="manufacturer" class="form-control" name="manufacturer"  value="${product.manufacturer}">
                                        <label for="manufacturer">Manufacturer</label>
                                </div>
                                <div class="md-form">
                                  <select name="categoryId"  value="${product.category}">
                                    <option value="" disabled selected>Choose your category</option>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="md-form">
                                  <select name="supplierId"  value="${product.supplier}">
                                    <option value="" disabled selected>Choose your Supplier</option>
                                    <c:forEach var="supplier" items="${suppliers}">
                                        <option value="${supplier.id}">${supplier.name}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="md-form clearfix">
                                    Select a file: <input type="file" name="productImage">
                                </div>
                                <button class="btn btn-primary">Submit</button>
                                <buttpn type="button" id="deleteProduct" class="btn btn-primary">Delete</buttpn>
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

    <script type="text/javascript">
        $( document ).ready(function() {
            $("#deleteProduct").click(function() {
                
                var deleteBtn = confirm("Do you want to delete this Product?");
                if(deleteBtn) {
                    $.ajax({
                        url: '/products/${product.id}/delete',
                        type: 'DELETE',
                        success: function(result) {
                            window.location.href = "/orders";
                        }
                    });
                }
            });
        });
    </script>
</body>

</html>