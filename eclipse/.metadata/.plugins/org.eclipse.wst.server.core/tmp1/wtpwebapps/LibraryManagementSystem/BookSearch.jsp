<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Book Search and Availability</title>
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
        </style>


        <script>
            jQuery(window).ready(function() {

                <%--  if ($('#searchBook')) { --%>
                $("#searchButton").click(function(event) {
                    
                    var filled = $('#searchBook').val();
                    console.log("hello");
                    jQuery.ajax({
                        url: "PopulateBook",
                        type: "get",
                        dataType: "json",
                        data: {
                            term: filled
                        },
                        success: function(data) {
                            // since we are using jQuery, you don't need to parse response
                            console.log("data", data);

                            drawTable(data);
                        }
                    });

                });


                function drawTable(data) {
                	  $("#bookTable").find("tr:not(:first)").remove();
                    for (var i = 0; i < data.length; i++) {
                        drawRow(data[i]);
                    }
                }

                function drawRow(rowData) {
                    var row = $("<tr />");
                    $("#bookTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
                    row.append($("<td>" + rowData.isbn + "</td>"));
                    row.append($("<td>" + rowData.title + "</td>"));
                    row.append($("<td>" + rowData.name + "</td>"));
                    row.append($("<td>" + rowData.avail + "</td>"));
                }
            });
        </script>
    </head>

    <body>

        <div class="container">
            <h2>
                <font color="red">Book Search and Availability</font>
            </h2>
			</br></br>
            <div class="searchArea">
                <label for="searchBook"><h3>Type Search String:</h3></label></br></br>
                <input type="text" width = "48px" height = "10px" id="searchBook" placeholder="Search Book.." name="search"></br></br>
            </div>

            <button type="submit" class="btn btn-default" id="searchButton">Submit</button></br></br>

        </div>
        <table id="bookTable" border="1" style="border-collapse: collapse;" cellpadding="8">
            <tr>
                <th>Isbn</th>
                <th>Title</th>
                <th>Name</th>
                <th>Availability</th>
            </tr>

        </table>

    </body>

    </html>