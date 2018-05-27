<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FinePayment</title>
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
    
	$("#finePaymentBtn").click(function(event) {
		var card_id = $('#card_id').val();
        var isbn = $('#isbn').val();
        jQuery.ajax({
            url: "FinePaymentServlet",
            type: "get",
            dataType: "json", 
            data: {
            	card_id : card_id,
            	isbn : isbn 
            },
            success: function(data) {
                // since we are using jQuery, you don't need to parse response
                
                drawTable(data);
                $("#fineDetails tr").click(function(event) {
              	  var loan_id = this.cells[0].innerHTML;
              	  var isbn = this.cells[1].innerHTML;
              	  var card_id = this.cells[2].innerHTML;
              	  var date_out = this.cells[3].innerHTML;
              	  var due_date = this.cells[4].innerHTML;
              	  var date_in = this.cells[5].innerHTML;
              	  var fine_amt = this.cells[6].innerHTML;
              	  var paid = this.cells[7].innerHTML;

              	$("#finePaymentBtn2").unbind().click(function(event) {
					jQuery.ajax({
                      url: "FinePaymentPayServlet",
                      type: "get",
                      dataType: "json",
                      data: {
                          loan_id: loan_id
                          
                      },
                      success: function(data2) {
                          // since we are using jQuery, you don't need to parse response
                          	if(data2[0].flag == 0){
                          		alert("Error: Payment of a fine for book that is not yet returned not allowed");    
                          	}
                          	if(data2[0].flag == 1){
                          		alert("Payment successful");   
                          	}
                     		      
                      }
                  });
              	});
                });
            }
        });

    });     

	$("#finePaymentBtn3").click(function(event) {
        jQuery.ajax({
            url: "FinePaymentDisplayServlet",
            type: "get",
            dataType: "json", 
            data: {
            },
            success: function(data) {
                // since we are using jQuery, you don't need to parse response
                
                drawTableFine(data);
              
            }
        });

    });     
	
        function drawTable(data) {
        	  $("#fineDetails").find("tr:not(:first)").remove();
            for (var i = 0; i < data.length; i++) {
                drawRow(data[i]);
            }
        }

        function drawRow(rowData) {
            var row = $("<tr />");
            $("#fineDetails").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
            row.append($("<td>" + rowData.loan_id + "</td>"));
            row.append($("<td>" + rowData.isbn+ "</td>"));
            row.append($("<td>" + rowData.card_id + "</td>"));
            row.append($("<td>" + rowData.date_out + "</td>"));
            row.append($("<td>" + rowData.due_date + "</td>"));
            row.append($("<td>" + rowData.date_in + "</td>"));
            row.append($("<td>" + rowData.fine_amt + "</td>"));
            row.append($("<td>" + rowData.paid + "</td>"));
            
        }
        function drawTableFine(data) {
      	  $("#fineDetailsSum").find("tr:not(:first)").remove();
          for (var i = 0; i < data.length; i++) {
              drawRowFine(data[i]);
          }
      }

      function drawRowFine(rowData) {
          var row = $("<tr />");
          $("#fineDetailsSum").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
          row.append($("<td>" + rowData.card_id + "</td>"));
          row.append($("<td>" + rowData.fine_amt + "</td>"));
          row.append($("<td>" + rowData.paid + "</td>"));
          
      }
    });
</script>
</head>
<body>
 <div class="container">
 <h2>
                <font color="red">Fine Payment</font>
            </h2>
	<div class="finePayment">
                <label for="finePayment"><h3>Pay Fine</h3></label></br></br>
                Card Id:    <input type="text" id="card_id" placeholder="Card Id.." name="cardId">
                Book Isbn:  <input type="text" id="isbn" placeholder="Book Isbn.." name="bookIsbn"></br>
                
            
            </div>
			</br>
            <button type="Submit" class="btn btn-default" id="finePaymentBtn">Get Fine Details</button>
            <button type="Submit" class="btn btn-default" id="finePaymentBtn2">Pay</button>
            <button type="Submit" class="btn btn-default" id="finePaymentBtn3">Display Fines</button>
			</br></br>
            
            <table id="fineDetails" border="1" style="border-collapse: collapse;" cellpadding="8">
            <tr>
                <th>Loan_id</th>
                <th>Isbn</th>
                <th>Card_id</th>
                <th>Date_Out</th>
                <th>Due_Date</th>
                <th>Date_in</th>
                <th>Fine_amt</th>
                <th>Paid</th>
            </tr>
         </table>
         </br></br></br>
          <table id="fineDetailsSum" border="1" style="border-collapse: collapse;" cellpadding="8">
            <tr>
                <th>Card_id</th>
                <th>Total_fine</th>
                <th>Paid</th>
            </tr>

         </table>
         
         </div>
</body>
</html>