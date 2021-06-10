<%-- 
    Document   : index
    Created on : 18-Jan-2020, 20:32:40
    Author     : N0731739
API KEY: boiutmvrh5rcji5lv0og
--%>
<%@page import="java.net.MalformedURLException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="org.me.shares.SharePrice"%>
<%@page import="org.me.shares.Shares"%>
<%@page import="org.me.shares.Share"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        
        
        
        <form method="get" class="w3-container w3-white">
            <label class="w3-text-blue"><b>Select Currency Code</b></label>
            <br>
            <select name="CurrencyCodes"  onchange="this.form.submit();">
                
               
            
        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
	docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
	// TODO process result here
	java.util.List<java.lang.String> result = port.getCurrencyCodes();
	for (String temp : result){
            out.println("<option>" + temp + "</option>");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
    
    </select>
    
        </form>
    
    
    
        <%-- start web service invocation --%><hr/>
    <%
        double d = 0.00;
        String pickedCurrency = "";
        
        //DecimalFormat df = new DecimalFormat("0.00##");
        //String dfResult = "";
        if (request.getParameter("CurrencyCodes") != null){
           String SelectedCurrency = request.getParameter("CurrencyCodes");
           pickedCurrency = SelectedCurrency.substring(0, 3);
    try {
        
        org.me.shares.SharesWS_Service service = new org.me.shares.SharesWS_Service();
	org.me.shares.SharesWS port = service.getSharesWSPort();
	
	java.util.List<org.me.shares.Share> result = port.listShares();
        
            
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + pickedCurrency + "&symbols=GBP");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() !=200){
               throw new IOException(conn.getResponseMessage());
            }
        
            BufferedReader Br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inString;
            StringBuilder stringB = new StringBuilder();
            while ((inString = Br.readLine()) != null){
                stringB.append(inString);
            }
            String newS = stringB.toString();
        
            
            String val = newS.replaceAll("[^0-9\\.]", "");
            d = Double.parseDouble(val);
            
            //for (Share temp : result){
                //for (SharePrice temp1 : temp.getSharePrice()) {
                    //DecimalFormat df = new DecimalFormat("0.00##");
                    //dfResult = df.format(temp1.getValue()/d);
                //}
            //}
            
            
            
            
        
        } catch (Exception e) {
            
            //CURRENCYCONVERTIONOFF-LINE
            docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
            docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
            
            org.me.shares.SharesWS_Service service1 = new org.me.shares.SharesWS_Service();
            org.me.shares.SharesWS port1 = service1.getSharesWSPort();
	
            java.util.List<org.me.shares.Share> result1 = port1.listShares();

	
            
            
            pickedCurrency = SelectedCurrency.substring(0, 3);
            String OGCurrency = "GBP";
        
            d = port.getConversionRate(OGCurrency, pickedCurrency);
            
           // for (Share temp : result1){
             //   for (SharePrice temp1 : temp.getSharePrice()) {
              //     dfResult = df.format(temp1.getValue()*d);
               // }
            //}
        }
        }
    %>
    <%-- end web service invocation --%><hr/>


   
    

        
        
        
            
        <form method="post" class="w3-container w3-white">
            <label class="w3-text-blue"><b>List Companies</b></label>
            <br>
            <input class="w3-btn w3-blue" type="submit" name="ListShares" value="Show">
        </form>
        
        
            <table style="width:100%">
                
                
            <%-- start web service invocation --%><hr/>
    <%
        
        if (request.getParameter("ListShares") != null){
    try {
	org.me.shares.SharesWS_Service service = new org.me.shares.SharesWS_Service();
	org.me.shares.SharesWS port = service.getSharesWSPort();
	
	java.util.List<org.me.shares.Share> result = port.listShares();
	//java.util.List<org.me.shares.SharePrice> value;
        out.println("<th>" + "Company logo" + "</th>");
        out.println("<th>" + "Company Name" + "</th>");
        out.println("<th>" + "Company Symbol" + "</th>");
        out.println("<th>" + "Available Shares" + "</th>");
        out.println("<th>" + "Share Value" + "</th>");
        out.println("<th>" + "Currency" + "</th>");
        out.println("<th>" + "Last Update" + "</th>");
        
        for (Share temp : result){
            out.println("<tr class=\"sb-table-item\">");
            out.println("<td>" + "<img src='//logo.clearbit.com/" + temp.getCompanyName() +".com?size=50'>" + "</td>");
            out.println("<td>" + temp.getCompanyName() + "</td>");
            out.println("<td>" + temp.getCompanySymbol() + "</td>");
            out.println("<td>" + temp.getShareavAilability()+ "</td>");
            for (SharePrice temp1 : temp.getSharePrice()) {
                DecimalFormat df = new DecimalFormat("0.00##");
                
                String dfResult = df.format(temp1.getValue()/d);
                out.println("<td>" + dfResult + "</br>");
                
                out.println("<td>" + pickedCurrency + "</td>");
                out.println("<td>" + temp1.getLastUpdate() + "</td>");
                out.println("</br>");
            }
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        }
    %>
    </table>
    <%-- end web service invocation --%><hr/>
    
    
    <form  method="post" class="w3-container w3-white">
            <label class="w3-text-blue"><b>Search for companies</b></label>
            <input class="w3-input w3-border w3-white" type="text" name="searchName" >
            <input class="w3-btn w3-blue" type="submit" name="searchButton" value="Search" >
    </form>
            
    <style>
            table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
        table#t01 {
            width: 100%;    
            background-color: #f1f1c1;
        }
        </style>
        
            <table style="width:100%">
                
    <%-- start web service invocation --%><hr/>
    <%
         if (request.getParameter("searchButton") != null) {
            String userInput = request.getParameter("searchName");
            try {
                org.me.shares.SharesWS_Service service = new org.me.shares.SharesWS_Service();
                org.me.shares.SharesWS port = service.getSharesWSPort();
                
                out.println("<th>" + "Company logo" + "</th>");
                out.println("<th>" + "Company Name" + "</th>");
                out.println("<th>" + "Company Symbol" + "</th>");
                out.println("<th>" + "Available Shares" + "</th>");
                out.println("<th>" + "Share Value" + "</th>");
                out.println("<th>" + "Currency" + "</th>");
                out.println("<th>" + "Last Update" + "</th>");
                // TODO initialize WS operation arguments here
                //java.lang.String searchInput = "";
                // TODO process result here
                java.util.List<org.me.shares.Share> result = port.search(userInput);
                for (Share temp : result){
                    out.println("<tr class=\"sb-table-item\">");
                    out.println("<td>" + "<img src='//logo.clearbit.com/" + temp.getCompanyName() +".com?size=50'>" + "</td>");
                    out.println("<td>" + temp.getCompanyName() + "</td>");
                    out.println("<td>" + temp.getCompanySymbol() + "</td>");
                    out.println("<td>" + temp.getShareavAilability() + "</td>");
                    for (SharePrice temp1 : temp.getSharePrice()){
                        DecimalFormat df = new DecimalFormat("0.00##");
                        String dfResult = df.format(temp1.getValue()/d);
                        out.println("<td>" + dfResult + "</br>");
                        out.println("<td>" + pickedCurrency + "</td>");
                        out.println("<td>" + temp1.getLastUpdate() + "</td>");
                    }
                }
                out.println("</tr>");
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }
    
    %>
   
    </table>

    <%-- end web service invocation --%><hr/>
    
    
    
    
    
    <form method="post" class="w3-container w3-white">
            <label class="w3-text-blue"><b>Purchase Company Shares</b></label> 
            <br>
            <label class="w3-text-blue"><b></b>Input company symbol</label>
            <input class="w3-input w3-border w3-white" type="text" name="companyS" >
            <label class="w3-text-blue"><b></b>Input amount of shares you wish to purchase</label>
            <input class="w3-input w3-border w3-white" type="text" name="amountS" >
    
            <input class="w3-btn w3-blue" type="submit" name="purchaseShares" value="Purchase">
    </form>
    <%-- start web service invocation --%><hr/>
    <%
  
        if (request.getParameter("purchaseShares") != null) {
            String companySymbol = request.getParameter("companyS");
            String temp = request.getParameter("amountS");
            int amount = Integer.parseInt(temp);
    try {
	org.me.shares.SharesWS_Service service = new org.me.shares.SharesWS_Service();
	org.me.shares.SharesWS port = service.getSharesWSPort();
	 
	java.util.List<org.me.shares.Share> result = port.purchaseShares(amount, companySymbol);
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
        
    }
        }
    
    %>
    <%-- end web service invocation --%><hr/>



    </body>
</html>
