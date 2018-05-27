<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Checking In of the Books</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
		
        <style>
    table {
                border: 1px solid #666;
                width: 100%;
            }
    th {
                background: #f8f8f8;
                font-weight: bold;
                padding: 2px;
            }        
    tr{
        cursor:pointer;
        background: -moz-linear-gradient(top, #ffffff, #D1E3E9);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#ffffff), to(#D1E3E9));
        text-align:center;
    }
 
    tr:hover{
        background: -moz-linear-gradient(top, #249ee4, #057cc0);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#249ee4), to(#057cc0));
    }
 
    tr:active
    {
        background: -moz-linear-gradient(top, #057cc0, #249ee4);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#057cc0), to(#249ee4));
    }
 
    #result{
        font-weight:bold;
        font-size:16pt;
    }
</style>

                <script>
            jQuery(window).ready(function() {

                $("#checkInButton").click(function(event) {
                    
                    var cardID = $('#cardIdCI').val();
                    var isbn = $('#isbnCI').val();
                    var name = $('#nameCI').val();
                    jQuery.ajax({
                        url: "CheckInServlet",
                        type: "get",
                        dataType: "json",
                        data: {
                            cardId: cardID,
                            isbn: isbn,
                            name: name
                            
                        },
                        success: function(data) {
                            // since we are using jQuery, you don't need to parse response
                       
                            drawTable(data);
                            
                            $("#bookLoans tr").click(function(event) {
                            	  var content = this.children.length;
                            	  var loan_id = this.cells[0].innerHTML;
                            	  var isbn = this.cells[1].innerHTML;
                            	  var card_id = this.cells[2].innerHTML;
                            	  var date_out = this.cells[3].innerHTML;
                            	  var due_date = this.cells[4].innerHTML;
                            	  var date_in = this.cells[5].innerHTML;

                            	$("#checkInButton2").click(function(event) {
            					jQuery.ajax({
                                    url: "CheckInServletUpdate",
                                    type: "get",
                                    dataType: "json",
                                    data: {
                                        loan_id: loan_id,
                                        isbn: isbn,
                                        card_id: card_id,
                                        date_out: date_out,
                                        due_date: due_date,
                                        date_in: date_in
                                        
                                    },
                                    success: function(data) {
                                        // since we are using jQuery, you don't need to parse response
                                   		alert("Check In successfull");         
                                    }
                                });
                            	});
                            });
                                        
                        }
                    });

                });

                function drawTable(data) {
                	  $("#bookLoans").find("tr:not(:first)").remove();
                    for (var i = 0; i < data.length; i++) {
                        drawRow(data[i]);
                    }
                }

                function drawRow(rowData) {
                    var row = $("<tr />");
	                    $("#bookLoans").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
	                    row.append($("<td>" + rowData.loan_id + "</td>"));
	                    row.append($("<td>" + rowData.isbn + "</td>"));
	                    row.append($("<td>" + rowData.card_id + "</td>"));
	                    row.append($("<td>" + rowData.date_out + "</td>"));
	                    row.append($("<td>" + rowData.due_date + "</td>"));
	                    row.append($("<td>" + rowData.date_in + "</td>"));
	                    
                }

            });
</script>
        
    </head>

    <body>

        <div class="container">
           <h2>
                <font color="red">Checking In of the Book</font>
            </h2>
            <div class="checkIn">
                <label for="checkIn"><h3>Enter details for Book CheckIn</h3></label></br></br>
                Card Id:    <input type="text" id="cardIdCI" placeholder="Card Id.." name="cardId"></br></br>
                Book Isbn:  <input type="text" id="isbnCI" placeholder="Book Isbn.." name="bookIsbn"></br></br>
                Name:  <input type="text" id="nameCI" placeholder="Borrower Name.." name="Name"></br>
            </div>
			</br>
            <button type="submit" class="btn btn-default" id="checkInButton">Submit</button> 
            <button type="submit" class="btn btn-default" id="checkInButton2">Check In</button> </br></br>
       
            <table id="bookLoans" border="1" style="border-collapse: collapse;" cellpadding="8">
            <tr>
                <th>Loan_id</th>
                <th>Isbn</th>
                <th>Card_id</th>
                <th>Date_Out</th>
                <th>Due_date</th>
                <th>Date_in</th>
            </tr>

         </table>
		
        </div>
      

    </body>

    </html>