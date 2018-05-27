<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Fine Processing</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
		

       
        
        <script>
            jQuery(window).ready(function() {

                $("#fineUpdateBtn").click(function(event) {
                    
                    jQuery.ajax({
                        url: "FineUpdateServlet",
                        type: "get",
                        dataType: "json",
                        data: {
                        },
                        success: function(data) {
                            // since we are using jQuery, you don't need to parse response
                            
                            if(data[0].flag == 1){
                                alert("Successful update");
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
                <font color="red">Fine Processing</font>
            </h2>
            <div class="fineUpdate">
                <label for="fineUpdate"><h3>Update fine details</h3></label></br></br>
             </div>
            <button type="Submit" class="btn btn-default" id="fineUpdateBtn">Update Fine</button>
			</br></br>
		
			
		
        </div>
      

    </body>

    </html>