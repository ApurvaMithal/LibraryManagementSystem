<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Checking Out / In of the Books</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script>
            jQuery(window).ready(function() {

                $("#checkOutButton").click(function(event) {
                    
                    var cardID = $('#cardId').val();
                    var isbn = $('#isbn').val();
                    jQuery.ajax({
                        url: "CheckOutServlet",
                        type: "get",
                        dataType: "json",
                        data: {
                            term1: cardID,
                            term2: isbn
                        },
                        success: function(data) {
                            // since we are using jQuery, you don't need to parse response
                            if(data[0].flag_maxLimit == 0 ){
                                alert("Error: Each BORROWER is permitted a maximum of 3 BOOK LOANS\n");
                            }
                            if(data[0].flag_avail == 0 ){
                                alert("Error: Book is currently not available\n");
                            }
                            if(data[0].flag_maxLimit == 1 && data[0].flag_avail == 1){
                                alert("Successful checkout");
                            }

                          //  drawTable(data);
                        }
                    });

                });
            });
        </script>
        
    </head>

    <body>

        <div class="container">
            <h2>
                <font color="red">Checking Out of the Book</font>
            </h2>
            <div class="checkOut">
                <label for="checkOut"><h3>Enter details for Book Checkout</h3></label></br></br>
                Card Id:    <input type="text" id="cardId" placeholder="Card Id.." name="cardId"></br></br>
                Book Isbn:  <input type="text" id="isbn" placeholder="Book Isbn.." name="bookIsbn"></br>
            </div>
			</br>
            <button type="submit" class="btn btn-default" id="checkOutButton">Check Out</button>
		
  
        </div>
      

    </body>

    </html>