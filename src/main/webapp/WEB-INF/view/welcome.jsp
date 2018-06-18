<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>myTrade</title>
    <link href="css/welcome.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    <link href="css/smallTable.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
</br>
<div>
    <div class="column">
        Products avaliable for trading:
        <section class="wrapper">
            <!-- Row title -->
            <main class="row title">
                <ul>
                    <li>Name</li>
                    <li>Shortname</li>
                    <li>Symbol</li>
                </ul>
            </main>
            <!-- Row 1 - fadeIn -->
            <c:forEach items="${list}" var="list">
                <section class="row-fadeIn-wrapper">
                    <article class="row fadeIn nfl">
                        <ul>
                            <li>${list.name}</li>
                            <li>${list.shortName}</li>
                            <li>${list.symbol}</li>
                        </ul>
                        <ul class="more-content">
                            <li>Click <a href="/picker">here</a> to pick a product and trade!</li>
                        </ul>
                    </article>
                </section>
            </c:forEach>
            If you have suggestions for future products to trade feel free to mail on address: <a
                href="mailto:request@myTrade.com?Subject=ProductRequest" target="_top">request@myTrade.com</a>
        </section>

    </div>
    <div class="column">
        <div class="main">
            <h2 class="allerta" style="color:lawngreen">${gzBuy}</h2>
            <h2>${lowBalance}</h2>
            </br><h1 class="allerta">Welcome ${firstname}</h1>
            <h2>Your current balance is: </h2>
            <h1 class="allerta" style="color:lawngreen">${balance}</h1>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p>
                Admin Panel</br>
                <a href="/currencies">Manage currencies</a>
                    <%--<a href="/users">Manage users</a>--%>
                </sec:authorize>
            </p>
            <hr class="style-four">
            <h1 class="allerta">Trade it!</h1>
            <h2><a href="/picker">Pick a product</a></h2>
            <h2><a href="/showTrans">Show transactions</a></h2>
            <hr class="style-four">
            <h2 class="allerta">Trading utilities</h2>
            <h2><a href="calendar" target="_blank">Market events calendar</a></h2>
            <h2><a href="techTrade" target="_blank">Technical trading informations</a></h2>
            <%--<iframe id="info" src="https://ssltsw.forexprostools.com?lang=1&forex=1,2,3,5,7,9,10&commodities=8830,8836,8831,8849,8833,8862,8832&indices=175,166,172,27,179,170,174&stocks=334,345,346,347,348,349,350&tabs=1,2,3,4" width="317" height="467"></iframe>--%>
        </div>
    </div>
    <div class="column allerta">
        <h3>London</h3>
        <iframe src="http://free.timeanddate.com/clock/i6a8c01g/n262/szw110/szh110/hocf09/hbw4/hfc282828/cf100/hgr0/fav0/fiv0/mqcfff/mql10/mqw4/mqd98/mhcfff/mhl10/mhw4/mhd98/mmv0/hhcfff/hmcfff/hscdc006c"
                frameborder="0" width="110" height="110"></iframe>
        <h3>New York</h3>
        <iframe src="http://free.timeanddate.com/clock/i6a8c01g/n179/szw110/szh110/hocf09/hbw4/hfc282828/cf100/hgr0/fav0/fiv0/mqcfff/mql10/mqw4/mqd98/mhcfff/mhl10/mhw4/mhd98/mmv0/hhcfff/hmcfff/hscdc006c"
                frameborder="0" width="110" height="110"></iframe>
        <h3>Sydney</h3>
        <iframe src="http://free.timeanddate.com/clock/i6a8c01g/n240/szw110/szh110/hocf09/hbw4/hfc282828/cf100/hgr0/fav0/fiv0/mqcfff/mql10/mqw4/mqd98/mhcfff/mhl10/mhw4/mhd98/mmv0/hhcfff/hmcfff/hscdc006c"
                frameborder="0" width="110" height="110"></iframe>
        <h3>Tokyo</h3>
        <iframe src="http://free.timeanddate.com/clock/i6a8c01g/n248/szw110/szh110/hocf09/hbw4/hfc282828/cf100/hgr0/fav0/fiv0/mqcfff/mql10/mqw4/mqd98/mhcfff/mhl10/mhw4/mhd98/mmv0/hhcfff/hmcfff/hscdc006c"
                frameborder="0" width="110" height="110"></iframe>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>