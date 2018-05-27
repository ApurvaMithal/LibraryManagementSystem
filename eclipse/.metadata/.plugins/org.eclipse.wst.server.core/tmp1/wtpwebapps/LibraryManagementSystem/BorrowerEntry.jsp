<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Borrower Entry </title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            jQuery(window).ready(function() {

                $("#newBorrower").click(function(event) {
                    
                    var ssn = $('#ssn').val();
                    var name = $('#name').val();
                    var address = $('#address').val();
                    var phone = $('#phone').val();
                    jQuery.ajax({
                        url: "NewBorrowerServlet",
                        type: "get",
                        dataType: "json",
                        data: {
                            ssn: ssn,
                            name: name,
                            address: address,
                            phone: phone
                        },
                        success: function(data) {
                            // since we are using jQuery, you don't need to parse response
                            if(data[0].flag_maxLimit == 0 ){
                                alert("Error: Each BORROWER is permitted a maximum of 1 library card");
                            }
                            if(data[0].flag_ssn == 0 ){
                                alert("Error: SSN cannot be NULL");
                            }
                            if(data[0].flag_name == 0 ){
                                alert("Error: Name cannot be NULL");
                            }
                            if(data[0].flag_address == 0 ){
                                alert("Error: Address cannot be NULL");
                            }
                            if(data[0].flag_maxLimit == 1 && data[0].flag_ssn == 1 && data[0].flag_name == 1 && data[0].flag_address == 1 ){
                                alert("Borrower Record successfully created");
                            }

                        }
                    });

                });
            });
        </script>
    </head>

    <body>

        <div class="container">
            <h2>
                <font color="red">Enter a new Borrower Record</font>
            </h2>
			</br></br>
            <div class="newBorrower">
                <label for="newBorrower"><h3>Enter details of the Borrower</h3></label></br></br>
                SSN: <input type="text" id="ssn" placeholder="SSn..." name="ssn"></br></br>
                Name: <input type="text" id="name" placeholder="Name.." name="name"></br></br>
                Address: <input type="text" id="address" placeholder="Address.." name="address"></br></br>
                Phone No: <input type="text" id="phone" placeholder="Phone No.." name="phone"></br></br>
                
            </div>
			</br>
            <button type="submit" class="btn btn-default" id="newBorrower">Submit</button>

        </div>

    </body>

    </html>