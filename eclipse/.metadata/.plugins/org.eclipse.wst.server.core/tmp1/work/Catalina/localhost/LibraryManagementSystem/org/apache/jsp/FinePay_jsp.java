/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.85
 * Generated at: 2018-03-10 21:10:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FinePay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>FinePayment</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("  <style>\r\n");
      out.write("    table {\r\n");
      out.write("                border: 1px solid #666;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("    th {\r\n");
      out.write("                background: #f8f8f8;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                padding: 2px;\r\n");
      out.write("            }        \r\n");
      out.write("    tr{\r\n");
      out.write("        cursor:pointer;\r\n");
      out.write("        background: -moz-linear-gradient(top, #ffffff, #D1E3E9);\r\n");
      out.write("        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#ffffff), to(#D1E3E9));\r\n");
      out.write("        text-align:center;\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    tr:hover{\r\n");
      out.write("        background: -moz-linear-gradient(top, #249ee4, #057cc0);\r\n");
      out.write("        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#249ee4), to(#057cc0));\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    tr:active\r\n");
      out.write("    {\r\n");
      out.write("        background: -moz-linear-gradient(top, #057cc0, #249ee4);\r\n");
      out.write("        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#057cc0), to(#249ee4));\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    #result{\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("        font-size:16pt;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("jQuery(window).ready(function() {\r\n");
      out.write("    \r\n");
      out.write("\t$(\"#finePaymentBtn\").click(function(event) {\r\n");
      out.write("\t\tvar card_id = $('#card_id').val();\r\n");
      out.write("        var isbn = $('#isbn').val();\r\n");
      out.write("        jQuery.ajax({\r\n");
      out.write("            url: \"FinePaymentServlet\",\r\n");
      out.write("            type: \"get\",\r\n");
      out.write("            dataType: \"json\", \r\n");
      out.write("            data: {\r\n");
      out.write("            \tcard_id : card_id,\r\n");
      out.write("            \tisbn : isbn \r\n");
      out.write("            },\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("                // since we are using jQuery, you don't need to parse response\r\n");
      out.write("                \r\n");
      out.write("                drawTable(data);\r\n");
      out.write("                $(\"#fineDetails tr\").click(function(event) {\r\n");
      out.write("              \t  var loan_id = this.cells[0].innerHTML;\r\n");
      out.write("              \t  var isbn = this.cells[1].innerHTML;\r\n");
      out.write("              \t  var card_id = this.cells[2].innerHTML;\r\n");
      out.write("              \t  var date_out = this.cells[3].innerHTML;\r\n");
      out.write("              \t  var due_date = this.cells[4].innerHTML;\r\n");
      out.write("              \t  var date_in = this.cells[5].innerHTML;\r\n");
      out.write("              \t  var fine_amt = this.cells[6].innerHTML;\r\n");
      out.write("              \t  var paid = this.cells[7].innerHTML;\r\n");
      out.write("\r\n");
      out.write("              \t$(\"#finePaymentBtn2\").unbind().click(function(event) {\r\n");
      out.write("\t\t\t\t\tjQuery.ajax({\r\n");
      out.write("                      url: \"FinePaymentPayServlet\",\r\n");
      out.write("                      type: \"get\",\r\n");
      out.write("                      dataType: \"json\",\r\n");
      out.write("                      data: {\r\n");
      out.write("                          loan_id: loan_id\r\n");
      out.write("                          \r\n");
      out.write("                      },\r\n");
      out.write("                      success: function(data2) {\r\n");
      out.write("                          // since we are using jQuery, you don't need to parse response\r\n");
      out.write("                          \tif(data2[0].flag == 0){\r\n");
      out.write("                          \t\talert(\"Error: Payment of a fine for book that is not yet returned not allowed\");    \r\n");
      out.write("                          \t}\r\n");
      out.write("                          \tif(data2[0].flag == 1){\r\n");
      out.write("                          \t\talert(\"Payment successful\");   \r\n");
      out.write("                          \t}\r\n");
      out.write("                     \t\t      \r\n");
      out.write("                      }\r\n");
      out.write("                  });\r\n");
      out.write("              \t});\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });     \r\n");
      out.write("\r\n");
      out.write("\t$(\"#finePaymentBtn3\").click(function(event) {\r\n");
      out.write("        jQuery.ajax({\r\n");
      out.write("            url: \"FinePaymentDisplayServlet\",\r\n");
      out.write("            type: \"get\",\r\n");
      out.write("            dataType: \"json\", \r\n");
      out.write("            data: {\r\n");
      out.write("            },\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("                // since we are using jQuery, you don't need to parse response\r\n");
      out.write("                \r\n");
      out.write("                drawTableFine(data);\r\n");
      out.write("              \r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });     \r\n");
      out.write("\t\r\n");
      out.write("        function drawTable(data) {\r\n");
      out.write("        \t  $(\"#fineDetails\").find(\"tr:not(:first)\").remove();\r\n");
      out.write("            for (var i = 0; i < data.length; i++) {\r\n");
      out.write("                drawRow(data[i]);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function drawRow(rowData) {\r\n");
      out.write("            var row = $(\"<tr />\");\r\n");
      out.write("            $(\"#fineDetails\").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it\r\n");
      out.write("            row.append($(\"<td>\" + rowData.loan_id + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.isbn+ \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.card_id + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.date_out + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.due_date + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.date_in + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.fine_amt + \"</td>\"));\r\n");
      out.write("            row.append($(\"<td>\" + rowData.paid + \"</td>\"));\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("        function drawTableFine(data) {\r\n");
      out.write("      \t  $(\"#fineDetailsSum\").find(\"tr:not(:first)\").remove();\r\n");
      out.write("          for (var i = 0; i < data.length; i++) {\r\n");
      out.write("              drawRowFine(data[i]);\r\n");
      out.write("          }\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      function drawRowFine(rowData) {\r\n");
      out.write("          var row = $(\"<tr />\");\r\n");
      out.write("          $(\"#fineDetailsSum\").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it\r\n");
      out.write("          row.append($(\"<td>\" + rowData.card_id + \"</td>\"));\r\n");
      out.write("          row.append($(\"<td>\" + rowData.fine_amt + \"</td>\"));\r\n");
      out.write("          row.append($(\"<td>\" + rowData.paid + \"</td>\"));\r\n");
      out.write("          \r\n");
      out.write("      }\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div class=\"container\">\r\n");
      out.write(" <h2>\r\n");
      out.write("                <font color=\"red\">Fine Payment</font>\r\n");
      out.write("            </h2>\r\n");
      out.write("\t<div class=\"finePayment\">\r\n");
      out.write("                <label for=\"finePayment\"><h3>Pay Fine</h3></label></br></br>\r\n");
      out.write("                Card Id:    <input type=\"text\" id=\"card_id\" placeholder=\"Card Id..\" name=\"cardId\">\r\n");
      out.write("                Book Isbn:  <input type=\"text\" id=\"isbn\" placeholder=\"Book Isbn..\" name=\"bookIsbn\"></br>\r\n");
      out.write("                \r\n");
      out.write("            \r\n");
      out.write("            </div>\r\n");
      out.write("\t\t\t</br>\r\n");
      out.write("            <button type=\"Submit\" class=\"btn btn-default\" id=\"finePaymentBtn\">Get Fine Details</button>\r\n");
      out.write("            <button type=\"Submit\" class=\"btn btn-default\" id=\"finePaymentBtn2\">Pay</button>\r\n");
      out.write("            <button type=\"Submit\" class=\"btn btn-default\" id=\"finePaymentBtn3\">Display Fines</button>\r\n");
      out.write("\t\t\t</br></br>\r\n");
      out.write("            \r\n");
      out.write("            <table id=\"fineDetails\" border=\"1\" style=\"border-collapse: collapse;\" cellpadding=\"8\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Loan_id</th>\r\n");
      out.write("                <th>Isbn</th>\r\n");
      out.write("                <th>Card_id</th>\r\n");
      out.write("                <th>Date_Out</th>\r\n");
      out.write("                <th>Due_Date</th>\r\n");
      out.write("                <th>Date_in</th>\r\n");
      out.write("                <th>Fine_amt</th>\r\n");
      out.write("                <th>Paid</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("         </table>\r\n");
      out.write("         </br></br></br>\r\n");
      out.write("          <table id=\"fineDetailsSum\" border=\"1\" style=\"border-collapse: collapse;\" cellpadding=\"8\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Card_id</th>\r\n");
      out.write("                <th>Total_fine</th>\r\n");
      out.write("                <th>Paid</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("         </table>\r\n");
      out.write("         \r\n");
      out.write("         </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
